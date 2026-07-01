package b.g.a.c.g0.t;

import b.g.a.c.x;

/* JADX INFO: compiled from: AttributePropertyWriter.java */
/* JADX INFO: loaded from: classes3.dex */
public class a extends b.g.a.c.g0.s {
    private static final long serialVersionUID = 1;
    public final String _attrName;

    public a(String str, b.g.a.c.c0.s sVar, b.g.a.c.i0.a aVar, b.g.a.c.j jVar) {
        super(sVar, aVar, jVar, null, null, null, sVar.g(), null);
        this._attrName = str;
    }

    @Override // b.g.a.c.g0.s
    public Object j(Object obj, b.g.a.b.d dVar, x xVar) throws Exception {
        return xVar.w(this._attrName);
    }

    @Override // b.g.a.c.g0.s
    public b.g.a.c.g0.s k(b.g.a.c.z.l<?> lVar, b.g.a.c.c0.c cVar, b.g.a.c.c0.s sVar, b.g.a.c.j jVar) {
        throw new IllegalStateException("Should not be called on this type");
    }
}
