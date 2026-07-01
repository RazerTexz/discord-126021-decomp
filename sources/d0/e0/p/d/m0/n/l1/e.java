package d0.e0.p.d.m0.n.l1;

import d0.e0.p.d.m0.n.d0;
import d0.e0.p.d.m0.n.e0;
import d0.e0.p.d.m0.n.i1;
import d0.e0.p.d.m0.n.j0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: IntersectionType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {
    public static final i1 intersectTypes(List<? extends i1> list) {
        j0 lowerBound;
        d0.z.d.m.checkNotNullParameter(list, "types");
        int size = list.size();
        if (size == 0) {
            throw new IllegalStateException("Expected some types".toString());
        }
        if (size == 1) {
            return (i1) d0.t.u.single((List) list);
        }
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(list, 10));
        boolean z2 = false;
        boolean z3 = false;
        for (i1 i1Var : list) {
            z2 = z2 || e0.isError(i1Var);
            if (i1Var instanceof j0) {
                lowerBound = (j0) i1Var;
            } else {
                if (!(i1Var instanceof d0.e0.p.d.m0.n.v)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (d0.e0.p.d.m0.n.r.isDynamic(i1Var)) {
                    return i1Var;
                }
                lowerBound = ((d0.e0.p.d.m0.n.v) i1Var).getLowerBound();
                z3 = true;
            }
            arrayList.add(lowerBound);
        }
        if (z2) {
            j0 j0VarCreateErrorType = d0.e0.p.d.m0.n.t.createErrorType(d0.z.d.m.stringPlus("Intersection of error types: ", list));
            d0.z.d.m.checkNotNullExpressionValue(j0VarCreateErrorType, "createErrorType(\"Intersection of error types: $types\")");
            return j0VarCreateErrorType;
        }
        if (!z3) {
            return v.a.intersectTypes$descriptors(arrayList);
        }
        ArrayList arrayList2 = new ArrayList(d0.t.o.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList2.add(d0.e0.p.d.m0.n.y.upperIfFlexible((i1) it.next()));
        }
        d0 d0Var = d0.a;
        v vVar = v.a;
        return d0.flexibleType(vVar.intersectTypes$descriptors(arrayList), vVar.intersectTypes$descriptors(arrayList2));
    }
}
