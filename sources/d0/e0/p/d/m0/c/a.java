package d0.e0.p.d.m0.c;

import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: CallableDescriptor.java */
/* JADX INFO: loaded from: classes3.dex */
public interface a extends n, q, w0<a> {
    q0 getDispatchReceiverParameter();

    q0 getExtensionReceiverParameter();

    @Override // d0.e0.p.d.m0.c.m
    a getOriginal();

    Collection<? extends a> getOverriddenDescriptors();

    d0.e0.p.d.m0.n.c0 getReturnType();

    List<z0> getTypeParameters();

    <V> V getUserData(a$a<V> a_a);

    List<c1> getValueParameters();

    boolean hasSynthesizedParameterNames();
}
