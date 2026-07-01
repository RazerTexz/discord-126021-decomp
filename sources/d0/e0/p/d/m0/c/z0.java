package d0.e0.p.d.m0.c;

import d0.e0.p.d.m0.n.j1;
import java.util.List;

/* JADX INFO: compiled from: TypeParameterDescriptor.java */
/* JADX INFO: loaded from: classes3.dex */
public interface z0 extends h, d0.e0.p.d.m0.n.n1.m {
    int getIndex();

    @Override // d0.e0.p.d.m0.c.h, d0.e0.p.d.m0.c.m
    z0 getOriginal();

    d0.e0.p.d.m0.m.o getStorageManager();

    @Override // d0.e0.p.d.m0.c.h
    d0.e0.p.d.m0.n.u0 getTypeConstructor();

    List<d0.e0.p.d.m0.n.c0> getUpperBounds();

    j1 getVariance();

    boolean isCapturedFromOuterDeclaration();

    boolean isReified();
}
