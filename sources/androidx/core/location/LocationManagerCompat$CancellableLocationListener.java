package androidx.core.location;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import androidx.core.util.Consumer;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class LocationManagerCompat$CancellableLocationListener implements LocationListener {
    private Consumer<Location> mConsumer;
    private final Executor mExecutor;
    private final LocationManager mLocationManager;
    private final Handler mTimeoutHandler = new Handler(Looper.getMainLooper());

    @Nullable
    public Runnable mTimeoutRunnable;

    @GuardedBy("this")
    private boolean mTriggered;

    public LocationManagerCompat$CancellableLocationListener(LocationManager locationManager, Executor executor, Consumer<Location> consumer) {
        this.mLocationManager = locationManager;
        this.mExecutor = executor;
        this.mConsumer = consumer;
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    private void cleanup() {
        this.mConsumer = null;
        this.mLocationManager.removeUpdates(this);
        Runnable runnable = this.mTimeoutRunnable;
        if (runnable != null) {
            this.mTimeoutHandler.removeCallbacks(runnable);
            this.mTimeoutRunnable = null;
        }
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public void cancel() {
        synchronized (this) {
            if (this.mTriggered) {
                return;
            }
            this.mTriggered = true;
            cleanup();
        }
    }

    @Override // android.location.LocationListener
    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public void onLocationChanged(@Nullable Location location) {
        synchronized (this) {
            if (this.mTriggered) {
                return;
            }
            this.mTriggered = true;
            this.mExecutor.execute(new LocationManagerCompat$CancellableLocationListener$2(this, this.mConsumer, location));
            cleanup();
        }
    }

    @Override // android.location.LocationListener
    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public void onProviderDisabled(@NonNull String str) {
        onLocationChanged((Location) null);
    }

    @Override // android.location.LocationListener
    public void onProviderEnabled(@NonNull String str) {
    }

    @Override // android.location.LocationListener
    public void onStatusChanged(String str, int i, Bundle bundle) {
    }

    public void startTimeout(long j) {
        synchronized (this) {
            if (this.mTriggered) {
                return;
            }
            LocationManagerCompat$CancellableLocationListener$1 locationManagerCompat$CancellableLocationListener$1 = new LocationManagerCompat$CancellableLocationListener$1(this);
            this.mTimeoutRunnable = locationManagerCompat$CancellableLocationListener$1;
            this.mTimeoutHandler.postDelayed(locationManagerCompat$CancellableLocationListener$1, j);
        }
    }
}
