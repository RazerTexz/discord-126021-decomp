package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager$NameNotFoundException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.Nullable;
import b.i.a.f.e.a;
import b.i.a.f.e.c;
import b.i.a.f.h.a.b;
import b.i.a.f.h.a.d;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class AdvertisingIdClient {

    @Nullable
    public a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public b f2993b;
    public boolean c;
    public final Object d = new Object();

    @Nullable
    public AdvertisingIdClient$a e;
    public final Context f;
    public final boolean g;
    public final long h;

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

    public static a c(Context context, boolean z2) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException, PackageManager$NameNotFoundException, IOException {
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            int iB = c.f1346b.b(context, 12451000);
            if (iB != 0 && iB != 2) {
                throw new IOException("Google Play services not available");
            }
            String str = z2 ? "com.google.android.gms.ads.identifier.service.PERSISTENT_START" : "com.google.android.gms.ads.identifier.service.START";
            a aVar = new a();
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
        } catch (PackageManager$NameNotFoundException unused) {
            throw new GooglePlayServicesNotAvailableException(9);
        }
    }

    public static b d(a aVar) throws IOException {
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

    public static AdvertisingIdClient$Info getAdvertisingIdInfo(Context context) throws GooglePlayServicesRepairableException, IllegalStateException, GooglePlayServicesNotAvailableException, IOException {
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
            AdvertisingIdClient$Info advertisingIdClient$InfoB = advertisingIdClient.b();
            advertisingIdClient.g(advertisingIdClient$InfoB, zA, f, SystemClock.elapsedRealtime() - jElapsedRealtime, string, null);
            advertisingIdClient.a();
            return advertisingIdClient$InfoB;
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
        b.c.a.a0.d.x("Calling this from your main thread can lead to deadlock");
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

    public AdvertisingIdClient$Info b() throws IOException {
        AdvertisingIdClient$Info advertisingIdClient$Info;
        b.c.a.a0.d.x("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.c) {
                Objects.requireNonNull(this.a, "null reference");
                Objects.requireNonNull(this.f2993b, "null reference");
                advertisingIdClient$Info = new AdvertisingIdClient$Info(this.f2993b.getId(), this.f2993b.D(true));
            } else {
                synchronized (this.d) {
                    AdvertisingIdClient$a advertisingIdClient$a = this.e;
                    if (advertisingIdClient$a == null || !advertisingIdClient$a.m) {
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
                        advertisingIdClient$Info = new AdvertisingIdClient$Info(this.f2993b.getId(), this.f2993b.D(true));
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
        return advertisingIdClient$Info;
    }

    public final void e() {
        synchronized (this.d) {
            AdvertisingIdClient$a advertisingIdClient$a = this.e;
            if (advertisingIdClient$a != null) {
                advertisingIdClient$a.l.countDown();
                try {
                    this.e.join();
                } catch (InterruptedException unused) {
                }
            }
            if (this.h > 0) {
                this.e = new AdvertisingIdClient$a(this, this.h);
            }
        }
    }

    public final void f(boolean z2) throws GooglePlayServicesRepairableException, IllegalStateException, GooglePlayServicesNotAvailableException, IOException {
        b.c.a.a0.d.x("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.c) {
                a();
            }
            a aVarC = c(this.f, this.g);
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

    public final boolean g(AdvertisingIdClient$Info advertisingIdClient$Info, boolean z2, float f, long j, String str, Throwable th) {
        if (Math.random() > f) {
            return false;
        }
        HashMap map = new HashMap();
        map.put("app_context", z2 ? "1" : "0");
        if (advertisingIdClient$Info != null) {
            map.put("limit_ad_tracking", advertisingIdClient$Info.isLimitAdTrackingEnabled() ? "1" : "0");
        }
        if (advertisingIdClient$Info != null && advertisingIdClient$Info.getId() != null) {
            map.put("ad_id_size", Integer.toString(advertisingIdClient$Info.getId().length()));
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
