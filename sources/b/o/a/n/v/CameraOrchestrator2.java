package b.o.a.n.v;

import b.o.a.n.CameraEngine;
import b.o.a.n.v.CameraOrchestrator;
import b.o.a.r.WorkerHandler;

/* JADX INFO: renamed from: b.o.a.n.v.b, reason: use source file name */
/* JADX INFO: compiled from: CameraOrchestrator.java */
/* JADX INFO: loaded from: classes3.dex */
public class CameraOrchestrator2 implements Runnable {
    public final /* synthetic */ CameraOrchestrator j;

    public CameraOrchestrator2(CameraOrchestrator cameraOrchestrator) {
        this.j = cameraOrchestrator;
    }

    @Override // java.lang.Runnable
    public void run() {
        CameraOrchestrator.c<?> cVar;
        synchronized (this.j.e) {
            cVar = null;
            if (!this.j.d) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                for (CameraOrchestrator.c<?> cVar2 : this.j.c) {
                    if (cVar2.e <= jCurrentTimeMillis) {
                        cVar = cVar2;
                        break;
                    }
                }
                if (cVar != null) {
                    this.j.d = true;
                }
            }
        }
        if (cVar != null) {
            CameraOrchestrator cameraOrchestrator = this.j;
            WorkerHandler workerHandler = CameraEngine.this.k;
            workerHandler.c(new CameraOrchestrator3(cameraOrchestrator, cVar, workerHandler));
        }
    }
}
