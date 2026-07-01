package b.g.a.c.g0.u;

import java.io.IOException;

/* JADX INFO: compiled from: StdScalarSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class p0<T> extends q0<T> {
    public p0(Class<T> cls) {
        super(cls);
    }

    @Override // b.g.a.c.n
    public void g(T t, b.g.a.b.d dVar, b.g.a.c.x xVar, b.g.a.c.e0.g gVar) throws IOException {
        b.g.a.b.s.b bVarE = gVar.e(dVar, gVar.d(t, b.g.a.b.h.VALUE_STRING));
        f(t, dVar, xVar);
        gVar.f(dVar, bVarE);
    }

    public p0(Class<?> cls, boolean z2) {
        super(cls);
    }
}
