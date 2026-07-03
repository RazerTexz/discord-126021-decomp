package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.n */
/* JADX INFO: compiled from: KotlinTypeFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC11970n extends AbstractC11967m {

    /* JADX INFO: renamed from: k */
    public final AbstractC11934j0 f24838k;

    public AbstractC11970n(AbstractC11934j0 abstractC11934j0) {
        C12238m.checkNotNullParameter(abstractC11934j0, "delegate");
        this.f24838k = abstractC11934j0;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11967m
    public AbstractC11934j0 getDelegate() {
        return this.f24838k;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11932i1
    public AbstractC11934j0 makeNullableAsSpecified(boolean z2) {
        return z2 == isMarkedNullable() ? this : this.f24838k.makeNullableAsSpecified(z2).replaceAnnotations(getAnnotations());
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11934j0, p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11932i1
    public AbstractC11970n replaceAnnotations(InterfaceC11344g interfaceC11344g) {
        C12238m.checkNotNullParameter(interfaceC11344g, "newAnnotations");
        return interfaceC11344g != getAnnotations() ? new C11927h(this, interfaceC11344g) : this;
    }
}
