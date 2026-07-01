package d0.e0.p.d.m0.o.m;

import d0.g0.t;
import d0.g0.w;
import d0.z.d.m;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: capitalizeDecapitalize.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static final boolean a(String str, int i, boolean z2) {
        char cCharAt = str.charAt(i);
        if (z2) {
            return 'A' <= cCharAt && cCharAt <= 'Z';
        }
        return Character.isUpperCase(cCharAt);
    }

    public static final String b(String str, boolean z2) {
        if (z2) {
            return toLowerCaseAsciiOnly(str);
        }
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = str.toLowerCase();
        m.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
        return lowerCase;
    }

    public static final String capitalizeAsciiOnly(String str) {
        m.checkNotNullParameter(str, "<this>");
        boolean z2 = false;
        if (str.length() == 0) {
            return str;
        }
        char cCharAt = str.charAt(0);
        if ('a' <= cCharAt && cCharAt <= 'z') {
            z2 = true;
        }
        if (!z2) {
            return str;
        }
        char upperCase = Character.toUpperCase(cCharAt);
        String strSubstring = str.substring(1);
        m.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
        return String.valueOf(upperCase) + strSubstring;
    }

    public static final String decapitalizeAsciiOnly(String str) {
        m.checkNotNullParameter(str, "<this>");
        boolean z2 = false;
        if (str.length() == 0) {
            return str;
        }
        char cCharAt = str.charAt(0);
        if ('A' <= cCharAt && cCharAt <= 'Z') {
            z2 = true;
        }
        if (!z2) {
            return str;
        }
        char lowerCase = Character.toLowerCase(cCharAt);
        String strSubstring = str.substring(1);
        m.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
        return String.valueOf(lowerCase) + strSubstring;
    }

    public static final String decapitalizeSmartForCompiler(String str, boolean z2) {
        Integer next;
        m.checkNotNullParameter(str, "<this>");
        if ((str.length() == 0) || !a(str, 0, z2)) {
            return str;
        }
        if (str.length() == 1 || !a(str, 1, z2)) {
            return z2 ? decapitalizeAsciiOnly(str) : t.decapitalize(str);
        }
        Iterator<Integer> it = w.getIndices(str).iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!(!a(str, next.intValue(), z2)));
        Integer num = next;
        if (num == null) {
            return b(str, z2);
        }
        int iIntValue = num.intValue() - 1;
        String strSubstring = str.substring(0, iIntValue);
        m.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        String strB = b(strSubstring, z2);
        String strSubstring2 = str.substring(iIntValue);
        m.checkNotNullExpressionValue(strSubstring2, "(this as java.lang.String).substring(startIndex)");
        return m.stringPlus(strB, strSubstring2);
    }

    public static final String toLowerCaseAsciiOnly(String str) {
        m.checkNotNullParameter(str, "<this>");
        StringBuilder sb = new StringBuilder(str.length());
        int length = str.length();
        int i = 0;
        while (i < length) {
            char cCharAt = str.charAt(i);
            i++;
            if ('A' <= cCharAt && cCharAt <= 'Z') {
                cCharAt = Character.toLowerCase(cCharAt);
            }
            sb.append(cCharAt);
        }
        String string = sb.toString();
        m.checkNotNullExpressionValue(string, "builder.toString()");
        return string;
    }
}
