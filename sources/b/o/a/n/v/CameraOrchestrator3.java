package b.o.a.n.v;

import androidx.annotation.NonNull;
import b.o.a.n.CameraEngine;
import b.o.a.n.v.CameraOrchestrator;
import b.o.a.r.WorkerHandler;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.CancellationException;

/* JADX INFO: renamed from: b.o.a.n.v.c, reason: use source file name */
/* JADX INFO: compiled from: CameraOrchestrator.java */
/* JADX INFO: loaded from: classes3.dex */
public class CameraOrchestrator3 implements Runnable {
    public final /* synthetic */ CameraOrchestrator.c j;
    public final /* synthetic */ WorkerHandler k;
    public final /* synthetic */ CameraOrchestrator l;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: b.o.a.n.v.c$a */
    /* JADX INFO: compiled from: CameraOrchestrator.java */
    public class a<T> implements b.i.a.f.n.c<T> {
        public a() {
        }

        @Override // b.i.a.f.n.c
        public void onComplete(@NonNull Task<T> task) {
            Exception excK = task.k();
            if (excK != null) {
                CameraOrchestrator.a.a(2, CameraOrchestrator3.this.j.a.toUpperCase(), "- Finished with ERROR.", excK);
                CameraOrchestrator3 cameraOrchestrator3 = CameraOrchestrator3.this;
                if (cameraOrchestrator3.j.d) {
                    CameraEngine.b(CameraEngine.this, excK, false);
                }
                CameraOrchestrator3.this.j.f1942b.a(excK);
            } else if (task.n()) {
                CameraOrchestrator.a.a(1, CameraOrchestrator3.this.j.a.toUpperCase(), "- Finished because ABORTED.");
                CameraOrchestrator3.this.j.f1942b.a(new CancellationException());
            } else {
                CameraOrchestrator.a.a(1, CameraOrchestrator3.this.j.a.toUpperCase(), "- Finished.");
                CameraOrchestrator3.this.j.f1942b.b(task.l());
            }
            synchronized (CameraOrchestrator3.this.l.e) {
                CameraOrchestrator3 cameraOrchestrator4 = CameraOrchestrator3.this;
                CameraOrchestrator.a(cameraOrchestrator4.l, cameraOrchestrator4.j);
            }
        }
    }

    public CameraOrchestrator3(CameraOrchestrator cameraOrchestrator, CameraOrchestrator.c cVar, WorkerHandler workerHandler) {
        this.l = cameraOrchestrator;
        this.j = cVar;
        this.k = workerHandler;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            CameraOrchestrator.a.a(1, this.j.a.toUpperCase(), "- Executing.");
            Task task = (Task) this.j.c.call();
            WorkerHandler workerHandler = this.k;
            a aVar = new a();
            if (task.o()) {
                workerHandler.c(new CameraOrchestrator4(aVar, task));
            } else {
                task.c(workerHandler.g, aVar);
            }
        } catch (Exception e) {
            CameraOrchestrator.a.a(1, this.j.a.toUpperCase(), "- Finished with ERROR.", e);
            if (this.j.d) {
                CameraEngine.b(CameraEngine.this, e, false);
            }
            this.j.f1942b.a(e);
            synchronized (this.l.e) {
                CameraOrchestrator.a(this.l, this.j);
            }
        }
    }
}
