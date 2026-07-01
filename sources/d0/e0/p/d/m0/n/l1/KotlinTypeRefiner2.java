package d0.e0.p.d.m0.n.l1;

import d0.e0.p.d.m0.c.ModuleCapability;
import d0.e0.p.d.m0.n.KotlinType;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.h, reason: use source file name */
/* JADX INFO: compiled from: KotlinTypeRefiner.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class KotlinTypeRefiner2 {
    public static final ModuleCapability<KotlinTypeRefiner3<KotlinTypeRefiner>> a = new ModuleCapability<>("KotlinTypeRefiner");

    public static final ModuleCapability<KotlinTypeRefiner3<KotlinTypeRefiner>> getREFINER_CAPABILITY() {
        return a;
    }

    public static final List<KotlinType> refineTypes(KotlinTypeRefiner kotlinTypeRefiner, Iterable<? extends KotlinType> iterable) {
        Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "<this>");
        Intrinsics3.checkNotNullParameter(iterable, "types");
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(iterable, 10));
        Iterator<? extends KotlinType> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(kotlinTypeRefiner.refineType(it.next()));
        }
        return arrayList;
    }
}
