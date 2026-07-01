package b.g.a.c.g0.u;

import b.g.a.c.m$a;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: SerializableSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
@b.g.a.c.y.a
public class g0 extends q0<b.g.a.c.m> {
    public static final g0 k = new g0();

    public g0() {
        super(b.g.a.c.m.class);
    }

    @Override // b.g.a.c.n
    public boolean d(b.g.a.c.x xVar, Object obj) {
        b.g.a.c.m mVar = (b.g.a.c.m) obj;
        if (!(mVar instanceof m$a)) {
            return false;
        }
        Objects.requireNonNull((m$a) mVar);
        return false;
    }

    @Override // b.g.a.c.n
    public void f(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
        ((b.g.a.c.m) obj).c(dVar, xVar);
    }

    @Override // b.g.a.c.n
    public void g(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar, b.g.a.c.e0.g gVar) throws IOException {
        ((b.g.a.c.m) obj).d(dVar, xVar, gVar);
    }
}
