package b.g.a.c.i0;

/* JADX INFO: compiled from: NameTransformer.java */
/* JADX INFO: loaded from: classes3.dex */
public final class l extends n {
    public final /* synthetic */ String k;

    public l(String str) {
        this.k = str;
    }

    @Override // b.g.a.c.i0.n
    public String a(String str) {
        return b.d.b.a.a.J(new StringBuilder(), this.k, str);
    }

    public String toString() {
        return b.d.b.a.a.J(b.d.b.a.a.U("[PrefixTransformer('"), this.k, "')]");
    }
}
