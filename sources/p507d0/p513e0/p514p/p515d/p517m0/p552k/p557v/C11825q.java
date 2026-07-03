package p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v;

import java.util.Collection;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.AbstractC11288h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11352h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.AbstractC11947g;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.v.q */
/* JADX INFO: compiled from: IntegerValueTypeConstructor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11825q implements InterfaceC12008u0 {
    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0
    public AbstractC11288h getBuiltIns() {
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0
    public /* bridge */ /* synthetic */ InterfaceC11352h getDeclarationDescriptor() {
        return (InterfaceC11352h) m11471getDeclarationDescriptor();
    }

    /* JADX INFO: renamed from: getDeclarationDescriptor, reason: collision with other method in class */
    public Void m11471getDeclarationDescriptor() {
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0
    public List<InterfaceC11477z0> getParameters() {
        return C12147n.emptyList();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0
    public Collection<AbstractC11913c0> getSupertypes() {
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0
    public boolean isDenotable() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0
    public InterfaceC12008u0 refine(AbstractC11947g abstractC11947g) {
        C12238m.checkNotNullParameter(abstractC11947g, "kotlinTypeRefiner");
        return this;
    }

    public String toString() {
        return "IntegerValueType(0)";
    }
}
