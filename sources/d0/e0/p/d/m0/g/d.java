package d0.e0.p.d.m0.g;

import d0.g0.t;
import d0.z.d.m;

/* JADX INFO: compiled from: FqNamesUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public static final boolean isSubpackageOf(b bVar, b bVar2) {
        m.checkNotNullParameter(bVar, "<this>");
        m.checkNotNullParameter(bVar2, "packageName");
        if (m.areEqual(bVar, bVar2) || bVar2.isRoot()) {
            return true;
        }
        String strAsString = bVar.asString();
        m.checkNotNullExpressionValue(strAsString, "this.asString()");
        String strAsString2 = bVar2.asString();
        m.checkNotNullExpressionValue(strAsString2, "packageName.asString()");
        return t.startsWith$default(strAsString, strAsString2, false, 2, null) && strAsString.charAt(strAsString2.length()) == '.';
    }

    public static final boolean isValidJavaFqName(String str) {
        h hVar = h.AFTER_DOT;
        if (str == null) {
            return false;
        }
        h hVar2 = h.BEGINNING;
        int i = 0;
        while (i < str.length()) {
            char cCharAt = str.charAt(i);
            i++;
            int iOrdinal = hVar2.ordinal();
            if (iOrdinal != 0) {
                if (iOrdinal != 1) {
                    if (iOrdinal != 2) {
                        continue;
                    }
                } else if (cCharAt == '.') {
                    hVar2 = hVar;
                } else if (!Character.isJavaIdentifierPart(cCharAt)) {
                    return false;
                }
            }
            if (!Character.isJavaIdentifierPart(cCharAt)) {
                return false;
            }
            hVar2 = h.MIDDLE;
        }
        return hVar2 != hVar;
    }

    public static final b tail(b bVar, b bVar2) {
        m.checkNotNullParameter(bVar, "<this>");
        m.checkNotNullParameter(bVar2, "prefix");
        if (!isSubpackageOf(bVar, bVar2) || bVar2.isRoot()) {
            return bVar;
        }
        if (m.areEqual(bVar, bVar2)) {
            b bVar3 = b.a;
            m.checkNotNullExpressionValue(bVar3, "ROOT");
            return bVar3;
        }
        String strAsString = bVar.asString();
        m.checkNotNullExpressionValue(strAsString, "asString()");
        String strSubstring = strAsString.substring(bVar2.asString().length() + 1);
        m.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
        return new b(strSubstring);
    }
}
