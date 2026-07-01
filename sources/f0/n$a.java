package f0;

import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Cookie.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class n$a {
    public n$a(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public final int a(String str, int i, int i2, boolean z2) {
        while (i < i2) {
            char cCharAt = str.charAt(i);
            if (((cCharAt < ' ' && cCharAt != '\t') || cCharAt >= 127 || ('0' <= cCharAt && '9' >= cCharAt) || (('a' <= cCharAt && 'z' >= cCharAt) || (('A' <= cCharAt && 'Z' >= cCharAt) || cCharAt == ':'))) == (!z2)) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public final boolean b(String str, String str2) {
        if (d0.z.d.m.areEqual(str, str2)) {
            return true;
        }
        if (d0.g0.t.endsWith$default(str, str2, false, 2, null) && str.charAt((str.length() - str2.length()) - 1) == '.') {
            byte[] bArr = f0.e0.c.a;
            d0.z.d.m.checkParameterIsNotNull(str, "$this$canParseAsIpAddress");
            if (!f0.e0.c.f.matches(str)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x00c4  */
    public final long c(String str, int i, int i2) {
        int iA = a(str, i, i2, false);
        Matcher matcher = n.d.matcher(str);
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        int iIndexOf$default = -1;
        int i6 = -1;
        int i7 = -1;
        while (iA < i2) {
            int iA2 = a(str, iA + 1, i2, true);
            matcher.region(iA, iA2);
            if (i4 == -1 && matcher.usePattern(n.d).matches()) {
                String strGroup = matcher.group(1);
                d0.z.d.m.checkExpressionValueIsNotNull(strGroup, "matcher.group(1)");
                i4 = Integer.parseInt(strGroup);
                String strGroup2 = matcher.group(2);
                d0.z.d.m.checkExpressionValueIsNotNull(strGroup2, "matcher.group(2)");
                i6 = Integer.parseInt(strGroup2);
                String strGroup3 = matcher.group(3);
                d0.z.d.m.checkExpressionValueIsNotNull(strGroup3, "matcher.group(3)");
                i7 = Integer.parseInt(strGroup3);
            } else if (i5 == -1 && matcher.usePattern(n.c).matches()) {
                String strGroup4 = matcher.group(1);
                d0.z.d.m.checkExpressionValueIsNotNull(strGroup4, "matcher.group(1)");
                i5 = Integer.parseInt(strGroup4);
            } else if (iIndexOf$default == -1) {
                Pattern pattern = n.f3676b;
                if (matcher.usePattern(pattern).matches()) {
                    String strGroup5 = matcher.group(1);
                    d0.z.d.m.checkExpressionValueIsNotNull(strGroup5, "matcher.group(1)");
                    Locale locale = Locale.US;
                    d0.z.d.m.checkExpressionValueIsNotNull(locale, "Locale.US");
                    if (strGroup5 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                    }
                    String lowerCase = strGroup5.toLowerCase(locale);
                    d0.z.d.m.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                    String strPattern = pattern.pattern();
                    d0.z.d.m.checkExpressionValueIsNotNull(strPattern, "MONTH_PATTERN.pattern()");
                    iIndexOf$default = d0.g0.w.indexOf$default((CharSequence) strPattern, lowerCase, 0, false, 6, (Object) null) / 4;
                } else if (i3 != -1 && matcher.usePattern(n.a).matches()) {
                    String strGroup6 = matcher.group(1);
                    d0.z.d.m.checkExpressionValueIsNotNull(strGroup6, "matcher.group(1)");
                    i3 = Integer.parseInt(strGroup6);
                }
            } else if (i3 != -1) {
            }
            iA = a(str, iA2 + 1, i2, false);
        }
        if (70 <= i3 && 99 >= i3) {
            i3 += 1900;
        }
        if (i3 >= 0 && 69 >= i3) {
            i3 += 2000;
        }
        if (!(i3 >= 1601)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (!(iIndexOf$default != -1)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (!(1 <= i5 && 31 >= i5)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (!(i4 >= 0 && 23 >= i4)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (!(i6 >= 0 && 59 >= i6)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (!(i7 >= 0 && 59 >= i7)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar(f0.e0.c.e);
        gregorianCalendar.setLenient(false);
        gregorianCalendar.set(1, i3);
        gregorianCalendar.set(2, iIndexOf$default - 1);
        gregorianCalendar.set(5, i5);
        gregorianCalendar.set(11, i4);
        gregorianCalendar.set(12, i6);
        gregorianCalendar.set(13, i7);
        gregorianCalendar.set(14, 0);
        return gregorianCalendar.getTimeInMillis();
    }
}
