package p007b.p225i.p226a.p288f.p330i.p332b;

import android.os.Bundle;

/* JADX INFO: renamed from: b.i.a.f.i.b.d */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4004d {

    /* JADX INFO: renamed from: a */
    public static final C4004d f10622a = new C4004d(null, null);

    /* JADX INFO: renamed from: b */
    public final Boolean f10623b;

    /* JADX INFO: renamed from: c */
    public final Boolean f10624c;

    public C4004d(Boolean bool, Boolean bool2) {
        this.f10623b = bool;
        this.f10624c = bool2;
    }

    /* JADX INFO: renamed from: a */
    public static int m5562a(Boolean bool) {
        if (bool == null) {
            return 0;
        }
        return bool.booleanValue() ? 1 : 2;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x001e  */
    /* JADX INFO: renamed from: b */
    public static C4004d m5563b(String str) {
        Boolean bool;
        Boolean bool2;
        Boolean bool3;
        Boolean bool4 = null;
        if (str != null) {
            if (str.length() < 3) {
                bool2 = null;
            } else {
                char cCharAt = str.charAt(2);
                if (cCharAt == '0') {
                    bool2 = Boolean.FALSE;
                } else if (cCharAt != '1') {
                    bool2 = null;
                } else {
                    bool2 = Boolean.TRUE;
                }
            }
            if (str.length() >= 4) {
                char cCharAt2 = str.charAt(3);
                if (cCharAt2 == '0') {
                    bool3 = Boolean.FALSE;
                } else if (cCharAt2 == '1') {
                    bool3 = Boolean.TRUE;
                }
                bool4 = bool3;
            }
            bool = bool4;
            bool4 = bool2;
        } else {
            bool = null;
        }
        return new C4004d(bool4, bool);
    }

    /* JADX INFO: renamed from: c */
    public static Boolean m5564c(Boolean bool, Boolean bool2) {
        if (bool == null) {
            return bool2;
        }
        if (bool2 == null) {
            return bool;
        }
        return Boolean.valueOf(bool.booleanValue() && bool2.booleanValue());
    }

    /* JADX INFO: renamed from: e */
    public static boolean m5565e(int i, int i2) {
        return i <= i2;
    }

    /* JADX INFO: renamed from: g */
    public static C4004d m5566g(Bundle bundle) {
        return bundle == null ? f10622a : new C4004d(m5567i(bundle.getString("ad_storage")), m5567i(bundle.getString("analytics_storage")));
    }

    /* JADX INFO: renamed from: i */
    public static Boolean m5567i(String str) {
        if (str == null) {
            return null;
        }
        if (str.equals("granted")) {
            return Boolean.TRUE;
        }
        if (str.equals("denied")) {
            return Boolean.FALSE;
        }
        return null;
    }

    /* JADX INFO: renamed from: d */
    public final String m5568d() {
        char c;
        StringBuilder sb = new StringBuilder("G1");
        Boolean bool = this.f10623b;
        char c2 = '0';
        if (bool == null) {
            c = '-';
        } else {
            c = bool.booleanValue() ? '1' : '0';
        }
        sb.append(c);
        Boolean bool2 = this.f10624c;
        if (bool2 == null) {
            c2 = '-';
        } else if (bool2.booleanValue()) {
            c2 = '1';
        }
        sb.append(c2);
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C4004d)) {
            return false;
        }
        C4004d c4004d = (C4004d) obj;
        return m5562a(this.f10623b) == m5562a(c4004d.f10623b) && m5562a(this.f10624c) == m5562a(c4004d.f10624c);
    }

    /* JADX INFO: renamed from: f */
    public final boolean m5569f(C4004d c4004d) {
        Boolean bool = this.f10623b;
        Boolean bool2 = Boolean.FALSE;
        if (bool != bool2 || c4004d.f10623b == bool2) {
            return this.f10624c == bool2 && c4004d.f10624c != bool2;
        }
        return true;
    }

    /* JADX INFO: renamed from: h */
    public final C4004d m5570h(C4004d c4004d) {
        return new C4004d(m5564c(this.f10623b, c4004d.f10623b), m5564c(this.f10624c, c4004d.f10624c));
    }

    public final int hashCode() {
        return m5562a(this.f10624c) + ((m5562a(this.f10623b) + 527) * 31);
    }

    /* JADX INFO: renamed from: j */
    public final boolean m5571j() {
        Boolean bool = this.f10623b;
        return bool == null || bool.booleanValue();
    }

    /* JADX INFO: renamed from: k */
    public final boolean m5572k() {
        Boolean bool = this.f10624c;
        return bool == null || bool.booleanValue();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ConsentSettings: ");
        sb.append("adStorage=");
        Boolean bool = this.f10623b;
        if (bool == null) {
            sb.append("uninitialized");
        } else {
            sb.append(bool.booleanValue() ? "granted" : "denied");
        }
        sb.append(", analyticsStorage=");
        Boolean bool2 = this.f10624c;
        if (bool2 == null) {
            sb.append("uninitialized");
        } else {
            sb.append(bool2.booleanValue() ? "granted" : "denied");
        }
        return sb.toString();
    }
}
