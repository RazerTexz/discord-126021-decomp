package b.g.a.c.g0.t;

import b.g.a.c.g0.u.q0;
import b.g.a.c.x;
import java.io.IOException;

/* JADX INFO: compiled from: FailingSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class c extends q0<Object> {
    public final String _msg;

    public c(String str) {
        super(Object.class);
        this._msg = str;
    }

    @Override // b.g.a.c.n
    public void f(Object obj, b.g.a.b.d dVar, x xVar) throws IOException {
        xVar.G(this._msg, new Object[0]);
        throw null;
    }
}
