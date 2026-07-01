package b.g.a.c.g0.t;

import b.g.a.c.x;
import java.io.IOException;
import java.util.Iterator;

/* JADX INFO: compiled from: IteratorSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
@b.g.a.c.y.a
public class h extends b.g.a.c.g0.u.b<Iterator<?>> {
    public h(b.g.a.c.j jVar, boolean z2, b.g.a.c.e0.g gVar) {
        super((Class<?>) Iterator.class, jVar, z2, gVar, (b.g.a.c.n<Object>) null);
    }

    @Override // b.g.a.c.n
    public boolean d(x xVar, Object obj) {
        return !((Iterator) obj).hasNext();
    }

    @Override // b.g.a.c.g0.u.b, b.g.a.c.n
    public void f(Object obj, b.g.a.b.d dVar, x xVar) throws IOException {
        Iterator<?> it = (Iterator) obj;
        dVar.X(it);
        u(it, dVar, xVar);
        dVar.t();
    }

    @Override // b.g.a.c.g0.h
    public b.g.a.c.g0.h<?> p(b.g.a.c.e0.g gVar) {
        return new h(this, this._property, gVar, this._elementSerializer, this._unwrapSingle);
    }

    @Override // b.g.a.c.g0.h
    public /* bridge */ /* synthetic */ boolean q(Object obj) {
        return false;
    }

    @Override // b.g.a.c.g0.u.b
    public /* bridge */ /* synthetic */ void s(Iterator<?> it, b.g.a.b.d dVar, x xVar) throws IOException {
        u(it, dVar, xVar);
    }

    @Override // b.g.a.c.g0.u.b
    public b.g.a.c.g0.u.b<Iterator<?>> t(b.g.a.c.d dVar, b.g.a.c.e0.g gVar, b.g.a.c.n nVar, Boolean bool) {
        return new h(this, dVar, gVar, nVar, bool);
    }

    public void u(Iterator<?> it, b.g.a.b.d dVar, x xVar) throws IOException {
        b.g.a.c.n<Object> nVarR;
        if (it.hasNext()) {
            b.g.a.c.n<Object> nVar = this._elementSerializer;
            if (nVar != null) {
                b.g.a.c.e0.g gVar = this._valueTypeSerializer;
                do {
                    Object next = it.next();
                    if (next == null) {
                        xVar.l(dVar);
                    } else if (gVar == null) {
                        nVar.f(next, dVar, xVar);
                    } else {
                        nVar.g(next, dVar, xVar, gVar);
                    }
                } while (it.hasNext());
                return;
            }
            b.g.a.c.e0.g gVar2 = this._valueTypeSerializer;
            l lVar = this._dynamicSerializers;
            do {
                Object next2 = it.next();
                if (next2 == null) {
                    xVar.l(dVar);
                } else {
                    Class<?> cls = next2.getClass();
                    b.g.a.c.n<Object> nVarC = lVar.c(cls);
                    if (nVarC == null) {
                        if (this._elementType.r()) {
                            l$d l_dA = lVar.a(xVar.k(this._elementType, cls), xVar, this._property);
                            l lVar2 = l_dA.f708b;
                            if (lVar != lVar2) {
                                this._dynamicSerializers = lVar2;
                            }
                            nVarR = l_dA.a;
                        } else {
                            nVarR = r(lVar, cls, xVar);
                        }
                        nVarC = nVarR;
                        lVar = this._dynamicSerializers;
                    }
                    if (gVar2 == null) {
                        nVarC.f(next2, dVar, xVar);
                    } else {
                        nVarC.g(next2, dVar, xVar, gVar2);
                    }
                }
            } while (it.hasNext());
        }
    }

    public h(h hVar, b.g.a.c.d dVar, b.g.a.c.e0.g gVar, b.g.a.c.n<?> nVar, Boolean bool) {
        super(hVar, dVar, gVar, nVar, bool);
    }
}
