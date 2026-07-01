package b.g.a.c.g0.u;

import b.g.a.b.f$b;
import java.io.IOException;

/* JADX INFO: compiled from: NumberSerializers.java */
/* JADX INFO: loaded from: classes3.dex */
@b.g.a.c.y.a
public class a0 extends w<Object> {
    public a0(Class<?> cls) {
        super(cls, f$b.INT, "integer");
    }

    @Override // b.g.a.c.n
    public void f(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
        dVar.H(((Integer) obj).intValue());
    }

    @Override // b.g.a.c.g0.u.p0, b.g.a.c.n
    public void g(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar, b.g.a.c.e0.g gVar) throws IOException {
        f(obj, dVar, xVar);
    }
}
