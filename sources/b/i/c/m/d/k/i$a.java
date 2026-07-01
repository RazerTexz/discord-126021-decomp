package b.i.c.m.d.k;

/* JADX INFO: compiled from: CrashlyticsBackgroundWorker.java */
/* JADX INFO: loaded from: classes3.dex */
public class i$a implements Runnable {
    public final /* synthetic */ i j;

    public i$a(i iVar) {
        this.j = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.j.d.set(Boolean.TRUE);
    }
}
