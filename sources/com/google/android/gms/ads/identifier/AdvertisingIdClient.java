package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.f.e.c;
import b.i.a.f.h.a.b;
import b.i.a.f.h.a.d;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class AdvertisingIdClient {

    @Nullable
    public b.i.a.f.e.a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public b f2993b;
    public boolean c;
    public final Object d = new Object();

    @Nullable
    public a e;
    public final Context f;
    public final boolean g;
    public final long h;

    public static final class Info {
        public final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f2994b;

        public Info(String str, boolean z2) {
            this.a = str;
            this.f2994b = z2;
        }

        public final String getId() {
            return this.a;
        }

        public final boolean isLimitAdTrackingEnabled() {
            return this.f2994b;
        }

        public final String toString() {
            String str = this.a;
            boolean z2 = this.f2994b;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 7);
            sb.append("{");
            sb.append(str);
            sb.append("}");
            sb.append(z2);
            return sb.toString();
        }
    }

    public static class a extends Thread {
        public WeakReference<AdvertisingIdClient> j;
        public long k;
        public CountDownLatch l = new CountDownLatch(1);
        public boolean m = false;

        public a(AdvertisingIdClient advertisingIdClient, long j) {
            this.j = new WeakReference<>(advertisingIdClient);
            this.k = j;
            start();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            AdvertisingIdClient advertisingIdClient;
            try {
                if (this.l.await(this.k, TimeUnit.MILLISECONDS) || (advertisingIdClient = this.j.get()) == null) {
                    return;
                }
                advertisingIdClient.a();
                this.m = true;
            } catch (InterruptedException unused) {
                AdvertisingIdClient advertisingIdClient2 = this.j.get();
                if (advertisingIdClient2 != null) {
                    advertisingIdClient2.a();
                    this.m = true;
                }
            }
        }
    }

    public AdvertisingIdClient(Context context, long j, boolean z2, boolean z3) {
        Context applicationContext;
        Objects.requireNonNull(context, "null reference");
        if (z2 && (applicationContext = context.getApplicationContext()) != null) {
            context = applicationContext;
        }
        this.f = context;
        this.c = false;
        this.h = j;
        this.g = z3;
    }

    public static b.i.a.f.e.a c(Context context, boolean z2) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException, PackageManager.NameNotFoundException, IOException {
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            int iB = c.f1346b.b(context, 12451000);
            if (iB != 0 && iB != 2) {
                throw new IOException("Google Play services not available");
            }
            String str = z2 ? "com.google.android.gms.ads.identifier.service.PERSISTENT_START" : "com.google.android.gms.ads.identifier.service.START";
            b.i.a.f.e.a aVar = new b.i.a.f.e.a();
            Intent intent = new Intent(str);
            intent.setPackage("com.google.android.gms");
            try {
                if (b.i.a.f.e.n.a.b().a(context, intent, aVar, 1)) {
                    return aVar;
                }
                throw new IOException("Connection failure");
            } catch (Throwable th) {
                throw new IOException(th);
            }
        } catch (PackageManager.NameNotFoundException unused) {
            throw new GooglePlayServicesNotAvailableException(9);
        }
    }

    public static b d(b.i.a.f.e.a aVar) throws IOException {
        try {
            IBinder iBinderA = aVar.a(10000L, TimeUnit.MILLISECONDS);
            int i = b.i.a.f.h.a.c.a;
            IInterface iInterfaceQueryLocalInterface = iBinderA.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            return iInterfaceQueryLocalInterface instanceof b ? (b) iInterfaceQueryLocalInterface : new d(iBinderA);
        } catch (InterruptedException unused) {
            throw new IOException("Interrupted exception");
        } catch (Throwable th) {
            throw new IOException(th);
        }
    }

    public static Info getAdvertisingIdInfo(Context context) throws GooglePlayServicesRepairableException, IllegalStateException, GooglePlayServicesNotAvailableException, IOException {
        float f;
        String string;
        b.i.a.f.a.a.b bVar = new b.i.a.f.a.a.b(context);
        boolean zA = bVar.a("gads:ad_id_app_context:enabled");
        try {
            SharedPreferences sharedPreferences = bVar.a;
            f = sharedPreferences == null ? 0.0f : sharedPreferences.getFloat("gads:ad_id_app_context:ping_ratio", 0.0f);
        } catch (Throwable th) {
            Log.w("GmscoreFlag", "Error while reading from SharedPreferences ", th);
        }
        try {
            SharedPreferences sharedPreferences2 = bVar.a;
            string = sharedPreferences2 == null ? "" : sharedPreferences2.getString("gads:ad_id_use_shared_preference:experiment_id", "");
        } catch (Throwable th2) {
            Log.w("GmscoreFlag", "Error while reading from SharedPreferences ", th2);
        }
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context, -1L, zA, bVar.a("gads:ad_id_use_persistent_service:enabled"));
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            advertisingIdClient.f(false);
            Info infoB = advertisingIdClient.b();
            advertisingIdClient.g(infoB, zA, f, SystemClock.elapsedRealtime() - jElapsedRealtime, string, null);
            advertisingIdClient.a();
            return infoB;
        } catch (Throwable th3) {
            try {
                advertisingIdClient.g(null, zA, f, -1L, string, th3);
                throw th3;
            } catch (Throwable th4) {
                advertisingIdClient.a();
                throw th4;
            }
        }
    }

    public final void a() {
        AnimatableValueParser.x("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.f == null || this.a == null) {
                return;
            }
            try {
                if (this.c) {
                    b.i.a.f.e.n.a.b().c(this.f, this.a);
                }
            } catch (Throwable th) {
                Log.i("AdvertisingIdClient", "AdvertisingIdClient unbindService failed.", th);
            }
            this.c = false;
            this.f2993b = null;
            this.a = null;
        }
    }

    public Info b() throws IOException {
        Info info;
        AnimatableValueParser.x("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.c) {
                Objects.requireNonNull(this.a, "null reference");
                Objects.requireNonNull(this.f2993b, "null reference");
                info = new Info(this.f2993b.getId(), this.f2993b.D(true));
            } else {
                synchronized (this.d) {
                    a aVar = this.e;
                    if (aVar == null || !aVar.m) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
                try {
                    f(false);
                    if (!this.c) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                    Objects.requireNonNull(this.a, "null reference");
                    Objects.requireNonNull(this.f2993b, "null reference");
                    try {
                        info = new Info(this.f2993b.getId(), this.f2993b.D(true));
                    } catch (RemoteException e) {
                        Log.i("AdvertisingIdClient", "GMS remote exception ", e);
                        throw new IOException("Remote exception");
                    }
                } catch (Exception e2) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e2);
                }
            }
            throw th;
        }
        e();
        return info;
    }

    public final void e() {
        synchronized (this.d) {
            a aVar = this.e;
            if (aVar != null) {
                aVar.l.countDown();
                try {
                    this.e.join();
                } catch (InterruptedException unused) {
                }
            }
            if (this.h > 0) {
                this.e = new a(this, this.h);
            }
        }
    }

    public final void f(boolean z2) throws GooglePlayServicesRepairableException, IllegalStateException, GooglePlayServicesNotAvailableException, IOException {
        AnimatableValueParser.x("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.c) {
                a();
            }
            b.i.a.f.e.a aVarC = c(this.f, this.g);
            this.a = aVarC;
            this.f2993b = d(aVarC);
            this.c = true;
            if (z2) {
                e();
            }
        }
    }

    public void finalize() throws Throwable {
        a();
        super.finalize();
    }

    public final boolean g(Info info, boolean z2, float f, long j, String str, Throwable th) {
        if (Math.random() > f) {
            return false;
        }
        HashMap map = new HashMap();
        map.put("app_context", z2 ? "1" : "0");
        if (info != null) {
            map.put("limit_ad_tracking", info.isLimitAdTrackingEnabled() ? "1" : "0");
        }
        if (info != null && info.getId() != null) {
            map.put("ad_id_size", Integer.toString(info.getId().length()));
        }
        if (th != null) {
            map.put("error", th.getClass().getName());
        }
        if (str != null && !str.isEmpty()) {
            map.put("experiment_id", str);
        }
        map.put("tag", "AdvertisingIdClient");
        map.put("time_spent", Long.toString(j));
        new b.i.a.f.a.a.a(map).start();
        return true;
    }
}
