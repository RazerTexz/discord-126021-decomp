package d0.e0.p.d.m0.n;

import java.util.List;

/* JADX INFO: compiled from: KotlinType.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class v extends i1 implements d0.e0.p.d.m0.n.n1.f {
    public final j0 k;
    public final j0 l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(j0 j0Var, j0 j0Var2) {
        super(null);
        d0.z.d.m.checkNotNullParameter(j0Var, "lowerBound");
        d0.z.d.m.checkNotNullParameter(j0Var2, "upperBound");
        this.k = j0Var;
        this.l = j0Var2;
    }

    @Override // d0.e0.p.d.m0.c.g1.a
    public d0.e0.p.d.m0.c.g1.g getAnnotations() {
        return getDelegate().getAnnotations();
    }

    @Override // d0.e0.p.d.m0.n.c0
    public List<w0> getArguments() {
        return getDelegate().getArguments();
    }

    @Override // d0.e0.p.d.m0.n.c0
    public u0 getConstructor() {
        return getDelegate().getConstructor();
    }

    public abstract j0 getDelegate();

    public final j0 getLowerBound() {
        return this.k;
    }

    @Override // d0.e0.p.d.m0.n.c0
    public d0.e0.p.d.m0.k.a0.i getMemberScope() {
        return getDelegate().getMemberScope();
    }

    public final j0 getUpperBound() {
        return this.l;
    }

    @Override // d0.e0.p.d.m0.n.c0
    public boolean isMarkedNullable() {
        return getDelegate().isMarkedNullable();
    }

    public abstract String render(d0.e0.p.d.m0.j.c cVar, d0.e0.p.d.m0.j.h hVar);

    public String toString() {
        return d0.e0.p.d.m0.j.c.c.renderType(this);
    }
}
