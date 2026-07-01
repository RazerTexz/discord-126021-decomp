package d0.e0.p.d.m0.c.i1;

import java.util.List;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: LazyPackageViewDescriptorImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class s extends k implements d0.e0.p.d.m0.c.j0 {
    public static final /* synthetic */ KProperty<Object>[] l = {d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(s.class), "fragments", "getFragments()Ljava/util/List;"))};
    public final y m;
    public final d0.e0.p.d.m0.g.b n;
    public final d0.e0.p.d.m0.m.j o;
    public final d0.e0.p.d.m0.k.a0.i p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(y yVar, d0.e0.p.d.m0.g.b bVar, d0.e0.p.d.m0.m.o oVar) {
        super(d0.e0.p.d.m0.c.g1.g.f.getEMPTY(), bVar.shortNameOrSpecial());
        d0.z.d.m.checkNotNullParameter(yVar, "module");
        d0.z.d.m.checkNotNullParameter(bVar, "fqName");
        d0.z.d.m.checkNotNullParameter(oVar, "storageManager");
        this.m = yVar;
        this.n = bVar;
        this.o = oVar.createLazyValue(new s$a(this));
        this.p = new d0.e0.p.d.m0.k.a0.h(oVar, new s$b(this));
    }

    @Override // d0.e0.p.d.m0.c.m
    public <R, D> R accept(d0.e0.p.d.m0.c.o<R, D> oVar, D d) {
        d0.z.d.m.checkNotNullParameter(oVar, "visitor");
        return oVar.visitPackageViewDescriptor(this, d);
    }

    public boolean equals(Object obj) {
        d0.e0.p.d.m0.c.j0 j0Var = obj instanceof d0.e0.p.d.m0.c.j0 ? (d0.e0.p.d.m0.c.j0) obj : null;
        return j0Var != null && d0.z.d.m.areEqual(getFqName(), j0Var.getFqName()) && d0.z.d.m.areEqual(getModule(), j0Var.getModule());
    }

    @Override // d0.e0.p.d.m0.c.m
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.m getContainingDeclaration() {
        return getContainingDeclaration();
    }

    @Override // d0.e0.p.d.m0.c.j0
    public d0.e0.p.d.m0.g.b getFqName() {
        return this.n;
    }

    @Override // d0.e0.p.d.m0.c.j0
    public List<d0.e0.p.d.m0.c.e0> getFragments() {
        return (List) d0.e0.p.d.m0.m.n.getValue(this.o, this, (KProperty<?>) l[0]);
    }

    @Override // d0.e0.p.d.m0.c.j0
    public d0.e0.p.d.m0.k.a0.i getMemberScope() {
        return this.p;
    }

    @Override // d0.e0.p.d.m0.c.j0
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.c0 getModule() {
        return getModule();
    }

    public int hashCode() {
        return getFqName().hashCode() + (getModule().hashCode() * 31);
    }

    @Override // d0.e0.p.d.m0.c.j0
    public boolean isEmpty() {
        return d0.e0.p.d.m0.c.j0$a.isEmpty(this);
    }

    @Override // d0.e0.p.d.m0.c.m
    public d0.e0.p.d.m0.c.j0 getContainingDeclaration() {
        if (getFqName().isRoot()) {
            return null;
        }
        y module = getModule();
        d0.e0.p.d.m0.g.b bVarParent = getFqName().parent();
        d0.z.d.m.checkNotNullExpressionValue(bVarParent, "fqName.parent()");
        return module.getPackage(bVarParent);
    }

    @Override // d0.e0.p.d.m0.c.j0
    public y getModule() {
        return this.m;
    }
}
