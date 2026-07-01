package b.i.a.f.i.b;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager$NameNotFoundException;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Size;
import androidx.annotation.WorkerThread;
import b.i.a.f.h.l.oa;
import b.i.a.f.h.l.pa;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends s5 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Boolean f1521b;

    @NonNull
    public e c;
    public Boolean d;

    public c(u4 u4Var) {
        super(u4Var);
        this.c = b.a;
    }

    public static long B() {
        return p.D.a(null).longValue();
    }

    public final boolean A(String str) {
        return "1".equals(this.c.h(str, "measurement.event_sampling_enabled"));
    }

    @WorkerThread
    public final boolean C() {
        if (this.f1521b == null) {
            Boolean boolW = w("app_measurement_lite");
            this.f1521b = boolW;
            if (boolW == null) {
                this.f1521b = Boolean.FALSE;
            }
        }
        return this.f1521b.booleanValue() || !this.a.f;
    }

    @Nullable
    public final Bundle D() {
        try {
            if (this.a.f1570b.getPackageManager() == null) {
                g().f.a("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo applicationInfoA = b.i.a.f.e.p.b.a(this.a.f1570b).a(this.a.f1570b.getPackageName(), 128);
            if (applicationInfoA != null) {
                return applicationInfoA.metaData;
            }
            g().f.a("Failed to load metadata: ApplicationInfo is null");
            return null;
        } catch (PackageManager$NameNotFoundException e) {
            g().f.b("Failed to load metadata: Package name not found", e);
            return null;
        }
    }

    public final String h(String str, String str2) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, str2);
        } catch (ClassNotFoundException e) {
            g().f.b("Could not find SystemProperties class", e);
            return str2;
        } catch (IllegalAccessException e2) {
            g().f.b("Could not access SystemProperties.get()", e2);
            return str2;
        } catch (NoSuchMethodException e3) {
            g().f.b("Could not find SystemProperties.get() method", e3);
            return str2;
        } catch (InvocationTargetException e4) {
            g().f.b("SystemProperties.get() threw an exception", e4);
            return str2;
        }
    }

    public final int m(@Size(min = 1) String str) {
        return Math.max(Math.min(q(str, p.I), 100), 25);
    }

    @WorkerThread
    public final long n(String str, @NonNull j3<Long> j3Var) {
        if (str == null) {
            return j3Var.a(null).longValue();
        }
        String strH = this.c.h(str, j3Var.f1539b);
        if (TextUtils.isEmpty(strH)) {
            return j3Var.a(null).longValue();
        }
        try {
            return j3Var.a(Long.valueOf(Long.parseLong(strH))).longValue();
        } catch (NumberFormatException unused) {
            return j3Var.a(null).longValue();
        }
    }

    public final boolean o(j3<Boolean> j3Var) {
        return u(null, j3Var);
    }

    public final int p(@Size(min = 1) String str) {
        if (b.i.a.f.h.l.o8.b() && u(null, p.w0)) {
            return Math.max(Math.min(q(str, p.H), 2000), 500);
        }
        return 500;
    }

    @WorkerThread
    public final int q(String str, @NonNull j3<Integer> j3Var) {
        if (str == null) {
            return j3Var.a(null).intValue();
        }
        String strH = this.c.h(str, j3Var.f1539b);
        if (TextUtils.isEmpty(strH)) {
            return j3Var.a(null).intValue();
        }
        try {
            return j3Var.a(Integer.valueOf(Integer.parseInt(strH))).intValue();
        } catch (NumberFormatException unused) {
            return j3Var.a(null).intValue();
        }
    }

    @WorkerThread
    public final double r(String str, @NonNull j3<Double> j3Var) {
        if (str == null) {
            return j3Var.a(null).doubleValue();
        }
        String strH = this.c.h(str, j3Var.f1539b);
        if (TextUtils.isEmpty(strH)) {
            return j3Var.a(null).doubleValue();
        }
        try {
            return j3Var.a(Double.valueOf(Double.parseDouble(strH))).doubleValue();
        } catch (NumberFormatException unused) {
            return j3Var.a(null).doubleValue();
        }
    }

    @WorkerThread
    public final int s(@Size(min = 1) String str) {
        return q(str, p.o);
    }

    public final int t() {
        if (!b.i.a.f.h.l.o8.b() || !this.a.h.u(null, p.x0)) {
            return 25;
        }
        t9 t9VarE = e();
        Boolean bool = t9VarE.a.x().e;
        return t9VarE.y0() >= 201500 || (bool != null && !bool.booleanValue()) ? 100 : 25;
    }

    @WorkerThread
    public final boolean u(String str, @NonNull j3<Boolean> j3Var) {
        if (str == null) {
            return j3Var.a(null).booleanValue();
        }
        String strH = this.c.h(str, j3Var.f1539b);
        return TextUtils.isEmpty(strH) ? j3Var.a(null).booleanValue() : j3Var.a(Boolean.valueOf(Boolean.parseBoolean(strH))).booleanValue();
    }

    public final boolean v(String str, j3<Boolean> j3Var) {
        return u(str, j3Var);
    }

    @Nullable
    public final Boolean w(@Size(min = 1) String str) {
        b.c.a.a0.d.w(str);
        Bundle bundleD = D();
        if (bundleD == null) {
            g().f.a("Failed to load metadata: Metadata bundle is null");
            return null;
        }
        if (bundleD.containsKey(str)) {
            return Boolean.valueOf(bundleD.getBoolean(str));
        }
        return null;
    }

    public final boolean x() {
        Boolean boolW = w("firebase_analytics_collection_deactivated");
        return boolW != null && boolW.booleanValue();
    }

    public final Boolean y() {
        Boolean boolW = w("google_analytics_adid_collection_enabled");
        return Boolean.valueOf(boolW == null || boolW.booleanValue());
    }

    public final Boolean z() {
        if (!((oa) pa.j.a()).a() || !o(p.u0)) {
            return Boolean.TRUE;
        }
        Boolean boolW = w("google_analytics_automatic_screen_reporting_enabled");
        return Boolean.valueOf(boolW == null || boolW.booleanValue());
    }
}
