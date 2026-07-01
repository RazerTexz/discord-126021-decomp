package d0.e0.p.d.m0.n.l1;

import d0.e0.p.d.m0.n.ErrorUtils;
import d0.e0.p.d.m0.n.KotlinType2;
import d0.e0.p.d.m0.n.KotlinType3;
import d0.e0.p.d.m0.n.KotlinType4;
import d0.e0.p.d.m0.n.KotlinType6;
import d0.e0.p.d.m0.n.KotlinTypeFactory;
import d0.e0.p.d.m0.n.dynamicTypes2;
import d0.e0.p.d.m0.n.flexibleTypes2;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.e, reason: use source file name */
/* JADX INFO: compiled from: IntersectionType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class IntersectionType {
    public static final KotlinType3 intersectTypes(List<? extends KotlinType3> list) {
        KotlinType4 lowerBound;
        Intrinsics3.checkNotNullParameter(list, "types");
        int size = list.size();
        if (size == 0) {
            throw new IllegalStateException("Expected some types".toString());
        }
        if (size == 1) {
            return (KotlinType3) _Collections.single((List) list);
        }
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
        boolean z2 = false;
        boolean z3 = false;
        for (KotlinType3 kotlinType3 : list) {
            z2 = z2 || KotlinType2.isError(kotlinType3);
            if (kotlinType3 instanceof KotlinType4) {
                lowerBound = (KotlinType4) kotlinType3;
            } else {
                if (!(kotlinType3 instanceof KotlinType6)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (dynamicTypes2.isDynamic(kotlinType3)) {
                    return kotlinType3;
                }
                lowerBound = ((KotlinType6) kotlinType3).getLowerBound();
                z3 = true;
            }
            arrayList.add(lowerBound);
        }
        if (z2) {
            KotlinType4 kotlinType4CreateErrorType = ErrorUtils.createErrorType(Intrinsics3.stringPlus("Intersection of error types: ", list));
            Intrinsics3.checkNotNullExpressionValue(kotlinType4CreateErrorType, "createErrorType(\"Intersection of error types: $types\")");
            return kotlinType4CreateErrorType;
        }
        if (!z3) {
            return IntersectionType2.a.intersectTypes$descriptors(arrayList);
        }
        ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList2.add(flexibleTypes2.upperIfFlexible((KotlinType3) it.next()));
        }
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.a;
        IntersectionType2 intersectionType2 = IntersectionType2.a;
        return KotlinTypeFactory.flexibleType(intersectionType2.intersectTypes$descriptors(arrayList), intersectionType2.intersectTypes$descriptors(arrayList2));
    }
}
