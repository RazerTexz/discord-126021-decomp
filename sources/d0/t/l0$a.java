package d0.t;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: SlidingWindow.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l0$a<T> extends b<T> {
    public int l;
    public int m;
    public final /* synthetic */ l0 n;

    public l0$a(l0 l0Var) {
        this.n = l0Var;
        this.l = l0Var.size();
        this.m = l0.access$getStartIndex$p(l0Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // d0.t.b
    public void a() {
        if (this.l == 0) {
            this.j = 3;
            return;
        }
        b(l0.access$getBuffer$p(this.n)[this.m]);
        this.m = (this.m + 1) % l0.access$getCapacity$p(this.n);
        this.l--;
    }
}
