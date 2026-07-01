package b.g.a.c.g0.t;

import b.g.a.c.g0.u.h0;
import b.g.a.c.w;
import b.g.a.c.x;
import java.io.IOException;
import java.util.Collection;

/* JADX INFO: compiled from: StringCollectionSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
@b.g.a.c.y.a
public class o extends h0<Collection<String>> {
    public static final o k = new o();

    public o() {
        super(Collection.class);
    }

    @Override // b.g.a.c.n
    public void f(Object obj, b.g.a.b.d dVar, x xVar) throws IOException {
        Collection<String> collection = (Collection) obj;
        int size = collection.size();
        if (size == 1 && ((this._unwrapSingle == null && xVar.D(w.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) || this._unwrapSingle == Boolean.TRUE)) {
            r(collection, dVar, xVar);
            return;
        }
        dVar.b0(collection, size);
        r(collection, dVar, xVar);
        dVar.t();
    }

    @Override // b.g.a.c.g0.u.h0, b.g.a.c.n
    public void g(Object obj, b.g.a.b.d dVar, x xVar, b.g.a.c.e0.g gVar) throws IOException {
        Collection<String> collection = (Collection) obj;
        b.g.a.b.s.b bVarE = gVar.e(dVar, gVar.d(collection, b.g.a.b.h.START_ARRAY));
        dVar.e(collection);
        r(collection, dVar, xVar);
        gVar.f(dVar, bVarE);
    }

    @Override // b.g.a.c.g0.u.h0
    public b.g.a.c.n<?> p(b.g.a.c.d dVar, Boolean bool) {
        return new o(this, bool);
    }

    @Override // b.g.a.c.g0.u.h0
    public void q(Collection<String> collection, b.g.a.b.d dVar, x xVar, b.g.a.c.e0.g gVar) throws IOException {
        b.g.a.b.s.b bVarE = gVar.e(dVar, gVar.d(collection, b.g.a.b.h.START_ARRAY));
        dVar.e(collection);
        r(collection, dVar, xVar);
        gVar.f(dVar, bVarE);
    }

    public final void r(Collection<String> collection, b.g.a.b.d dVar, x xVar) throws IOException {
        int i = 0;
        try {
            for (String str : collection) {
                if (str == null) {
                    xVar.l(dVar);
                } else {
                    dVar.j0(str);
                }
                i++;
            }
        } catch (Exception e) {
            n(xVar, e, collection, i);
            throw null;
        }
    }

    public o(o oVar, Boolean bool) {
        super(oVar, bool);
    }
}
