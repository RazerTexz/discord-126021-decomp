package b.g.a.c.g0;

import b.g.a.c.g0.u.t;
import b.g.a.c.x;
import java.util.Map;

/* JADX INFO: compiled from: AnyGetterWriter.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {
    public final b.g.a.c.d a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.g.a.c.c0.i f700b;
    public b.g.a.c.n<Object> c;
    public t d;

    public a(b.g.a.c.d dVar, b.g.a.c.c0.i iVar, b.g.a.c.n<?> nVar) {
        this.f700b = iVar;
        this.a = dVar;
        this.c = nVar;
        if (nVar instanceof t) {
            this.d = (t) nVar;
        }
    }

    public void a(Object obj, b.g.a.b.d dVar, x xVar) throws Exception {
        Object objJ = this.f700b.j(obj);
        if (objJ == null) {
            return;
        }
        if (!(objJ instanceof Map)) {
            xVar.f(this.a.getType(), String.format("Value returned by 'any-getter' %s() not java.util.Map but %s", this.f700b.c(), objJ.getClass().getName()));
            throw null;
        }
        t tVar = this.d;
        if (tVar != null) {
            tVar.u((Map) objJ, dVar, xVar);
        } else {
            this.c.f(objJ, dVar, xVar);
        }
    }
}
