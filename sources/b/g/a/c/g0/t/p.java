package b.g.a.c.g0.t;

import b.g.a.c.x;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;

/* JADX INFO: compiled from: TypeWrappedSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public final class p extends b.g.a.c.n<Object> implements b.g.a.c.g0.i {
    public final b.g.a.c.e0.g j;
    public final b.g.a.c.n<Object> k;

    public p(b.g.a.c.e0.g gVar, b.g.a.c.n<?> nVar) {
        this.j = gVar;
        this.k = nVar;
    }

    @Override // b.g.a.c.g0.i
    public b.g.a.c.n<?> a(x xVar, b.g.a.c.d dVar) throws JsonMappingException {
        b.g.a.c.n<?> nVarZ = this.k;
        if (nVarZ instanceof b.g.a.c.g0.i) {
            nVarZ = xVar.z(nVarZ, dVar);
        }
        return nVarZ == this.k ? this : new p(this.j, nVarZ);
    }

    @Override // b.g.a.c.n
    public Class<Object> c() {
        return Object.class;
    }

    @Override // b.g.a.c.n
    public void f(Object obj, b.g.a.b.d dVar, x xVar) throws IOException {
        this.k.g(obj, dVar, xVar, this.j);
    }

    @Override // b.g.a.c.n
    public void g(Object obj, b.g.a.b.d dVar, x xVar, b.g.a.c.e0.g gVar) throws IOException {
        this.k.g(obj, dVar, xVar, gVar);
    }
}
