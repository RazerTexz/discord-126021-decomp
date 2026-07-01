package b.f.e;

/* JADX INFO: renamed from: b.f.e.a, reason: use source file name */
/* JADX INFO: compiled from: AbstractDataSource.java */
/* JADX INFO: loaded from: classes.dex */
public class AbstractDataSource implements Runnable {
    public final /* synthetic */ boolean j;
    public final /* synthetic */ DataSubscriber k;
    public final /* synthetic */ boolean l;
    public final /* synthetic */ AbstractDataSource3 m;

    public AbstractDataSource(AbstractDataSource3 abstractDataSource3, boolean z2, DataSubscriber dataSubscriber, boolean z3) {
        this.m = abstractDataSource3;
        this.j = z2;
        this.k = dataSubscriber;
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
