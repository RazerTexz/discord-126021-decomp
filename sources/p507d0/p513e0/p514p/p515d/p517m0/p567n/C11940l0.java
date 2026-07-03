package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.AbstractC11947g;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.l0 */
/* JADX INFO: compiled from: TypeWithEnhancement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11940l0 extends AbstractC11967m implements InterfaceC11923f1 {

    /* JADX INFO: renamed from: k */
    public final AbstractC11934j0 f24797k;

    /* JADX INFO: renamed from: l */
    public final AbstractC11913c0 f24798l;

    public C11940l0(AbstractC11934j0 abstractC11934j0, AbstractC11913c0 abstractC11913c0) {
        C12238m.checkNotNullParameter(abstractC11934j0, "delegate");
        C12238m.checkNotNullParameter(abstractC11913c0, "enhancement");
        this.f24797k = abstractC11934j0;
        this.f24798l = abstractC11913c0;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11967m
    public AbstractC11934j0 getDelegate() {
        return this.f24797k;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC11923f1
    public AbstractC11913c0 getEnhancement() {
        return this.f24798l;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC11923f1
    public AbstractC11932i1 getOrigin() {
        return this.f24797k;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11932i1
    public AbstractC11934j0 makeNullableAsSpecified(boolean z2) {
        return (AbstractC11934j0) C11926g1.wrapEnhancement(getOrigin().makeNullableAsSpecified(z2), getEnhancement().unwrap().makeNullableAsSpecified(z2));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11932i1
    public AbstractC11934j0 replaceAnnotations(InterfaceC11344g interfaceC11344g) {
        C12238m.checkNotNullParameter(interfaceC11344g, "newAnnotations");
        return (AbstractC11934j0) C11926g1.wrapEnhancement(getOrigin().replaceAnnotations(interfaceC11344g), getEnhancement());
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11967m
    public C11940l0 replaceDelegate(AbstractC11934j0 abstractC11934j0) {
        C12238m.checkNotNullParameter(abstractC11934j0, "delegate");
        return new C11940l0(abstractC11934j0, getEnhancement());
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11967m, p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11932i1, p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0
    public C11940l0 refine(AbstractC11947g abstractC11947g) {
        C12238m.checkNotNullParameter(abstractC11947g, "kotlinTypeRefiner");
        return new C11940l0((AbstractC11934j0) abstractC11947g.refineType(this.f24797k), abstractC11947g.refineType(getEnhancement()));
    }
}
