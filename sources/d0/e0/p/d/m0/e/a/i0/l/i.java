package d0.e0.p.d.m0.e.a.i0.l;

import d0.e0.p.d.m0.c.i1.a0;
import d0.e0.p.d.m0.c.u0;
import d0.e0.p.d.m0.e.a.k0.u;
import d0.z.d.y;
import java.util.List;
import java.util.Map;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: LazyJavaPackageFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i extends a0 {
    public static final /* synthetic */ KProperty<Object>[] o = {d0.z.d.a0.property1(new y(d0.z.d.a0.getOrCreateKotlinClass(i.class), "binaryClasses", "getBinaryClasses$descriptors_jvm()Ljava/util/Map;")), d0.z.d.a0.property1(new y(d0.z.d.a0.getOrCreateKotlinClass(i.class), "partToFacade", "getPartToFacade()Ljava/util/HashMap;"))};
    public final u p;
    public final d0.e0.p.d.m0.e.a.i0.g q;
    public final d0.e0.p.d.m0.m.j r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final d f3333s;
    public final d0.e0.p.d.m0.m.j<List<d0.e0.p.d.m0.g.b>> t;
    public final d0.e0.p.d.m0.c.g1.g u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(d0.e0.p.d.m0.e.a.i0.g gVar, u uVar) {
        super(gVar.getModule(), uVar.getFqName());
        d0.z.d.m.checkNotNullParameter(gVar, "outerContext");
        d0.z.d.m.checkNotNullParameter(uVar, "jPackage");
        this.p = uVar;
        d0.e0.p.d.m0.e.a.i0.g gVarChildForClassOrPackage$default = d0.e0.p.d.m0.e.a.i0.a.childForClassOrPackage$default(gVar, this, null, 0, 6, null);
        this.q = gVarChildForClassOrPackage$default;
        this.r = gVarChildForClassOrPackage$default.getStorageManager().createLazyValue(new i$a(this));
        this.f3333s = new d(gVarChildForClassOrPackage$default, uVar, this);
        this.t = gVarChildForClassOrPackage$default.getStorageManager().createRecursionTolerantLazyValue(new i$c(this), d0.t.n.emptyList());
        this.u = gVarChildForClassOrPackage$default.getComponents().getJavaTypeEnhancementState().getDisabledDefaultAnnotations() ? d0.e0.p.d.m0.c.g1.g.f.getEMPTY() : d0.e0.p.d.m0.e.a.i0.e.resolveAnnotations(gVarChildForClassOrPackage$default, uVar);
        gVarChildForClassOrPackage$default.getStorageManager().createLazyValue(new i$b(this));
    }

    public static final /* synthetic */ d0.e0.p.d.m0.e.a.i0.g access$getC$p(i iVar) {
        return iVar.q;
    }

    public static final /* synthetic */ u access$getJPackage$p(i iVar) {
        return iVar.p;
    }

    public final d0.e0.p.d.m0.c.e findClassifierByJavaClass$descriptors_jvm(d0.e0.p.d.m0.e.a.k0.g gVar) {
        d0.z.d.m.checkNotNullParameter(gVar, "jClass");
        return this.f3333s.getJavaScope$descriptors_jvm().findClassifierByJavaClass$descriptors_jvm(gVar);
    }

    @Override // d0.e0.p.d.m0.c.g1.b, d0.e0.p.d.m0.c.g1.a
    public d0.e0.p.d.m0.c.g1.g getAnnotations() {
        return this.u;
    }

    public final Map<String, d0.e0.p.d.m0.e.b.p> getBinaryClasses$descriptors_jvm() {
        return (Map) d0.e0.p.d.m0.m.n.getValue(this.r, this, (KProperty<?>) o[0]);
    }

    @Override // d0.e0.p.d.m0.c.e0
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.k.a0.i getMemberScope() {
        return getMemberScope();
    }

    @Override // d0.e0.p.d.m0.c.i1.a0, d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.p
    public u0 getSource() {
        return new d0.e0.p.d.m0.e.b.q(this);
    }

    public final List<d0.e0.p.d.m0.g.b> getSubPackageFqNames$descriptors_jvm() {
        return this.t.invoke();
    }

    @Override // d0.e0.p.d.m0.c.i1.a0, d0.e0.p.d.m0.c.i1.k
    public String toString() {
        return d0.z.d.m.stringPlus("Lazy Java package fragment: ", getFqName());
    }

    @Override // d0.e0.p.d.m0.c.e0
    public d getMemberScope() {
        return this.f3333s;
    }
}
