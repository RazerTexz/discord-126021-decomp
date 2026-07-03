package p507d0.p513e0.p514p.p515d.p517m0.p521c;

import java.util.Collection;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11914c1;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.n0 */
/* JADX INFO: compiled from: PropertyDescriptor.java */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC11453n0 extends InterfaceC11321b, InterfaceC11329d1 {
    List<InterfaceC11451m0> getAccessors();

    InterfaceC11468v getBackingField();

    InterfaceC11468v getDelegateField();

    InterfaceC11455o0 getGetter();

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11321b, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11318a, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m
    InterfaceC11453n0 getOriginal();

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11321b, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11318a
    Collection<? extends InterfaceC11453n0> getOverriddenDescriptors();

    InterfaceC11457p0 getSetter();

    boolean isDelegated();

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11471w0
    InterfaceC11453n0 substitute(C11914c1 c11914c1);
}
