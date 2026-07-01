package d0.e0.p.d.m0.e.a;

import java.util.Collection;

/* JADX INFO: compiled from: ClassicBuiltinSpecialProperties.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k {
    public static final k a = new k();

    public final String getBuiltinSpecialPropertyGetterName(d0.e0.p.d.m0.c.b bVar) {
        d0.e0.p.d.m0.g.e eVar;
        d0.z.d.m.checkNotNullParameter(bVar, "<this>");
        d0.e0.p.d.m0.b.h.isBuiltIn(bVar);
        d0.e0.p.d.m0.c.b bVarFirstOverridden$default = d0.e0.p.d.m0.k.x.a.firstOverridden$default(d0.e0.p.d.m0.k.x.a.getPropertyIfAccessor(bVar), false, new k$a(this), 1, null);
        if (bVarFirstOverridden$default == null || (eVar = i.a.getPROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP().get(d0.e0.p.d.m0.k.x.a.getFqNameSafe(bVarFirstOverridden$default))) == null) {
            return null;
        }
        return eVar.asString();
    }

    public final boolean hasBuiltinSpecialPropertyFqName(d0.e0.p.d.m0.c.b bVar) {
        d0.z.d.m.checkNotNullParameter(bVar, "callableMemberDescriptor");
        i iVar = i.a;
        if (!iVar.getSPECIAL_SHORT_NAMES().contains(bVar.getName())) {
            return false;
        }
        if (!d0.t.u.contains(iVar.getSPECIAL_FQ_NAMES(), d0.e0.p.d.m0.k.x.a.fqNameOrNull(bVar)) || !bVar.getValueParameters().isEmpty()) {
            if (!d0.e0.p.d.m0.b.h.isBuiltIn(bVar)) {
                return false;
            }
            Collection<? extends d0.e0.p.d.m0.c.b> overriddenDescriptors = bVar.getOverriddenDescriptors();
            d0.z.d.m.checkNotNullExpressionValue(overriddenDescriptors, "overriddenDescriptors");
            if (overriddenDescriptors.isEmpty()) {
                return false;
            }
            for (d0.e0.p.d.m0.c.b bVar2 : overriddenDescriptors) {
                d0.z.d.m.checkNotNullExpressionValue(bVar2, "it");
                if (hasBuiltinSpecialPropertyFqName(bVar2)) {
                }
            }
            return false;
        }
        return true;
    }
}
