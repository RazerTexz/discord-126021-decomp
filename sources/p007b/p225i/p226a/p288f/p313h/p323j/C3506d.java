package p007b.p225i.p226a.p288f.p313h.p323j;

import android.text.TextUtils;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import java.util.Objects;
import p007b.p225i.p226a.p288f.p291b.C3180f;

/* JADX INFO: renamed from: b.i.a.f.h.j.d */
/* JADX INFO: loaded from: classes3.dex */
public class C3506d {

    /* JADX INFO: renamed from: j */
    public final C3515g f9684j;

    public C3506d(C3515g c3515g) {
        Objects.requireNonNull(c3515g, "null reference");
        this.f9684j = c3515g;
    }

    /* JADX INFO: renamed from: c */
    public static String m4424c(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof Boolean) {
            return obj == Boolean.TRUE ? "true" : "false";
        }
        return obj instanceof Throwable ? ((Throwable) obj).toString() : obj.toString();
    }

    /* JADX INFO: renamed from: e */
    public static String m4425e(String str, Object obj, Object obj2, Object obj3) {
        String str2 = "";
        if (str == null) {
            str = "";
        }
        String strM4424c = m4424c(obj);
        String strM4424c2 = m4424c(obj2);
        String strM4424c3 = m4424c(obj3);
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = ": ";
        }
        String str3 = ", ";
        if (!TextUtils.isEmpty(strM4424c)) {
            sb.append(str2);
            sb.append(strM4424c);
            str2 = ", ";
        }
        if (TextUtils.isEmpty(strM4424c2)) {
            str3 = str2;
        } else {
            sb.append(str2);
            sb.append(strM4424c2);
        }
        if (!TextUtils.isEmpty(strM4424c3)) {
            sb.append(str3);
            sb.append(strM4424c3);
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: A */
    public final void m4426A(String str, Object obj) {
        m4430a(6, str, obj, null, null);
    }

    /* JADX INFO: renamed from: C */
    public final void m4427C(String str) {
        m4430a(2, str, null, null, null);
    }

    /* JADX INFO: renamed from: D */
    public final void m4428D(String str) {
        m4430a(5, str, null, null, null);
    }

    /* JADX INFO: renamed from: H */
    public final void m4429H(String str) {
        m4430a(6, str, null, null, null);
    }

    /* JADX INFO: renamed from: a */
    public final void m4430a(int i, String str, Object obj, Object obj2, Object obj3) {
        C3515g c3515g = this.f9684j;
        C3535p0 c3535p0 = null;
        C3529m0 c3529m0 = c3515g != null ? c3515g.f9726f : null;
        if (c3529m0 == null) {
            String str2 = C3510e0.f9690b.f9716a;
            if (Log.isLoggable(str2, i)) {
                Log.println(i, str2, m4425e(str, obj, obj2, obj3));
                return;
            }
            return;
        }
        String str3 = C3510e0.f9690b.f9716a;
        if (Log.isLoggable(str3, i)) {
            Log.println(i, str3, m4425e(str, obj, obj2, obj3));
        }
        if (i >= 5) {
            synchronized (c3529m0) {
                Objects.requireNonNull(str, "null reference");
                if (i < 0) {
                    i = 0;
                }
                if (i >= 9) {
                    i = 8;
                }
                char c = c3529m0.f9684j.f9725e.m4513a() ? 'C' : 'c';
                char cCharAt = "01VDIWEA?".charAt(i);
                String str4 = C3512f.f9715a;
                String strM4425e = m4425e(str, C3529m0.m4464R(obj), C3529m0.m4464R(obj2), C3529m0.m4464R(obj3));
                StringBuilder sb = new StringBuilder(String.valueOf(str4).length() + 4 + String.valueOf(strM4425e).length());
                sb.append(ExifInterface.GPS_MEASUREMENT_3D);
                sb.append(cCharAt);
                sb.append(c);
                sb.append(str4);
                sb.append(":");
                sb.append(strM4425e);
                String string = sb.toString();
                if (string.length() > 1024) {
                    string = string.substring(0, 1024);
                }
                C3515g c3515g2 = c3529m0.f9684j;
                C3535p0 c3535p1 = c3515g2.f9731k;
                if (c3535p1 != null && c3535p1.m4442I()) {
                    c3535p0 = c3515g2.f9731k;
                }
                if (c3535p0 != null) {
                    c3535p0.f9780o.m4496a(string);
                }
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m4431b(String str, Object obj) {
        m4430a(2, str, obj, null, null);
    }

    /* JADX INFO: renamed from: d */
    public final void m4432d(String str, Object obj) {
        m4430a(3, str, obj, null, null);
    }

    /* JADX INFO: renamed from: f */
    public final void m4433f(String str, Object obj, Object obj2) {
        m4430a(5, str, obj, obj2, null);
    }

    /* JADX INFO: renamed from: n */
    public final C3529m0 m4434n() {
        return this.f9684j.m4451c();
    }

    /* JADX INFO: renamed from: q */
    public final C3180f m4435q() {
        return this.f9684j.m4452d();
    }

    /* JADX INFO: renamed from: s */
    public final C3497a m4436s() {
        return this.f9684j.m4453e();
    }

    /* JADX INFO: renamed from: t */
    public final C3499a1 m4437t() {
        C3515g c3515g = this.f9684j;
        C3515g.m4449a(c3515g.f9730j);
        return c3515g.f9730j;
    }

    /* JADX INFO: renamed from: u */
    public final C3535p0 m4438u() {
        C3515g c3515g = this.f9684j;
        C3515g.m4449a(c3515g.f9731k);
        return c3515g.f9731k;
    }

    /* JADX INFO: renamed from: x */
    public final void m4439x(String str, Object obj) {
        m4430a(5, str, obj, null, null);
    }

    /* JADX INFO: renamed from: y */
    public final void m4440y(String str, Object obj, Object obj2) {
        m4430a(6, str, obj, obj2, null);
    }
}
