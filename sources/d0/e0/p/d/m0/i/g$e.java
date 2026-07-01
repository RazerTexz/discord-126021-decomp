package d0.e0.p.d.m0.i;

/* JADX INFO: compiled from: GeneratedMessageLite.java */
/* JADX INFO: loaded from: classes3.dex */
public final class g$e implements f$a<g$e> {
    public final h$b<?> j;
    public final int k;
    public final w$b l;
    public final boolean m;
    public final boolean n;

    public g$e(h$b<?> h_b, int i, w$b w_b, boolean z2, boolean z3) {
        this.j = h_b;
        this.k = i;
        this.l = w_b;
        this.m = z2;
        this.n = z3;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return compareTo((g$e) obj);
    }

    public h$b<?> getEnumType() {
        return this.j;
    }

    @Override // d0.e0.p.d.m0.i.f$a
    public w$c getLiteJavaType() {
        return this.l.getJavaType();
    }

    @Override // d0.e0.p.d.m0.i.f$a
    public w$b getLiteType() {
        return this.l;
    }

    @Override // d0.e0.p.d.m0.i.f$a
    public int getNumber() {
        return this.k;
    }

    @Override // d0.e0.p.d.m0.i.f$a
    public n$a internalMergeFrom(n$a n_a, n nVar) {
        return ((g$b) n_a).mergeFrom((g) nVar);
    }

    @Override // d0.e0.p.d.m0.i.f$a
    public boolean isPacked() {
        return this.n;
    }

    @Override // d0.e0.p.d.m0.i.f$a
    public boolean isRepeated() {
        return this.m;
    }

    public int compareTo(g$e g_e) {
        return this.k - g_e.k;
    }
}
