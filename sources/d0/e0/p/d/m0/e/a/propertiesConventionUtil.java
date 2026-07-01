package d0.e0.p.d.m0.e.a;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.o.m.capitalizeDecapitalize;
import d0.g0.Strings4;
import d0.g0.StringsJVM;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.c0, reason: use source file name */
/* JADX INFO: compiled from: propertiesConventionUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class propertiesConventionUtil {
    public static Name a(Name name, String str, boolean z2, String str2, int i) {
        if ((i & 4) != 0) {
            z2 = true;
        }
        if ((i & 8) != 0) {
            str2 = null;
        }
        if (!name.isSpecial()) {
            String identifier = name.getIdentifier();
            Intrinsics3.checkNotNullExpressionValue(identifier, "methodName.identifier");
            boolean z3 = false;
            if (StringsJVM.startsWith$default(identifier, str, false, 2, null) && identifier.length() != str.length()) {
                char cCharAt = identifier.charAt(str.length());
                if ('a' <= cCharAt && cCharAt <= 'z') {
                    z3 = true;
                }
                if (!z3) {
                    if (str2 != null) {
                        return Name.identifier(Intrinsics3.stringPlus(str2, Strings4.removePrefix(identifier, str)));
                    }
                    if (!z2) {
                        return name;
                    }
                    String strDecapitalizeSmartForCompiler = capitalizeDecapitalize.decapitalizeSmartForCompiler(Strings4.removePrefix(identifier, str), true);
                    if (Name.isValidIdentifier(strDecapitalizeSmartForCompiler)) {
                        return Name.identifier(strDecapitalizeSmartForCompiler);
                    }
                }
            }
        }
        return null;
    }

    public static final List<Name> getPropertyNamesCandidatesByAccessorName(Name name) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        String strAsString = name.asString();
        Intrinsics3.checkNotNullExpressionValue(strAsString, "name.asString()");
        JvmAbi jvmAbi = JvmAbi.a;
        if (JvmAbi.isGetterName(strAsString)) {
            return Collections2.listOfNotNull(propertyNameByGetMethodName(name));
        }
        return JvmAbi.isSetterName(strAsString) ? propertyNamesBySetMethodName(name) : BuiltinSpecialProperties.a.getPropertyNameCandidatesBySpecialGetterName(name);
    }

    public static final Name propertyNameByGetMethodName(Name name) {
        Intrinsics3.checkNotNullParameter(name, "methodName");
        Name nameA = a(name, "get", false, null, 12);
        return nameA == null ? a(name, "is", false, null, 8) : nameA;
    }

    public static final Name propertyNameBySetMethodName(Name name, boolean z2) {
        Intrinsics3.checkNotNullParameter(name, "methodName");
        return a(name, "set", false, z2 ? "is" : null, 4);
    }

    public static final List<Name> propertyNamesBySetMethodName(Name name) {
        Intrinsics3.checkNotNullParameter(name, "methodName");
        return Collections2.listOfNotNull((Object[]) new Name[]{propertyNameBySetMethodName(name, false), propertyNameBySetMethodName(name, true)});
    }
}
