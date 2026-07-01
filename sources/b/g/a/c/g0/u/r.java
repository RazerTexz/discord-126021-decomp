package b.g.a.c.g0.u;

import java.io.IOException;
import java.util.Iterator;

/* JADX INFO: compiled from: IterableSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
@b.g.a.c.y.a
public class r extends b<Iterable<?>> {
    public r(b.g.a.c.j jVar, boolean z2, b.g.a.c.e0.g gVar) {
        super((Class<?>) Iterable.class, jVar, z2, gVar, (b.g.a.c.n<Object>) null);
    }

    @Override // b.g.a.c.n
    public boolean d(b.g.a.c.x xVar, Object obj) {
        return !((Iterable) obj).iterator().hasNext();
    }

    @Override // b.g.a.c.g0.u.b, b.g.a.c.n
    public void f(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
        Iterable<?> iterable = (Iterable) obj;
        if (((this._unwrapSingle == null && xVar.D(b.g.a.c.w.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) || this._unwrapSingle == Boolean.TRUE) && u(iterable)) {
            v(iterable, dVar, xVar);
            return;
        }
        dVar.X(iterable);
        v(iterable, dVar, xVar);
        dVar.t();
    }

    @Override // b.g.a.c.g0.h
    public b.g.a.c.g0.h<?> p(b.g.a.c.e0.g gVar) {
        return new r(this, this._property, gVar, this._elementSerializer, this._unwrapSingle);
    }

    @Override // b.g.a.c.g0.h
    public /* bridge */ /* synthetic */ boolean q(Object obj) {
        return u((Iterable) obj);
    }

    @Override // b.g.a.c.g0.u.b
    public /* bridge */ /* synthetic */ void s(Iterable<?> iterable, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
        v(iterable, dVar, xVar);
    }

    @Override // b.g.a.c.g0.u.b
    public b<Iterable<?>> t(b.g.a.c.d dVar, b.g.a.c.e0.g gVar, b.g.a.c.n nVar, Boolean bool) {
        return new r(this, dVar, gVar, nVar, bool);
    }

    public boolean u(Iterable<?> iterable) {
        if (iterable == null) {
            return false;
        }
        Iterator<?> it = iterable.iterator();
        if (!it.hasNext()) {
            return false;
        }
        it.next();
        return !it.hasNext();
    }

    public void v(Iterable<?> iterable, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
        b.g.a.c.n<Object> nVar;
        Iterator<?> it = iterable.iterator();
        if (it.hasNext()) {
            b.g.a.c.e0.g gVar = this._valueTypeSerializer;
            Class<?> cls = null;
            b.g.a.c.n<Object> nVarU = null;
            do {
                Object next = it.next();
                if (next == null) {
                    xVar.l(dVar);
                } else {
                    b.g.a.c.n<Object> nVar2 = this._elementSerializer;
                    if (nVar2 == null) {
                        Class<?> cls2 = next.getClass();
                        if (cls2 != cls) {
                            nVarU = xVar.u(cls2, this._property);
                            cls = cls2;
                        }
                        nVar = nVarU;
                    } else {
                        nVar = nVarU;
                        nVarU = nVar2;
                    }
                    if (gVar == null) {
                        nVarU.f(next, dVar, xVar);
                    } else {
                        nVarU.g(next, dVar, xVar, gVar);
                    }
                    nVarU = nVar;
                }
            } while (it.hasNext());
        }
    }

    public r(r rVar, b.g.a.c.d dVar, b.g.a.c.e0.g gVar, b.g.a.c.n<?> nVar, Boolean bool) {
        super(rVar, dVar, gVar, nVar, bool);
    }
}
