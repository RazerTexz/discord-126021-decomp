package androidx.core.location;

import android.location.GnssStatus$Callback;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build$VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import androidx.collection.SimpleArrayMap;
import androidx.core.os.CancellationSignal;
import androidx.core.os.ExecutorCompat;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import java.lang.reflect.Field;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
public final class LocationManagerCompat {
    private static final long GET_CURRENT_LOCATION_TIMEOUT_MS = 30000;
    private static final long MAX_CURRENT_LOCATION_AGE_MS = 10000;
    private static final long PRE_N_LOOPER_TIMEOUT_S = 5;
    private static Field sContextField;

    @GuardedBy("sGnssStatusListeners")
    private static final SimpleArrayMap<Object, Object> sGnssStatusListeners = new SimpleArrayMap<>();

    private LocationManagerCompat() {
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public static void getCurrentLocation(@NonNull LocationManager locationManager, @NonNull String str, @Nullable CancellationSignal cancellationSignal, @NonNull Executor executor, @NonNull Consumer<Location> consumer) {
        if (Build$VERSION.SDK_INT >= 30) {
            LocationManagerCompat$Api30Impl.getCurrentLocation(locationManager, str, cancellationSignal, executor, consumer);
            return;
        }
        if (cancellationSignal != null) {
            cancellationSignal.throwIfCanceled();
        }
        Location lastKnownLocation = locationManager.getLastKnownLocation(str);
        if (lastKnownLocation != null && SystemClock.elapsedRealtime() - LocationCompat.getElapsedRealtimeMillis(lastKnownLocation) < 10000) {
            executor.execute(new LocationManagerCompat$1(consumer, lastKnownLocation));
            return;
        }
        LocationManagerCompat$CancellableLocationListener locationManagerCompat$CancellableLocationListener = new LocationManagerCompat$CancellableLocationListener(locationManager, executor, consumer);
        locationManager.requestLocationUpdates(str, 0L, 0.0f, locationManagerCompat$CancellableLocationListener, Looper.getMainLooper());
        if (cancellationSignal != null) {
            cancellationSignal.setOnCancelListener(new LocationManagerCompat$2(locationManagerCompat$CancellableLocationListener));
        }
        locationManagerCompat$CancellableLocationListener.startTimeout(30000L);
    }

    @Nullable
    public static String getGnssHardwareModelName(@NonNull LocationManager locationManager) {
        if (Build$VERSION.SDK_INT >= 28) {
            return LocationManagerCompat$Api28Impl.getGnssHardwareModelName(locationManager);
        }
        return null;
    }

    public static int getGnssYearOfHardware(@NonNull LocationManager locationManager) {
        if (Build$VERSION.SDK_INT >= 28) {
            return LocationManagerCompat$Api28Impl.getGnssYearOfHardware(locationManager);
        }
        return 0;
    }

    public static boolean isLocationEnabled(@NonNull LocationManager locationManager) {
        if (Build$VERSION.SDK_INT >= 28) {
            return LocationManagerCompat$Api28Impl.isLocationEnabled(locationManager);
        }
        return locationManager.isProviderEnabled("network") || locationManager.isProviderEnabled("gps");
    }

    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    public static boolean registerGnssStatusCallback(@NonNull LocationManager locationManager, @NonNull GnssStatusCompat$Callback gnssStatusCompat$Callback, @NonNull Handler handler) {
        return Build$VERSION.SDK_INT >= 30 ? registerGnssStatusCallback(locationManager, ExecutorCompat.create(handler), gnssStatusCompat$Callback) : registerGnssStatusCallback(locationManager, new LocationManagerCompat$InlineHandlerExecutor(handler), gnssStatusCompat$Callback);
    }

    public static void unregisterGnssStatusCallback(@NonNull LocationManager locationManager, @NonNull GnssStatusCompat$Callback gnssStatusCompat$Callback) {
        int i = Build$VERSION.SDK_INT;
        if (i >= 30) {
            SimpleArrayMap<Object, Object> simpleArrayMap = sGnssStatusListeners;
            synchronized (simpleArrayMap) {
                GnssStatus$Callback gnssStatus$Callback = (LocationManagerCompat$GnssStatusTransport) simpleArrayMap.remove(gnssStatusCompat$Callback);
                if (gnssStatus$Callback != null) {
                    locationManager.unregisterGnssStatusCallback(gnssStatus$Callback);
                }
            }
            return;
        }
        if (i >= 24) {
            SimpleArrayMap<Object, Object> simpleArrayMap2 = sGnssStatusListeners;
            synchronized (simpleArrayMap2) {
                LocationManagerCompat$PreRGnssStatusTransport locationManagerCompat$PreRGnssStatusTransport = (LocationManagerCompat$PreRGnssStatusTransport) simpleArrayMap2.remove(gnssStatusCompat$Callback);
                if (locationManagerCompat$PreRGnssStatusTransport != null) {
                    locationManagerCompat$PreRGnssStatusTransport.unregister();
                    locationManager.unregisterGnssStatusCallback(locationManagerCompat$PreRGnssStatusTransport);
                }
            }
            return;
        }
        SimpleArrayMap<Object, Object> simpleArrayMap3 = sGnssStatusListeners;
        synchronized (simpleArrayMap3) {
            LocationManagerCompat$GpsStatusTransport locationManagerCompat$GpsStatusTransport = (LocationManagerCompat$GpsStatusTransport) simpleArrayMap3.remove(gnssStatusCompat$Callback);
            if (locationManagerCompat$GpsStatusTransport != null) {
                locationManagerCompat$GpsStatusTransport.unregister();
                locationManager.removeGpsStatusListener(locationManagerCompat$GpsStatusTransport);
            }
        }
    }

    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    public static boolean registerGnssStatusCallback(@NonNull LocationManager locationManager, @NonNull Executor executor, @NonNull GnssStatusCompat$Callback gnssStatusCompat$Callback) {
        if (Build$VERSION.SDK_INT >= 30) {
            return registerGnssStatusCallback(locationManager, null, executor, gnssStatusCompat$Callback);
        }
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper == null) {
            looperMyLooper = Looper.getMainLooper();
        }
        return registerGnssStatusCallback(locationManager, new Handler(looperMyLooper), executor, gnssStatusCompat$Callback);
    }

