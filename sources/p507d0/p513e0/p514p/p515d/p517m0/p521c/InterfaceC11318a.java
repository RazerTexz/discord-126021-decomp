package p507d0.p513e0.p514p.p515d.p517m0.p521c;

import java.util.Collection;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.a */
/* JADX INFO: compiled from: CallableDescriptor.java */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC11318a extends InterfaceC11452n, InterfaceC11458q, InterfaceC11471w0<InterfaceC11318a> {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.a$a */
    /* JADX INFO: compiled from: CallableDescriptor.java */
    public interface a<V> {
    }

    InterfaceC11459q0 getDispatchReceiverParameter();

    InterfaceC11459q0 getExtensionReceiverParameter();

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m
    InterfaceC11318a getOriginal();

    Collection<? extends InterfaceC11318a> getOverriddenDescriptors();

    AbstractC11913c0 getReturnType();

    List<InterfaceC11477z0> getTypeParameters();

    <V> V getUserData(a<V> aVar);

    List<InterfaceC11326c1> getValueParameters();

    boolean hasSynthesizedParameterNames();
}
