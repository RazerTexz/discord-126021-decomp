package b.g.a.c.g0.u;

import b.g.a.a.i$d;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;

/* JADX INFO: compiled from: BooleanSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e$a extends p0<Object> implements b.g.a.c.g0.i {
    private static final long serialVersionUID = 1;
    public final boolean _forPrimitive;

    public e$a(boolean z2) {
        super(z2 ? Boolean.TYPE : Boolean.class, false);
        this._forPrimitive = z2;
    }

    @Override // b.g.a.c.g0.i
    public b.g.a.c.n<?> a(b.g.a.c.x xVar, b.g.a.c.d dVar) throws JsonMappingException {
        i$d i_dL = l(xVar, dVar, Boolean.class);
        return (i_dL == null || i_dL.e().f()) ? this : new e(this._forPrimitive);
    }

    @Override // b.g.a.c.n
    public void f(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
        dVar.H(!Boolean.FALSE.equals(obj) ? 1 : 0);
    }

    @Override // b.g.a.c.g0.u.p0, b.g.a.c.n
    public final void g(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar, b.g.a.c.e0.g gVar) throws IOException {
        dVar.s(Boolean.TRUE.equals(obj));
    }
}
