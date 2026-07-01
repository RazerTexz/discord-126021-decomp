package b.g.a.c.g0.u;

import b.g.a.c.g0.t.l$b;
import java.io.IOException;

/* JADX INFO: compiled from: StdKeySerializers.java */
/* JADX INFO: loaded from: classes3.dex */
public class o0$b extends q0<Object> {
    public transient b.g.a.c.g0.t.l k;

    public o0$b() {
        super(String.class, false);
        this.k = l$b.f706b;
    }

    @Override // b.g.a.c.n
    public void f(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
        Class<?> cls = obj.getClass();
        b.g.a.c.g0.t.l lVar = this.k;
        b.g.a.c.n<Object> nVarC = lVar.c(cls);
        if (nVarC == null) {
            if (cls == Object.class) {
                nVarC = new o0$a(8, cls);
                this.k = lVar.b(cls, nVarC);
            } else {
                nVarC = xVar.o(xVar._config._base._typeFactory.b(null, cls, b.g.a.c.h0.n.l), null);
                b.g.a.c.g0.t.l lVarB = lVar.b(cls, nVarC);
                if (lVar != lVarB) {
                    this.k = lVarB;
                }
            }
        }
        nVarC.f(obj, dVar, xVar);
    }

    public Object readResolve() {
        this.k = l$b.f706b;
        return this;
    }
}
