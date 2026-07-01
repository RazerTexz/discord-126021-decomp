package b.f.e;

/* JADX INFO: compiled from: AbstractDataSource.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements Runnable {
    public final /* synthetic */ f j;
    public final /* synthetic */ c k;

    public b(c cVar, f fVar) {
        this.k = cVar;
        this.j = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.j.onProgressUpdate(this.k);
    }
}
