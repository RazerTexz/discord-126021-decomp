package d0.e0.p.d.m0.j;

import d0.e0.p.d.m0.g.FqNameUnsafe;
import d0.e0.p.d.m0.g.Name;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: renamed from: d0.e0.p.d.m0.j.q, reason: use source file name */
/* JADX INFO: compiled from: RenderingUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class RenderingUtils {
    /* JADX WARN: Code duplicated, block: B:21:0x0041  */
    public static final String render(Name name) {
        boolean z2;
        Intrinsics3.checkNotNullParameter(name, "<this>");
        boolean z3 = false;
        if (!name.isSpecial()) {
            String strAsString = name.asString();
            Intrinsics3.checkNotNullExpressionValue(strAsString, "asString()");
            if (KeywordStringsGenerated.a.contains(strAsString)) {
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
            String strAsString2 = name.asString();
            Intrinsics3.checkNotNullExpressionValue(strAsString2, "asString()");
            return strAsString2;
        }
        String strAsString3 = name.asString();
        Intrinsics3.checkNotNullExpressionValue(strAsString3, "asString()");
        return Intrinsics3.stringPlus(String.valueOf('`') + strAsString3, "`");
    }

    public static final String renderFqName(List<Name> list) {
        Intrinsics3.checkNotNullParameter(list, "pathSegments");
        StringBuilder sb = new StringBuilder();
        for (Name name : list) {
            if (sb.length() > 0) {
                sb.append(".");
            }
            sb.append(render(name));
        }
        String string = sb.toString();
        Intrinsics3.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public static final String render(FqNameUnsafe fqNameUnsafe) {
        Intrinsics3.checkNotNullParameter(fqNameUnsafe, "<this>");
        List<Name> listPathSegments = fqNameUnsafe.pathSegments();
        Intrinsics3.checkNotNullExpressionValue(listPathSegments, "pathSegments()");
        return renderFqName(listPathSegments);
    }
}
