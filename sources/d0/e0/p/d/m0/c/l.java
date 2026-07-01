package d0.e0.p.d.m0.c;

import java.util.List;

/* JADX INFO: compiled from: ConstructorDescriptor.java */
/* JADX INFO: loaded from: classes3.dex */
public interface l extends x {
    e getConstructedClass();

    @Override // d0.e0.p.d.m0.c.x, d0.e0.p.d.m0.c.n, d0.e0.p.d.m0.c.m
    i getContainingDeclaration();

    @Override // d0.e0.p.d.m0.c.a
    d0.e0.p.d.m0.n.c0 getReturnType();

    @Override // d0.e0.p.d.m0.c.a
    List<z0> getTypeParameters();

    boolean isPrimary();

    @Override // d0.e0.p.d.m0.c.x, d0.e0.p.d.m0.c.w0
    l substitute(d0.e0.p.d.m0.n.c1 c1Var);
}
