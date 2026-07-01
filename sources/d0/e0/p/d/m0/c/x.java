package d0.e0.p.d.m0.c;

import java.util.Collection;

/* JADX INFO: compiled from: FunctionDescriptor.java */
/* JADX INFO: loaded from: classes3.dex */
public interface x extends b {
    @Override // d0.e0.p.d.m0.c.n, d0.e0.p.d.m0.c.m
    m getContainingDeclaration();

    x getInitialSignatureDescriptor();

    @Override // d0.e0.p.d.m0.c.b, d0.e0.p.d.m0.c.a, d0.e0.p.d.m0.c.m
    x getOriginal();

    @Override // d0.e0.p.d.m0.c.b, d0.e0.p.d.m0.c.a
    Collection<? extends x> getOverriddenDescriptors();

    boolean isHiddenForResolutionEverywhereBesideSupercalls();

    boolean isHiddenToOvercomeSignatureClash();

    boolean isInfix();

    boolean isInline();

    boolean isOperator();

    boolean isSuspend();

    boolean isTailrec();

    x$a<? extends x> newCopyBuilder();

    x substitute(d0.e0.p.d.m0.n.c1 c1Var);
}
