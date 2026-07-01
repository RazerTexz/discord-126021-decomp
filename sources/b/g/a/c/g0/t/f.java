package b.g.a.c.g0.t;

import b.g.a.c.w;
import b.g.a.c.x;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: IndexedListSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
@b.g.a.c.y.a
public final class f extends b.g.a.c.g0.u.b<List<?>> {
    private static final long serialVersionUID = 1;

    public f(b.g.a.c.j jVar, boolean z2, b.g.a.c.e0.g gVar, b.g.a.c.n<Object> nVar) {
        super((Class<?>) List.class, jVar, z2, gVar, nVar);
    }

    @Override // b.g.a.c.n
    public boolean d(x xVar, Object obj) {
        return ((List) obj).isEmpty();
    }

    @Override // b.g.a.c.g0.u.b, b.g.a.c.n
    public void f(Object obj, b.g.a.b.d dVar, x xVar) throws IOException {
        List<?> list = (List) obj;
        int size = list.size();
        if (size == 1 && ((this._unwrapSingle == null && xVar.D(w.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) || this._unwrapSingle == Boolean.TRUE)) {
            u(list, dVar, xVar);
            return;
        }
        dVar.b0(list, size);
        u(list, dVar, xVar);
        dVar.t();
    }

    @Override // b.g.a.c.g0.h
    public b.g.a.c.g0.h<?> p(b.g.a.c.e0.g gVar) {
        return new f(this, this._property, gVar, this._elementSerializer, this._unwrapSingle);
    }

    @Override // b.g.a.c.g0.h
    public boolean q(Object obj) {
        return ((List) obj).size() == 1;
    }

    @Override // b.g.a.c.g0.u.b
    public /* bridge */ /* synthetic */ void s(List<?> list, b.g.a.b.d dVar, x xVar) throws IOException {
        u(list, dVar, xVar);
    }

    @Override // b.g.a.c.g0.u.b
    public b.g.a.c.g0.u.b<List<?>> t(b.g.a.c.d dVar, b.g.a.c.e0.g gVar, b.g.a.c.n nVar, Boolean bool) {
        return new f(this, dVar, gVar, nVar, bool);
    }

    public void u(List<?> list, b.g.a.b.d dVar, x xVar) throws IOException {
        b.g.a.c.n<Object> nVarR;
        b.g.a.c.n<Object> nVarR2;
        b.g.a.c.n<Object> nVar = this._elementSerializer;
        int i = 0;
        if (nVar != null) {
            int size = list.size();
            if (size == 0) {
                return;
            }
            b.g.a.c.e0.g gVar = this._valueTypeSerializer;
            while (i < size) {
                Object obj = list.get(i);
                if (obj == null) {
                    try {
                        xVar.l(dVar);
                    } catch (Exception e) {
                        n(xVar, e, list, i);
                        throw null;
                    }
                } else if (gVar == null) {
                    nVar.f(obj, dVar, xVar);
                } else {
                    nVar.g(obj, dVar, xVar, gVar);
                }
                i++;
            }
            return;
        }
        if (this._valueTypeSerializer == null) {
            int size2 = list.size();
            if (size2 == 0) {
                return;
            }
            try {
                l lVar = this._dynamicSerializers;
                while (i < size2) {
                    Object obj2 = list.get(i);
                    if (obj2 == null) {
                        xVar.l(dVar);
                    } else {
                        Class<?> cls = obj2.getClass();
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
                        nVarC.f(obj2, dVar, xVar);
                    }
                    i++;
                }
                return;
            } catch (Exception e2) {
                n(xVar, e2, list, i);
                throw null;
            }
        }
        int size3 = list.size();
        if (size3 == 0) {
            return;
        }
        try {
            b.g.a.c.e0.g gVar2 = this._valueTypeSerializer;
            l lVar3 = this._dynamicSerializers;
            while (i < size3) {
                Object obj3 = list.get(i);
                if (obj3 == null) {
                    xVar.l(dVar);
                } else {
                    Class<?> cls2 = obj3.getClass();
                    b.g.a.c.n<Object> nVarC2 = lVar3.c(cls2);
                    if (nVarC2 == null) {
                        if (this._elementType.r()) {
                            l$d l_dA2 = lVar3.a(xVar.k(this._elementType, cls2), xVar, this._property);
                            l lVar4 = l_dA2.f708b;
                            if (lVar3 != lVar4) {
                                this._dynamicSerializers = lVar4;
                            }
                            nVarR2 = l_dA2.a;
                        } else {
                            nVarR2 = r(lVar3, cls2, xVar);
                        }
                        nVarC2 = nVarR2;
                        lVar3 = this._dynamicSerializers;
                    }
                    nVarC2.g(obj3, dVar, xVar, gVar2);
                }
                i++;
            }
        } catch (Exception e3) {
            n(xVar, e3, list, i);
            throw null;
        }
    }

    public f(f fVar, b.g.a.c.d dVar, b.g.a.c.e0.g gVar, b.g.a.c.n<?> nVar, Boolean bool) {
        super(fVar, dVar, gVar, nVar, bool);
    }
}
