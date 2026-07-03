package p007b.p452o.p453a.p455n;

import com.otaliastudios.cameraview.CameraException;
import com.otaliastudios.cameraview.CameraView;
import p007b.p452o.p453a.C5103b;

/* JADX INFO: renamed from: b.o.a.n.j */
/* JADX INFO: compiled from: CameraEngine.java */
/* JADX INFO: loaded from: classes3.dex */
public class RunnableC5136j implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ Throwable f13930j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ AbstractC5135i f13931k;

    public RunnableC5136j(AbstractC5135i abstractC5135i, Throwable th) {
        this.f13931k = abstractC5135i;
        this.f13930j = th;
    }

    @Override // java.lang.Runnable
    public void run() {
        Throwable th = this.f13930j;
        if (th instanceof CameraException) {
            CameraException cameraException = (CameraException) th;
            if (cameraException.m9303a()) {
                AbstractC5135i.f13918j.m7159a(3, "EXCEPTION:", "Got CameraException. Since it is unrecoverable, executing destroy(false).");
                this.f13931k.m7329d(false, 0);
            }
            AbstractC5135i.f13918j.m7159a(3, "EXCEPTION:", "Got CameraException. Dispatching to callback.");
            ((CameraView.C11195b) this.f13931k.f13921m).m9311a(cameraException);
            return;
        }
        C5103b c5103b = AbstractC5135i.f13918j;
        c5103b.m7159a(3, "EXCEPTION:", "Unexpected error! Executing destroy(true).");
        this.f13931k.m7329d(true, 0);
        c5103b.m7159a(3, "EXCEPTION:", "Unexpected error! Throwing.");
        Throwable th2 = this.f13930j;
        if (!(th2 instanceof RuntimeException)) {
            throw new RuntimeException(this.f13930j);
        }
        throw ((RuntimeException) th2);
    }
}
