package d0.e0.p.d.m0.o.m;

import d0.g0.Strings4;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: renamed from: d0.e0.p.d.m0.o.m.a, reason: use source file name */
/* JADX INFO: compiled from: capitalizeDecapitalize.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class capitalizeDecapitalize {
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
        Intrinsics3.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
        return lowerCase;
    }

    public static final String capitalizeAsciiOnly(String str) {
        Intrinsics3.checkNotNullParameter(str, "<this>");
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
        Intrinsics3.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
        return String.valueOf(upperCase) + strSubstring;
    }

    public static final String decapitalizeAsciiOnly(String str) {
        Intrinsics3.checkNotNullParameter(str, "<this>");
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
        Intrinsics3.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
        return String.valueOf(lowerCase) + strSubstring;
    }

    public static final String decapitalizeSmartForCompiler(String str, boolean z2) {
        Integer next;
        Intrinsics3.checkNotNullParameter(str, "<this>");
        if ((str.length() == 0) || !a(str, 0, z2)) {
            return str;
        }
        if (str.length() == 1 || !a(str, 1, z2)) {
            return z2 ? decapitalizeAsciiOnly(str) : StringsJVM.decapitalize(str);
        }
        Iterator<Integer> it = Strings4.getIndices(str).iterator();
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
        Intrinsics3.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        String strB = b(strSubstring, z2);
        String strSubstring2 = str.substring(iIntValue);
        Intrinsics3.checkNotNullExpressionValue(strSubstring2, "(this as java.lang.String).substring(startIndex)");
        return Intrinsics3.stringPlus(strB, strSubstring2);
    }

    public static final String toLowerCaseAsciiOnly(String str) {
        Intrinsics3.checkNotNullParameter(str, "<this>");
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
        Intrinsics3.checkNotNullExpressionValue(string, "builder.toString()");
        return string;
    }
}
