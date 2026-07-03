package p507d0.p513e0.p514p.p515d.p517m0.p552k.p555u.p556a;

import java.util.Collection;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.AbstractC11288h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11352h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.EnumC11935j1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12012w0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.AbstractC11947g;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.C11950j;
import p507d0.p580t.C12145m;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.u.a.c */
/* JADX INFO: compiled from: CapturedTypeConstructor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11805c implements InterfaceC11804b {

    /* JADX INFO: renamed from: a */
    public final InterfaceC12012w0 f24432a;

    /* JADX INFO: renamed from: b */
    public C11950j f24433b;

    public C11805c(InterfaceC12012w0 interfaceC12012w0) {
        C12238m.checkNotNullParameter(interfaceC12012w0, "projection");
        this.f24432a = interfaceC12012w0;
        getProjection().getProjectionKind();
        EnumC11935j1 enumC11935j1 = EnumC11935j1.INVARIANT;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0
    public AbstractC11288h getBuiltIns() {
        AbstractC11288h builtIns = getProjection().getType().getConstructor().getBuiltIns();
        C12238m.checkNotNullExpressionValue(builtIns, "projection.type.constructor.builtIns");
        return builtIns;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0
    public /* bridge */ /* synthetic */ InterfaceC11352h getDeclarationDescriptor() {
        return (InterfaceC11352h) m11470getDeclarationDescriptor();
    }

    /* JADX INFO: renamed from: getDeclarationDescriptor, reason: collision with other method in class */
    public Void m11470getDeclarationDescriptor() {
        return null;
    }

    public final C11950j getNewTypeConstructor() {
        return this.f24433b;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0
    public List<InterfaceC11477z0> getParameters() {
        return C12147n.emptyList();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p555u.p556a.InterfaceC11804b
    public InterfaceC12012w0 getProjection() {
        return this.f24432a;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0
    public Collection<AbstractC11913c0> getSupertypes() {
        AbstractC11913c0 type = getProjection().getProjectionKind() == EnumC11935j1.OUT_VARIANCE ? getProjection().getType() : getBuiltIns().getNullableAnyType();
        C12238m.checkNotNullExpressionValue(type, "if (projection.projectionKind == Variance.OUT_VARIANCE)\n            projection.type\n        else\n            builtIns.nullableAnyType");
        return C12145m.listOf(type);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0
    public boolean isDenotable() {
        return false;
    }

    public final void setNewTypeConstructor(C11950j c11950j) {
        this.f24433b = c11950j;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("CapturedTypeConstructor(");
        sbM833U.append(getProjection());
        sbM833U.append(')');
        return sbM833U.toString();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0
    public C11805c refine(AbstractC11947g abstractC11947g) {
        C12238m.checkNotNullParameter(abstractC11947g, "kotlinTypeRefiner");
        InterfaceC12012w0 interfaceC12012w0Refine = getProjection().refine(abstractC11947g);
        C12238m.checkNotNullExpressionValue(interfaceC12012w0Refine, "projection.refine(kotlinTypeRefiner)");
        return new C11805c(interfaceC12012w0Refine);
    }
}
