package d0.e0.p.d.m0.n.l1;

import d0.e0.p.d.m0.n.a0;
import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.i1;
import d0.e0.p.d.m0.n.j0;
import d0.e0.p.d.m0.n.m0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: IntersectionType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class v {
    public static final v a = new v();

    public static final boolean access$isStrictSupertype(v vVar, c0 c0Var, c0 c0Var2) {
        Objects.requireNonNull(vVar);
        m mVar = l.f3529b.getDefault();
        return mVar.isSubtypeOf(c0Var, c0Var2) && !mVar.isSubtypeOf(c0Var2, c0Var);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x004d  */
    public final Collection<j0> a(Collection<? extends j0> collection, Function2<? super j0, ? super j0, Boolean> function2) {
        boolean z2;
        ArrayList<j0> arrayList = new ArrayList(collection);
        Iterator it = arrayList.iterator();
        d0.z.d.m.checkNotNullExpressionValue(it, "filteredTypes.iterator()");
        while (it.hasNext()) {
            j0 j0Var = (j0) it.next();
            boolean z3 = false;
            if (!arrayList.isEmpty()) {
                for (j0 j0Var2 : arrayList) {
                    if (j0Var2 != j0Var) {
                        d0.z.d.m.checkNotNullExpressionValue(j0Var2, "lower");
                        d0.z.d.m.checkNotNullExpressionValue(j0Var, "upper");
                        if (function2.invoke(j0Var2, j0Var).booleanValue()) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        z3 = true;
                        break;
                    }
                }
            }
            if (z3) {
                it.remove();
            }
        }
        return arrayList;
    }

    public final j0 intersectTypes$descriptors(List<? extends j0> list) {
        d0.z.d.m.checkNotNullParameter(list, "types");
        list.size();
        ArrayList<j0> arrayList = new ArrayList();
        for (j0 j0Var : list) {
            if (j0Var.getConstructor() instanceof a0) {
                Collection<c0> supertypes = j0Var.getConstructor().getSupertypes();
                d0.z.d.m.checkNotNullExpressionValue(supertypes, "type.constructor.supertypes");
                ArrayList arrayList2 = new ArrayList(d0.t.o.collectionSizeOrDefault(supertypes, 10));
                for (c0 c0Var : supertypes) {
                    d0.z.d.m.checkNotNullExpressionValue(c0Var, "it");
                    j0 j0VarUpperIfFlexible = d0.e0.p.d.m0.n.y.upperIfFlexible(c0Var);
                    if (j0Var.isMarkedNullable()) {
                        j0VarUpperIfFlexible = j0VarUpperIfFlexible.makeNullableAsSpecified(true);
                    }
                    arrayList2.add(j0VarUpperIfFlexible);
                }
                arrayList.addAll(arrayList2);
            } else {
                arrayList.add(j0Var);
            }
        }
        v$a v_aCombine = v$a.j;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            v_aCombine = v_aCombine.combine((i1) it.next());
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (j0 j0VarMakeSimpleTypeDefinitelyNotNullOrNotNull$default : arrayList) {
            if (v_aCombine == v$a.m) {
                if (j0VarMakeSimpleTypeDefinitelyNotNullOrNotNull$default instanceof i) {
                    j0VarMakeSimpleTypeDefinitelyNotNullOrNotNull$default = m0.withNotNullProjection((i) j0VarMakeSimpleTypeDefinitelyNotNullOrNotNull$default);
                }
                j0VarMakeSimpleTypeDefinitelyNotNullOrNotNull$default = m0.makeSimpleTypeDefinitelyNotNullOrNotNull$default(j0VarMakeSimpleTypeDefinitelyNotNullOrNotNull$default, false, 1, null);
            }
            linkedHashSet.add(j0VarMakeSimpleTypeDefinitelyNotNullOrNotNull$default);
        }
        if (linkedHashSet.size() == 1) {
            return (j0) d0.t.u.single(linkedHashSet);
        }
        new w(linkedHashSet);
        Collection<j0> collectionA = a(linkedHashSet, new x(this));
        ((ArrayList) collectionA).isEmpty();
        j0 j0VarFindIntersectionType = d0.e0.p.d.m0.k.v.n.a.findIntersectionType(collectionA);
        if (j0VarFindIntersectionType != null) {
            return j0VarFindIntersectionType;
        }
        Collection<j0> collectionA2 = a(collectionA, new y(l.f3529b.getDefault()));
        ArrayList arrayList3 = (ArrayList) collectionA2;
        arrayList3.isEmpty();
        return arrayList3.size() < 2 ? (j0) d0.t.u.single(collectionA2) : new a0(linkedHashSet).createType();
    }
}
