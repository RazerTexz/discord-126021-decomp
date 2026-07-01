package b.o.a.n;

import com.otaliastudios.cameraview.CameraException;
import com.otaliastudios.cameraview.CameraView$b;

/* JADX INFO: compiled from: CameraEngine.java */
/* JADX INFO: loaded from: classes3.dex */
public class j implements Runnable {
    public final /* synthetic */ Throwable j;
    public final /* synthetic */ i k;

    public j(i iVar, Throwable th) {
        this.k = iVar;
        this.j = th;
    }

    @Override // java.lang.Runnable
    public void run() {
        Throwable th = this.j;
        if (th instanceof CameraException) {
            CameraException cameraException = (CameraException) th;
            if (cameraException.a()) {
                i.j.a(3, "EXCEPTION:", "Got CameraException. Since it is unrecoverable, executing destroy(false).");
                this.k.d(false, 0);
            }
            i.j.a(3, "EXCEPTION:", "Got CameraException. Dispatching to callback.");
            ((CameraView$b) this.k.m).a(cameraException);
            return;
        }
        b.o.a.b bVar = i.j;
        bVar.a(3, "EXCEPTION:", "Unexpected error! Executing destroy(true).");
        this.k.d(true, 0);
        bVar.a(3, "EXCEPTION:", "Unexpected error! Throwing.");
        Throwable th2 = this.j;
        if (!(th2 instanceof RuntimeException)) {
            throw new RuntimeException(this.j);
        }
        throw ((RuntimeException) th2);
    }
}
