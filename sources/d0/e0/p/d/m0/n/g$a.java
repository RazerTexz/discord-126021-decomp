package d0.e0.p.d.m0.n;

import java.util.Collection;
import java.util.List;
import kotlin.Lazy;

/* JADX INFO: compiled from: AbstractTypeConstructor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g$a implements u0 {
    public final d0.e0.p.d.m0.n.l1.g a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f3524b;
    public final /* synthetic */ g c;

    public g$a(g gVar, d0.e0.p.d.m0.n.l1.g gVar2) {
        d0.z.d.m.checkNotNullParameter(gVar, "this$0");
        d0.z.d.m.checkNotNullParameter(gVar2, "kotlinTypeRefiner");
        this.c = gVar;
        this.a = gVar2;
        this.f3524b = d0.g.lazy(d0.i.PUBLICATION, new g$a$a(this, gVar));
    }

    public static final /* synthetic */ d0.e0.p.d.m0.n.l1.g access$getKotlinTypeRefiner$p(g$a g_a) {
        return g_a.a;
    }

    public boolean equals(Object obj) {
        return this.c.equals(obj);
    }

    @Override // d0.e0.p.d.m0.n.u0
    public d0.e0.p.d.m0.b.h getBuiltIns() {
        d0.e0.p.d.m0.b.h builtIns = this.c.getBuiltIns();
        d0.z.d.m.checkNotNullExpressionValue(builtIns, "this@AbstractTypeConstructor.builtIns");
        return builtIns;
    }

    @Override // d0.e0.p.d.m0.n.u0
    public d0.e0.p.d.m0.c.h getDeclarationDescriptor() {
        return this.c.getDeclarationDescriptor();
    }

    @Override // d0.e0.p.d.m0.n.u0
    public List<d0.e0.p.d.m0.c.z0> getParameters() {
        List<d0.e0.p.d.m0.c.z0> parameters = this.c.getParameters();
        d0.z.d.m.checkNotNullExpressionValue(parameters, "this@AbstractTypeConstructor.parameters");
        return parameters;
    }

    @Override // d0.e0.p.d.m0.n.u0
    public /* bridge */ /* synthetic */ Collection getSupertypes() {
        return getSupertypes();
    }

    public int hashCode() {
        return this.c.hashCode();
    }

    @Override // d0.e0.p.d.m0.n.u0
    public boolean isDenotable() {
        return this.c.isDenotable();
    }

    @Override // d0.e0.p.d.m0.n.u0
    public u0 refine(d0.e0.p.d.m0.n.l1.g gVar) {
        d0.z.d.m.checkNotNullParameter(gVar, "kotlinTypeRefiner");
        return this.c.refine(gVar);
    }

    public String toString() {
        return this.c.toString();
    }

    @Override // d0.e0.p.d.m0.n.u0
    public List<c0> getSupertypes() {
        return (List) this.f3524b.getValue();
    }
}
