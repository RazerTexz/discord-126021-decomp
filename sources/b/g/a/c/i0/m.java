package b.g.a.c.i0;

/* JADX INFO: compiled from: NameTransformer.java */
/* JADX INFO: loaded from: classes3.dex */
public final class m extends n {
    public final /* synthetic */ String k;

    public m(String str) {
        this.k = str;
    }

    @Override // b.g.a.c.i0.n
    public String a(String str) {
        StringBuilder sbU = b.d.b.a.a.U(str);
        sbU.append(this.k);
        return sbU.toString();
    }

    public String toString() {
        return b.d.b.a.a.J(b.d.b.a.a.U("[SuffixTransformer('"), this.k, "')]");
    }
}
