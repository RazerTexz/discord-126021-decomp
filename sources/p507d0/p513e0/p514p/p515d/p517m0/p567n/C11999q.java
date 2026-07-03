package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import p507d0.p513e0.p514p.p515d.p517m0.p518b.AbstractC11288h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p551j.AbstractC11746c;
import p507d0.p513e0.p514p.p515d.p517m0.p551j.InterfaceC11751h;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.AbstractC11947g;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11976e;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p571o1.C11992a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.q */
/* JADX INFO: compiled from: dynamicTypes.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11999q extends AbstractC12009v implements InterfaceC11976e {

    /* JADX INFO: renamed from: m */
    public final InterfaceC11344g f24862m;

    /* JADX WARN: Illegal instructions before constructor call */
    public C11999q(AbstractC11288h abstractC11288h, InterfaceC11344g interfaceC11344g) {
        C12238m.checkNotNullParameter(abstractC11288h, "builtIns");
        C12238m.checkNotNullParameter(interfaceC11344g, "annotations");
        AbstractC11934j0 nothingType = abstractC11288h.getNothingType();
        C12238m.checkNotNullExpressionValue(nothingType, "builtIns.nothingType");
        AbstractC11934j0 nullableAnyType = abstractC11288h.getNullableAnyType();
        C12238m.checkNotNullExpressionValue(nullableAnyType, "builtIns.nullableAnyType");
        super(nothingType, nullableAnyType);
        this.f24862m = interfaceC11344g;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC12009v, p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11338a
    public InterfaceC11344g getAnnotations() {
        return this.f24862m;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC12009v
    public AbstractC11934j0 getDelegate() {
        return getUpperBound();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC12009v, p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0
    public boolean isMarkedNullable() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11932i1
    public C11999q makeNullableAsSpecified(boolean z2) {
        return this;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11932i1, p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0
    public C11999q refine(AbstractC11947g abstractC11947g) {
        C12238m.checkNotNullParameter(abstractC11947g, "kotlinTypeRefiner");
        return this;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC12009v
    public String render(AbstractC11746c abstractC11746c, InterfaceC11751h interfaceC11751h) {
        C12238m.checkNotNullParameter(abstractC11746c, "renderer");
        C12238m.checkNotNullParameter(interfaceC11751h, "options");
        return "dynamic";
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11932i1
    public C11999q replaceAnnotations(InterfaceC11344g interfaceC11344g) {
        C12238m.checkNotNullParameter(interfaceC11344g, "newAnnotations");
        return new C11999q(C11992a.getBuiltIns(getDelegate()), interfaceC11344g);
    }
}
