package d0.e0.p.d.m0.c;

import java.util.Collection;

/* JADX INFO: compiled from: ValueParameterDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface c1 extends k0, d1 {
    c1 copy(a aVar, d0.e0.p.d.m0.g.e eVar, int i);

    boolean declaresDefaultValue();

    @Override // d0.e0.p.d.m0.c.b1, d0.e0.p.d.m0.c.n, d0.e0.p.d.m0.c.m
    a getContainingDeclaration();

    int getIndex();

    @Override // d0.e0.p.d.m0.c.a, d0.e0.p.d.m0.c.m
    c1 getOriginal();

    @Override // d0.e0.p.d.m0.c.a
    Collection<c1> getOverriddenDescriptors();

    d0.e0.p.d.m0.n.c0 getVarargElementType();

    boolean isCrossinline();

    boolean isNoinline();
}
