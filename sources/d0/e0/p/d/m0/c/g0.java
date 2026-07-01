package d0.e0.p.d.m0.c;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: PackageFragmentProviderImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g0 implements i0 {
    public final Collection<e0> a;

    /* JADX WARN: Multi-variable type inference failed */
    public g0(Collection<? extends e0> collection) {
        d0.z.d.m.checkNotNullParameter(collection, "packageFragments");
        this.a = collection;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // d0.e0.p.d.m0.c.i0
    public void collectPackageFragments(d0.e0.p.d.m0.g.b bVar, Collection<e0> collection) {
        d0.z.d.m.checkNotNullParameter(bVar, "fqName");
        d0.z.d.m.checkNotNullParameter(collection, "packageFragments");
        for (Object obj : this.a) {
            if (d0.z.d.m.areEqual(((e0) obj).getFqName(), bVar)) {
                collection.add(obj);
            }
        }
    }

    @Override // d0.e0.p.d.m0.c.f0
    public List<e0> getPackageFragments(d0.e0.p.d.m0.g.b bVar) {
        d0.z.d.m.checkNotNullParameter(bVar, "fqName");
        Collection<e0> collection = this.a;
        ArrayList arrayList = new ArrayList();
        for (Object obj : collection) {
            if (d0.z.d.m.areEqual(((e0) obj).getFqName(), bVar)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Override // d0.e0.p.d.m0.c.f0
    public Collection<d0.e0.p.d.m0.g.b> getSubPackagesOf(d0.e0.p.d.m0.g.b bVar, Function1<? super d0.e0.p.d.m0.g.e, Boolean> function1) {
        d0.z.d.m.checkNotNullParameter(bVar, "fqName");
        d0.z.d.m.checkNotNullParameter(function1, "nameFilter");
        return d0.f0.q.toList(d0.f0.q.filter(d0.f0.q.map(d0.t.u.asSequence(this.a), g0$a.j), new g0$b(bVar)));
    }
}
