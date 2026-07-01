package b.g.a.c.g0.u;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: AtomicReferenceSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class c extends f0<AtomicReference<?>> {
    private static final long serialVersionUID = 1;

    public c(b.g.a.c.h0.i iVar, boolean z2, b.g.a.c.e0.g gVar, b.g.a.c.n<Object> nVar) {
        super(iVar, gVar, nVar);
    }

    @Override // b.g.a.c.g0.u.f0
    public Object q(AtomicReference<?> atomicReference) {
        return atomicReference.get();
    }

    @Override // b.g.a.c.g0.u.f0
    public Object r(AtomicReference<?> atomicReference) {
        return atomicReference.get();
    }

    @Override // b.g.a.c.g0.u.f0
    public boolean s(AtomicReference<?> atomicReference) {
        return atomicReference.get() != null;
    }

    @Override // b.g.a.c.g0.u.f0
    public f0<AtomicReference<?>> t(Object obj, boolean z2) {
        return new c(this, this._property, this._valueTypeSerializer, this._valueSerializer, this._unwrapper, obj, z2);
    }

    @Override // b.g.a.c.g0.u.f0
    public f0<AtomicReference<?>> u(b.g.a.c.d dVar, b.g.a.c.e0.g gVar, b.g.a.c.n<?> nVar, b.g.a.c.i0.n nVar2) {
        return new c(this, dVar, gVar, nVar, nVar2, this._suppressableValue, this._suppressNulls);
    }

    public c(c cVar, b.g.a.c.d dVar, b.g.a.c.e0.g gVar, b.g.a.c.n<?> nVar, b.g.a.c.i0.n nVar2, Object obj, boolean z2) {
        super(cVar, dVar, gVar, nVar, nVar2, obj, z2);
    }
}
