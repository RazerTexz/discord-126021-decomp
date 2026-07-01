package b.g.a.c.g0.u;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: StdJdkSerializers.java */
/* JADX INFO: loaded from: classes3.dex */
public class k0 extends p0<AtomicBoolean> {
    public k0() {
        super(AtomicBoolean.class, false);
    }

    @Override // b.g.a.c.n
    public void f(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
        dVar.s(((AtomicBoolean) obj).get());
    }
}
