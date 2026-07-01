package b.g.a.c.g0.u;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: StdJdkSerializers.java */
/* JADX INFO: loaded from: classes3.dex */
public class m0 extends p0<AtomicLong> {
    public m0() {
        super(AtomicLong.class, false);
    }

    @Override // b.g.a.c.n
    public void f(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
        dVar.I(((AtomicLong) obj).get());
    }
}
