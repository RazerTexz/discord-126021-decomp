package d0.e0.p.d.m0.b;

import d0.e0.p.d.m0.b.StandardNames;
import d0.e0.p.d.m0.g.ClassId;
import d0.e0.p.d.m0.g.FqName;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: renamed from: d0.e0.p.d.m0.b.c, reason: use source file name */
/* JADX INFO: compiled from: CompanionObjectMapping.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CompanionObjectMapping {
    public static final CompanionObjectMapping a = new CompanionObjectMapping();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<ClassId> f3210b;

    static {
        Set<PrimitiveType> set = PrimitiveType.j;
        StandardNames standardNames = StandardNames.a;
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(set, 10));
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(StandardNames.getPrimitiveFqName((PrimitiveType) it.next()));
        }
        FqName safe = StandardNames.a.g.toSafe();
        Intrinsics3.checkNotNullExpressionValue(safe, "string.toSafe()");
        List listPlus = _Collections.plus((Collection<? extends FqName>) arrayList, safe);
        FqName safe2 = StandardNames.a.i.toSafe();
        Intrinsics3.checkNotNullExpressionValue(safe2, "_boolean.toSafe()");
        List listPlus2 = _Collections.plus((Collection<? extends FqName>) listPlus, safe2);
        FqName safe3 = StandardNames.a.r.toSafe();
        Intrinsics3.checkNotNullExpressionValue(safe3, "_enum.toSafe()");
        List listPlus3 = _Collections.plus((Collection<? extends FqName>) listPlus2, safe3);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it2 = listPlus3.iterator();
        while (it2.hasNext()) {
            linkedHashSet.add(ClassId.topLevel((FqName) it2.next()));
        }
        f3210b = linkedHashSet;
    }

    public final Set<ClassId> allClassesWithIntrinsicCompanions() {
        return f3210b;
    }

    public final Set<ClassId> getClassIds() {
        return f3210b;
    }
}
