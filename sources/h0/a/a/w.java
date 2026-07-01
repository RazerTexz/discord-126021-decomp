package h0.a.a;

import com.adjust.sdk.Constants;
import com.discord.widgets.chat.input.MentionUtilsKt;

/* JADX INFO: compiled from: Type.java */
/* JADX INFO: loaded from: classes3.dex */
public final class w {
    public static final w a = new w(0, "VZCBSIFJD", 0, 1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final w f3726b = new w(1, "VZCBSIFJD", 1, 2);
    public static final w c = new w(2, "VZCBSIFJD", 2, 3);
    public static final w d = new w(3, "VZCBSIFJD", 3, 4);
    public static final w e = new w(4, "VZCBSIFJD", 4, 5);
    public static final w f = new w(5, "VZCBSIFJD", 5, 6);
    public static final w g = new w(6, "VZCBSIFJD", 6, 7);
    public static final w h = new w(7, "VZCBSIFJD", 7, 8);
    public static final w i = new w(8, "VZCBSIFJD", 8, 9);
    public final int j;
    public final String k;
    public final int l;
    public final int m;

    public w(int i2, String str, int i3, int i4) {
        this.j = i2;
        this.k = str;
        this.l = i3;
        this.m = i4;
    }

    public static w[] a(String str) {
        int i2 = 0;
        int iIndexOf = 1;
        int i3 = 0;
        while (str.charAt(iIndexOf) != ')') {
            while (str.charAt(iIndexOf) == '[') {
                iIndexOf++;
            }
            int i4 = iIndexOf + 1;
            iIndexOf = str.charAt(iIndexOf) == 'L' ? str.indexOf(59, i4) + 1 : i4;
            i3++;
        }
        w[] wVarArr = new w[i3];
        int i5 = 1;
        while (str.charAt(i5) != ')') {
            int i6 = i5;
            while (str.charAt(i6) == '[') {
                i6++;
            }
            int iIndexOf2 = i6 + 1;
            if (str.charAt(i6) == 'L') {
                iIndexOf2 = str.indexOf(59, iIndexOf2) + 1;
            }
            wVarArr[i2] = k(str, i5, iIndexOf2);
            i2++;
            i5 = iIndexOf2;
        }
        return wVarArr;
    }

    public static int b(String str) {
        char cCharAt = str.charAt(1);
        int i2 = 1;
        int i3 = 1;
        while (cCharAt != ')') {
            if (cCharAt == 'J' || cCharAt == 'D') {
                i2++;
                i3 += 2;
            } else {
                while (str.charAt(i2) == '[') {
                    i2++;
                }
                int iIndexOf = i2 + 1;
                if (str.charAt(i2) == 'L') {
                    iIndexOf = str.indexOf(59, iIndexOf) + 1;
                }
                i3++;
                i2 = iIndexOf;
            }
            cCharAt = str.charAt(i2);
        }
        char cCharAt2 = str.charAt(i2 + 1);
        if (cCharAt2 == 'V') {
            return i3 << 2;
        }
        return (i3 << 2) | ((cCharAt2 == 'J' || cCharAt2 == 'D') ? 2 : 1);
    }

    public static String e(Class<?> cls) {
        char c2;
        StringBuilder sb = new StringBuilder();
        while (cls.isArray()) {
            sb.append('[');
            cls = cls.getComponentType();
        }
        if (cls.isPrimitive()) {
            if (cls == Integer.TYPE) {
                c2 = 'I';
            } else if (cls == Void.TYPE) {
                c2 = 'V';
            } else if (cls == Boolean.TYPE) {
                c2 = 'Z';
            } else if (cls == Byte.TYPE) {
                c2 = 'B';
            } else if (cls == Character.TYPE) {
                c2 = 'C';
            } else if (cls == Short.TYPE) {
                c2 = 'S';
            } else if (cls == Double.TYPE) {
                c2 = 'D';
            } else if (cls == Float.TYPE) {
                c2 = 'F';
            } else {
                if (cls != Long.TYPE) {
                    throw new AssertionError();
                }
                c2 = 'J';
            }
            sb.append(c2);
        } else {
            sb.append('L');
            String name = cls.getName();
            int length = name.length();
            for (int i2 = 0; i2 < length; i2++) {
                char cCharAt = name.charAt(i2);
                if (cCharAt == '.') {
                    cCharAt = MentionUtilsKt.SLASH_CHAR;
                }
                sb.append(cCharAt);
            }
            sb.append(';');
        }
        return sb.toString();
    }

    public static w h(String str) {
        return new w(str.charAt(0) == '[' ? 9 : 12, str, 0, str.length());
    }

    public static w j(Class<?> cls) {
        if (!cls.isPrimitive()) {
            String strE = e(cls);
            return k(strE, 0, strE.length());
        }
        if (cls == Integer.TYPE) {
            return f;
        }
        if (cls == Void.TYPE) {
            return a;
        }
        if (cls == Boolean.TYPE) {
            return f3726b;
        }
        if (cls == Byte.TYPE) {
            return d;
        }
        if (cls == Character.TYPE) {
            return c;
        }
        if (cls == Short.TYPE) {
            return e;
        }
        if (cls == Double.TYPE) {
            return i;
        }
        if (cls == Float.TYPE) {
            return g;
        }
        if (cls == Long.TYPE) {
            return h;
        }
        throw new AssertionError();
    }

    public static w k(String str, int i2, int i3) {
        char cCharAt = str.charAt(i2);
        if (cCharAt == '(') {
            return new w(11, str, i2, i3);
        }
        if (cCharAt == 'F') {
            return g;
        }
        if (cCharAt == 'L') {
            return new w(10, str, i2 + 1, i3 - 1);
        }
        if (cCharAt == 'S') {
            return e;
        }
        if (cCharAt == 'V') {
            return a;
        }
        if (cCharAt == 'I') {
            return f;
        }
        if (cCharAt == 'J') {
            return h;
        }
        if (cCharAt == 'Z') {
            return f3726b;
        }
        if (cCharAt == '[') {
            return new w(9, str, i2, i3);
        }
        switch (cCharAt) {
            case 'B':
                return d;
            case 'C':
                return c;
            case 'D':
                return i;
            default:
                throw new IllegalArgumentException();
        }
    }

    public String c() {
        switch (this.j) {
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
                StringBuilder sb = new StringBuilder(k(this.k, this.l + f(), this.m).c());
                for (int iF = f(); iF > 0; iF--) {
                    sb.append("[]");
                }
                return sb.toString();
            case 10:
            case 12:
                return this.k.substring(this.l, this.m).replace(MentionUtilsKt.SLASH_CHAR, '.');
            case 11:
            default:
                throw new AssertionError();
        }
    }

    public String d() {
        int i2 = this.j;
        if (i2 == 10) {
            return this.k.substring(this.l - 1, this.m + 1);
        }
        if (i2 != 12) {
            return this.k.substring(this.l, this.m);
        }
        StringBuilder sbQ = b.d.b.a.a.Q('L');
        sbQ.append((CharSequence) this.k, this.l, this.m);
        sbQ.append(';');
        return sbQ.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        int i2 = this.j;
        if (i2 == 12) {
            i2 = 10;
        }
        int i3 = wVar.j;
        if (i2 != (i3 != 12 ? i3 : 10)) {
            return false;
        }
        int i4 = this.l;
        int i5 = this.m;
        int i6 = wVar.l;
        if (i5 - i4 != wVar.m - i6) {
            return false;
        }
        while (i4 < i5) {
            if (this.k.charAt(i4) != wVar.k.charAt(i6)) {
                return false;
            }
            i4++;
            i6++;
        }
        return true;
    }

    public int f() {
        int i2 = 1;
        while (this.k.charAt(this.l + i2) == '[') {
            i2++;
        }
        return i2;
    }

    public String g() {
        return this.k.substring(this.l, this.m);
    }

    public int hashCode() {
        int i2 = this.j;
        int iCharAt = (i2 == 12 ? 10 : i2) * 13;
        if (i2 >= 9) {
            int i3 = this.m;
            for (int i4 = this.l; i4 < i3; i4++) {
                iCharAt = (this.k.charAt(i4) + iCharAt) * 17;
            }
        }
        return iCharAt;
    }

    public int i() {
        int i2 = this.j;
        if (i2 == 12) {
            return 10;
        }
        return i2;
    }

    public String toString() {
        return d();
    }
}
