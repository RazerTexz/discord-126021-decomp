package b.g.a.c.g0.u;

import b.g.a.b.f$b;
import java.io.IOException;

/* JADX INFO: compiled from: NumberSerializers.java */
/* JADX INFO: loaded from: classes3.dex */
@b.g.a.c.y.a
public class z extends w<Object> {
    public static final z k = new z();

    public z() {
        super(Number.class, f$b.INT, "integer");
    }

    @Override // b.g.a.c.n
    public void f(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
        dVar.H(((Number) obj).intValue());
    }
}
