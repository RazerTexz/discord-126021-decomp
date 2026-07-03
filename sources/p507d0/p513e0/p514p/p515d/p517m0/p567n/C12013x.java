package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p551j.AbstractC11746c;
import p507d0.p513e0.p514p.p515d.p517m0.p551j.InterfaceC11751h;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.AbstractC11947g;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.x */
/* JADX INFO: compiled from: TypeWithEnhancement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12013x extends AbstractC12009v implements InterfaceC11923f1 {

    /* JADX INFO: renamed from: m */
    public final AbstractC12009v f24892m;

    /* JADX INFO: renamed from: n */
    public final AbstractC11913c0 f24893n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C12013x(AbstractC12009v abstractC12009v, AbstractC11913c0 abstractC11913c0) {
        super(abstractC12009v.getLowerBound(), abstractC12009v.getUpperBound());
        C12238m.checkNotNullParameter(abstractC12009v, "origin");
        C12238m.checkNotNullParameter(abstractC11913c0, "enhancement");
        this.f24892m = abstractC12009v;
        this.f24893n = abstractC11913c0;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC12009v
    public AbstractC11934j0 getDelegate() {
        return getOrigin().getDelegate();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC11923f1
    public AbstractC11913c0 getEnhancement() {
        return this.f24893n;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11932i1
    public AbstractC11932i1 makeNullableAsSpecified(boolean z2) {
        return C11926g1.wrapEnhancement(getOrigin().makeNullableAsSpecified(z2), getEnhancement().unwrap().makeNullableAsSpecified(z2));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC12009v
    public String render(AbstractC11746c abstractC11746c, InterfaceC11751h interfaceC11751h) {
        C12238m.checkNotNullParameter(abstractC11746c, "renderer");
        C12238m.checkNotNullParameter(interfaceC11751h, "options");
        return interfaceC11751h.getEnhancedTypes() ? abstractC11746c.renderType(getEnhancement()) : getOrigin().render(abstractC11746c, interfaceC11751h);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11932i1
    public AbstractC11932i1 replaceAnnotations(InterfaceC11344g interfaceC11344g) {
        C12238m.checkNotNullParameter(interfaceC11344g, "newAnnotations");
        return C11926g1.wrapEnhancement(getOrigin().replaceAnnotations(interfaceC11344g), getEnhancement());
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC11923f1
    public AbstractC12009v getOrigin() {
        return this.f24892m;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11932i1, p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0
    public C12013x refine(AbstractC11947g abstractC11947g) {
        C12238m.checkNotNullParameter(abstractC11947g, "kotlinTypeRefiner");
        return new C12013x((AbstractC12009v) abstractC11947g.refineType(getOrigin()), abstractC11947g.refineType(getEnhancement()));
    }
}
