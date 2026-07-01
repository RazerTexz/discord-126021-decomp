package d0.e0.p.d.m0.e.a.i0;

import d0.e0.p.d.m0.c.e0;
import d0.e0.p.d.m0.c.i0;
import d0.e0.p.d.m0.e.a.k0.u;
import d0.e0.p.d.m0.m.f$d;
import d0.t.n;
import d0.z.d.m;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: LazyJavaPackageFragmentProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f implements i0 {
    public final g a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d0.e0.p.d.m0.m.a<d0.e0.p.d.m0.g.b, d0.e0.p.d.m0.e.a.i0.l.i> f3322b;

    public f(b bVar) {
        m.checkNotNullParameter(bVar, "components");
        g gVar = new g(bVar, k$a.a, d0.h.lazyOf(null));
        this.a = gVar;
        this.f3322b = gVar.getStorageManager().createCacheWithNotNullValues();
    }

    public static final /* synthetic */ g access$getC$p(f fVar) {
        return fVar.a;
    }

    public final d0.e0.p.d.m0.e.a.i0.l.i a(d0.e0.p.d.m0.g.b bVar) {
        u uVarFindPackage = this.a.getComponents().getFinder().findPackage(bVar);
        if (uVarFindPackage == null) {
            return null;
        }
        return (d0.e0.p.d.m0.e.a.i0.l.i) ((f$d) this.f3322b).computeIfAbsent(bVar, new f$a(this, uVarFindPackage));
    }

    @Override // d0.e0.p.d.m0.c.i0
    public void collectPackageFragments(d0.e0.p.d.m0.g.b bVar, Collection<e0> collection) {
        m.checkNotNullParameter(bVar, "fqName");
        m.checkNotNullParameter(collection, "packageFragments");
        d0.e0.p.d.m0.p.a.addIfNotNull(collection, a(bVar));
    }

    @Override // d0.e0.p.d.m0.c.f0
    public List<d0.e0.p.d.m0.e.a.i0.l.i> getPackageFragments(d0.e0.p.d.m0.g.b bVar) {
        m.checkNotNullParameter(bVar, "fqName");
        return n.listOfNotNull(a(bVar));
    }

    @Override // d0.e0.p.d.m0.c.f0
    public /* bridge */ /* synthetic */ Collection getSubPackagesOf(d0.e0.p.d.m0.g.b bVar, Function1 function1) {
        return getSubPackagesOf(bVar, (Function1<? super d0.e0.p.d.m0.g.e, Boolean>) function1);
    }

    @Override // d0.e0.p.d.m0.c.f0
    public List<d0.e0.p.d.m0.g.b> getSubPackagesOf(d0.e0.p.d.m0.g.b bVar, Function1<? super d0.e0.p.d.m0.g.e, Boolean> function1) {
        m.checkNotNullParameter(bVar, "fqName");
        m.checkNotNullParameter(function1, "nameFilter");
        d0.e0.p.d.m0.e.a.i0.l.i iVarA = a(bVar);
        List<d0.e0.p.d.m0.g.b> subPackageFqNames$descriptors_jvm = iVarA == null ? null : iVarA.getSubPackageFqNames$descriptors_jvm();
        return subPackageFqNames$descriptors_jvm != null ? subPackageFqNames$descriptors_jvm : n.emptyList();
    }
}
