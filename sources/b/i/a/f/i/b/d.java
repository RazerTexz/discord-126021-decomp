package b.i.a.f.i.b;

import android.os.Bundle;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public static final d a = new d(null, null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Boolean f1523b;
    public final Boolean c;

    public d(Boolean bool, Boolean bool2) {
        this.f1523b = bool;
        this.c = bool2;
    }

    public static int a(Boolean bool) {
        if (bool == null) {
            return 0;
        }
        return bool.booleanValue() ? 1 : 2;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x001e  */
    public static d b(String str) {
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
        return new d(bool4, bool);
    }

    public static Boolean c(Boolean bool, Boolean bool2) {
        if (bool == null) {
            return bool2;
        }
        if (bool2 == null) {
            return bool;
        }
        return Boolean.valueOf(bool.booleanValue() && bool2.booleanValue());
    }

    public static boolean e(int i, int i2) {
        return i <= i2;
    }

    public static d g(Bundle bundle) {
        return bundle == null ? a : new d(i(bundle.getString("ad_storage")), i(bundle.getString("analytics_storage")));
    }

    public static Boolean i(String str) {
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

    public final String d() {
        char c;
        StringBuilder sb = new StringBuilder("G1");
        Boolean bool = this.f1523b;
        char c2 = '0';
        if (bool == null) {
            c = '-';
        } else {
            c = bool.booleanValue() ? '1' : '0';
        }
        sb.append(c);
        Boolean bool2 = this.c;
        if (bool2 == null) {
            c2 = '-';
        } else if (bool2.booleanValue()) {
            c2 = '1';
        }
        sb.append(c2);
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return a(this.f1523b) == a(dVar.f1523b) && a(this.c) == a(dVar.c);
    }

    public final boolean f(d dVar) {
        Boolean bool = this.f1523b;
        Boolean bool2 = Boolean.FALSE;
        if (bool != bool2 || dVar.f1523b == bool2) {
            return this.c == bool2 && dVar.c != bool2;
        }
        return true;
    }

    public final d h(d dVar) {
        return new d(c(this.f1523b, dVar.f1523b), c(this.c, dVar.c));
    }

    public final int hashCode() {
        return a(this.c) + ((a(this.f1523b) + 527) * 31);
    }

    public final boolean j() {
        Boolean bool = this.f1523b;
        return bool == null || bool.booleanValue();
    }

    public final boolean k() {
        Boolean bool = this.c;
        return bool == null || bool.booleanValue();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ConsentSettings: ");
        sb.append("adStorage=");
        Boolean bool = this.f1523b;
        if (bool == null) {
            sb.append("uninitialized");
        } else {
            sb.append(bool.booleanValue() ? "granted" : "denied");
        }
        sb.append(", analyticsStorage=");
        Boolean bool2 = this.c;
        if (bool2 == null) {
            sb.append("uninitialized");
        } else {
            sb.append(bool2.booleanValue() ? "granted" : "denied");
        }
        return sb.toString();
    }
}
