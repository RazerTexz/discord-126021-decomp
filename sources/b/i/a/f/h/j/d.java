package b.i.a.f.h.j;

import android.text.TextUtils;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class d {
    public final g j;

    public d(g gVar) {
        Objects.requireNonNull(gVar, "null reference");
        this.j = gVar;
    }

    public static String c(Object obj) {
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

    public static String e(String str, Object obj, Object obj2, Object obj3) {
        String str2 = "";
        if (str == null) {
            str = "";
        }
        String strC = c(obj);
        String strC2 = c(obj2);
        String strC3 = c(obj3);
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = ": ";
        }
        String str3 = ", ";
        if (!TextUtils.isEmpty(strC)) {
            sb.append(str2);
            sb.append(strC);
            str2 = ", ";
        }
        if (TextUtils.isEmpty(strC2)) {
            str3 = str2;
        } else {
            sb.append(str2);
            sb.append(strC2);
        }
        if (!TextUtils.isEmpty(strC3)) {
            sb.append(str3);
            sb.append(strC3);
        }
        return sb.toString();
    }

    public final void A(String str, Object obj) {
        a(6, str, obj, null, null);
    }

    public final void C(String str) {
        a(2, str, null, null, null);
    }

    public final void D(String str) {
        a(5, str, null, null, null);
    }

    public final void H(String str) {
        a(6, str, null, null, null);
    }

    public final void a(int i, String str, Object obj, Object obj2, Object obj3) {
        g gVar = this.j;
        p0 p0Var = null;
        m0 m0Var = gVar != null ? gVar.f : null;
        if (m0Var == null) {
            String str2 = e0.f1411b.a;
            if (Log.isLoggable(str2, i)) {
                Log.println(i, str2, e(str, obj, obj2, obj3));
                return;
            }
            return;
        }
        String str3 = e0.f1411b.a;
        if (Log.isLoggable(str3, i)) {
            Log.println(i, str3, e(str, obj, obj2, obj3));
        }
        if (i >= 5) {
            synchronized (m0Var) {
                Objects.requireNonNull(str, "null reference");
                if (i < 0) {
                    i = 0;
                }
                if (i >= 9) {
                    i = 8;
                }
                char c = m0Var.j.e.a() ? 'C' : 'c';
                char cCharAt = "01VDIWEA?".charAt(i);
                String str4 = f.a;
                String strE = e(str, m0.R(obj), m0.R(obj2), m0.R(obj3));
                StringBuilder sb = new StringBuilder(String.valueOf(str4).length() + 4 + String.valueOf(strE).length());
                sb.append(ExifInterface.GPS_MEASUREMENT_3D);
                sb.append(cCharAt);
                sb.append(c);
                sb.append(str4);
                sb.append(":");
                sb.append(strE);
                String string = sb.toString();
                if (string.length() > 1024) {
                    string = string.substring(0, 1024);
                }
                g gVar2 = m0Var.j;
                p0 p0Var2 = gVar2.k;
                if (p0Var2 != null && p0Var2.I()) {
                    p0Var = gVar2.k;
                }
                if (p0Var != null) {
                    p0Var.o.a(string);
                }
            }
        }
    }

    public final void b(String str, Object obj) {
        a(2, str, obj, null, null);
    }

    public final void d(String str, Object obj) {
        a(3, str, obj, null, null);
    }

    public final void f(String str, Object obj, Object obj2) {
        a(5, str, obj, obj2, null);
    }

    public final m0 n() {
        return this.j.c();
    }

    public final b.i.a.f.b.f q() {
        return this.j.d();
    }

    public final a s() {
        return this.j.e();
    }

    public final a1 t() {
        g gVar = this.j;
        g.a(gVar.j);
        return gVar.j;
    }

    public final p0 u() {
        g gVar = this.j;
        g.a(gVar.k);
        return gVar.k;
    }

    public final void x(String str, Object obj) {
        a(5, str, obj, null, null);
    }

    public final void y(String str, Object obj, Object obj2) {
        a(6, str, obj, obj2, null);
    }
}
