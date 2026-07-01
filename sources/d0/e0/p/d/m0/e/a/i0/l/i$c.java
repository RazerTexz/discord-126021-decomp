package d0.e0.p.d.m0.e.a.i0.l;

import d0.e0.p.d.m0.e.a.k0.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: LazyJavaPackageFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i$c extends d0.z.d.o implements Function0<List<? extends d0.e0.p.d.m0.g.b>> {
    public final /* synthetic */ i this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i$c(i iVar) {
        super(0);
        this.this$0 = iVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends d0.e0.p.d.m0.g.b> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends d0.e0.p.d.m0.g.b> invoke2() {
        Collection<u> subPackages = i.access$getJPackage$p(this.this$0).getSubPackages();
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(subPackages, 10));
        Iterator<T> it = subPackages.iterator();
        while (it.hasNext()) {
            arrayList.add(((u) it.next()).getFqName());
        }
        return arrayList;
    }
}
