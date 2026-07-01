package b.g.a.c.g0.u;

import b.g.a.c.g0.t.l$d;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: CollectionSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class j extends b<Collection<?>> {
    private static final long serialVersionUID = 1;

    public j(b.g.a.c.j jVar, boolean z2, b.g.a.c.e0.g gVar, b.g.a.c.n<Object> nVar) {
        super((Class<?>) Collection.class, jVar, z2, gVar, nVar);
    }

    @Override // b.g.a.c.n
    public boolean d(b.g.a.c.x xVar, Object obj) {
        return ((Collection) obj).isEmpty();
    }

    @Override // b.g.a.c.g0.u.b, b.g.a.c.n
    public void f(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
        Collection<?> collection = (Collection) obj;
        int size = collection.size();
        if (size == 1 && ((this._unwrapSingle == null && xVar.D(b.g.a.c.w.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) || this._unwrapSingle == Boolean.TRUE)) {
            u(collection, dVar, xVar);
            return;
        }
        dVar.b0(collection, size);
        u(collection, dVar, xVar);
        dVar.t();
    }

    @Override // b.g.a.c.g0.h
    public b.g.a.c.g0.h<?> p(b.g.a.c.e0.g gVar) {
        return new j(this, this._property, gVar, this._elementSerializer, this._unwrapSingle);
    }

    @Override // b.g.a.c.g0.h
    public boolean q(Object obj) {
        return ((Collection) obj).size() == 1;
    }

    @Override // b.g.a.c.g0.u.b
    public /* bridge */ /* synthetic */ void s(Collection<?> collection, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
        u(collection, dVar, xVar);
    }

    @Override // b.g.a.c.g0.u.b
    public b<Collection<?>> t(b.g.a.c.d dVar, b.g.a.c.e0.g gVar, b.g.a.c.n nVar, Boolean bool) {
        return new j(this, dVar, gVar, nVar, bool);
    }

    public void u(Collection<?> collection, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
        b.g.a.c.n<Object> nVarR;
        dVar.e(collection);
        b.g.a.c.n<Object> nVar = this._elementSerializer;
        int i = 0;
        if (nVar != null) {
            Iterator<?> it = collection.iterator();
            if (it.hasNext()) {
                b.g.a.c.e0.g gVar = this._valueTypeSerializer;
                do {
                    Object next = it.next();
                    if (next == null) {
                        try {
                            xVar.l(dVar);
                        } catch (Exception e) {
                            n(xVar, e, collection, i);
                            throw null;
                        }
                    } else if (gVar == null) {
                        nVar.f(next, dVar, xVar);
                    } else {
                        nVar.g(next, dVar, xVar, gVar);
                    }
                    i++;
                } while (it.hasNext());
                return;
            }
            return;
        }
        Iterator<?> it2 = collection.iterator();
        if (it2.hasNext()) {
            b.g.a.c.g0.t.l lVar = this._dynamicSerializers;
            b.g.a.c.e0.g gVar2 = this._valueTypeSerializer;
            do {
                try {
                    Object next2 = it2.next();
                    if (next2 == null) {
                        xVar.l(dVar);
                    } else {
                        Class<?> cls = next2.getClass();
                        b.g.a.c.n<Object> nVarC = lVar.c(cls);
                        if (nVarC == null) {
                            if (this._elementType.r()) {
                                l$d l_dA = lVar.a(xVar.k(this._elementType, cls), xVar, this._property);
                                b.g.a.c.g0.t.l lVar2 = l_dA.f708b;
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
                    i++;
                } catch (Exception e2) {
                    n(xVar, e2, collection, i);
                    throw null;
                }
            } while (it2.hasNext());
        }
    }

    public j(j jVar, b.g.a.c.d dVar, b.g.a.c.e0.g gVar, b.g.a.c.n<?> nVar, Boolean bool) {
        super(jVar, dVar, gVar, nVar, bool);
    }
}
