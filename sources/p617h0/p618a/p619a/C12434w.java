package p617h0.p618a.p619a;

import com.adjust.sdk.Constants;
import com.discord.widgets.chat.input.MentionUtilsKt;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: h0.a.a.w */
/* JADX INFO: compiled from: Type.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12434w {

    /* JADX INFO: renamed from: a */
    public static final C12434w f26361a = new C12434w(0, "VZCBSIFJD", 0, 1);

    /* JADX INFO: renamed from: b */
    public static final C12434w f26362b = new C12434w(1, "VZCBSIFJD", 1, 2);

    /* JADX INFO: renamed from: c */
    public static final C12434w f26363c = new C12434w(2, "VZCBSIFJD", 2, 3);

    /* JADX INFO: renamed from: d */
    public static final C12434w f26364d = new C12434w(3, "VZCBSIFJD", 3, 4);

    /* JADX INFO: renamed from: e */
    public static final C12434w f26365e = new C12434w(4, "VZCBSIFJD", 4, 5);

    /* JADX INFO: renamed from: f */
    public static final C12434w f26366f = new C12434w(5, "VZCBSIFJD", 5, 6);

    /* JADX INFO: renamed from: g */
    public static final C12434w f26367g = new C12434w(6, "VZCBSIFJD", 6, 7);

    /* JADX INFO: renamed from: h */
    public static final C12434w f26368h = new C12434w(7, "VZCBSIFJD", 7, 8);

    /* JADX INFO: renamed from: i */
    public static final C12434w f26369i = new C12434w(8, "VZCBSIFJD", 8, 9);

    /* JADX INFO: renamed from: j */
    public final int f26370j;

    /* JADX INFO: renamed from: k */
    public final String f26371k;

    /* JADX INFO: renamed from: l */
    public final int f26372l;

    /* JADX INFO: renamed from: m */
    public final int f26373m;

    public C12434w(int i, String str, int i2, int i3) {
        this.f26370j = i;
        this.f26371k = str;
        this.f26372l = i2;
        this.f26373m = i3;
    }

    /* JADX INFO: renamed from: a */
    public static C12434w[] m10644a(String str) {
        int i = 0;
        int iIndexOf = 1;
        int i2 = 0;
        while (str.charAt(iIndexOf) != ')') {
            while (str.charAt(iIndexOf) == '[') {
                iIndexOf++;
            }
            int i3 = iIndexOf + 1;
            iIndexOf = str.charAt(iIndexOf) == 'L' ? str.indexOf(59, i3) + 1 : i3;
            i2++;
        }
        C12434w[] c12434wArr = new C12434w[i2];
        int i4 = 1;
        while (str.charAt(i4) != ')') {
            int i5 = i4;
            while (str.charAt(i5) == '[') {
                i5++;
            }
            int iIndexOf2 = i5 + 1;
            if (str.charAt(i5) == 'L') {
                iIndexOf2 = str.indexOf(59, iIndexOf2) + 1;
            }
            c12434wArr[i] = m10649k(str, i4, iIndexOf2);
            i++;
            i4 = iIndexOf2;
        }
        return c12434wArr;
    }

    /* JADX INFO: renamed from: b */
    public static int m10645b(String str) {
        char cCharAt = str.charAt(1);
        int i = 1;
        int i2 = 1;
        while (cCharAt != ')') {
            if (cCharAt == 'J' || cCharAt == 'D') {
                i++;
                i2 += 2;
            } else {
                while (str.charAt(i) == '[') {
                    i++;
                }
                int iIndexOf = i + 1;
                if (str.charAt(i) == 'L') {
                    iIndexOf = str.indexOf(59, iIndexOf) + 1;
                }
                i2++;
                i = iIndexOf;
            }
            cCharAt = str.charAt(i);
        }
        char cCharAt2 = str.charAt(i + 1);
        if (cCharAt2 == 'V') {
            return i2 << 2;
        }
        return (i2 << 2) | ((cCharAt2 == 'J' || cCharAt2 == 'D') ? 2 : 1);
    }

    /* JADX INFO: renamed from: e */
    public static String m10646e(Class<?> cls) {
        char c;
        StringBuilder sb = new StringBuilder();
        while (cls.isArray()) {
            sb.append('[');
            cls = cls.getComponentType();
        }
        if (cls.isPrimitive()) {
            if (cls == Integer.TYPE) {
                c = 'I';
            } else if (cls == Void.TYPE) {
                c = 'V';
            } else if (cls == Boolean.TYPE) {
                c = 'Z';
            } else if (cls == Byte.TYPE) {
                c = 'B';
            } else if (cls == Character.TYPE) {
                c = 'C';
            } else if (cls == Short.TYPE) {
                c = 'S';
            } else if (cls == Double.TYPE) {
                c = 'D';
            } else if (cls == Float.TYPE) {
                c = 'F';
            } else {
                if (cls != Long.TYPE) {
                    throw new AssertionError();
                }
                c = 'J';
            }
            sb.append(c);
        } else {
            sb.append('L');
            String name = cls.getName();
            int length = name.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = name.charAt(i);
                if (cCharAt == '.') {
                    cCharAt = MentionUtilsKt.SLASH_CHAR;
                }
                sb.append(cCharAt);
            }
            sb.append(';');
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: h */
    public static C12434w m10647h(String str) {
        return new C12434w(str.charAt(0) == '[' ? 9 : 12, str, 0, str.length());
    }

    /* JADX INFO: renamed from: j */
    public static C12434w m10648j(Class<?> cls) {
        if (!cls.isPrimitive()) {
            String strM10646e = m10646e(cls);
            return m10649k(strM10646e, 0, strM10646e.length());
        }
        if (cls == Integer.TYPE) {
            return f26366f;
        }
        if (cls == Void.TYPE) {
            return f26361a;
        }
        if (cls == Boolean.TYPE) {
            return f26362b;
        }
        if (cls == Byte.TYPE) {
            return f26364d;
        }
        if (cls == Character.TYPE) {
            return f26363c;
        }
        if (cls == Short.TYPE) {
            return f26365e;
        }
        if (cls == Double.TYPE) {
            return f26369i;
        }
        if (cls == Float.TYPE) {
            return f26367g;
        }
        if (cls == Long.TYPE) {
            return f26368h;
        }
        throw new AssertionError();
    }

    /* JADX INFO: renamed from: k */
    public static C12434w m10649k(String str, int i, int i2) {
        char cCharAt = str.charAt(i);
        if (cCharAt == '(') {
            return new C12434w(11, str, i, i2);
        }
        if (cCharAt == 'F') {
            return f26367g;
        }
        if (cCharAt == 'L') {
            return new C12434w(10, str, i + 1, i2 - 1);
        }
        if (cCharAt == 'S') {
            return f26365e;
        }
        if (cCharAt == 'V') {
            return f26361a;
        }
        if (cCharAt == 'I') {
            return f26366f;
        }
        if (cCharAt == 'J') {
            return f26368h;
        }
        if (cCharAt == 'Z') {
            return f26362b;
        }
        if (cCharAt == '[') {
            return new C12434w(9, str, i, i2);
        }
        switch (cCharAt) {
            case 'B':
                return f26364d;
            case 'C':
                return f26363c;
            case 'D':
                return f26369i;
            default:
                throw new IllegalArgumentException();
        }
    }

    /* JADX INFO: renamed from: c */
    public String m10650c() {
        switch (this.f26370j) {
            case 0:
                return "void";
            case 1:
                return "boolean";
            case 2:
                return "char";
            case 3:
                return "byte";
            case 4:
                return "short";
            case 5:
                return "int";
            case 6:
                return "float";
            case 7:
                return Constants.LONG;
            case 8:
                return "double";
            case 9:
                StringBuilder sb = new StringBuilder(m10649k(this.f26371k, this.f26372l + m10652f(), this.f26373m).m10650c());
                for (int iM10652f = m10652f(); iM10652f > 0; iM10652f--) {
                    sb.append("[]");
                }
                return sb.toString();
            case 10:
            case 12:
                return this.f26371k.substring(this.f26372l, this.f26373m).replace(MentionUtilsKt.SLASH_CHAR, '.');
            case 11:
            default:
                throw new AssertionError();
        }
    }

    /* JADX INFO: renamed from: d */
    public String m10651d() {
        int i = this.f26370j;
        if (i == 10) {
            return this.f26371k.substring(this.f26372l - 1, this.f26373m + 1);
        }
        if (i != 12) {
            return this.f26371k.substring(this.f26372l, this.f26373m);
        }
        StringBuilder sbM829Q = C1643a.m829Q('L');
        sbM829Q.append((CharSequence) this.f26371k, this.f26372l, this.f26373m);
        sbM829Q.append(';');
        return sbM829Q.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C12434w)) {
            return false;
        }
        C12434w c12434w = (C12434w) obj;
        int i = this.f26370j;
        if (i == 12) {
            i = 10;
        }
        int i2 = c12434w.f26370j;
        if (i != (i2 != 12 ? i2 : 10)) {
            return false;
        }
        int i3 = this.f26372l;
        int i4 = this.f26373m;
        int i5 = c12434w.f26372l;
        if (i4 - i3 != c12434w.f26373m - i5) {
            return false;
        }
        while (i3 < i4) {
            if (this.f26371k.charAt(i3) != c12434w.f26371k.charAt(i5)) {
                return false;
            }
            i3++;
            i5++;
        }
        return true;
    }

    /* JADX INFO: renamed from: f */
    public int m10652f() {
        int i = 1;
        while (this.f26371k.charAt(this.f26372l + i) == '[') {
            i++;
        }
        return i;
    }

    /* JADX INFO: renamed from: g */
    public String m10653g() {
        return this.f26371k.substring(this.f26372l, this.f26373m);
    }

    public int hashCode() {
        int i = this.f26370j;
        int iCharAt = (i == 12 ? 10 : i) * 13;
        if (i >= 9) {
            int i2 = this.f26373m;
            for (int i3 = this.f26372l; i3 < i2; i3++) {
                iCharAt = (this.f26371k.charAt(i3) + iCharAt) * 17;
            }
        }
        return iCharAt;
    }

    /* JADX INFO: renamed from: i */
    public int m10654i() {
        int i = this.f26370j;
        if (i == 12) {
            return 10;
        }
        return i;
    }

    public String toString() {
        return m10651d();
    }
}
