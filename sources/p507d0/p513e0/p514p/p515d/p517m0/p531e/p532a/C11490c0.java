package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p573o.p574m.C12031a;
import p507d0.p579g0.C12103t;
import p507d0.p579g0.C12106w;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.c0 */
/* JADX INFO: compiled from: propertiesConventionUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11490c0 {
    /* JADX INFO: renamed from: a */
    public static C11716e m9449a(C11716e c11716e, String str, boolean z2, String str2, int i) {
        if ((i & 4) != 0) {
            z2 = true;
        }
        if ((i & 8) != 0) {
            str2 = null;
        }
        if (!c11716e.isSpecial()) {
            String identifier = c11716e.getIdentifier();
            C12238m.checkNotNullExpressionValue(identifier, "methodName.identifier");
            boolean z3 = false;
            if (C12103t.startsWith$default(identifier, str, false, 2, null) && identifier.length() != str.length()) {
                char cCharAt = identifier.charAt(str.length());
                if ('a' <= cCharAt && cCharAt <= 'z') {
                    z3 = true;
                }
                if (!z3) {
                    if (str2 != null) {
                        return C11716e.identifier(C12238m.stringPlus(str2, C12106w.removePrefix(identifier, str)));
                    }
                    if (!z2) {
                        return c11716e;
                    }
                    String strDecapitalizeSmartForCompiler = C12031a.decapitalizeSmartForCompiler(C12106w.removePrefix(identifier, str), true);
                    if (C11716e.isValidIdentifier(strDecapitalizeSmartForCompiler)) {
                        return C11716e.identifier(strDecapitalizeSmartForCompiler);
                    }
                }
            }
        }
        return null;
    }

    public static final List<C11716e> getPropertyNamesCandidatesByAccessorName(C11716e c11716e) {
        C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
        String strAsString = c11716e.asString();
        C12238m.checkNotNullExpressionValue(strAsString, "name.asString()");
        C11632z c11632z = C11632z.f23531a;
        if (C11632z.isGetterName(strAsString)) {
            return C12147n.listOfNotNull(propertyNameByGetMethodName(c11716e));
        }
        return C11632z.isSetterName(strAsString) ? propertyNamesBySetMethodName(c11716e) : C11522i.f23276a.getPropertyNameCandidatesBySpecialGetterName(c11716e);
    }

    public static final C11716e propertyNameByGetMethodName(C11716e c11716e) {
        C12238m.checkNotNullParameter(c11716e, "methodName");
        C11716e c11716eM9449a = m9449a(c11716e, "get", false, null, 12);
        return c11716eM9449a == null ? m9449a(c11716e, "is", false, null, 8) : c11716eM9449a;
    }

    public static final C11716e propertyNameBySetMethodName(C11716e c11716e, boolean z2) {
        C12238m.checkNotNullParameter(c11716e, "methodName");
        return m9449a(c11716e, "set", false, z2 ? "is" : null, 4);
    }

    public static final List<C11716e> propertyNamesBySetMethodName(C11716e c11716e) {
        C12238m.checkNotNullParameter(c11716e, "methodName");
        return C12147n.listOfNotNull((Object[]) new C11716e[]{propertyNameBySetMethodName(c11716e, false), propertyNameBySetMethodName(c11716e, true)});
    }
}
