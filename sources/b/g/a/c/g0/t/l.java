package b.g.a.c.g0.t;

import b.g.a.c.x;
import com.fasterxml.jackson.databind.JsonMappingException;

/* JADX INFO: compiled from: PropertySerializerMap.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class l {
    public final boolean a;

    public l(boolean z2) {
        this.a = z2;
    }

    public final l$d a(b.g.a.c.j jVar, x xVar, b.g.a.c.d dVar) throws JsonMappingException {
        b.g.a.c.n<Object> nVarM = xVar.m(jVar, dVar);
        return new l$d(nVarM, b(jVar._class, nVarM));
    }

    public abstract l b(Class<?> cls, b.g.a.c.n<Object> nVar);

    public abstract b.g.a.c.n<Object> c(Class<?> cls);

    public l(l lVar) {
        this.a = lVar.a;
    }
}
