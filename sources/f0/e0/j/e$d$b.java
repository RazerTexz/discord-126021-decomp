package f0.e0.j;

/* JADX INFO: compiled from: TaskQueue.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e$d$b extends f0.e0.f.a {
    public final /* synthetic */ e$d e;
    public final /* synthetic */ int f;
    public final /* synthetic */ int g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e$d$b(String str, boolean z2, String str2, boolean z3, e$d e_d, int i, int i2) {
        super(str2, z3);
        this.e = e_d;
        this.f = i;
        this.g = i2;
    }

    @Override // f0.e0.f.a
    public long a() {
        this.e.k.q(true, this.f, this.g);
        return -1L;
    }
}
