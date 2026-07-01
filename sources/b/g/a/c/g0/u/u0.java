package b.g.a.c.g0.u;

import java.io.IOException;

/* JADX INFO: compiled from: ToStringSerializerBase.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class u0 extends q0<Object> {
    public u0(Class<?> cls) {
        super(cls, false);
    }

    @Override // b.g.a.c.n
    public boolean d(b.g.a.c.x xVar, Object obj) {
        return p(obj).isEmpty();
    }

    @Override // b.g.a.c.n
    public void f(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
        dVar.j0(p(obj));
    }

    @Override // b.g.a.c.n
    public void g(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar, b.g.a.c.e0.g gVar) throws IOException {
        b.g.a.b.s.b bVarE = gVar.e(dVar, gVar.d(obj, b.g.a.b.h.VALUE_STRING));
        f(obj, dVar, xVar);
        gVar.f(dVar, bVarE);
    }

    public abstract String p(Object obj);
}
