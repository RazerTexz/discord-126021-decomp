package d0.e0.p.d.m0.b.p;

import d0.g0.t;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: FunctionClassKind.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c$a {
    public c$a(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public final c byClassNamePrefix(d0.e0.p.d.m0.g.b bVar, String str) {
        m.checkNotNullParameter(bVar, "packageFqName");
        m.checkNotNullParameter(str, "className");
        c[] cVarArrValues = c.values();
        for (int i = 0; i < 4; i++) {
            c cVar = cVarArrValues[i];
            if (m.areEqual(cVar.getPackageFqName(), bVar) && t.startsWith$default(str, cVar.getClassNamePrefix(), false, 2, null)) {
                return cVar;
            }
        }
        return null;
    }

    public final c getFunctionalClassKind(String str, d0.e0.p.d.m0.g.b bVar) {
        m.checkNotNullParameter(str, "className");
        m.checkNotNullParameter(bVar, "packageFqName");
        c$a$a className = parseClassName(str, bVar);
        if (className == null) {
            return null;
        }
        return className.getKind();
    }

    public final c$a$a parseClassName(String str, d0.e0.p.d.m0.g.b bVar) {
        Integer numValueOf;
        m.checkNotNullParameter(str, "className");
        m.checkNotNullParameter(bVar, "packageFqName");
        c cVarByClassNamePrefix = byClassNamePrefix(bVar, str);
        if (cVarByClassNamePrefix == null) {
            return null;
        }
        String strSubstring = str.substring(cVarByClassNamePrefix.getClassNamePrefix().length());
        m.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
        if (strSubstring.length() == 0) {
            numValueOf = null;
        } else {
            int length = strSubstring.length();
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i < length) {
                    char cCharAt = strSubstring.charAt(i);
                    i++;
                    int i3 = cCharAt - '0';
                    if (!(i3 >= 0 && i3 <= 9)) {
                        break;
                    }
                    i2 = (i2 * 10) + i3;
                } else {
                    numValueOf = Integer.valueOf(i2);
                }
            }
            numValueOf = null;
        }
        if (numValueOf == null) {
            return null;
        }
        return new c$a$a(cVarByClassNamePrefix, numValueOf.intValue());
    }
}
