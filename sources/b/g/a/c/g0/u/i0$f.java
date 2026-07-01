package b.g.a.c.g0.u;

import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: StdArraySerializers.java */
/* JADX INFO: loaded from: classes3.dex */
@b.g.a.c.y.a
public class i0$f extends i0$h<long[]> {
    static {
        b.g.a.c.h0.n.k.j(Long.TYPE);
    }

    public i0$f() {
        super(long[].class);
    }

    @Override // b.g.a.c.n
    public boolean d(b.g.a.c.x xVar, Object obj) {
        return ((long[]) obj).length == 0;
    }

    @Override // b.g.a.c.g0.u.a, b.g.a.c.n
    public void f(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
        long[] jArr = (long[]) obj;
        int i = 0;
        if (jArr.length == 1 && r(xVar)) {
            int length = jArr.length;
            while (i < length) {
                dVar.I(jArr[i]);
                i++;
            }
            return;
        }
        int length2 = jArr.length;
        Objects.requireNonNull(dVar);
        dVar.a(jArr.length, 0, length2);
        dVar.b0(jArr, length2);
        int i2 = length2 + 0;
        while (i < i2) {
            dVar.I(jArr[i]);
            i++;
        }
        dVar.t();
    }

    @Override // b.g.a.c.g0.h
    public boolean q(Object obj) {
        return ((long[]) obj).length == 1;
    }

    @Override // b.g.a.c.g0.u.a
    public b.g.a.c.n<?> s(b.g.a.c.d dVar, Boolean bool) {
        return new i0$f(this, dVar, bool);
    }

    @Override // b.g.a.c.g0.u.a
    public void t(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
        for (long j : (long[]) obj) {
            dVar.I(j);
        }
    }

    public i0$f(i0$f i0_f, b.g.a.c.d dVar, Boolean bool) {
        super(i0_f, dVar, bool);
    }
}
