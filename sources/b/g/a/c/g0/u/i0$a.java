package b.g.a.c.g0.u;

import java.io.IOException;

/* JADX INFO: compiled from: StdArraySerializers.java */
/* JADX INFO: loaded from: classes3.dex */
@b.g.a.c.y.a
public class i0$a extends a<boolean[]> {
    static {
        b.g.a.c.h0.n.k.j(Boolean.class);
    }

    public i0$a() {
        super(boolean[].class);
    }

    @Override // b.g.a.c.n
    public boolean d(b.g.a.c.x xVar, Object obj) {
        return ((boolean[]) obj).length == 0;
    }

    @Override // b.g.a.c.g0.u.a, b.g.a.c.n
    public void f(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
        boolean[] zArr = (boolean[]) obj;
        int length = zArr.length;
        if (length == 1 && r(xVar)) {
            u(zArr, dVar);
            return;
        }
        dVar.b0(zArr, length);
        u(zArr, dVar);
        dVar.t();
    }

    @Override // b.g.a.c.g0.h
    public b.g.a.c.g0.h<?> p(b.g.a.c.e0.g gVar) {
        return this;
    }

    @Override // b.g.a.c.g0.h
    public boolean q(Object obj) {
        return ((boolean[]) obj).length == 1;
    }

    @Override // b.g.a.c.g0.u.a
    public b.g.a.c.n<?> s(b.g.a.c.d dVar, Boolean bool) {
        return new i0$a(this, dVar, bool);
    }

    @Override // b.g.a.c.g0.u.a
    public /* bridge */ /* synthetic */ void t(boolean[] zArr, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
        u(zArr, dVar);
    }

    public void u(boolean[] zArr, b.g.a.b.d dVar) throws IOException {
        for (boolean z2 : zArr) {
            dVar.s(z2);
        }
    }

    public i0$a(i0$a i0_a, b.g.a.c.d dVar, Boolean bool) {
        super(i0_a, dVar, bool);
    }
}
