package p507d0.p513e0.p514p.p515d.p517m0.p573o.p574m;

import java.util.Iterator;
import java.util.Objects;
import p507d0.p579g0.C12103t;
import p507d0.p579g0.C12106w;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.o.m.a */
/* JADX INFO: compiled from: capitalizeDecapitalize.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12031a {
    /* JADX INFO: renamed from: a */
    public static final boolean m10040a(String str, int i, boolean z2) {
        char cCharAt = str.charAt(i);
        if (z2) {
            return 'A' <= cCharAt && cCharAt <= 'Z';
        }
        return Character.isUpperCase(cCharAt);
    }

    /* JADX INFO: renamed from: b */
    public static final String m10041b(String str, boolean z2) {
        if (z2) {
            return toLowerCaseAsciiOnly(str);
        }
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = str.toLowerCase();
        C12238m.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
        return lowerCase;
    }

    public static final String capitalizeAsciiOnly(String str) {
        C12238m.checkNotNullParameter(str, "<this>");
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
        C12238m.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
        return String.valueOf(upperCase) + strSubstring;
    }

    public static final String decapitalizeAsciiOnly(String str) {
        C12238m.checkNotNullParameter(str, "<this>");
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
        C12238m.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
        return String.valueOf(lowerCase) + strSubstring;
    }

    public static final String decapitalizeSmartForCompiler(String str, boolean z2) {
        Integer next;
        C12238m.checkNotNullParameter(str, "<this>");
        if ((str.length() == 0) || !m10040a(str, 0, z2)) {
            return str;
        }
        if (str.length() == 1 || !m10040a(str, 1, z2)) {
            return z2 ? decapitalizeAsciiOnly(str) : C12103t.decapitalize(str);
        }
        Iterator<Integer> it = C12106w.getIndices(str).iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!(!m10040a(str, next.intValue(), z2)));
        Integer num = next;
        if (num == null) {
            return m10041b(str, z2);
        }
        int iIntValue = num.intValue() - 1;
        String strSubstring = str.substring(0, iIntValue);
        C12238m.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        String strM10041b = m10041b(strSubstring, z2);
        String strSubstring2 = str.substring(iIntValue);
        C12238m.checkNotNullExpressionValue(strSubstring2, "(this as java.lang.String).substring(startIndex)");
        return C12238m.stringPlus(strM10041b, strSubstring2);
    }

    public static final String toLowerCaseAsciiOnly(String str) {
        C12238m.checkNotNullParameter(str, "<this>");
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
        C12238m.checkNotNullExpressionValue(string, "builder.toString()");
        return string;
    }
}
