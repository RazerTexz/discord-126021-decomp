package b.g.a.c.g0.u;

import b.g.a.b.f$b;
import java.io.IOException;

/* JADX INFO: compiled from: NumberSerializers.java */
/* JADX INFO: loaded from: classes3.dex */
@b.g.a.c.y.a
public class c0 extends w<Object> {
    public static final c0 k = new c0();

    public c0() {
        super(Short.class, f$b.INT, "number");
    }

    @Override // b.g.a.c.n
    public void f(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
        dVar.O(((Short) obj).shortValue());
    }
}
