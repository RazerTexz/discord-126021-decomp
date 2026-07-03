package p507d0.p513e0.p514p.p515d.p517m0.p521c;

import java.util.Collection;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.c1 */
/* JADX INFO: compiled from: ValueParameterDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC11326c1 extends InterfaceC11407k0, InterfaceC11329d1 {
    InterfaceC11326c1 copy(InterfaceC11318a interfaceC11318a, C11716e c11716e, int i);

    boolean declaresDefaultValue();

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11323b1, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11452n, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m
    InterfaceC11318a getContainingDeclaration();

    int getIndex();

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11318a, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m
    InterfaceC11326c1 getOriginal();

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11318a
    Collection<InterfaceC11326c1> getOverriddenDescriptors();

    AbstractC11913c0 getVarargElementType();

    boolean isCrossinline();

    boolean isNoinline();
}
