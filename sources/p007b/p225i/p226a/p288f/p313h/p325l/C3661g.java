package p007b.p225i.p226a.p288f.p313h.p325l;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.GuardedBy;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p299e.p308o.C3401c;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p226a.p288f.p299e.p308o.InterfaceC3400b;
import p007b.p225i.p226a.p288f.p299e.p310p.C3411b;
import p007b.p225i.p226a.p288f.p330i.p331a.C3967a;
import p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC4258z5;

/* JADX INFO: renamed from: b.i.a.f.h.l.g */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class C3661g {

    /* JADX INFO: renamed from: a */
    public static volatile C3661g f9946a;

    /* JADX INFO: renamed from: b */
    public static Boolean f9947b;

    /* JADX INFO: renamed from: c */
    public final String f9948c;

    /* JADX INFO: renamed from: d */
    public final InterfaceC3400b f9949d;

    /* JADX INFO: renamed from: e */
    public final ExecutorService f9950e;

    /* JADX INFO: renamed from: f */
    public final C3967a f9951f;

    /* JADX INFO: renamed from: g */
    @GuardedBy("listenerList")
    public final List<Pair<InterfaceC4258z5, c>> f9952g;

    /* JADX INFO: renamed from: h */
    public int f9953h;

    /* JADX INFO: renamed from: i */
    public boolean f9954i;

    /* JADX INFO: renamed from: j */
    public volatile InterfaceC3646ec f9955j;

    /* JADX INFO: renamed from: b.i.a.f.h.l.g$a */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
    public abstract class a implements Runnable {

        /* JADX INFO: renamed from: j */
        public final long f9956j;

        /* JADX INFO: renamed from: k */
        public final long f9957k;

        /* JADX INFO: renamed from: l */
        public final boolean f9958l;

        public a(boolean z2) {
            Objects.requireNonNull((C3401c) C3661g.this.f9949d);
            this.f9956j = System.currentTimeMillis();
            Objects.requireNonNull((C3401c) C3661g.this.f9949d);
            this.f9957k = SystemClock.elapsedRealtime();
            this.f9958l = z2;
        }

        /* JADX INFO: renamed from: a */
        public abstract void mo4521a() throws RemoteException;

        /* JADX INFO: renamed from: b */
        public void mo4887b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C3661g.this.f9954i) {
                mo4887b();
                return;
            }
            try {
                mo4521a();
            } catch (Exception e) {
                C3661g.this.m4885b(e, false, this.f9958l);
                mo4887b();
            }
        }
    }

    /* JADX INFO: renamed from: b.i.a.f.h.l.g$b */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
    public class b implements Application.ActivityLifecycleCallbacks {
        public b() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity activity, Bundle bundle) {
            C3661g c3661g = C3661g.this;
            c3661g.f9950e.execute(new C3634e0(this, bundle, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
            C3661g c3661g = C3661g.this;
            c3661g.f9950e.execute(new C3704j0(this, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
            C3661g c3661g = C3661g.this;
            c3661g.f9950e.execute(new C3648f0(this, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
            C3661g c3661g = C3661g.this;
            c3661g.f9950e.execute(new C3662g0(this, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            BinderC3618cc binderC3618cc = new BinderC3618cc();
            C3661g c3661g = C3661g.this;
            c3661g.f9950e.execute(new C3676h0(this, activity, binderC3618cc));
            Bundle bundleM4621t0 = binderC3618cc.m4621t0(50L);
            if (bundleM4621t0 != null) {
                bundle.putAll(bundleM4621t0);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity activity) {
            C3661g c3661g = C3661g.this;
            c3661g.f9950e.execute(new C3620d0(this, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity activity) {
            C3661g c3661g = C3661g.this;
            c3661g.f9950e.execute(new C3690i0(this, activity));
        }
    }

    /* JADX INFO: renamed from: b.i.a.f.h.l.g$c */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
    public static class c extends AbstractBinderC3591b {

        /* JADX INFO: renamed from: a */
        public final InterfaceC4258z5 f9961a;

        public c(InterfaceC4258z5 interfaceC4258z5) {
            this.f9961a = interfaceC4258z5;
        }

        @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3605c
        /* JADX INFO: renamed from: Z */
        public final void mo4572Z(String str, String str2, Bundle bundle, long j) {
            this.f9961a.mo5979a(str, str2, bundle, j);
        }

        @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3605c
        /* JADX INFO: renamed from: a */
        public final int mo4573a() {
            return System.identityHashCode(this.f9961a);
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0060  */
    public C3661g(Context context, String str, String str2, String str3, Bundle bundle) {
        boolean z2;
        boolean z3;
        boolean z4;
        if (str == null || !m4884e(str2, str3)) {
            this.f9948c = "FA";
        } else {
            this.f9948c = str;
        }
        this.f9949d = C3401c.f9584a;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC3768o());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.f9950e = Executors.unconfigurableExecutorService(threadPoolExecutor);
        this.f9951f = new C3967a(this);
        this.f9952g = new ArrayList();
        try {
            z2 = C3404f.m4254V1(context, "google_app_id") != null;
        } catch (IllegalStateException unused) {
        }
        if (z2) {
            try {
                Class.forName("com.google.firebase.analytics.FirebaseAnalytics");
                z3 = true;
            } catch (ClassNotFoundException unused2) {
                z3 = false;
            }
            if (z3) {
                z4 = true;
            } else {
                z4 = false;
            }
        } else {
            z4 = true;
        }
        if (!z4) {
            this.f9954i = true;
            Log.w(this.f9948c, "Disabling data collection. Found google_app_id in strings.xml but Google Analytics for Firebase is missing. Remove this value or add Google Analytics for Firebase to resume data collection.");
            return;
        }
        if (!m4884e(str2, str3)) {
            if (str2 == null || str3 == null) {
                if ((str2 == null) ^ (str3 == null)) {
                    Log.w(this.f9948c, "Specified origin or custom app id is null. Both parameters will be ignored.");
                }
            } else {
                Log.v(this.f9948c, "Deferring to Google Analytics for Firebase for event data collection. https://goo.gl/J1sWQy");
            }
        }
        this.f9950e.execute(new C3703j(this, str2, str3, context, bundle));
        Application application = (Application) context.getApplicationContext();
        if (application == null) {
            Log.w(this.f9948c, "Unable to register lifecycle notifications. Application null.");
        } else {
            application.registerActivityLifecycleCallbacks(new b());
        }
    }

    /* JADX INFO: renamed from: a */
    public static C3661g m4882a(Context context, String str, String str2, String str3, Bundle bundle) {
        Objects.requireNonNull(context, "null reference");
        if (f9946a == null) {
            synchronized (C3661g.class) {
                if (f9946a == null) {
                    f9946a = new C3661g(context, null, null, null, bundle);
                }
            }
        }
        return f9946a;
    }

    /* JADX INFO: renamed from: d */
    public static void m4883d(Context context) {
        boolean z2;
        Bundle bundle;
        synchronized (C3661g.class) {
            try {
                if (f9947b != null) {
                    return;
                }
                C1460d.m583w("app_measurement_internal_disable_startup_flags");
                try {
                    ApplicationInfo applicationInfoM4373a = C3411b.m4376a(context).m4373a(context.getPackageName(), 128);
                    z2 = (applicationInfoM4373a == null || (bundle = applicationInfoM4373a.metaData) == null) ? false : bundle.getBoolean("app_measurement_internal_disable_startup_flags");
                } catch (PackageManager.NameNotFoundException unused) {
                }
                if (z2) {
                    f9947b = Boolean.TRUE;
                    return;
                }
                SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
                f9947b = Boolean.valueOf(sharedPreferences.getBoolean("allow_remote_dynamite", true));
                SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                editorEdit.remove("allow_remote_dynamite");
                editorEdit.apply();
            } catch (Exception e) {
                Log.e("FA", "Exception reading flag from SharedPreferences.", e);
                f9947b = Boolean.TRUE;
            }
        }
    }

    /* JADX INFO: renamed from: e */
    public static boolean m4884e(String str, String str2) {
        boolean z2;
        if (str2 != null && str != null) {
            try {
                Class.forName("com.google.firebase.analytics.FirebaseAnalytics");
                z2 = true;
            } catch (ClassNotFoundException unused) {
                z2 = false;
            }
            if (!z2) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: b */
    public final void m4885b(Exception exc, boolean z2, boolean z3) {
        this.f9954i |= z2;
        if (z2) {
            Log.w(this.f9948c, "Data collection startup failed. No data will be collected.", exc);
            return;
        }
        if (z3) {
            this.f9950e.execute(new C3898y(this, "Error with data collection. Data lost.", exc));
        }
        Log.w(this.f9948c, "Error with data collection. Data lost.", exc);
    }

    /* JADX INFO: renamed from: c */
    public final void m4886c(String str, String str2, Bundle bundle, boolean z2, boolean z3, Long l) {
        this.f9950e.execute(new C3606c0(this, null, str, str2, bundle, z2, z3));
    }
}
