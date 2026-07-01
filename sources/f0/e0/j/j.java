package f0.e0.j;

/* JADX INFO: compiled from: TaskQueue.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j extends f0.e0.f.a {
    public final /* synthetic */ e e;
    public final /* synthetic */ int f;
    public final /* synthetic */ a g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(String str, boolean z2, String str2, boolean z3, e eVar, int i, a aVar) {
        super(str2, z3);
        this.e = eVar;
        this.f = i;
        this.g = aVar;
    }

    @Override // f0.e0.f.a
    public long a() {
        this.e.w.c(this.f, this.g);
        synchronized (this.e) {
            this.e.M.remove(Integer.valueOf(this.f));
        }
        return -1L;
    }
}
