package b.g.a.c.g0.u;

import java.io.IOException;

/* JADX INFO: compiled from: RawSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class e0<T> extends q0<T> {
    public e0(Class<?> cls) {
        super(cls, false);
    }

    @Override // b.g.a.c.n
    public void f(T t, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
        dVar.V(t.toString());
    }

    @Override // b.g.a.c.n
    public void g(T t, b.g.a.b.d dVar, b.g.a.c.x xVar, b.g.a.c.e0.g gVar) throws IOException {
        b.g.a.b.s.b bVarE = gVar.e(dVar, gVar.d(t, b.g.a.b.h.VALUE_EMBEDDED_OBJECT));
        dVar.V(t.toString());
        gVar.f(dVar, bVarE);
    }
}
