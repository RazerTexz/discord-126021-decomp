package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.k1 */
/* JADX INFO: compiled from: KotlinType.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC11938k1 extends AbstractC11913c0 {
    public AbstractC11938k1() {
        super(null);
    }

    /* JADX INFO: renamed from: a */
    public abstract AbstractC11913c0 mo10011a();

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11338a
    public InterfaceC11344g getAnnotations() {
        return mo10011a().getAnnotations();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0
    public List<InterfaceC12012w0> getArguments() {
        return mo10011a().getArguments();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0
    public InterfaceC12008u0 getConstructor() {
        return mo10011a().getConstructor();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0
    public InterfaceC11770i getMemberScope() {
        return mo10011a().getMemberScope();
    }

    public boolean isComputed() {
        return true;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0
    public boolean isMarkedNullable() {
        return mo10011a().isMarkedNullable();
    }

    public String toString() {
        return isComputed() ? mo10011a().toString() : "<Not computed yet>";
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0
    public final AbstractC11932i1 unwrap() {
        AbstractC11913c0 abstractC11913c0Mo10011a = mo10011a();
        while (abstractC11913c0Mo10011a instanceof AbstractC11938k1) {
            abstractC11913c0Mo10011a = ((AbstractC11938k1) abstractC11913c0Mo10011a).mo10011a();
        }
        return (AbstractC11932i1) abstractC11913c0Mo10011a;
    }
}
