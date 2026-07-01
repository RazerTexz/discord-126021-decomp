package b.g.a.c.g0.u;

import java.io.IOException;

/* JADX INFO: compiled from: ByteArraySerializer.java */
/* JADX INFO: loaded from: classes3.dex */
@b.g.a.c.y.a
public class f extends q0<byte[]> {
    private static final long serialVersionUID = 1;

    public f() {
        super(byte[].class);
    }

    @Override // b.g.a.c.n
    public boolean d(b.g.a.c.x xVar, Object obj) {
        return ((byte[]) obj).length == 0;
    }

    @Override // b.g.a.c.n
    public void f(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
        byte[] bArr = (byte[]) obj;
        dVar.n(xVar._config._base._defaultBase64, bArr, 0, bArr.length);
    }

    @Override // b.g.a.c.n
    public void g(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar, b.g.a.c.e0.g gVar) throws IOException {
        byte[] bArr = (byte[]) obj;
        b.g.a.b.s.b bVarE = gVar.e(dVar, gVar.d(bArr, b.g.a.b.h.VALUE_EMBEDDED_OBJECT));
        dVar.n(xVar._config._base._defaultBase64, bArr, 0, bArr.length);
        gVar.f(dVar, bVarE);
    }
}
