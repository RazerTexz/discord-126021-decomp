package d0.e0.p.d.m0.c;

import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: PropertyDescriptor.java */
/* JADX INFO: loaded from: classes3.dex */
public interface n0 extends b, d1 {
    List<m0> getAccessors();

    v getBackingField();

    v getDelegateField();

    o0 getGetter();

    @Override // d0.e0.p.d.m0.c.b, d0.e0.p.d.m0.c.a, d0.e0.p.d.m0.c.m
    n0 getOriginal();

    @Override // d0.e0.p.d.m0.c.b, d0.e0.p.d.m0.c.a
    Collection<? extends n0> getOverriddenDescriptors();

    p0 getSetter();

    boolean isDelegated();

    @Override // d0.e0.p.d.m0.c.w0
    n0 substitute(d0.e0.p.d.m0.n.c1 c1Var);
}
