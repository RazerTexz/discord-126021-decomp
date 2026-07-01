package d0.e0.p.d.m0.c;

import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: ClassDescriptor.java */
/* JADX INFO: loaded from: classes3.dex */
public interface e extends g, i {
    e getCompanionObjectDescriptor();

    Collection<d> getConstructors();

    @Override // d0.e0.p.d.m0.c.n, d0.e0.p.d.m0.c.m
    m getContainingDeclaration();

    List<z0> getDeclaredTypeParameters();

    @Override // d0.e0.p.d.m0.c.h
    d0.e0.p.d.m0.n.j0 getDefaultType();

    f getKind();

    d0.e0.p.d.m0.k.a0.i getMemberScope(d0.e0.p.d.m0.n.z0 z0Var);

    z getModality();

    @Override // d0.e0.p.d.m0.c.m
    e getOriginal();

    Collection<e> getSealedSubclasses();

    d0.e0.p.d.m0.k.a0.i getStaticScope();

    q0 getThisAsReceiverParameter();

    d0.e0.p.d.m0.k.a0.i getUnsubstitutedInnerClassesScope();

    d0.e0.p.d.m0.k.a0.i getUnsubstitutedMemberScope();

    d getUnsubstitutedPrimaryConstructor();

    u getVisibility();

    boolean isCompanionObject();

    boolean isData();

    boolean isFun();

    boolean isInline();

    boolean isValue();
}
