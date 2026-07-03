package p007b.p225i.p226a.p288f.p330i.p332b;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.GuardedBy;
import java.util.Objects;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3401c;

/* JADX INFO: renamed from: b.i.a.f.i.b.q3 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4157q3 extends AbstractC4170r5 {

    /* JADX INFO: renamed from: c */
    public char f11138c;

    /* JADX INFO: renamed from: d */
    public long f11139d;

    /* JADX INFO: renamed from: e */
    @GuardedBy("this")
    public String f11140e;

    /* JADX INFO: renamed from: f */
    public final C4179s3 f11141f;

    /* JADX INFO: renamed from: g */
    public final C4179s3 f11142g;

    /* JADX INFO: renamed from: h */
    public final C4179s3 f11143h;

    /* JADX INFO: renamed from: i */
    public final C4179s3 f11144i;

    /* JADX INFO: renamed from: j */
    public final C4179s3 f11145j;

    /* JADX INFO: renamed from: k */
    public final C4179s3 f11146k;

    /* JADX INFO: renamed from: l */
    public final C4179s3 f11147l;

    /* JADX INFO: renamed from: m */
    public final C4179s3 f11148m;

    /* JADX INFO: renamed from: n */
    public final C4179s3 f11149n;

    public C4157q3(C4202u4 c4202u4) {
        super(c4202u4);
        this.f11138c = (char) 0;
        this.f11139d = -1L;
        this.f11141f = new C4179s3(this, 6, false, false);
        this.f11142g = new C4179s3(this, 6, true, false);
        this.f11143h = new C4179s3(this, 6, false, true);
        this.f11144i = new C4179s3(this, 5, false, false);
        this.f11145j = new C4179s3(this, 5, true, false);
        this.f11146k = new C4179s3(this, 5, false, true);
        this.f11147l = new C4179s3(this, 4, false, false);
        this.f11148m = new C4179s3(this, 3, false, false);
        this.f11149n = new C4179s3(this, 2, false, false);
    }

    /* JADX INFO: renamed from: s */
    public static Object m5788s(String str) {
        if (str == null) {
            return null;
        }
        return new C4212v3(str);
    }

    /* JADX INFO: renamed from: t */
    public static String m5789t(boolean z2, Object obj) {
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
            StringBuilder sbM830R = C1643a.m830R(str.length() + str.length() + 43, str, jRound, "...");
            sbM830R.append(str);
            sbM830R.append(jRound2);
            return sbM830R.toString();
        }
        if (obj instanceof Boolean) {
            return String.valueOf(obj);
        }
        if (!(obj instanceof Throwable)) {
            if (obj instanceof C4212v3) {
                return ((C4212v3) obj).f11299a;
            }
            return z2 ? "-" : String.valueOf(obj);
        }
        Throwable th = (Throwable) obj;
        StringBuilder sb = new StringBuilder(z2 ? th.getClass().getName() : th.toString());
        String strM5791y = m5791y(C4202u4.class.getCanonicalName());
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            if (!stackTraceElement.isNativeMethod() && (className = stackTraceElement.getClassName()) != null && m5791y(className).equals(strM5791y)) {
                sb.append(": ");
                sb.append(stackTraceElement);
                break;
            }
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: u */
    public static String m5790u(boolean z2, String str, Object obj, Object obj2, Object obj3) {
        String str2 = "";
        if (str == null) {
            str = "";
        }
        String strM5789t = m5789t(z2, obj);
        String strM5789t2 = m5789t(z2, obj2);
        String strM5789t3 = m5789t(z2, obj3);
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = ": ";
        }
        String str3 = ", ";
        if (!TextUtils.isEmpty(strM5789t)) {
            sb.append(str2);
            sb.append(strM5789t);
            str2 = ", ";
        }
        if (TextUtils.isEmpty(strM5789t2)) {
            str3 = str2;
        } else {
            sb.append(str2);
            sb.append(strM5789t2);
        }
        if (!TextUtils.isEmpty(strM5789t3)) {
            sb.append(str3);
            sb.append(strM5789t3);
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: y */
    public static String m5791y(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int iLastIndexOf = str.lastIndexOf(46);
        return iLastIndexOf == -1 ? str : str.substring(0, iLastIndexOf);
    }

    /* JADX INFO: renamed from: A */
    public final C4179s3 m5792A() {
        return this.f11144i;
    }

    /* JADX INFO: renamed from: B */
    public final C4179s3 m5793B() {
        return this.f11146k;
    }

    /* JADX INFO: renamed from: C */
    public final C4179s3 m5794C() {
        return this.f11148m;
    }

    /* JADX INFO: renamed from: D */
    public final C4179s3 m5795D() {
        return this.f11149n;
    }

    /* JADX INFO: renamed from: E */
    public final String m5796E() {
        long jAbs;
        Pair<String, Long> pair;
        C4092k4 c4092k4 = m5867l().f10635e;
        c4092k4.f10875e.mo5848b();
        c4092k4.f10875e.mo5848b();
        long j = c4092k4.f10875e.m5579w().getLong(c4092k4.f10871a, 0L);
        if (j == 0) {
            c4092k4.m5696a();
            jAbs = 0;
        } else {
            Objects.requireNonNull((C3401c) c4092k4.f10875e.f11202a.f11267o);
            jAbs = Math.abs(j - System.currentTimeMillis());
        }
        long j2 = c4092k4.f10874d;
        if (jAbs < j2) {
            pair = null;
        } else if (jAbs > (j2 << 1)) {
            c4092k4.m5696a();
            pair = null;
        } else {
            String string = c4092k4.f10875e.m5579w().getString(c4092k4.f10873c, null);
            long j3 = c4092k4.f10875e.m5579w().getLong(c4092k4.f10872b, 0L);
            c4092k4.m5696a();
            pair = (string == null || j3 <= 0) ? C4009d4.f10629c : new Pair<>(string, Long.valueOf(j3));
        }
        if (pair == null || pair == C4009d4.f10629c) {
            return null;
        }
        String strValueOf = String.valueOf(pair.second);
        String str = (String) pair.first;
        return C1643a.m859k(C1643a.m841b(str, strValueOf.length() + 1), strValueOf, ":", str);
    }

    /* JADX INFO: renamed from: F */
    public final String m5797F() {
        String str;
        synchronized (this) {
            if (this.f11140e == null) {
                String str2 = this.f11202a.f11257e;
                if (str2 == null) {
                    str2 = "FA";
                }
                this.f11140e = str2;
            }
            str = this.f11140e;
        }
        return str;
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.AbstractC4170r5
    /* JADX INFO: renamed from: r */
    public final boolean mo5574r() {
        return false;
    }

    /* JADX INFO: renamed from: v */
    public final void m5798v(int i, String str) {
        Log.println(i, m5797F(), str);
    }

    /* JADX INFO: renamed from: w */
    public final void m5799w(int i, boolean z2, boolean z3, String str, Object obj, Object obj2, Object obj3) {
        if (!z2 && Log.isLoggable(m5797F(), i)) {
            Log.println(i, m5797F(), m5790u(false, str, obj, obj2, obj3));
        }
        if (z3 || i < 5) {
            return;
        }
        Objects.requireNonNull(str, "null reference");
        C4169r4 c4169r4 = this.f11202a.f11263k;
        if (c4169r4 == null) {
            m5798v(6, "Scheduler not set. Not logging error/warn");
        } else {
            if (!c4169r4.m5856n()) {
                m5798v(6, "Scheduler not initialized. Not logging error/warn");
                return;
            }
            if (i < 0) {
                i = 0;
            }
            c4169r4.m5852v(new RunnableC4190t3(this, i >= 9 ? 8 : i, str, obj, obj2, obj3));
        }
    }

    /* JADX INFO: renamed from: x */
    public final boolean m5800x(int i) {
        return Log.isLoggable(m5797F(), i);
    }

    /* JADX INFO: renamed from: z */
    public final C4179s3 m5801z() {
        return this.f11141f;
    }
}
