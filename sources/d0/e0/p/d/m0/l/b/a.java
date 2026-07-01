package d0.e0.p.d.m0.l.b;

import d0.e0.p.d.m0.c.e0;
import d0.e0.p.d.m0.c.i0;
import d0.t.n0;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AbstractDeserializedPackageFragmentProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements i0 {
    public final d0.e0.p.d.m0.m.o a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s f3481b;
    public final d0.e0.p.d.m0.c.c0 c;
    public j d;
    public final d0.e0.p.d.m0.m.i<d0.e0.p.d.m0.g.b, e0> e;

    public a(d0.e0.p.d.m0.m.o oVar, s sVar, d0.e0.p.d.m0.c.c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(oVar, "storageManager");
        d0.z.d.m.checkNotNullParameter(sVar, "finder");
        d0.z.d.m.checkNotNullParameter(c0Var, "moduleDescriptor");
        this.a = oVar;
        this.f3481b = sVar;
        this.c = c0Var;
        this.e = oVar.createMemoizedFunctionWithNullableValues(new a$a(this));
    }

    @Override // d0.e0.p.d.m0.c.i0
    public void collectPackageFragments(d0.e0.p.d.m0.g.b bVar, Collection<e0> collection) {
        d0.z.d.m.checkNotNullParameter(bVar, "fqName");
        d0.z.d.m.checkNotNullParameter(collection, "packageFragments");
        d0.e0.p.d.m0.p.a.addIfNotNull(collection, this.e.invoke(bVar));
    }

    @Override // d0.e0.p.d.m0.c.f0
    public List<e0> getPackageFragments(d0.e0.p.d.m0.g.b bVar) {
        d0.z.d.m.checkNotNullParameter(bVar, "fqName");
        return d0.t.n.listOfNotNull(this.e.invoke(bVar));
    }

    @Override // d0.e0.p.d.m0.c.f0
    public Collection<d0.e0.p.d.m0.g.b> getSubPackagesOf(d0.e0.p.d.m0.g.b bVar, Function1<? super d0.e0.p.d.m0.g.e, Boolean> function1) {
        d0.z.d.m.checkNotNullParameter(bVar, "fqName");
        d0.z.d.m.checkNotNullParameter(function1, "nameFilter");
        return n0.emptySet();
    }
}
