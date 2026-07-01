package b.g.a.c.g0.t;

import b.g.a.c.g0.u.h0;
import b.g.a.c.w;
import b.g.a.c.x;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: IndexedStringListSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
@b.g.a.c.y.a
public final class g extends h0<List<String>> {
    public static final g k = new g();
    private static final long serialVersionUID = 1;

    public g() {
        super(List.class);
    }

    @Override // b.g.a.c.n
    public void f(Object obj, b.g.a.b.d dVar, x xVar) throws IOException {
        List<String> list = (List) obj;
        int size = list.size();
        if (size == 1 && ((this._unwrapSingle == null && xVar.D(w.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) || this._unwrapSingle == Boolean.TRUE)) {
            r(list, dVar, xVar, 1);
            return;
        }
        dVar.b0(list, size);
        r(list, dVar, xVar, size);
        dVar.t();
    }

    @Override // b.g.a.c.g0.u.h0, b.g.a.c.n
    public /* bridge */ /* synthetic */ void g(Object obj, b.g.a.b.d dVar, x xVar, b.g.a.c.e0.g gVar) throws IOException {
        s((List) obj, dVar, xVar, gVar);
    }

    @Override // b.g.a.c.g0.u.h0
    public b.g.a.c.n<?> p(b.g.a.c.d dVar, Boolean bool) {
        return new g(this, bool);
    }

    @Override // b.g.a.c.g0.u.h0
    public /* bridge */ /* synthetic */ void q(Collection collection, b.g.a.b.d dVar, x xVar, b.g.a.c.e0.g gVar) throws IOException {
        s((List) collection, dVar, xVar, gVar);
    }

    public final void r(List<String> list, b.g.a.b.d dVar, x xVar, int i) throws IOException {
        for (int i2 = 0; i2 < i; i2++) {
            try {
                String str = list.get(i2);
                if (str == null) {
                    xVar.l(dVar);
                } else {
                    dVar.j0(str);
                }
            } catch (Exception e) {
                n(xVar, e, list, i2);
                throw null;
            }
        }
    }

    public void s(List<String> list, b.g.a.b.d dVar, x xVar, b.g.a.c.e0.g gVar) throws IOException {
        b.g.a.b.s.b bVarE = gVar.e(dVar, gVar.d(list, b.g.a.b.h.START_ARRAY));
        dVar.e(list);
        r(list, dVar, xVar, list.size());
        gVar.f(dVar, bVarE);
    }

    public g(g gVar, Boolean bool) {
        super(gVar, bool);
    }
}
