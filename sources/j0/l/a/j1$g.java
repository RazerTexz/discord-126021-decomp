package j0.l.a;

/* JADX INFO: compiled from: OperatorReplay.java */
/* JADX INFO: loaded from: classes3.dex */
public final class j1$g<T> extends j1$b<T> {
    private static final long serialVersionUID = -5898283885385201806L;
    public final int limit;

    public j1$g(int i) {
        this.limit = i;
    }

    @Override // j0.l.a.j1$b
    public void a() {
        if (this.size > this.limit) {
            j1$d j1_d = get().get();
            if (j1_d == null) {
                throw new IllegalStateException("Empty list!");
            }
            this.size--;
            set(j1_d);
        }
    }
}
