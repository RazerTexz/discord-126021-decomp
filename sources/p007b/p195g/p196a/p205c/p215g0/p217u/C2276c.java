package p007b.p195g.p196a.p205c.p215g0.p217u;

import java.util.concurrent.atomic.AtomicReference;
import p007b.p195g.p196a.p205c.AbstractC2364n;
import p007b.p195g.p196a.p205c.InterfaceC2206d;
import p007b.p195g.p196a.p205c.p212e0.AbstractC2215g;
import p007b.p195g.p196a.p205c.p218h0.C2330i;
import p007b.p195g.p196a.p205c.p219i0.AbstractC2352n;

/* JADX INFO: renamed from: b.g.a.c.g0.u.c */
/* JADX INFO: compiled from: AtomicReferenceSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2276c extends AbstractC2283f0<AtomicReference<?>> {
    private static final long serialVersionUID = 1;

    public C2276c(C2330i c2330i, boolean z2, AbstractC2215g abstractC2215g, AbstractC2364n<Object> abstractC2364n) {
        super(c2330i, abstractC2215g, abstractC2364n);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2283f0
    /* JADX INFO: renamed from: q */
    public Object mo2046q(AtomicReference<?> atomicReference) {
        return atomicReference.get();
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2283f0
    /* JADX INFO: renamed from: r */
    public Object mo2047r(AtomicReference<?> atomicReference) {
        return atomicReference.get();
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2283f0
    /* JADX INFO: renamed from: s */
    public boolean mo2048s(AtomicReference<?> atomicReference) {
        return atomicReference.get() != null;
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2283f0
    /* JADX INFO: renamed from: t */
    public AbstractC2283f0<AtomicReference<?>> mo2049t(Object obj, boolean z2) {
        return new C2276c(this, this._property, this._valueTypeSerializer, this._valueSerializer, this._unwrapper, obj, z2);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2283f0
    /* JADX INFO: renamed from: u */
    public AbstractC2283f0<AtomicReference<?>> mo2050u(InterfaceC2206d interfaceC2206d, AbstractC2215g abstractC2215g, AbstractC2364n<?> abstractC2364n, AbstractC2352n abstractC2352n) {
        return new C2276c(this, interfaceC2206d, abstractC2215g, abstractC2364n, abstractC2352n, this._suppressableValue, this._suppressNulls);
    }

    public C2276c(C2276c c2276c, InterfaceC2206d interfaceC2206d, AbstractC2215g abstractC2215g, AbstractC2364n<?> abstractC2364n, AbstractC2352n abstractC2352n, Object obj, boolean z2) {
        super(c2276c, interfaceC2206d, abstractC2215g, abstractC2364n, abstractC2352n, obj, z2);
    }
}
