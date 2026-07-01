package d0.g0;

import d0.t.c0;
import d0.z.d.d0;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: compiled from: StringsJVM.kt */
/* JADX INFO: loaded from: classes3.dex */
public class t extends s {
    public static final String capitalize(String str) {
        d0.z.d.m.checkNotNullParameter(str, "$this$capitalize");
        Locale locale = Locale.getDefault();
        d0.z.d.m.checkNotNullExpressionValue(locale, "Locale.getDefault()");
        return capitalize(str, locale);
    }

    public static final int compareTo(String str, String str2, boolean z2) {
        d0.z.d.m.checkNotNullParameter(str, "$this$compareTo");
        d0.z.d.m.checkNotNullParameter(str2, "other");
        return z2 ? str.compareToIgnoreCase(str2) : str.compareTo(str2);
    }

    public static final String decapitalize(String str) {
        d0.z.d.m.checkNotNullParameter(str, "$this$decapitalize");
        if (!(str.length() > 0) || Character.isLowerCase(str.charAt(0))) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        String strSubstring = str.substring(0, 1);
        d0.z.d.m.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        Objects.requireNonNull(strSubstring, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = strSubstring.toLowerCase();
        d0.z.d.m.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
        sb.append(lowerCase);
        String strSubstring2 = str.substring(1);
        d0.z.d.m.checkNotNullExpressionValue(strSubstring2, "(this as java.lang.String).substring(startIndex)");
        sb.append(strSubstring2);
        return sb.toString();
    }

    public static final boolean endsWith(String str, String str2, boolean z2) {
        d0.z.d.m.checkNotNullParameter(str, "$this$endsWith");
        d0.z.d.m.checkNotNullParameter(str2, "suffix");
        return !z2 ? str.endsWith(str2) : regionMatches(str, str.length() - str2.length(), str2, 0, str2.length(), true);
    }

    public static /* synthetic */ boolean endsWith$default(String str, String str2, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        return endsWith(str, str2, z2);
    }

    public static final boolean equals(String str, String str2, boolean z2) {
        if (str == null) {
            return str2 == null;
        }
        return !z2 ? str.equals(str2) : str.equalsIgnoreCase(str2);
    }

    public static /* synthetic */ boolean equals$default(String str, String str2, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        return equals(str, str2, z2);
    }

    public static final Comparator<String> getCASE_INSENSITIVE_ORDER(d0 d0Var) {
        d0.z.d.m.checkNotNullParameter(d0Var, "$this$CASE_INSENSITIVE_ORDER");
        Comparator<String> comparator = String.CASE_INSENSITIVE_ORDER;
        d0.z.d.m.checkNotNullExpressionValue(comparator, "java.lang.String.CASE_INSENSITIVE_ORDER");
        return comparator;
    }

    public static final boolean isBlank(CharSequence charSequence) {
        boolean z2;
        d0.z.d.m.checkNotNullParameter(charSequence, "$this$isBlank");
        if (charSequence.length() != 0) {
            Iterable indices = w.getIndices(charSequence);
            if ((indices instanceof Collection) && ((Collection) indices).isEmpty()) {
                z2 = true;
            } else {
                Iterator it = indices.iterator();
                while (it.hasNext()) {
                    if (!a.isWhitespace(charSequence.charAt(((c0) it).nextInt()))) {
                        z2 = false;
                    }
                }
                z2 = true;
            }
            if (!z2) {
                return false;
            }
        }
        return true;
    }

    public static final boolean regionMatches(String str, int i, String str2, int i2, int i3, boolean z2) {
        d0.z.d.m.checkNotNullParameter(str, "$this$regionMatches");
        d0.z.d.m.checkNotNullParameter(str2, "other");
        return !z2 ? str.regionMatches(i, str2, i2, i3) : str.regionMatches(z2, i, str2, i2, i3);
    }

    public static final String repeat(CharSequence charSequence, int i) {
        d0.z.d.m.checkNotNullParameter(charSequence, "$this$repeat");
        int i2 = 1;
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + i + '.').toString());
        }
        if (i == 0) {
            return "";
        }
        if (i == 1) {
            return charSequence.toString();
        }
        int length = charSequence.length();
        if (length == 0) {
            return "";
        }
        if (length == 1) {
            char cCharAt = charSequence.charAt(0);
            char[] cArr = new char[i];
            for (int i3 = 0; i3 < i; i3++) {
                cArr[i3] = cCharAt;
            }
            return new String(cArr);
        }
        StringBuilder sb = new StringBuilder(charSequence.length() * i);
        if (1 <= i) {
            while (true) {
                sb.append(charSequence);
                if (i2 == i) {
                    break;
                }
                i2++;
            }
        }
        String string = sb.toString();
        d0.z.d.m.checkNotNullExpressionValue(string, "sb.toString()");
        return string;
    }

    public static final String replace(String str, char c, char c2, boolean z2) {
        d0.z.d.m.checkNotNullParameter(str, "$this$replace");
        if (!z2) {
            String strReplace = str.replace(c, c2);
            d0.z.d.m.checkNotNullExpressionValue(strReplace, "(this as java.lang.Strin…replace(oldChar, newChar)");
            return strReplace;
        }
        StringBuilder sb = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (b.equals(cCharAt, c, z2)) {
                cCharAt = c2;
            }
            sb.append(cCharAt);
        }
        String string = sb.toString();
        d0.z.d.m.checkNotNullExpressionValue(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }

    public static /* synthetic */ String replace$default(String str, char c, char c2, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = false;
        }
        return replace(str, c, c2, z2);
    }

    public static final String replaceFirst(String str, String str2, String str3, boolean z2) {
        b.d.b.a.a.q0(str, "$this$replaceFirst", str2, "oldValue", str3, "newValue");
        int iIndexOf$default = w.indexOf$default(str, str2, 0, z2, 2, (Object) null);
        return iIndexOf$default < 0 ? str : w.replaceRange(str, iIndexOf$default, str2.length() + iIndexOf$default, str3).toString();
    }

    public static /* synthetic */ String replaceFirst$default(String str, String str2, String str3, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = false;
        }
        return replaceFirst(str, str2, str3, z2);
    }

    public static final boolean startsWith(String str, String str2, boolean z2) {
        d0.z.d.m.checkNotNullParameter(str, "$this$startsWith");
        d0.z.d.m.checkNotNullParameter(str2, "prefix");
        return !z2 ? str.startsWith(str2) : regionMatches(str, 0, str2, 0, str2.length(), z2);
    }

    public static /* synthetic */ boolean startsWith$default(String str, String str2, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        return startsWith(str, str2, z2);
    }

    public static final String capitalize(String str, Locale locale) {
        d0.z.d.m.checkNotNullParameter(str, "$this$capitalize");
        d0.z.d.m.checkNotNullParameter(locale, "locale");
        if (!(str.length() > 0)) {
            return str;
        }
        char cCharAt = str.charAt(0);
        if (!Character.isLowerCase(cCharAt)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        char titleCase = Character.toTitleCase(cCharAt);
        if (titleCase != Character.toUpperCase(cCharAt)) {
            sb.append(titleCase);
        } else {
            String strSubstring = str.substring(0, 1);
            d0.z.d.m.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            Objects.requireNonNull(strSubstring, "null cannot be cast to non-null type java.lang.String");
            String upperCase = strSubstring.toUpperCase(locale);
            d0.z.d.m.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase(locale)");
            sb.append(upperCase);
        }
        String strSubstring2 = str.substring(1);
        d0.z.d.m.checkNotNullExpressionValue(strSubstring2, "(this as java.lang.String).substring(startIndex)");
        sb.append(strSubstring2);
        String string = sb.toString();
        d0.z.d.m.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public static /* synthetic */ String replace$default(String str, String str2, String str3, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = false;
        }
        return replace(str, str2, str3, z2);
    }

    public static /* synthetic */ boolean startsWith$default(String str, String str2, int i, boolean z2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z2 = false;
        }
        return startsWith(str, str2, i, z2);
    }

    public static final boolean startsWith(String str, String str2, int i, boolean z2) {
        d0.z.d.m.checkNotNullParameter(str, "$this$startsWith");
        d0.z.d.m.checkNotNullParameter(str2, "prefix");
        if (!z2) {
            return str.startsWith(str2, i);
        }
        return regionMatches(str, i, str2, 0, str2.length(), z2);
    }

    public static final String replace(String str, String str2, String str3, boolean z2) {
        d0.z.d.m.checkNotNullParameter(str, "$this$replace");
        d0.z.d.m.checkNotNullParameter(str2, "oldValue");
        d0.z.d.m.checkNotNullParameter(str3, "newValue");
        int i = 0;
        int iIndexOf = w.indexOf(str, str2, 0, z2);
        if (iIndexOf < 0) {
            return str;
        }
        int length = str2.length();
        int iCoerceAtLeast = d0.d0.f.coerceAtLeast(length, 1);
        int length2 = str3.length() + (str.length() - length);
        if (length2 >= 0) {
            StringBuilder sb = new StringBuilder(length2);
            do {
                sb.append((CharSequence) str, i, iIndexOf);
                sb.append(str3);
                i = iIndexOf + length;
                if (iIndexOf >= str.length()) {
                    break;
                }
                iIndexOf = w.indexOf(str, str2, iIndexOf + iCoerceAtLeast, z2);
            } while (iIndexOf > 0);
            sb.append((CharSequence) str, i, str.length());
            String string = sb.toString();
            d0.z.d.m.checkNotNullExpressionValue(string, "stringBuilder.append(this, i, length).toString()");
            return string;
        }
        throw new OutOfMemoryError();
    }
}
