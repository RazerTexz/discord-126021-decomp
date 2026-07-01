package b.g.a.c.g0.u;

import java.io.IOException;

/* JADX INFO: compiled from: StdArraySerializers.java */
/* JADX INFO: loaded from: classes3.dex */
@b.g.a.c.y.a
public class i0$g extends i0$h<short[]> {
    static {
        b.g.a.c.h0.n.k.j(Short.TYPE);
    }

    public i0$g() {
        super(short[].class);
    }

    @Override // b.g.a.c.n
    public boolean d(b.g.a.c.x xVar, Object obj) {
        return ((short[]) obj).length == 0;
    }

    @Override // b.g.a.c.g0.u.a, b.g.a.c.n
    public void f(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
        short[] sArr = (short[]) obj;
        int length = sArr.length;
        if (length == 1 && r(xVar)) {
            u(sArr, dVar);
            return;
        }
        dVar.b0(sArr, length);
        u(sArr, dVar);
        dVar.t();
    }

    @Override // b.g.a.c.g0.h
    public boolean q(Object obj) {
        return ((short[]) obj).length == 1;
    }

    @Override // b.g.a.c.g0.u.a
    public b.g.a.c.n<?> s(b.g.a.c.d dVar, Boolean bool) {
        return new i0$g(this, dVar, bool);
    }

    @Override // b.g.a.c.g0.u.a
    public /* bridge */ /* synthetic */ void t(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
        u((short[]) obj, dVar);
    }

    public void u(short[] sArr, b.g.a.b.d dVar) throws IOException {
        for (short s2 : sArr) {
            dVar.H(s2);
        }
    }

    public i0$g(i0$g i0_g, b.g.a.c.d dVar, Boolean bool) {
        super(i0_g, dVar, bool);
    }
}
