package b.g.a.c.g0.u;

import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: StdArraySerializers.java */
/* JADX INFO: loaded from: classes3.dex */
@b.g.a.c.y.a
public class i0$e extends a<int[]> {
    static {
        b.g.a.c.h0.n.k.j(Integer.TYPE);
    }

    public i0$e() {
        super(int[].class);
    }

    @Override // b.g.a.c.n
    public boolean d(b.g.a.c.x xVar, Object obj) {
        return ((int[]) obj).length == 0;
    }

    @Override // b.g.a.c.g0.u.a, b.g.a.c.n
    public void f(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
        int[] iArr = (int[]) obj;
        int i = 0;
        if (iArr.length == 1 && r(xVar)) {
            int length = iArr.length;
            while (i < length) {
                dVar.H(iArr[i]);
                i++;
            }
            return;
        }
        int length2 = iArr.length;
        Objects.requireNonNull(dVar);
        dVar.a(iArr.length, 0, length2);
        dVar.b0(iArr, length2);
        int i2 = length2 + 0;
        while (i < i2) {
            dVar.H(iArr[i]);
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
        return ((int[]) obj).length == 1;
    }

    @Override // b.g.a.c.g0.u.a
    public b.g.a.c.n<?> s(b.g.a.c.d dVar, Boolean bool) {
        return new i0$e(this, dVar, bool);
    }

    @Override // b.g.a.c.g0.u.a
    public void t(int[] iArr, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
        for (int i : iArr) {
            dVar.H(i);
        }
    }

    public i0$e(i0$e i0_e, b.g.a.c.d dVar, Boolean bool) {
        super(i0_e, dVar, bool);
    }
}
