package p507d0.p513e0.p514p.p515d.p517m0.p551j;

import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11714c;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.j.q */
/* JADX INFO: compiled from: RenderingUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11760q {
    /* JADX WARN: Code duplicated, block: B:21:0x0041  */
    public static final String render(C11716e c11716e) {
        boolean z2;
        C12238m.checkNotNullParameter(c11716e, "<this>");
        boolean z3 = false;
        if (!c11716e.isSpecial()) {
            String strAsString = c11716e.asString();
            C12238m.checkNotNullExpressionValue(strAsString, "asString()");
            if (C11755l.f24316a.contains(strAsString)) {
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
            String strAsString2 = c11716e.asString();
            C12238m.checkNotNullExpressionValue(strAsString2, "asString()");
            return strAsString2;
        }
        String strAsString3 = c11716e.asString();
        C12238m.checkNotNullExpressionValue(strAsString3, "asString()");
        return C12238m.stringPlus(String.valueOf('`') + strAsString3, "`");
    }

    public static final String renderFqName(List<C11716e> list) {
        C12238m.checkNotNullParameter(list, "pathSegments");
        StringBuilder sb = new StringBuilder();
        for (C11716e c11716e : list) {
            if (sb.length() > 0) {
                sb.append(".");
            }
            sb.append(render(c11716e));
        }
        String string = sb.toString();
        C12238m.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public static final String render(C11714c c11714c) {
        C12238m.checkNotNullParameter(c11714c, "<this>");
        List<C11716e> listPathSegments = c11714c.pathSegments();
        C12238m.checkNotNullExpressionValue(listPathSegments, "pathSegments()");
        return renderFqName(listPathSegments);
    }
}
