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
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p289a.p290a.C3173a;
import p007b.p225i.p226a.p288f.p289a.p290a.C3174b;
import p007b.p225i.p226a.p288f.p299e.C3256c;
import p007b.p225i.p226a.p288f.p299e.ServiceConnectionC3252a;
import p007b.p225i.p226a.p288f.p299e.p307n.C3398a;
import p007b.p225i.p226a.p288f.p313h.p314a.AbstractBinderC3439c;
import p007b.p225i.p226a.p288f.p313h.p314a.C3440d;
import p007b.p225i.p226a.p288f.p313h.p314a.InterfaceC3438b;

/* JADX INFO: loaded from: classes3.dex */
public class AdvertisingIdClient {

    /* JADX INFO: renamed from: a */
    @Nullable
    public ServiceConnectionC3252a f20372a;

    /* JADX INFO: renamed from: b */
    @Nullable
    public InterfaceC3438b f20373b;

    /* JADX INFO: renamed from: c */
    public boolean f20374c;

    /* JADX INFO: renamed from: d */
    public final Object f20375d = new Object();

    /* JADX INFO: renamed from: e */
    @Nullable
    public C10786a f20376e;

    /* JADX INFO: renamed from: f */
    public final Context f20377f;

    /* JADX INFO: renamed from: g */
    public final boolean f20378g;

    /* JADX INFO: renamed from: h */
    public final long f20379h;

    public static final class Info {

        /* JADX INFO: renamed from: a */
        public final String f20380a;

        /* JADX INFO: renamed from: b */
        public final boolean f20381b;

        public Info(String str, boolean z2) {
            this.f20380a = str;
            this.f20381b = z2;
        }

        public final String getId() {
            return this.f20380a;
        }

        public final boolean isLimitAdTrackingEnabled() {
            return this.f20381b;
        }

        public final String toString() {
            String str = this.f20380a;
            boolean z2 = this.f20381b;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 7);
            sb.append("{");
            sb.append(str);
            sb.append("}");
            sb.append(z2);
            return sb.toString();
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.ads.identifier.AdvertisingIdClient$a */
    public static class C10786a extends Thread {

        /* JADX INFO: renamed from: j */
        public WeakReference<AdvertisingIdClient> f20382j;

        /* JADX INFO: renamed from: k */
        public long f20383k;

        /* JADX INFO: renamed from: l */
        public CountDownLatch f20384l = new CountDownLatch(1);

        /* JADX INFO: renamed from: m */
        public boolean f20385m = false;

