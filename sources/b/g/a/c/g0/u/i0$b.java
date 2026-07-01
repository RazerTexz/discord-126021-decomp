package b.g.a.c.g0.u;

import java.io.IOException;

/* JADX INFO: compiled from: StdArraySerializers.java */
/* JADX INFO: loaded from: classes3.dex */
@b.g.a.c.y.a
public class i0$b extends q0<char[]> {
    public i0$b() {
        super(char[].class);
    }

    @Override // b.g.a.c.n
    public boolean d(b.g.a.c.x xVar, Object obj) {
        return ((char[]) obj).length == 0;
    }

    @Override // b.g.a.c.n
    public void f(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
        char[] cArr = (char[]) obj;
        if (!xVar.D(b.g.a.c.w.WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS)) {
            dVar.m0(cArr, 0, cArr.length);
            return;
        }
        dVar.b0(cArr, cArr.length);
        int length = cArr.length;
        for (int i = 0; i < length; i++) {
            dVar.m0(cArr, i, 1);
        }
        dVar.t();
    }

    @Override // b.g.a.c.n
    public void g(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar, b.g.a.c.e0.g gVar) throws IOException {
        b.g.a.b.s.b bVarE;
        char[] cArr = (char[]) obj;
        if (xVar.D(b.g.a.c.w.WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS)) {
            bVarE = gVar.e(dVar, gVar.d(cArr, b.g.a.b.h.START_ARRAY));
            int length = cArr.length;
            for (int i = 0; i < length; i++) {
                dVar.m0(cArr, i, 1);
            }
        } else {
            bVarE = gVar.e(dVar, gVar.d(cArr, b.g.a.b.h.VALUE_STRING));
            dVar.m0(cArr, 0, cArr.length);
        }
        gVar.f(dVar, bVarE);
    }
}
