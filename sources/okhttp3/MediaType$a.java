package okhttp3;

import b.d.b.a.a;
import d0.g0.t;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import kotlin.TypeCastException;

/* JADX INFO: compiled from: MediaType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class MediaType$a {
    public static final MediaType a(String str) {
        m.checkParameterIsNotNull(str, "$this$toMediaType");
        Matcher matcher = MediaType.a.matcher(str);
        if (!matcher.lookingAt()) {
            throw new IllegalArgumentException(("No subtype found for: \"" + str + '\"').toString());
        }
        String strGroup = matcher.group(1);
        m.checkExpressionValueIsNotNull(strGroup, "typeSubtype.group(1)");
        Locale locale = Locale.US;
        m.checkExpressionValueIsNotNull(locale, "Locale.US");
        if (strGroup == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = strGroup.toLowerCase(locale);
        m.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        String strGroup2 = matcher.group(2);
        m.checkExpressionValueIsNotNull(strGroup2, "typeSubtype.group(2)");
        m.checkExpressionValueIsNotNull(locale, "Locale.US");
        if (strGroup2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase2 = strGroup2.toLowerCase(locale);
        m.checkExpressionValueIsNotNull(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
        ArrayList arrayList = new ArrayList();
        Matcher matcher2 = MediaType.f3808b.matcher(str);
        int iEnd = matcher.end();
        while (iEnd < str.length()) {
            matcher2.region(iEnd, str.length());
            if (!matcher2.lookingAt()) {
                StringBuilder sbU = a.U("Parameter is not formatted correctly: \"");
                String strSubstring = str.substring(iEnd);
                m.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.String).substring(startIndex)");
                sbU.append(strSubstring);
                sbU.append("\" for: \"");
                sbU.append(str);
                sbU.append('\"');
                throw new IllegalArgumentException(sbU.toString().toString());
            }
            String strGroup3 = matcher2.group(1);
            if (strGroup3 == null) {
                iEnd = matcher2.end();
            } else {
                String strGroup4 = matcher2.group(2);
                if (strGroup4 == null) {
                    strGroup4 = matcher2.group(3);
                } else if (t.startsWith$default(strGroup4, "'", false, 2, null) && t.endsWith$default(strGroup4, "'", false, 2, null) && strGroup4.length() > 2) {
                    strGroup4 = strGroup4.substring(1, strGroup4.length() - 1);
                    m.checkExpressionValueIsNotNull(strGroup4, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                }
                arrayList.add(strGroup3);
                arrayList.add(strGroup4);
                iEnd = matcher2.end();
            }
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return new MediaType(str, lowerCase, lowerCase2, (String[]) array, null);
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public static final MediaType b(String str) {
        m.checkParameterIsNotNull(str, "$this$toMediaTypeOrNull");
        try {
            return a(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }
}
