package d0.e0.p.d.m0.c;

import d0.e0.p.d.m0.n.j1;
import java.util.List;

/* JADX INFO: compiled from: typeParameterUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c implements z0 {
    public final z0 j;
    public final m k;
    public final int l;

    public c(z0 z0Var, m mVar, int i) {
        d0.z.d.m.checkNotNullParameter(z0Var, "originalDescriptor");
        d0.z.d.m.checkNotNullParameter(mVar, "declarationDescriptor");
        this.j = z0Var;
        this.k = mVar;
        this.l = i;
    }

    @Override // d0.e0.p.d.m0.c.m
    public <R, D> R accept(o<R, D> oVar, D d) {
        return (R) this.j.accept(oVar, d);
    }

    @Override // d0.e0.p.d.m0.c.g1.a
    public d0.e0.p.d.m0.c.g1.g getAnnotations() {
        return this.j.getAnnotations();
    }

    @Override // d0.e0.p.d.m0.c.n, d0.e0.p.d.m0.c.m
    public m getContainingDeclaration() {
        return this.k;
    }

    @Override // d0.e0.p.d.m0.c.h
    public d0.e0.p.d.m0.n.j0 getDefaultType() {
        return this.j.getDefaultType();
    }

    @Override // d0.e0.p.d.m0.c.z0
    public int getIndex() {
        return this.j.getIndex() + this.l;
    }

    @Override // d0.e0.p.d.m0.c.m
    public d0.e0.p.d.m0.g.e getName() {
        return this.j.getName();
    }

    @Override // d0.e0.p.d.m0.c.h, d0.e0.p.d.m0.c.m
    public /* bridge */ /* synthetic */ h getOriginal() {
        return getOriginal();
    }

    @Override // d0.e0.p.d.m0.c.p
    public u0 getSource() {
        return this.j.getSource();
    }

    @Override // d0.e0.p.d.m0.c.z0
    public d0.e0.p.d.m0.m.o getStorageManager() {
        return this.j.getStorageManager();
    }

    @Override // d0.e0.p.d.m0.c.z0, d0.e0.p.d.m0.c.h
    public d0.e0.p.d.m0.n.u0 getTypeConstructor() {
        return this.j.getTypeConstructor();
    }

    @Override // d0.e0.p.d.m0.c.z0
    public List<d0.e0.p.d.m0.n.c0> getUpperBounds() {
        return this.j.getUpperBounds();
    }

    @Override // d0.e0.p.d.m0.c.z0
    public j1 getVariance() {
        return this.j.getVariance();
    }

    @Override // d0.e0.p.d.m0.c.z0
    public boolean isCapturedFromOuterDeclaration() {
        return true;
    }

    @Override // d0.e0.p.d.m0.c.z0
    public boolean isReified() {
        return this.j.isReified();
    }

    public String toString() {
        return this.j + "[inner-copy]";
    }

    @Override // d0.e0.p.d.m0.c.m
    public /* bridge */ /* synthetic */ m getOriginal() {
        return getOriginal();
    }

    @Override // d0.e0.p.d.m0.c.z0, d0.e0.p.d.m0.c.h, d0.e0.p.d.m0.c.m
    public z0 getOriginal() {
        z0 original = this.j.getOriginal();
        d0.z.d.m.checkNotNullExpressionValue(original, "originalDescriptor.original");
        return original;
    }
}
