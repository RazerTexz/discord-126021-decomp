package b.i.e.q.r.f.d;

/* JADX INFO: compiled from: AI01320xDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends f {
    public b(b.i.e.n.a aVar) {
        super(aVar);
    }

    @Override // b.i.e.q.r.f.d.i
    public void d(StringBuilder sb, int i) {
        if (i < 10000) {
            sb.append("(3202)");
        } else {
            sb.append("(3203)");
        }
    }

    @Override // b.i.e.q.r.f.d.i
    public int e(int i) {
        return i < 10000 ? i : i - 10000;
    }
}
