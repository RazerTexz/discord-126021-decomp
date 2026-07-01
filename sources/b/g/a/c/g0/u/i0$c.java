package b.g.a.c.g0.u;

import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: StdArraySerializers.java */
/* JADX INFO: loaded from: classes3.dex */
@b.g.a.c.y.a
public class i0$c extends a<double[]> {
    static {
        b.g.a.c.h0.n.k.j(Double.TYPE);
    }

    public i0$c() {
        super(double[].class);
    }

    @Override // b.g.a.c.n
    public boolean d(b.g.a.c.x xVar, Object obj) {
        return ((double[]) obj).length == 0;
    }

    @Override // b.g.a.c.g0.u.a, b.g.a.c.n
    public void f(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
        double[] dArr = (double[]) obj;
        int i = 0;
        if (dArr.length == 1 && r(xVar)) {
            int length = dArr.length;
            while (i < length) {
                dVar.C(dArr[i]);
                i++;
            }
            return;
        }
        int length2 = dArr.length;
        Objects.requireNonNull(dVar);
        dVar.a(dArr.length, 0, length2);
        dVar.b0(dArr, length2);
        int i2 = length2 + 0;
        while (i < i2) {
            dVar.C(dArr[i]);
            i++;
        }
        dVar.t();
    }

    @Override // b.g.a.c.g0.h
    public b.g.a.c.g0.h<?> p(b.g.a.c.e0.g gVar) {
        return this;
    }

    @Override // b.g.a.c.g0.h
    public boolean q(Object obj) {
        return ((double[]) obj).length == 1;
    }

    @Override // b.g.a.c.g0.u.a
    public b.g.a.c.n<?> s(b.g.a.c.d dVar, Boolean bool) {
        return new i0$c(this, dVar, bool);
    }

    @Override // b.g.a.c.g0.u.a
    public void t(double[] dArr, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
        for (double d : dArr) {
            dVar.C(d);
        }
    }

    public i0$c(i0$c i0_c, b.g.a.c.d dVar, Boolean bool) {
        super(i0_c, dVar, bool);
    }
}
