package p507d0.p513e0.p514p.p515d.p517m0.p552k;

import java.util.Collection;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11321b;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.j */
/* JADX INFO: compiled from: OverridingStrategy.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC11792j {
    public abstract void addFakeOverride(InterfaceC11321b interfaceC11321b);

    public abstract void inheritanceConflict(InterfaceC11321b interfaceC11321b, InterfaceC11321b interfaceC11321b2);

    public abstract void overrideConflict(InterfaceC11321b interfaceC11321b, InterfaceC11321b interfaceC11321b2);

    public void setOverriddenDescriptors(InterfaceC11321b interfaceC11321b, Collection<? extends InterfaceC11321b> collection) {
        C12238m.checkNotNullParameter(interfaceC11321b, "member");
        C12238m.checkNotNullParameter(collection, "overridden");
        interfaceC11321b.setOverriddenDescriptors(collection);
    }
}
