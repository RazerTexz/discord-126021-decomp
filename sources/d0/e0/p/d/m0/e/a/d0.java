package d0.e0.p.d.m0.e.a;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.m0;
import d0.e0.p.d.m0.c.n0;
import d0.e0.p.d.m0.c.t0;
import d0.e0.p.d.m0.n.j0;

/* JADX INFO: compiled from: specialBuiltinMembers.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d0 {
    public static final boolean doesOverrideBuiltinWithDifferentJvmName(d0.e0.p.d.m0.c.b bVar) {
        d0.z.d.m.checkNotNullParameter(bVar, "<this>");
        return getOverriddenBuiltinWithDifferentJvmName(bVar) != null;
    }

    public static final String getJvmMethodNameIfSpecial(d0.e0.p.d.m0.c.b bVar) {
        d0.e0.p.d.m0.g.e jvmName;
        d0.z.d.m.checkNotNullParameter(bVar, "callableMemberDescriptor");
        d0.e0.p.d.m0.c.b overriddenBuiltinWithDifferentJvmName = d0.e0.p.d.m0.b.h.isBuiltIn(bVar) ? getOverriddenBuiltinWithDifferentJvmName(bVar) : null;
        d0.e0.p.d.m0.c.b propertyIfAccessor = overriddenBuiltinWithDifferentJvmName == null ? null : d0.e0.p.d.m0.k.x.a.getPropertyIfAccessor(overriddenBuiltinWithDifferentJvmName);
        if (propertyIfAccessor == null) {
            return null;
        }
        if (propertyIfAccessor instanceof n0) {
            return k.a.getBuiltinSpecialPropertyGetterName(propertyIfAccessor);
        }
        if (!(propertyIfAccessor instanceof t0) || (jvmName = g.m.getJvmName((t0) propertyIfAccessor)) == null) {
            return null;
        }
        return jvmName.asString();
    }

    public static final <T extends d0.e0.p.d.m0.c.b> T getOverriddenBuiltinWithDifferentJvmName(T t) {
        d0.z.d.m.checkNotNullParameter(t, "<this>");
        if (!e0.a.getORIGINAL_SHORT_NAMES().contains(t.getName()) && !i.a.getSPECIAL_SHORT_NAMES().contains(d0.e0.p.d.m0.k.x.a.getPropertyIfAccessor(t).getName())) {
            return null;
        }
        if (t instanceof n0 ? true : t instanceof m0) {
            return (T) d0.e0.p.d.m0.k.x.a.firstOverridden$default(t, false, d0$a.j, 1, null);
        }
        if (t instanceof t0) {
            return (T) d0.e0.p.d.m0.k.x.a.firstOverridden$default(t, false, d0$b.j, 1, null);
        }
        return null;
    }

    public static final <T extends d0.e0.p.d.m0.c.b> T getOverriddenSpecialBuiltin(T t) {
        d0.z.d.m.checkNotNullParameter(t, "<this>");
        T t2 = (T) getOverriddenBuiltinWithDifferentJvmName(t);
        if (t2 != null) {
            return t2;
        }
        h hVar = h.m;
        d0.e0.p.d.m0.g.e name = t.getName();
        d0.z.d.m.checkNotNullExpressionValue(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        if (hVar.getSameAsBuiltinMethodWithErasedValueParameters(name)) {
            return (T) d0.e0.p.d.m0.k.x.a.firstOverridden$default(t, false, d0$c.j, 1, null);
        }
        return null;
    }

    public static final boolean hasRealKotlinSuperClassWithOverrideOf(d0.e0.p.d.m0.c.e eVar, d0.e0.p.d.m0.c.a aVar) {
        d0.z.d.m.checkNotNullParameter(eVar, "<this>");
        d0.z.d.m.checkNotNullParameter(aVar, "specialCallableDescriptor");
        j0 defaultType = ((d0.e0.p.d.m0.c.e) aVar.getContainingDeclaration()).getDefaultType();
        d0.z.d.m.checkNotNullExpressionValue(defaultType, "specialCallableDescriptor.containingDeclaration as ClassDescriptor).defaultType");
        d0.e0.p.d.m0.c.e superClassDescriptor = d0.e0.p.d.m0.k.e.getSuperClassDescriptor(eVar);
        while (true) {
            if (superClassDescriptor == null) {
                return false;
            }
            if (!(superClassDescriptor instanceof d0.e0.p.d.m0.e.a.h0.d)) {
                if (d0.e0.p.d.m0.n.l1.t.findCorrespondingSupertype(superClassDescriptor.getDefaultType(), defaultType) != null) {
                    return !d0.e0.p.d.m0.b.h.isBuiltIn(superClassDescriptor);
                }
            }
            superClassDescriptor = d0.e0.p.d.m0.k.e.getSuperClassDescriptor(superClassDescriptor);
        }
    }

    public static final boolean isFromJava(d0.e0.p.d.m0.c.b bVar) {
        d0.z.d.m.checkNotNullParameter(bVar, "<this>");
        return d0.e0.p.d.m0.k.x.a.getPropertyIfAccessor(bVar).getContainingDeclaration() instanceof d0.e0.p.d.m0.e.a.h0.d;
    }

    public static final boolean isFromJavaOrBuiltins(d0.e0.p.d.m0.c.b bVar) {
        d0.z.d.m.checkNotNullParameter(bVar, "<this>");
        return isFromJava(bVar) || d0.e0.p.d.m0.b.h.isBuiltIn(bVar);
    }
}
