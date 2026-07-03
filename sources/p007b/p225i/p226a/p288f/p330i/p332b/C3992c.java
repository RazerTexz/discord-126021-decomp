package p007b.p225i.p226a.p288f.p330i.p332b;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Size;
import androidx.annotation.WorkerThread;
import java.lang.reflect.InvocationTargetException;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p299e.p310p.C3411b;
import p007b.p225i.p226a.p288f.p313h.p325l.C3777o8;
import p007b.p225i.p226a.p288f.p313h.p325l.C3792pa;
import p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3779oa;

/* JADX INFO: renamed from: b.i.a.f.i.b.c */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3992c extends C4181s5 {

    /* JADX INFO: renamed from: b */
    public Boolean f10579b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public InterfaceC4016e f10580c;

    /* JADX INFO: renamed from: d */
    public Boolean f10581d;

    public C3992c(C4202u4 c4202u4) {
        super(c4202u4);
        this.f10580c = C3980b.f10556a;
    }

    /* JADX INFO: renamed from: B */
    public static long m5519B() {
        return C4142p.f11026D.m5693a(null).longValue();
    }

    /* JADX INFO: renamed from: A */
    public final boolean m5520A(String str) {
        return "1".equals(this.f10580c.mo5500h(str, "measurement.event_sampling_enabled"));
    }

    @WorkerThread
    /* JADX INFO: renamed from: C */
    public final boolean m5521C() {
        if (this.f10579b == null) {
            Boolean boolM5534w = m5534w("app_measurement_lite");
            this.f10579b = boolM5534w;
            if (boolM5534w == null) {
                this.f10579b = Boolean.FALSE;
            }
        }
        return this.f10579b.booleanValue() || !this.f11202a.f11258f;
    }

    @Nullable
    /* JADX INFO: renamed from: D */
    public final Bundle m5522D() {
        try {
            if (this.f11202a.f11254b.getPackageManager() == null) {
                mo5726g().f11141f.m5860a("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo applicationInfoM4373a = C3411b.m4376a(this.f11202a.f11254b).m4373a(this.f11202a.f11254b.getPackageName(), 128);
            if (applicationInfoM4373a != null) {
                return applicationInfoM4373a.metaData;
            }
            mo5726g().f11141f.m5860a("Failed to load metadata: ApplicationInfo is null");
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            mo5726g().f11141f.m5861b("Failed to load metadata: Package name not found", e);
            return null;
        }
    }

    /* JADX INFO: renamed from: h */
    public final String m5523h(String str, String str2) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, str2);
        } catch (ClassNotFoundException e) {
            mo5726g().f11141f.m5861b("Could not find SystemProperties class", e);
            return str2;
        } catch (IllegalAccessException e2) {
            mo5726g().f11141f.m5861b("Could not access SystemProperties.get()", e2);
            return str2;
        } catch (NoSuchMethodException e3) {
            mo5726g().f11141f.m5861b("Could not find SystemProperties.get() method", e3);
            return str2;
        } catch (InvocationTargetException e4) {
            mo5726g().f11141f.m5861b("SystemProperties.get() threw an exception", e4);
            return str2;
        }
    }

    /* JADX INFO: renamed from: m */
    public final int m5524m(@Size(min = 1) String str) {
        return Math.max(Math.min(m5528q(str, C4142p.f11036I), 100), 25);
    }

    @WorkerThread
    /* JADX INFO: renamed from: n */
    public final long m5525n(String str, @NonNull C4080j3<Long> c4080j3) {
        if (str == null) {
            return c4080j3.m5693a(null).longValue();
        }
        String strMo5500h = this.f10580c.mo5500h(str, c4080j3.f10839b);
        if (TextUtils.isEmpty(strMo5500h)) {
            return c4080j3.m5693a(null).longValue();
        }
        try {
            return c4080j3.m5693a(Long.valueOf(Long.parseLong(strMo5500h))).longValue();
        } catch (NumberFormatException unused) {
            return c4080j3.m5693a(null).longValue();
        }
    }

    /* JADX INFO: renamed from: o */
    public final boolean m5526o(C4080j3<Boolean> c4080j3) {
        return m5532u(null, c4080j3);
    }

    /* JADX INFO: renamed from: p */
    public final int m5527p(@Size(min = 1) String str) {
        if (C3777o8.m5155b() && m5532u(null, C4142p.f11106w0)) {
            return Math.max(Math.min(m5528q(str, C4142p.f11034H), 2000), 500);
        }
        return 500;
    }

    @WorkerThread
    /* JADX INFO: renamed from: q */
    public final int m5528q(String str, @NonNull C4080j3<Integer> c4080j3) {
        if (str == null) {
            return c4080j3.m5693a(null).intValue();
        }
        String strMo5500h = this.f10580c.mo5500h(str, c4080j3.f10839b);
        if (TextUtils.isEmpty(strMo5500h)) {
            return c4080j3.m5693a(null).intValue();
        }
        try {
            return c4080j3.m5693a(Integer.valueOf(Integer.parseInt(strMo5500h))).intValue();
        } catch (NumberFormatException unused) {
            return c4080j3.m5693a(null).intValue();
        }
    }

    @WorkerThread
    /* JADX INFO: renamed from: r */
    public final double m5529r(String str, @NonNull C4080j3<Double> c4080j3) {
        if (str == null) {
            return c4080j3.m5693a(null).doubleValue();
        }
        String strMo5500h = this.f10580c.mo5500h(str, c4080j3.f10839b);
        if (TextUtils.isEmpty(strMo5500h)) {
            return c4080j3.m5693a(null).doubleValue();
        }
        try {
            return c4080j3.m5693a(Double.valueOf(Double.parseDouble(strMo5500h))).doubleValue();
        } catch (NumberFormatException unused) {
            return c4080j3.m5693a(null).doubleValue();
        }
    }

    @WorkerThread
    /* JADX INFO: renamed from: s */
    public final int m5530s(@Size(min = 1) String str) {
        return m5528q(str, C4142p.f11089o);
    }

    /* JADX INFO: renamed from: t */
    public final int m5531t() {
        if (!C3777o8.m5155b() || !this.f11202a.f11260h.m5532u(null, C4142p.f11108x0)) {
            return 25;
        }
        C4196t9 c4196t9M5866e = m5866e();
        Boolean bool = c4196t9M5866e.f11202a.m5953x().f11155e;
        return c4196t9M5866e.m5928y0() >= 201500 || (bool != null && !bool.booleanValue()) ? 100 : 25;
    }

    @WorkerThread
    /* JADX INFO: renamed from: u */
    public final boolean m5532u(String str, @NonNull C4080j3<Boolean> c4080j3) {
        if (str == null) {
            return c4080j3.m5693a(null).booleanValue();
        }
        String strMo5500h = this.f10580c.mo5500h(str, c4080j3.f10839b);
        return TextUtils.isEmpty(strMo5500h) ? c4080j3.m5693a(null).booleanValue() : c4080j3.m5693a(Boolean.valueOf(Boolean.parseBoolean(strMo5500h))).booleanValue();
    }

    /* JADX INFO: renamed from: v */
    public final boolean m5533v(String str, C4080j3<Boolean> c4080j3) {
        return m5532u(str, c4080j3);
    }

    @Nullable
    /* JADX INFO: renamed from: w */
    public final Boolean m5534w(@Size(min = 1) String str) {
        C1460d.m583w(str);
        Bundle bundleM5522D = m5522D();
        if (bundleM5522D == null) {
            mo5726g().f11141f.m5860a("Failed to load metadata: Metadata bundle is null");
            return null;
        }
        if (bundleM5522D.containsKey(str)) {
            return Boolean.valueOf(bundleM5522D.getBoolean(str));
        }
        return null;
    }

    /* JADX INFO: renamed from: x */
    public final boolean m5535x() {
        Boolean boolM5534w = m5534w("firebase_analytics_collection_deactivated");
        return boolM5534w != null && boolM5534w.booleanValue();
    }

    /* JADX INFO: renamed from: y */
    public final Boolean m5536y() {
        Boolean boolM5534w = m5534w("google_analytics_adid_collection_enabled");
        return Boolean.valueOf(boolM5534w == null || boolM5534w.booleanValue());
    }

    /* JADX INFO: renamed from: z */
    public final Boolean m5537z() {
        if (!((InterfaceC3779oa) C3792pa.f10251j.mo4555a()).mo5158a() || !m5526o(C4142p.f11102u0)) {
            return Boolean.TRUE;
        }
        Boolean boolM5534w = m5534w("google_analytics_automatic_screen_reporting_enabled");
        return Boolean.valueOf(boolM5534w == null || boolM5534w.booleanValue());
    }
}
