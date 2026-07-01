package b.o.a.n.v;

/* JADX INFO: compiled from: CameraStateOrchestrator.java */
/* JADX INFO: loaded from: classes3.dex */
public class h implements Runnable {
    public final /* synthetic */ e j;
    public final /* synthetic */ Runnable k;
    public final /* synthetic */ f l;

    public h(f fVar, e eVar, Runnable runnable) {
        this.l = fVar;
        this.j = eVar;
        this.k = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.l.f.f(this.j)) {
            this.k.run();
        }
    }
}
