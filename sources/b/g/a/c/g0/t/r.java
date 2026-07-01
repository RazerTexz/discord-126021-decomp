package b.g.a.c.g0.t;

import b.g.a.c.g0.u.q0;
import b.g.a.c.x;
import java.io.IOException;

/* JADX INFO: compiled from: UnsupportedTypeSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class r extends q0<Object> {
    private static final long serialVersionUID = 1;
    public final String _message;
    public final b.g.a.c.j _type;

    public r(b.g.a.c.j jVar, String str) {
        super(Object.class);
        this._type = jVar;
        this._message = str;
    }

    @Override // b.g.a.c.n
    public void f(Object obj, b.g.a.b.d dVar, x xVar) throws IOException {
        xVar.f(this._type, this._message);
        throw null;
    }
}
