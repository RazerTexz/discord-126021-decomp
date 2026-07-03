package p507d0.p513e0.p514p.p515d.p517m0.p521c;

import java.util.Collection;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11321b;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC12018z0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11914c1;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.x */
/* JADX INFO: compiled from: FunctionDescriptor.java */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC11472x extends InterfaceC11321b {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.x$a */
    /* JADX INFO: compiled from: FunctionDescriptor.java */
    public interface a<D extends InterfaceC11472x> {
        D build();

        a<D> setAdditionalAnnotations(InterfaceC11344g interfaceC11344g);

        a<D> setCopyOverrides(boolean z2);

        a<D> setDispatchReceiverParameter(InterfaceC11459q0 interfaceC11459q0);

        a<D> setDropOriginalInContainingParts();

        a<D> setExtensionReceiverParameter(InterfaceC11459q0 interfaceC11459q0);

        a<D> setHiddenForResolutionEverywhereBesideSupercalls();

        a<D> setHiddenToOvercomeSignatureClash();

        a<D> setKind(InterfaceC11321b.a aVar);

        a<D> setModality(EnumC11476z enumC11476z);

        a<D> setName(C11716e c11716e);

        a<D> setOriginal(InterfaceC11321b interfaceC11321b);

        a<D> setOwner(InterfaceC11450m interfaceC11450m);

        a<D> setPreserveSourceElement();

        a<D> setReturnType(AbstractC11913c0 abstractC11913c0);

        a<D> setSignatureChange();

        a<D> setSubstitution(AbstractC12018z0 abstractC12018z0);

        a<D> setTypeParameters(List<InterfaceC11477z0> list);

        a<D> setValueParameters(List<InterfaceC11326c1> list);

        a<D> setVisibility(AbstractC11466u abstractC11466u);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11452n, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m
    InterfaceC11450m getContainingDeclaration();

    InterfaceC11472x getInitialSignatureDescriptor();

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11321b, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11318a, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m
    InterfaceC11472x getOriginal();

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11321b, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11318a
    Collection<? extends InterfaceC11472x> getOverriddenDescriptors();

    boolean isHiddenForResolutionEverywhereBesideSupercalls();

    boolean isHiddenToOvercomeSignatureClash();

    boolean isInfix();

    boolean isInline();

    boolean isOperator();

    boolean isSuspend();

    boolean isTailrec();

    a<? extends InterfaceC11472x> newCopyBuilder();

    InterfaceC11472x substitute(C11914c1 c11914c1);
}
