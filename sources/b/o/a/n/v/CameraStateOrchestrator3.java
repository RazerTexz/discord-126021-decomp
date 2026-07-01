package b.o.a.n.v;

/* JADX INFO: renamed from: b.o.a.n.v.h, reason: use source file name */
/* JADX INFO: compiled from: CameraStateOrchestrator.java */
/* JADX INFO: loaded from: classes3.dex */
public class CameraStateOrchestrator3 implements Runnable {
    public final /* synthetic */ CameraState2 j;
    public final /* synthetic */ Runnable k;
    public final /* synthetic */ CameraStateOrchestrator l;

    public CameraStateOrchestrator3(CameraStateOrchestrator cameraStateOrchestrator, CameraState2 cameraState2, Runnable runnable) {
        this.l = cameraStateOrchestrator;
        this.j = cameraState2;
        this.k = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.l.f.f(this.j)) {
            this.k.run();
        }
    }
}
