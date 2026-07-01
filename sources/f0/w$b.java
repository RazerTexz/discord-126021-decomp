package f0;

import com.adjust.sdk.Constants;
import com.google.android.material.badge.BadgeDrawable;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: HttpUrl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class w$b {
    public w$b(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public static String a(w$b w_b, String str, int i, int i2, String str2, boolean z2, boolean z3, boolean z4, boolean z5, Charset charset, int i3) {
        int i4;
        String str3;
        boolean z6;
        String str4;
        int i5 = (i3 & 1) != 0 ? 0 : i;
        int length = (i3 & 2) != 0 ? str.length() : i2;
        boolean z7 = (i3 & 8) != 0 ? false : z2;
        boolean z8 = (i3 & 16) != 0 ? false : z3;
        boolean z9 = (i3 & 32) != 0 ? false : z4;
        boolean z10 = (i3 & 64) != 0 ? false : z5;
        Charset charset2 = (i3 & 128) != 0 ? null : charset;
        d0.z.d.m.checkParameterIsNotNull(str, "$this$canonicalize");
        d0.z.d.m.checkParameterIsNotNull(str2, "encodeSet");
        int iCharCount = i5;
        while (true) {
            if (iCharCount >= length) {
                String strSubstring = str.substring(i5, length);
                d0.z.d.m.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                return strSubstring;
            }
            int iCodePointAt = str.codePointAt(iCharCount);
            i4 = 2;
            if (iCodePointAt < 32 || iCodePointAt == 127 || (iCodePointAt >= 128 && !z10)) {
                str3 = "(this as java.lang.Strin…ing(startIndex, endIndex)";
                break;
            }
            str3 = "(this as java.lang.Strin…ing(startIndex, endIndex)";
            if (d0.g0.w.contains$default((CharSequence) str2, (char) iCodePointAt, false, 2, (Object) null) || ((iCodePointAt == 37 && (!z7 || (z8 && !w_b.c(str, iCharCount, length)))) || (iCodePointAt == 43 && z9))) {
                break;
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        g0.e eVar = new g0.e();
        eVar.c0(str, i5, iCharCount);
        g0.e eVar2 = null;
        while (iCharCount < length) {
            int iCodePointAt2 = str.codePointAt(iCharCount);
            if (z7 && (iCodePointAt2 == 9 || iCodePointAt2 == 10 || iCodePointAt2 == 12 || iCodePointAt2 == 13)) {
                z6 = z9;
                str4 = str3;
            } else if (iCodePointAt2 == 43 && z9) {
                eVar.b0(z7 ? BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX : "%2B");
                z6 = z9;
                str4 = str3;
            } else {
                if (iCodePointAt2 < 32 || iCodePointAt2 == 127 || (iCodePointAt2 >= 128 && !z10)) {
                    z6 = z9;
                } else {
                    z6 = z9;
                    if (!d0.g0.w.contains$default((CharSequence) str2, (char) iCodePointAt2, false, i4, (Object) null) && (iCodePointAt2 != 37 || (z7 && (!z8 || w_b.c(str, iCharCount, length))))) {
                        eVar.d0(iCodePointAt2);
                        str4 = str3;
                    }
                }
                if (eVar2 == null) {
                    eVar2 = new g0.e();
                }
                if (charset2 == null || d0.z.d.m.areEqual(charset2, StandardCharsets.UTF_8)) {
                    str4 = str3;
                    eVar2.d0(iCodePointAt2);
                } else {
                    int iCharCount2 = Character.charCount(iCodePointAt2) + iCharCount;
                    d0.z.d.m.checkParameterIsNotNull(str, "string");
                    d0.z.d.m.checkParameterIsNotNull(charset2, "charset");
                    if (!(iCharCount >= 0)) {
                        throw new IllegalArgumentException(b.d.b.a.a.q("beginIndex < 0: ", iCharCount).toString());
                    }
                    if (!(iCharCount2 >= iCharCount)) {
                        throw new IllegalArgumentException(b.d.b.a.a.s("endIndex < beginIndex: ", iCharCount2, " < ", iCharCount).toString());
                    }
                    if (!(iCharCount2 <= str.length())) {
                        StringBuilder sbV = b.d.b.a.a.V("endIndex > string.length: ", iCharCount2, " > ");
                        sbV.append(str.length());
                        throw new IllegalArgumentException(sbV.toString().toString());
                    }
                    if (d0.z.d.m.areEqual(charset2, d0.g0.c.a)) {
                        eVar2.c0(str, iCharCount, iCharCount2);
                        str4 = str3;
                    } else {
                        String strSubstring2 = str.substring(iCharCount, iCharCount2);
                        str4 = str3;
                        d0.z.d.m.checkExpressionValueIsNotNull(strSubstring2, str4);
                        if (strSubstring2 == null) {
                            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                        }
                        byte[] bytes = strSubstring2.getBytes(charset2);
                        d0.z.d.m.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
                        eVar2.S(bytes, 0, bytes.length);
                    }
                }
                while (!eVar2.w()) {
                    int i6 = eVar2.readByte() & 255;
                    eVar.T(37);
                    char[] cArr = w.a;
                    eVar.T(cArr[(i6 >> 4) & 15]);
                    eVar.T(cArr[i6 & 15]);
                }
            }
            iCharCount += Character.charCount(iCodePointAt2);
            i4 = 2;
            z9 = z6;
            str3 = str4;
        }
        return eVar.D();
    }

    public static String d(w$b w_b, String str, int i, int i2, boolean z2, int i3) {
        int i4;
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        if ((i3 & 4) != 0) {
            z2 = false;
        }
        d0.z.d.m.checkParameterIsNotNull(str, "$this$percentDecode");
        int iCharCount = i;
        while (iCharCount < i2) {
            char cCharAt = str.charAt(iCharCount);
            if (cCharAt == '%' || (cCharAt == '+' && z2)) {
                g0.e eVar = new g0.e();
                eVar.c0(str, i, iCharCount);
                while (iCharCount < i2) {
                    int iCodePointAt = str.codePointAt(iCharCount);
                    if (iCodePointAt == 37 && (i4 = iCharCount + 2) < i2) {
                        int iR = f0.e0.c.r(str.charAt(iCharCount + 1));
                        int iR2 = f0.e0.c.r(str.charAt(i4));
                        if (iR == -1 || iR2 == -1) {
                            eVar.d0(iCodePointAt);
                            iCharCount += Character.charCount(iCodePointAt);
                        } else {
                            eVar.T((iR << 4) + iR2);
                            iCharCount = Character.charCount(iCodePointAt) + i4;
                        }
                    } else if (iCodePointAt == 43 && z2) {
                        eVar.T(32);
                        iCharCount++;
                    } else {
                        eVar.d0(iCodePointAt);
                        iCharCount += Character.charCount(iCodePointAt);
                    }
                }
                return eVar.D();
            }
            iCharCount++;
        }
        String strSubstring = str.substring(i, i2);
        d0.z.d.m.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final int b(String str) {
        d0.z.d.m.checkParameterIsNotNull(str, "scheme");
        int iHashCode = str.hashCode();
        if (iHashCode != 3213448) {
            if (iHashCode == 99617003 && str.equals(Constants.SCHEME)) {
                return 443;
            }
        } else if (str.equals("http")) {
            return 80;
        }
        return -1;
    }

    public final boolean c(String str, int i, int i2) {
        int i3 = i + 2;
        return i3 < i2 && str.charAt(i) == '%' && f0.e0.c.r(str.charAt(i + 1)) != -1 && f0.e0.c.r(str.charAt(i3)) != -1;
    }

    public final List<String> e(String str) {
        d0.z.d.m.checkParameterIsNotNull(str, "$this$toQueryNamesAndValues");
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i <= str.length()) {
            int iIndexOf$default = d0.g0.w.indexOf$default((CharSequence) str, '&', i, false, 4, (Object) null);
            if (iIndexOf$default == -1) {
                iIndexOf$default = str.length();
            }
            int i2 = iIndexOf$default;
            int iIndexOf$default2 = d0.g0.w.indexOf$default((CharSequence) str, '=', i, false, 4, (Object) null);
            if (iIndexOf$default2 == -1 || iIndexOf$default2 > i2) {
                String strSubstring = str.substring(i, i2);
                d0.z.d.m.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                arrayList.add(strSubstring);
                arrayList.add(null);
            } else {
                String strSubstring2 = str.substring(i, iIndexOf$default2);
                d0.z.d.m.checkExpressionValueIsNotNull(strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                arrayList.add(strSubstring2);
                String strSubstring3 = str.substring(iIndexOf$default2 + 1, i2);
                d0.z.d.m.checkExpressionValueIsNotNull(strSubstring3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                arrayList.add(strSubstring3);
            }
            i = i2 + 1;
        }
        return arrayList;
    }
}
