package d0.e0.p.d.m0.e.a;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.List;

/* JADX INFO: compiled from: propertiesConventionUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c0 {
    public static d0.e0.p.d.m0.g.e a(d0.e0.p.d.m0.g.e eVar, String str, boolean z2, String str2, int i) {
        if ((i & 4) != 0) {
            z2 = true;
        }
        if ((i & 8) != 0) {
            str2 = null;
        }
        if (!eVar.isSpecial()) {
            String identifier = eVar.getIdentifier();
            d0.z.d.m.checkNotNullExpressionValue(identifier, "methodName.identifier");
            boolean z3 = false;
            if (d0.g0.t.startsWith$default(identifier, str, false, 2, null) && identifier.length() != str.length()) {
                char cCharAt = identifier.charAt(str.length());
                if ('a' <= cCharAt && cCharAt <= 'z') {
                    z3 = true;
                }
                if (!z3) {
                    if (str2 != null) {
                        return d0.e0.p.d.m0.g.e.identifier(d0.z.d.m.stringPlus(str2, d0.g0.w.removePrefix(identifier, str)));
                    }
                    if (!z2) {
                        return eVar;
                    }
                    String strDecapitalizeSmartForCompiler = d0.e0.p.d.m0.o.m.a.decapitalizeSmartForCompiler(d0.g0.w.removePrefix(identifier, str), true);
                    if (d0.e0.p.d.m0.g.e.isValidIdentifier(strDecapitalizeSmartForCompiler)) {
                        return d0.e0.p.d.m0.g.e.identifier(strDecapitalizeSmartForCompiler);
                    }
                }
            }
        }
        return null;
    }

    public static final List<d0.e0.p.d.m0.g.e> getPropertyNamesCandidatesByAccessorName(d0.e0.p.d.m0.g.e eVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        String strAsString = eVar.asString();
        d0.z.d.m.checkNotNullExpressionValue(strAsString, "name.asString()");
        z zVar = z.a;
        if (z.isGetterName(strAsString)) {
            return d0.t.n.listOfNotNull(propertyNameByGetMethodName(eVar));
        }
        return z.isSetterName(strAsString) ? propertyNamesBySetMethodName(eVar) : i.a.getPropertyNameCandidatesBySpecialGetterName(eVar);
    }

    public static final d0.e0.p.d.m0.g.e propertyNameByGetMethodName(d0.e0.p.d.m0.g.e eVar) {
        d0.z.d.m.checkNotNullParameter(eVar, "methodName");
        d0.e0.p.d.m0.g.e eVarA = a(eVar, "get", false, null, 12);
        return eVarA == null ? a(eVar, "is", false, null, 8) : eVarA;
    }

    public static final d0.e0.p.d.m0.g.e propertyNameBySetMethodName(d0.e0.p.d.m0.g.e eVar, boolean z2) {
        d0.z.d.m.checkNotNullParameter(eVar, "methodName");
        return a(eVar, "set", false, z2 ? "is" : null, 4);
    }

    public static final List<d0.e0.p.d.m0.g.e> propertyNamesBySetMethodName(d0.e0.p.d.m0.g.e eVar) {
        d0.z.d.m.checkNotNullParameter(eVar, "methodName");
        return d0.t.n.listOfNotNull((Object[]) new d0.e0.p.d.m0.g.e[]{propertyNameBySetMethodName(eVar, false), propertyNameBySetMethodName(eVar, true)});
    }
}
