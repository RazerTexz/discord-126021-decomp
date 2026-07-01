package b.g.a.c.g0.u;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: StdJdkSerializers.java */
/* JADX INFO: loaded from: classes3.dex */
public class l0 extends p0<AtomicInteger> {
    public l0() {
        super(AtomicInteger.class, false);
    }

    @Override // b.g.a.c.n
    public void f(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
        dVar.H(((AtomicInteger) obj).get());
    }
}
