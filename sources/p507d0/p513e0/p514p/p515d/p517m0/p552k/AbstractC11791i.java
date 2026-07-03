package p507d0.p513e0.p514p.p515d.p517m0.p552k;

import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11321b;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.i */
/* JADX INFO: compiled from: OverridingStrategy.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC11791i extends AbstractC11792j {
    public abstract void conflict(InterfaceC11321b interfaceC11321b, InterfaceC11321b interfaceC11321b2);

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.AbstractC11792j
    public void inheritanceConflict(InterfaceC11321b interfaceC11321b, InterfaceC11321b interfaceC11321b2) {
        C12238m.checkNotNullParameter(interfaceC11321b, "first");
        C12238m.checkNotNullParameter(interfaceC11321b2, "second");
        conflict(interfaceC11321b, interfaceC11321b2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.AbstractC11792j
    public void overrideConflict(InterfaceC11321b interfaceC11321b, InterfaceC11321b interfaceC11321b2) {
        C12238m.checkNotNullParameter(interfaceC11321b, "fromSuper");
        C12238m.checkNotNullParameter(interfaceC11321b2, "fromCurrent");
        conflict(interfaceC11321b, interfaceC11321b2);
    }
}
