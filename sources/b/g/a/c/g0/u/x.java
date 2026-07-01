package b.g.a.c.g0.u;

import b.g.a.b.f$b;
import java.io.IOException;

/* JADX INFO: compiled from: NumberSerializers.java */
/* JADX INFO: loaded from: classes3.dex */
@b.g.a.c.y.a
public class x extends w<Object> {
    public x(Class<?> cls) {
        super(cls, f$b.DOUBLE, "number");
    }

    @Override // b.g.a.c.n
    public void f(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
        dVar.C(((Double) obj).doubleValue());
    }

    @Override // b.g.a.c.g0.u.p0, b.g.a.c.n
    public void g(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar, b.g.a.c.e0.g gVar) throws IOException {
        Double d = (Double) obj;
        double dDoubleValue = d.doubleValue();
        if (!(Double.isNaN(dDoubleValue) || Double.isInfinite(dDoubleValue))) {
            dVar.C(d.doubleValue());
            return;
        }
        b.g.a.b.s.b bVarE = gVar.e(dVar, gVar.d(obj, b.g.a.b.h.VALUE_NUMBER_FLOAT));
        dVar.C(d.doubleValue());
        gVar.f(dVar, bVarE);
    }
}
