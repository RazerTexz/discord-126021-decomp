package b.g.a.c.g0.u;

import java.io.IOException;

/* JADX INFO: compiled from: StdArraySerializers.java */
/* JADX INFO: loaded from: classes3.dex */
@b.g.a.c.y.a
public class i0$d extends i0$h<float[]> {
    static {
        b.g.a.c.h0.n.k.j(Float.TYPE);
    }

    public i0$d() {
        super(float[].class);
    }

    @Override // b.g.a.c.n
    public boolean d(b.g.a.c.x xVar, Object obj) {
        return ((float[]) obj).length == 0;
    }

    @Override // b.g.a.c.g0.u.a, b.g.a.c.n
    public void f(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
        float[] fArr = (float[]) obj;
        int length = fArr.length;
        if (length == 1 && r(xVar)) {
            u(fArr, dVar);
            return;
        }
        dVar.b0(fArr, length);
        u(fArr, dVar);
        dVar.t();
    }

    @Override // b.g.a.c.g0.h
    public boolean q(Object obj) {
        return ((float[]) obj).length == 1;
    }

    @Override // b.g.a.c.g0.u.a
    public b.g.a.c.n<?> s(b.g.a.c.d dVar, Boolean bool) {
        return new i0$d(this, dVar, bool);
    }

    @Override // b.g.a.c.g0.u.a
    public /* bridge */ /* synthetic */ void t(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
        u((float[]) obj, dVar);
    }

    public void u(float[] fArr, b.g.a.b.d dVar) throws IOException {
        for (float f : fArr) {
            dVar.D(f);
        }
    }

    public i0$d(i0$d i0_d, b.g.a.c.d dVar, Boolean bool) {
        super(i0_d, dVar, bool);
    }
}