        public C10786a(AdvertisingIdClient advertisingIdClient, long j) {
            this.f20382j = new WeakReference<>(advertisingIdClient);
            this.f20383k = j;
            start();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            AdvertisingIdClient advertisingIdClient;
            try {
                if (this.f20384l.await(this.f20383k, TimeUnit.MILLISECONDS) || (advertisingIdClient = this.f20382j.get()) == null) {
                    return;
                }
                advertisingIdClient.m9002a();
                this.f20385m = true;
            } catch (InterruptedException unused) {
                AdvertisingIdClient advertisingIdClient2 = this.f20382j.get();
                if (advertisingIdClient2 != null) {
                    advertisingIdClient2.m9002a();
                    this.f20385m = true;
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
        this.f20377f = context;
        this.f20374c = false;
        this.f20379h = j;
        this.f20378g = z3;
    }

    /* JADX INFO: renamed from: c */
    public static ServiceConnectionC3252a m9000c(Context context, boolean z2) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException, PackageManager.NameNotFoundException, IOException {
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            int iMo4018b = C3256c.f9307b.mo4018b(context, 12451000);
            if (iMo4018b != 0 && iMo4018b != 2) {
                throw new IOException("Google Play services not available");
            }
            String str = z2 ? "com.google.android.gms.ads.identifier.service.PERSISTENT_START" : "com.google.android.gms.ads.identifier.service.START";
            ServiceConnectionC3252a serviceConnectionC3252a = new ServiceConnectionC3252a();
            Intent intent = new Intent(str);
            intent.setPackage("com.google.android.gms");
            try {
                if (C3398a.m4181b().m4182a(context, intent, serviceConnectionC3252a, 1)) {
                    return serviceConnectionC3252a;
                }
                throw new IOException("Connection failure");
            } catch (Throwable th) {
                throw new IOException(th);
            }
        } catch (PackageManager.NameNotFoundException unused) {
            throw new GooglePlayServicesNotAvailableException(9);
        }
    }

    /* JADX INFO: renamed from: d */
    public static InterfaceC3438b m9001d(ServiceConnectionC3252a serviceConnectionC3252a) throws IOException {
        try {
            IBinder iBinderM4014a = serviceConnectionC3252a.m4014a(10000L, TimeUnit.MILLISECONDS);
            int i = AbstractBinderC3439c.f9622a;
            IInterface iInterfaceQueryLocalInterface = iBinderM4014a.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            return iInterfaceQueryLocalInterface instanceof InterfaceC3438b ? (InterfaceC3438b) iInterfaceQueryLocalInterface : new C3440d(iBinderM4014a);
        } catch (InterruptedException unused) {
            throw new IOException("Interrupted exception");
        } catch (Throwable th) {
            throw new IOException(th);
        }
    }

    public static Info getAdvertisingIdInfo(Context context) throws GooglePlayServicesRepairableException, IllegalStateException, GooglePlayServicesNotAvailableException, IOException {
        float f;
        String string;
        C3174b c3174b = new C3174b(context);
        boolean zM3965a = c3174b.m3965a("gads:ad_id_app_context:enabled");
        try {
            SharedPreferences sharedPreferences = c3174b.f9191a;
            f = sharedPreferences == null ? 0.0f : sharedPreferences.getFloat("gads:ad_id_app_context:ping_ratio", 0.0f);
        } catch (Throwable th) {
            Log.w("GmscoreFlag", "Error while reading from SharedPreferences ", th);
        }
        try {
            SharedPreferences sharedPreferences2 = c3174b.f9191a;
            string = sharedPreferences2 == null ? "" : sharedPreferences2.getString("gads:ad_id_use_shared_preference:experiment_id", "");
        } catch (Throwable th2) {
            Log.w("GmscoreFlag", "Error while reading from SharedPreferences ", th2);
        }
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context, -1L, zM3965a, c3174b.m3965a("gads:ad_id_use_persistent_service:enabled"));
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            advertisingIdClient.m9005f(false);
            Info infoM9003b = advertisingIdClient.m9003b();
            advertisingIdClient.m9006g(infoM9003b, zM3965a, f, SystemClock.elapsedRealtime() - jElapsedRealtime, string, null);
            advertisingIdClient.m9002a();
            return infoM9003b;
        } catch (Throwable th3) {
            try {
                advertisingIdClient.m9006g(null, zM3965a, f, -1L, string, th3);
                throw th3;
            } catch (Throwable th4) {
                advertisingIdClient.m9002a();
                throw th4;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m9002a() {
        C1460d.m587x("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.f20377f == null || this.f20372a == null) {
                return;
            }
            try {
                if (this.f20374c) {
                    C3398a.m4181b().m4183c(this.f20377f, this.f20372a);
                }
            } catch (Throwable th) {
                Log.i("AdvertisingIdClient", "AdvertisingIdClient unbindService failed.", th);
            }
            this.f20374c = false;
            this.f20373b = null;
            this.f20372a = null;
        }
    }

    /* JADX INFO: renamed from: b */
    public Info m9003b() throws IOException {
        Info info;
        C1460d.m587x("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.f20374c) {
                Objects.requireNonNull(this.f20372a, "null reference");
                Objects.requireNonNull(this.f20373b, "null reference");
                info = new Info(this.f20373b.getId(), this.f20373b.mo4391D(true));
            } else {
                synchronized (this.f20375d) {
                    C10786a c10786a = this.f20376e;
                    if (c10786a == null || !c10786a.f20385m) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
                try {
                    m9005f(false);
                    if (!this.f20374c) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                    Objects.requireNonNull(this.f20372a, "null reference");
                    Objects.requireNonNull(this.f20373b, "null reference");
                    try {
                        info = new Info(this.f20373b.getId(), this.f20373b.mo4391D(true));
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
        m9004e();
        return info;
    }

    /* JADX INFO: renamed from: e */
    public final void m9004e() {
        synchronized (this.f20375d) {
            C10786a c10786a = this.f20376e;
            if (c10786a != null) {
                c10786a.f20384l.countDown();
                try {
                    this.f20376e.join();
                } catch (InterruptedException unused) {
                }
            }
            if (this.f20379h > 0) {
                this.f20376e = new C10786a(this, this.f20379h);
            }
        }
    }

    /* JADX INFO: renamed from: f */
    public final void m9005f(boolean z2) throws GooglePlayServicesRepairableException, IllegalStateException, GooglePlayServicesNotAvailableException, IOException {
        C1460d.m587x("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.f20374c) {
                m9002a();
            }
            ServiceConnectionC3252a serviceConnectionC3252aM9000c = m9000c(this.f20377f, this.f20378g);
            this.f20372a = serviceConnectionC3252aM9000c;
            this.f20373b = m9001d(serviceConnectionC3252aM9000c);
            this.f20374c = true;
            if (z2) {
                m9004e();
            }
        }
    }

    public void finalize() throws Throwable {
        m9002a();
        super.finalize();
    }

    /* JADX INFO: renamed from: g */
    public final boolean m9006g(Info info, boolean z2, float f, long j, String str, Throwable th) {
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
        new C3173a(map).start();
        return true;
    }
}
