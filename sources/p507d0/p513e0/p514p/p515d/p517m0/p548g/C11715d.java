package p507d0.p513e0.p514p.p515d.p517m0.p548g;

import p507d0.p579g0.C12103t;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.g.d */
/* JADX INFO: compiled from: FqNamesUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11715d {
    public static final boolean isSubpackageOf(C11713b c11713b, C11713b c11713b2) {
        C12238m.checkNotNullParameter(c11713b, "<this>");
        C12238m.checkNotNullParameter(c11713b2, "packageName");
        if (C12238m.areEqual(c11713b, c11713b2) || c11713b2.isRoot()) {
            return true;
        }
        String strAsString = c11713b.asString();
        C12238m.checkNotNullExpressionValue(strAsString, "this.asString()");
        String strAsString2 = c11713b2.asString();
        C12238m.checkNotNullExpressionValue(strAsString2, "packageName.asString()");
        return C12103t.startsWith$default(strAsString, strAsString2, false, 2, null) && strAsString.charAt(strAsString2.length()) == '.';
    }

    public static final boolean isValidJavaFqName(String str) {
        EnumC11719h enumC11719h = EnumC11719h.AFTER_DOT;
        if (str == null) {
            return false;
        }
        EnumC11719h enumC11719h2 = EnumC11719h.BEGINNING;
        int i = 0;
        while (i < str.length()) {
            char cCharAt = str.charAt(i);
            i++;
            int iOrdinal = enumC11719h2.ordinal();
            if (iOrdinal != 0) {
                if (iOrdinal != 1) {
                    if (iOrdinal != 2) {
                        continue;
                    }
                } else if (cCharAt == '.') {
                    enumC11719h2 = enumC11719h;
                } else if (!Character.isJavaIdentifierPart(cCharAt)) {
                    return false;
                }
            }
            if (!Character.isJavaIdentifierPart(cCharAt)) {
                return false;
            }
            enumC11719h2 = EnumC11719h.MIDDLE;
        }
        return enumC11719h2 != enumC11719h;
    }

    public static final C11713b tail(C11713b c11713b, C11713b c11713b2) {
        C12238m.checkNotNullParameter(c11713b, "<this>");
        C12238m.checkNotNullParameter(c11713b2, "prefix");
        if (!isSubpackageOf(c11713b, c11713b2) || c11713b2.isRoot()) {
            return c11713b;
        }
        if (C12238m.areEqual(c11713b, c11713b2)) {
            C11713b c11713b3 = C11713b.f24079a;
            C12238m.checkNotNullExpressionValue(c11713b3, "ROOT");
            return c11713b3;
        }
        String strAsString = c11713b.asString();
        C12238m.checkNotNullExpressionValue(strAsString, "asString()");
        String strSubstring = strAsString.substring(c11713b2.asString().length() + 1);
        C12238m.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
        return new C11713b(strSubstring);
    }
}
