package b.o.a.n;

import b.o.a.x.Size3;

/* JADX INFO: renamed from: b.o.a.n.h, reason: use source file name */
/* JADX INFO: compiled from: CameraBaseEngine.java */
/* JADX INFO: loaded from: classes3.dex */
public class CameraBaseEngine2 implements Runnable {
    public final /* synthetic */ CameraBaseEngine j;

    public CameraBaseEngine2(CameraBaseEngine cameraBaseEngine) {
        this.j = cameraBaseEngine;
    }

    @Override // java.lang.Runnable
    public void run() {
        Size3 size3R0 = this.j.R0();
        if (size3R0.equals(this.j.f1931s)) {
            CameraEngine.j.a(1, "onSurfaceChanged:", "The computed preview size is identical. No op.");
            return;
        }
        CameraEngine.j.a(1, "onSurfaceChanged:", "Computed a new preview size. Calling onPreviewStreamSizeChanged().");
        CameraBaseEngine cameraBaseEngine = this.j;
        cameraBaseEngine.f1931s = size3R0;
        cameraBaseEngine.X0();
    }
}
