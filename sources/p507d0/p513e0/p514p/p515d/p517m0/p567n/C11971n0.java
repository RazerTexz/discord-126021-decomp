package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import p507d0.p513e0.p514p.p515d.p517m0.p518b.AbstractC11288h;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.AbstractC11947g;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.n0 */
/* JADX INFO: compiled from: StarProjectionImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11971n0 extends AbstractC12014x0 {

    /* JADX INFO: renamed from: a */
    public final AbstractC11913c0 f24839a;

    public C11971n0(AbstractC11288h abstractC11288h) {
        C12238m.checkNotNullParameter(abstractC11288h, "kotlinBuiltIns");
        AbstractC11934j0 nullableAnyType = abstractC11288h.getNullableAnyType();
        C12238m.checkNotNullExpressionValue(nullableAnyType, "kotlinBuiltIns.nullableAnyType");
        this.f24839a = nullableAnyType;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12012w0
    public EnumC11935j1 getProjectionKind() {
        return EnumC11935j1.OUT_VARIANCE;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12012w0
    public AbstractC11913c0 getType() {
        return this.f24839a;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12012w0
    public boolean isStarProjection() {
        return true;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12012w0
    public InterfaceC12012w0 refine(AbstractC11947g abstractC11947g) {
        C12238m.checkNotNullParameter(abstractC11947g, "kotlinTypeRefiner");
        return this;
    }
}
