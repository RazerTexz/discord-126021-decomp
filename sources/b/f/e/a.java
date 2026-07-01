package b.f.e;

/* JADX INFO: compiled from: AbstractDataSource.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements Runnable {
    public final /* synthetic */ boolean j;
    public final /* synthetic */ f k;
    public final /* synthetic */ boolean l;
    public final /* synthetic */ c m;

    public a(c cVar, boolean z2, f fVar, boolean z3) {
        this.m = cVar;
        this.j = z2;
        this.k = fVar;
        this.l = z3;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.j) {
            this.k.onFailure(this.m);
        } else if (this.l) {
            this.k.onCancellation(this.m);
        } else {
            this.k.onNewResult(this.m);
        }
    }
}
