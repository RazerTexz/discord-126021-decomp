package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.AbstractC11947g;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.a */
/* JADX INFO: compiled from: SpecialTypes.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11906a extends AbstractC11967m {

    /* JADX INFO: renamed from: k */
    public final AbstractC11934j0 f24737k;

    /* JADX INFO: renamed from: l */
    public final AbstractC11934j0 f24738l;

    public C11906a(AbstractC11934j0 abstractC11934j0, AbstractC11934j0 abstractC11934j1) {
        C12238m.checkNotNullParameter(abstractC11934j0, "delegate");
        C12238m.checkNotNullParameter(abstractC11934j1, "abbreviation");
        this.f24737k = abstractC11934j0;
        this.f24738l = abstractC11934j1;
    }

    public final AbstractC11934j0 getAbbreviation() {
        return this.f24738l;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11967m
    public AbstractC11934j0 getDelegate() {
        return this.f24737k;
    }

    public final AbstractC11934j0 getExpandedType() {
        return this.f24737k;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11967m
    public C11906a replaceDelegate(AbstractC11934j0 abstractC11934j0) {
        C12238m.checkNotNullParameter(abstractC11934j0, "delegate");
        return new C11906a(abstractC11934j0, this.f24738l);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11934j0, p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11932i1
    public C11906a makeNullableAsSpecified(boolean z2) {
        return new C11906a(this.f24737k.makeNullableAsSpecified(z2), this.f24738l.makeNullableAsSpecified(z2));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11934j0, p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11932i1
    public C11906a replaceAnnotations(InterfaceC11344g interfaceC11344g) {
        C12238m.checkNotNullParameter(interfaceC11344g, "newAnnotations");
        return new C11906a(this.f24737k.replaceAnnotations(interfaceC11344g), this.f24738l);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11967m, p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11932i1, p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0
    public C11906a refine(AbstractC11947g abstractC11947g) {
        C12238m.checkNotNullParameter(abstractC11947g, "kotlinTypeRefiner");
        return new C11906a((AbstractC11934j0) abstractC11947g.refineType(this.f24737k), (AbstractC11934j0) abstractC11947g.refineType(this.f24738l));
    }
}
