package p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11932i1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11934j0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC12009v;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11916d0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11919e0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C12001r;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C12005t;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C12015y;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.e */
/* JADX INFO: compiled from: IntersectionType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11945e {
    public static final AbstractC11932i1 intersectTypes(List<? extends AbstractC11932i1> list) {
        AbstractC11934j0 lowerBound;
        C12238m.checkNotNullParameter(list, "types");
        int size = list.size();
        if (size == 0) {
            throw new IllegalStateException("Expected some types".toString());
        }
        if (size == 1) {
            return (AbstractC11932i1) C12163u.single((List) list);
        }
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(list, 10));
        boolean z2 = false;
        boolean z3 = false;
        for (AbstractC11932i1 abstractC11932i1 : list) {
            z2 = z2 || C11919e0.isError(abstractC11932i1);
            if (abstractC11932i1 instanceof AbstractC11934j0) {
                lowerBound = (AbstractC11934j0) abstractC11932i1;
            } else {
                if (!(abstractC11932i1 instanceof AbstractC12009v)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (C12001r.isDynamic(abstractC11932i1)) {
                    return abstractC11932i1;
                }
                lowerBound = ((AbstractC12009v) abstractC11932i1).getLowerBound();
                z3 = true;
            }
            arrayList.add(lowerBound);
        }
        if (z2) {
            AbstractC11934j0 abstractC11934j0CreateErrorType = C12005t.createErrorType(C12238m.stringPlus("Intersection of error types: ", list));
            C12238m.checkNotNullExpressionValue(abstractC11934j0CreateErrorType, "createErrorType(\"Intersection of error types: $types\")");
            return abstractC11934j0CreateErrorType;
        }
        if (!z3) {
            return C11962v.f24831a.intersectTypes$descriptors(arrayList);
        }
        ArrayList arrayList2 = new ArrayList(C12149o.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList2.add(C12015y.upperIfFlexible((AbstractC11932i1) it.next()));
        }
        C11916d0 c11916d0 = C11916d0.f24748a;
        C11962v c11962v = C11962v.f24831a;
        return C11916d0.flexibleType(c11962v.intersectTypes$descriptors(arrayList), c11962v.intersectTypes$descriptors(arrayList2));
    }
}