    /* JADX WARN: Code duplicated, block: B:89:0x010a A[Catch: all -> 0x0126, TryCatch #2 {all -> 0x0126, blocks: (B:83:0x00e9, B:84:0x00ff, B:87:0x0102, B:89:0x010a, B:91:0x0112, B:92:0x0118, B:93:0x0119, B:94:0x011e, B:95:0x011f, B:96:0x0125, B:73:0x00d8), top: B:107:0x0098 }] */
    /* JADX WARN: Code duplicated, block: B:91:0x0112 A[Catch: all -> 0x0126, TryCatch #2 {all -> 0x0126, blocks: (B:83:0x00e9, B:84:0x00ff, B:87:0x0102, B:89:0x010a, B:91:0x0112, B:92:0x0118, B:93:0x0119, B:94:0x011e, B:95:0x011f, B:96:0x0125, B:73:0x00d8), top: B:107:0x0098 }] */
    /* JADX WARN: Code duplicated, block: B:93:0x0119 A[Catch: all -> 0x0126, TryCatch #2 {all -> 0x0126, blocks: (B:83:0x00e9, B:84:0x00ff, B:87:0x0102, B:89:0x010a, B:91:0x0112, B:92:0x0118, B:93:0x0119, B:94:0x011e, B:95:0x011f, B:96:0x0125, B:73:0x00d8), top: B:107:0x0098 }] */
    /* JADX WARN: Code duplicated, block: B:95:0x011f A[Catch: all -> 0x0126, TryCatch #2 {all -> 0x0126, blocks: (B:83:0x00e9, B:84:0x00ff, B:87:0x0102, B:89:0x010a, B:91:0x0112, B:92:0x0118, B:93:0x0119, B:94:0x011e, B:95:0x011f, B:96:0x0125, B:73:0x00d8), top: B:107:0x0098 }] */
    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    private static boolean registerGnssStatusCallback(LocationManager locationManager, Handler handler, Executor executor, GnssStatusCompat$Callback gnssStatusCompat$Callback) {
        int i = Build$VERSION.SDK_INT;
        boolean z2 = true;
        if (i >= 30) {
            SimpleArrayMap<Object, Object> simpleArrayMap = sGnssStatusListeners;
            synchronized (simpleArrayMap) {
                GnssStatus$Callback locationManagerCompat$GnssStatusTransport = (LocationManagerCompat$GnssStatusTransport) simpleArrayMap.get(gnssStatusCompat$Callback);
                if (locationManagerCompat$GnssStatusTransport == null) {
                    locationManagerCompat$GnssStatusTransport = new LocationManagerCompat$GnssStatusTransport(gnssStatusCompat$Callback);
                }
                if (!locationManager.registerGnssStatusCallback(executor, locationManagerCompat$GnssStatusTransport)) {
                    return false;
                }
                simpleArrayMap.put(gnssStatusCompat$Callback, locationManagerCompat$GnssStatusTransport);
                return true;
            }
        }
        if (i >= 24) {
            Preconditions.checkArgument(handler != null);
            SimpleArrayMap<Object, Object> simpleArrayMap2 = sGnssStatusListeners;
            synchronized (simpleArrayMap2) {
                LocationManagerCompat$PreRGnssStatusTransport locationManagerCompat$PreRGnssStatusTransport = (LocationManagerCompat$PreRGnssStatusTransport) simpleArrayMap2.get(gnssStatusCompat$Callback);
                if (locationManagerCompat$PreRGnssStatusTransport == null) {
                    locationManagerCompat$PreRGnssStatusTransport = new LocationManagerCompat$PreRGnssStatusTransport(gnssStatusCompat$Callback);
                } else {
                    locationManagerCompat$PreRGnssStatusTransport.unregister();
                }
                locationManagerCompat$PreRGnssStatusTransport.register(executor);
                if (!locationManager.registerGnssStatusCallback(locationManagerCompat$PreRGnssStatusTransport, handler)) {
                    return false;
                }
                simpleArrayMap2.put(gnssStatusCompat$Callback, locationManagerCompat$PreRGnssStatusTransport);
                return true;
            }
        }
        Preconditions.checkArgument(handler != null);
        SimpleArrayMap<Object, Object> simpleArrayMap3 = sGnssStatusListeners;
        synchronized (simpleArrayMap3) {
            LocationManagerCompat$GpsStatusTransport locationManagerCompat$GpsStatusTransport = (LocationManagerCompat$GpsStatusTransport) simpleArrayMap3.get(gnssStatusCompat$Callback);
            if (locationManagerCompat$GpsStatusTransport == null) {
                locationManagerCompat$GpsStatusTransport = new LocationManagerCompat$GpsStatusTransport(locationManager, gnssStatusCompat$Callback);
            } else {
                locationManagerCompat$GpsStatusTransport.unregister();
            }
            locationManagerCompat$GpsStatusTransport.register(executor);
            FutureTask futureTask = new FutureTask(new LocationManagerCompat$3(locationManager, locationManagerCompat$GpsStatusTransport));
            if (Looper.myLooper() == handler.getLooper()) {
                futureTask.run();
            } else if (!handler.post(futureTask)) {
                throw new IllegalStateException(handler + " is shutting down");
            }
            try {
                try {
                    long nanos = TimeUnit.SECONDS.toNanos(5L);
                    long jNanoTime = System.nanoTime() + nanos;
                    boolean z3 = false;
                    while (((Boolean) futureTask.get(nanos, TimeUnit.NANOSECONDS)).booleanValue()) {
                        try {
                            try {
                                sGnssStatusListeners.put(gnssStatusCompat$Callback, locationManagerCompat$GpsStatusTransport);
                                if (z3) {
                                    Thread.currentThread().interrupt();
                                }
                                return true;
                            } catch (ExecutionException e) {
                                e = e;
                                if (!(e.getCause() instanceof RuntimeException)) {
                                    if (e.getCause() instanceof Error) {
                                        throw ((Error) e.getCause());
                                    }
                                    throw new IllegalStateException(e);
                                }
                                throw ((RuntimeException) e.getCause());
                            } catch (TimeoutException e2) {
                                e = e2;
                                throw new IllegalStateException(handler + " appears to be blocked, please run registerGnssStatusCallback() directly on a Looper thread or ensure the main Looper is not blocked by this thread", e);
                            }
                        } catch (InterruptedException unused) {
                            nanos = jNanoTime - System.nanoTime();
                            z3 = true;
                        } catch (ExecutionException e3) {
                            e = e3;
                            if (!(e.getCause() instanceof RuntimeException)) {
                                if (e.getCause() instanceof Error) {
                                    throw ((Error) e.getCause());
                                }
                                throw new IllegalStateException(e);
                            }
                            throw ((RuntimeException) e.getCause());
                        } catch (TimeoutException e4) {
                            e = e4;
                            throw new IllegalStateException(handler + " appears to be blocked, please run registerGnssStatusCallback() directly on a Looper thread or ensure the main Looper is not blocked by this thread", e);
                        } catch (Throwable th) {
                            th = th;
                            z2 = z3;
                            if (z2) {
                                Thread.currentThread().interrupt();
                            }
                            throw th;
                        }
                    }
                    if (z3) {
                        Thread.currentThread().interrupt();
                    }
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (ExecutionException e5) {
                e = e5;
            } catch (TimeoutException e6) {
                e = e6;
            } catch (Throwable th3) {
                th = th3;
                z2 = false;
            }
        }
    }
}
