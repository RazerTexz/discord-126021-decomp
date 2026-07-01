package d0.e0.p.d.m0.e.a.g0;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.c1;
import d0.e0.p.d.m0.l.b.p;
import java.util.Collection;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: DescriptorResolverUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static /* synthetic */ void a(int i) {
        String str = i != 18 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i != 18 ? 3 : 2];
        switch (i) {
            case 1:
            case 7:
            case 13:
                objArr[0] = "membersFromSupertypes";
                break;
            case 2:
            case 8:
            case 14:
                objArr[0] = "membersFromCurrent";
                break;
            case 3:
            case 9:
            case 15:
                objArr[0] = "classDescriptor";
                break;
            case 4:
            case 10:
            case 16:
                objArr[0] = "errorReporter";
                break;
            case 5:
            case 11:
            case 17:
                objArr[0] = "overridingUtil";
                break;
            case 6:
            case 12:
            case 19:
            default:
                objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                break;
            case 18:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils";
                break;
            case 20:
                objArr[0] = "annotationClass";
                break;
        }
        if (i != 18) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils";
        } else {
            objArr[1] = "resolveOverrides";
        }
        switch (i) {
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                objArr[2] = "resolveOverridesForStaticMembers";
                break;
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
                objArr[2] = "resolveOverrides";
                break;
            case 18:
                break;
            case 19:
            case 20:
                objArr[2] = "getAnnotationParameterByName";
                break;
            default:
                objArr[2] = "resolveOverridesForNonStaticMembers";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i == 18) {
            throw new IllegalStateException(str2);
        }
    }

    public static <D extends d0.e0.p.d.m0.c.b> Collection<D> b(d0.e0.p.d.m0.g.e eVar, Collection<D> collection, Collection<D> collection2, d0.e0.p.d.m0.c.e eVar2, p pVar, d0.e0.p.d.m0.k.k kVar, boolean z2) {
        if (eVar == null) {
            a(12);
            throw null;
        }
        if (collection == null) {
            a(13);
            throw null;
        }
        if (collection2 == null) {
            a(14);
            throw null;
        }
        if (eVar2 == null) {
            a(15);
            throw null;
        }
        if (pVar == null) {
            a(16);
            throw null;
        }
        if (kVar == null) {
            a(17);
            throw null;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        kVar.generateOverridesInFunctionGroup(eVar, collection, collection2, eVar2, new a$a(pVar, linkedHashSet, z2));
        return linkedHashSet;
    }

    public static c1 getAnnotationParameterByName(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.c.e eVar2) {
        if (eVar == null) {
            a(19);
            throw null;
        }
        if (eVar2 == null) {
            a(20);
            throw null;
        }
        Collection<d0.e0.p.d.m0.c.d> constructors = eVar2.getConstructors();
        if (constructors.size() != 1) {
            return null;
        }
        for (c1 c1Var : constructors.iterator().next().getValueParameters()) {
            if (c1Var.getName().equals(eVar)) {
                return c1Var;
            }
        }
        return null;
    }

    public static <D extends d0.e0.p.d.m0.c.b> Collection<D> resolveOverridesForNonStaticMembers(d0.e0.p.d.m0.g.e eVar, Collection<D> collection, Collection<D> collection2, d0.e0.p.d.m0.c.e eVar2, p pVar, d0.e0.p.d.m0.k.k kVar) {
        if (eVar == null) {
            a(0);
            throw null;
        }
        if (collection == null) {
            a(1);
            throw null;
        }
        if (collection2 == null) {
            a(2);
            throw null;
        }
        if (eVar2 == null) {
            a(3);
            throw null;
        }
        if (pVar == null) {
            a(4);
            throw null;
        }
        if (kVar != null) {
            return b(eVar, collection, collection2, eVar2, pVar, kVar, false);
        }
        a(5);
        throw null;
    }

    public static <D extends d0.e0.p.d.m0.c.b> Collection<D> resolveOverridesForStaticMembers(d0.e0.p.d.m0.g.e eVar, Collection<D> collection, Collection<D> collection2, d0.e0.p.d.m0.c.e eVar2, p pVar, d0.e0.p.d.m0.k.k kVar) {
        if (eVar == null) {
            a(6);
            throw null;
        }
        if (collection == null) {
            a(7);
            throw null;
        }
        if (collection2 == null) {
            a(8);
            throw null;
        }
        if (eVar2 == null) {
            a(9);
            throw null;
        }
        if (pVar == null) {
            a(10);
            throw null;
        }
        if (kVar != null) {
            return b(eVar, collection, collection2, eVar2, pVar, kVar, true);
        }
        a(11);
        throw null;
    }
}
