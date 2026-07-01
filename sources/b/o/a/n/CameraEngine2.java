package b.o.a.n;

import b.o.a.CameraLogger;
import com.otaliastudios.cameraview.CameraException;
import com.otaliastudios.cameraview.CameraView;

/* JADX INFO: renamed from: b.o.a.n.j, reason: use source file name */
/* JADX INFO: compiled from: CameraEngine.java */
/* JADX INFO: loaded from: classes3.dex */
public class CameraEngine2 implements Runnable {
    public final /* synthetic */ Throwable j;
    public final /* synthetic */ CameraEngine k;

    public CameraEngine2(CameraEngine cameraEngine, Throwable th) {
        this.k = cameraEngine;
        this.j = th;
    }

    @Override // java.lang.Runnable
    public void run() {
        Throwable th = this.j;
        if (th instanceof CameraException) {
            CameraException cameraException = (CameraException) th;
            if (cameraException.a()) {
                CameraEngine.j.a(3, "EXCEPTION:", "Got CameraException. Since it is unrecoverable, executing destroy(false).");
                this.k.d(false, 0);
            }
            CameraEngine.j.a(3, "EXCEPTION:", "Got CameraException. Dispatching to callback.");
            ((CameraView.b) this.k.m).a(cameraException);
            return;
        }
        CameraLogger cameraLogger = CameraEngine.j;
        cameraLogger.a(3, "EXCEPTION:", "Unexpected error! Executing destroy(true).");
        this.k.d(true, 0);
        cameraLogger.a(3, "EXCEPTION:", "Unexpected error! Throwing.");
        Throwable th2 = this.j;
        if (!(th2 instanceof RuntimeException)) {
            throw new RuntimeException(this.j);
        }
        throw ((RuntimeException) th2);
    }
}
