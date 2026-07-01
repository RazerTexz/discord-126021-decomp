package b.i.a.f.h.l;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences$Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager$NameNotFoundException;
import android.os.Bundle;
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

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class g {
    public static volatile g a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Boolean f1442b;
    public final String c;
    public final b.i.a.f.e.o.b d;
    public final ExecutorService e;
    public final b.i.a.f.i.a.a f;

    @GuardedBy("listenerList")
    public final List<Pair<b.i.a.f.i.b.z5, g$c>> g;
    public int h;
    public boolean i;
    public volatile ec j;

    /* JADX WARN: Code duplicated, block: B:21:0x0060  */
    public g(Context context, String str, String str2, String str3, Bundle bundle) {
        boolean z2;
        boolean z3;
        boolean z4;
        if (str == null || !e(str2, str3)) {
            this.c = "FA";
        } else {
            this.c = str;
        }
        this.d = b.i.a.f.e.o.c.a;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new o());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.e = Executors.unconfigurableExecutorService(threadPoolExecutor);
        this.f = new b.i.a.f.i.a.a(this);
        this.g = new ArrayList();
        try {
            z2 = b.i.a.f.e.o.f.V1(context, "google_app_id") != null;
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
            this.i = true;
            Log.w(this.c, "Disabling data collection. Found google_app_id in strings.xml but Google Analytics for Firebase is missing. Remove this value or add Google Analytics for Firebase to resume data collection.");
            return;
        }
        if (!e(str2, str3)) {
            if (str2 == null || str3 == null) {
                if ((str2 == null) ^ (str3 == null)) {
                    Log.w(this.c, "Specified origin or custom app id is null. Both parameters will be ignored.");
                }
            } else {
                Log.v(this.c, "Deferring to Google Analytics for Firebase for event data collection. https://goo.gl/J1sWQy");
            }
        }
        this.e.execute(new j(this, str2, str3, context, bundle));
        Application application = (Application) context.getApplicationContext();
        if (application == null) {
            Log.w(this.c, "Unable to register lifecycle notifications. Application null.");
        } else {
            application.registerActivityLifecycleCallbacks(new g$b(this));
        }
    }

    public static g a(Context context, String str, String str2, String str3, Bundle bundle) {
        Objects.requireNonNull(context, "null reference");
        if (a == null) {
            synchronized (g.class) {
                if (a == null) {
                    a = new g(context, null, null, null, bundle);
                }
            }
        }
        return a;
    }

    public static void d(Context context) {
        boolean z2;
        Bundle bundle;
        synchronized (g.class) {
            try {
                if (f1442b != null) {
                    return;
                }
                b.c.a.a0.d.w("app_measurement_internal_disable_startup_flags");
                try {
                    ApplicationInfo applicationInfoA = b.i.a.f.e.p.b.a(context).a(context.getPackageName(), 128);
                    z2 = (applicationInfoA == null || (bundle = applicationInfoA.metaData) == null) ? false : bundle.getBoolean("app_measurement_internal_disable_startup_flags");
                } catch (PackageManager$NameNotFoundException unused) {
                }
                if (z2) {
                    f1442b = Boolean.TRUE;
                    return;
                }
                SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
                f1442b = Boolean.valueOf(sharedPreferences.getBoolean("allow_remote_dynamite", true));
                SharedPreferences$Editor sharedPreferences$EditorEdit = sharedPreferences.edit();
                sharedPreferences$EditorEdit.remove("allow_remote_dynamite");
                sharedPreferences$EditorEdit.apply();
            } catch (Exception e) {
                Log.e("FA", "Exception reading flag from SharedPreferences.", e);
                f1442b = Boolean.TRUE;
            }
        }
    }

    public static boolean e(String str, String str2) {
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

    public final void b(Exception exc, boolean z2, boolean z3) {
        this.i |= z2;
        if (z2) {
            Log.w(this.c, "Data collection startup failed. No data will be collected.", exc);
            return;
        }
        if (z3) {
            this.e.execute(new y(this, "Error with data collection. Data lost.", exc));
        }
        Log.w(this.c, "Error with data collection. Data lost.", exc);
    }

    public final void c(String str, String str2, Bundle bundle, boolean z2, boolean z3, Long l) {
        this.e.execute(new c0(this, null, str, str2, bundle, z2, z3));
    }
}
