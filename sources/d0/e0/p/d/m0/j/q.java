package d0.e0.p.d.m0.j;

import java.util.List;

/* JADX INFO: compiled from: RenderingUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class q {
    /* JADX WARN: Code duplicated, block: B:21:0x0041  */
    public static final String render(d0.e0.p.d.m0.g.e eVar) {
        boolean z2;
        d0.z.d.m.checkNotNullParameter(eVar, "<this>");
        boolean z3 = false;
        if (!eVar.isSpecial()) {
            String strAsString = eVar.asString();
            d0.z.d.m.checkNotNullExpressionValue(strAsString, "asString()");
            if (l.a.contains(strAsString)) {
                z3 = true;
            } else {
                int i = 0;
                while (true) {
                    if (i >= strAsString.length()) {
                        z2 = false;
                        break;
                    }
                    char cCharAt = strAsString.charAt(i);
                    if ((Character.isLetterOrDigit(cCharAt) || cCharAt == '_') ? false : true) {
                        z2 = true;
                        break;
                    }
                    i++;
                }
                if (z2) {
                    z3 = true;
                }
            }
        }
        if (!z3) {
            String strAsString2 = eVar.asString();
            d0.z.d.m.checkNotNullExpressionValue(strAsString2, "asString()");
            return strAsString2;
        }
        String strAsString3 = eVar.asString();
        d0.z.d.m.checkNotNullExpressionValue(strAsString3, "asString()");
        return d0.z.d.m.stringPlus(String.valueOf('`') + strAsString3, "`");
    }

    public static final String renderFqName(List<d0.e0.p.d.m0.g.e> list) {
        d0.z.d.m.checkNotNullParameter(list, "pathSegments");
        StringBuilder sb = new StringBuilder();
        for (d0.e0.p.d.m0.g.e eVar : list) {
            if (sb.length() > 0) {
                sb.append(".");
            }
            sb.append(render(eVar));
        }
        String string = sb.toString();
        d0.z.d.m.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public static final String render(d0.e0.p.d.m0.g.c cVar) {
        d0.z.d.m.checkNotNullParameter(cVar, "<this>");
        List<d0.e0.p.d.m0.g.e> listPathSegments = cVar.pathSegments();
        d0.z.d.m.checkNotNullExpressionValue(listPathSegments, "pathSegments()");
        return renderFqName(listPathSegments);
    }
}
