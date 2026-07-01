package b.g.a.c.g0.u;

import java.io.IOException;

/* JADX INFO: compiled from: StringSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
@b.g.a.c.y.a
public final class r0 extends p0<Object> {
    private static final long serialVersionUID = 1;

    public r0() {
        super(String.class, false);
    }

    @Override // b.g.a.c.n
    public boolean d(b.g.a.c.x xVar, Object obj) {
        return ((String) obj).isEmpty();
    }

    @Override // b.g.a.c.n
    public void f(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
        dVar.j0((String) obj);
    }

    @Override // b.g.a.c.g0.u.p0, b.g.a.c.n
    public final void g(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar, b.g.a.c.e0.g gVar) throws IOException {
        dVar.j0((String) obj);
    }
}
