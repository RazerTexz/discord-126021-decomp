package b.g.a.c.i0;

/* JADX INFO: compiled from: NameTransformer.java */
/* JADX INFO: loaded from: classes3.dex */
public final class k extends n {
    public final /* synthetic */ String k;
    public final /* synthetic */ String l;

    public k(String str, String str2) {
        this.k = str;
        this.l = str2;
    }

    @Override // b.g.a.c.i0.n
    public String a(String str) {
        return this.k + str + this.l;
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("[PreAndSuffixTransformer('");
        sbU.append(this.k);
        sbU.append("','");
        return b.d.b.a.a.J(sbU, this.l, "')]");
    }
}
