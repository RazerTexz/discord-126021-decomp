package b.g.a.c.h0;

/* JADX INFO: compiled from: PlaceholderForType.java */
/* JADX INFO: loaded from: classes3.dex */
public class h extends l {
    private static final long serialVersionUID = 1;
    public b.g.a.c.j _actualType;
    public final int _ordinal;

    public h(int i) {
        super(Object.class, m.l, n.k(), null, 1, null, null, false);
        this._ordinal = i;
    }

    @Override // b.g.a.c.j
    public b.g.a.c.j C(Class<?> cls, m mVar, b.g.a.c.j jVar, b.g.a.c.j[] jVarArr) {
        L();
        throw null;
    }

    @Override // b.g.a.c.j
    public b.g.a.c.j D(b.g.a.c.j jVar) {
        L();
        throw null;
    }

    @Override // b.g.a.c.j
    public b.g.a.c.j E(Object obj) {
        L();
        throw null;
    }

    @Override // b.g.a.c.j
    public b.g.a.c.j G() {
        L();
        throw null;
    }

    @Override // b.g.a.c.j
    public b.g.a.c.j H(Object obj) {
        L();
        throw null;
    }

    @Override // b.g.a.c.j
    public b.g.a.c.j I(Object obj) {
        L();
        throw null;
    }

    @Override // b.g.a.c.h0.l
    public String K() {
        return toString();
    }

    public final <T> T L() {
        StringBuilder sbU = b.d.b.a.a.U("Operation should not be attempted on ");
        sbU.append(h.class.getName());
        throw new UnsupportedOperationException(sbU.toString());
    }

    @Override // b.g.a.c.j
    public boolean equals(Object obj) {
        return obj == this;
    }

    @Override // b.g.a.c.j
    public StringBuilder l(StringBuilder sb) {
        sb.append('$');
        sb.append(this._ordinal + 1);
        return sb;
    }

    @Override // b.g.a.c.j
    public StringBuilder m(StringBuilder sb) {
        l(sb);
        return sb;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        l(sb);
        return sb.toString();
    }

    @Override // b.g.a.c.j
    public boolean v() {
        return false;
    }
}
