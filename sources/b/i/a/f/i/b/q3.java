package b.i.a.f.i.b;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.GuardedBy;
import b.d.b.a.outline;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class q3 extends r5 {
    public char c;
    public long d;

    @GuardedBy("this")
    public String e;
    public final s3 f;
    public final s3 g;
    public final s3 h;
    public final s3 i;
    public final s3 j;
    public final s3 k;
    public final s3 l;
    public final s3 m;
    public final s3 n;

    public q3(u4 u4Var) {
        super(u4Var);
        this.c = (char) 0;
        this.d = -1L;
        this.f = new s3(this, 6, false, false);
        this.g = new s3(this, 6, true, false);
        this.h = new s3(this, 6, false, true);
        this.i = new s3(this, 5, false, false);
        this.j = new s3(this, 5, true, false);
        this.k = new s3(this, 5, false, true);
        this.l = new s3(this, 4, false, false);
        this.m = new s3(this, 3, false, false);
        this.n = new s3(this, 2, false, false);
    }

    public static Object s(String str) {
        if (str == null) {
            return null;
        }
        return new v3(str);
    }

    public static String t(boolean z2, Object obj) {
        String className;
        if (obj == null) {
            return "";
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf(((Integer) obj).intValue());
        }
        if (obj instanceof Long) {
            if (!z2) {
                return String.valueOf(obj);
            }
            Long l = (Long) obj;
            if (Math.abs(l.longValue()) < 100) {
                return String.valueOf(obj);
            }
            String str = String.valueOf(obj).charAt(0) == '-' ? "-" : "";
            String strValueOf = String.valueOf(Math.abs(l.longValue()));
            long jRound = Math.round(Math.pow(10.0d, strValueOf.length() - 1));
            long jRound2 = Math.round(Math.pow(10.0d, strValueOf.length()) - 1.0d);
            StringBuilder sbR = outline.R(str.length() + str.length() + 43, str, jRound, "...");
            sbR.append(str);
            sbR.append(jRound2);
            return sbR.toString();
        }
        if (obj instanceof Boolean) {
            return String.valueOf(obj);
        }
        if (!(obj instanceof Throwable)) {
            if (obj instanceof v3) {
                return ((v3) obj).a;
            }
            return z2 ? "-" : String.valueOf(obj);
        }
        Throwable th = (Throwable) obj;
        StringBuilder sb = new StringBuilder(z2 ? th.getClass().getName() : th.toString());
        String strY = y(u4.class.getCanonicalName());
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            if (!stackTraceElement.isNativeMethod() && (className = stackTraceElement.getClassName()) != null && y(className).equals(strY)) {
                sb.append(": ");
                sb.append(stackTraceElement);
                break;
            }
        }
        return sb.toString();
    }

    public static String u(boolean z2, String str, Object obj, Object obj2, Object obj3) {
        String str2 = "";
        if (str == null) {
            str = "";
        }
        String strT = t(z2, obj);
        String strT2 = t(z2, obj2);
        String strT3 = t(z2, obj3);
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = ": ";
        }
        String str3 = ", ";
        if (!TextUtils.isEmpty(strT)) {
            sb.append(str2);
            sb.append(strT);
            str2 = ", ";
        }
        if (TextUtils.isEmpty(strT2)) {
            str3 = str2;
        } else {
            sb.append(str2);
            sb.append(strT2);
        }
        if (!TextUtils.isEmpty(strT3)) {
            sb.append(str3);
            sb.append(strT3);
        }
        return sb.toString();
    }

    public static String y(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int iLastIndexOf = str.lastIndexOf(46);
        return iLastIndexOf == -1 ? str : str.substring(0, iLastIndexOf);
    }

    public final s3 A() {
        return this.i;
    }

    public final s3 B() {
        return this.k;
    }

    public final s3 C() {
        return this.m;
    }

    public final s3 D() {
        return this.n;
    }

    public final String E() {
        long jAbs;
        Pair<String, Long> pair;
        k4 k4Var = l().e;
        k4Var.e.b();
        k4Var.e.b();
        long j = k4Var.e.w().getLong(k4Var.a, 0L);
        if (j == 0) {
            k4Var.a();
            jAbs = 0;
        } else {
            Objects.requireNonNull((b.i.a.f.e.o.c) k4Var.e.a.o);
            jAbs = Math.abs(j - System.currentTimeMillis());
        }
        long j2 = k4Var.d;
        if (jAbs < j2) {
            pair = null;
        } else if (jAbs > (j2 << 1)) {
            k4Var.a();
            pair = null;
        } else {
            String string = k4Var.e.w().getString(k4Var.c, null);
            long j3 = k4Var.e.w().getLong(k4Var.f1541b, 0L);
            k4Var.a();
            pair = (string == null || j3 <= 0) ? d4.c : new Pair<>(string, Long.valueOf(j3));
        }
        if (pair == null || pair == d4.c) {
            return null;
        }
        String strValueOf = String.valueOf(pair.second);
        String str = (String) pair.first;
        return outline.k(outline.b(str, strValueOf.length() + 1), strValueOf, ":", str);
    }

    public final String F() {
        String str;
        synchronized (this) {
            if (this.e == null) {
                String str2 = this.a.e;
                if (str2 == null) {
                    str2 = "FA";
                }
                this.e = str2;
            }
            str = this.e;
        }
        return str;
    }

    @Override // b.i.a.f.i.b.r5
    public final boolean r() {
        return false;
    }

    public final void v(int i, String str) {
        Log.println(i, F(), str);
    }

    public final void w(int i, boolean z2, boolean z3, String str, Object obj, Object obj2, Object obj3) {
        if (!z2 && Log.isLoggable(F(), i)) {
            Log.println(i, F(), u(false, str, obj, obj2, obj3));
        }
        if (z3 || i < 5) {
            return;
        }
        Objects.requireNonNull(str, "null reference");
        r4 r4Var = this.a.k;
        if (r4Var == null) {
            v(6, "Scheduler not set. Not logging error/warn");
        } else {
            if (!r4Var.n()) {
                v(6, "Scheduler not initialized. Not logging error/warn");
                return;
            }
            if (i < 0) {
                i = 0;
            }
            r4Var.v(new t3(this, i >= 9 ? 8 : i, str, obj, obj2, obj3));
        }
    }

    public final boolean x(int i) {
        return Log.isLoggable(F(), i);
    }

    public final s3 z() {
        return this.f;
    }
}
