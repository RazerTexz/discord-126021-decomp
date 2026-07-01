package d0.e0.p.d.m0.c.i1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: CompositePackageFragmentProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j implements d0.e0.p.d.m0.c.i0 {
    public final List<d0.e0.p.d.m0.c.f0> a;

    /* JADX WARN: Multi-variable type inference failed */
    public j(List<? extends d0.e0.p.d.m0.c.f0> list) {
        d0.z.d.m.checkNotNullParameter(list, "providers");
        this.a = list;
        list.size();
        d0.t.u.toSet(list).size();
    }

    @Override // d0.e0.p.d.m0.c.i0
    public void collectPackageFragments(d0.e0.p.d.m0.g.b bVar, Collection<d0.e0.p.d.m0.c.e0> collection) {
        d0.z.d.m.checkNotNullParameter(bVar, "fqName");
        d0.z.d.m.checkNotNullParameter(collection, "packageFragments");
        Iterator<d0.e0.p.d.m0.c.f0> it = this.a.iterator();
        while (it.hasNext()) {
            d0.e0.p.d.m0.c.h0.collectPackageFragmentsOptimizedIfPossible(it.next(), bVar, collection);
        }
    }

    @Override // d0.e0.p.d.m0.c.f0
    public List<d0.e0.p.d.m0.c.e0> getPackageFragments(d0.e0.p.d.m0.g.b bVar) {
        d0.z.d.m.checkNotNullParameter(bVar, "fqName");
        ArrayList arrayList = new ArrayList();
        Iterator<d0.e0.p.d.m0.c.f0> it = this.a.iterator();
        while (it.hasNext()) {
            d0.e0.p.d.m0.c.h0.collectPackageFragmentsOptimizedIfPossible(it.next(), bVar, arrayList);
        }
        return d0.t.u.toList(arrayList);
    }

    @Override // d0.e0.p.d.m0.c.f0
    public Collection<d0.e0.p.d.m0.g.b> getSubPackagesOf(d0.e0.p.d.m0.g.b bVar, Function1<? super d0.e0.p.d.m0.g.e, Boolean> function1) {
        d0.z.d.m.checkNotNullParameter(bVar, "fqName");
        d0.z.d.m.checkNotNullParameter(function1, "nameFilter");
        HashSet hashSet = new HashSet();
        Iterator<d0.e0.p.d.m0.c.f0> it = this.a.iterator();
        while (it.hasNext()) {
            hashSet.addAll(it.next().getSubPackagesOf(bVar, function1));
        }
        return hashSet;
    }
}
