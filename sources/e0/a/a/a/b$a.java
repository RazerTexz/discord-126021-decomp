package e0.a.a.a;

import android.hardware.Camera;

/* JADX INFO: compiled from: CameraHandlerThread.java */
/* JADX INFO: loaded from: classes3.dex */
public class b$a implements Runnable {
    public final /* synthetic */ Camera j;
    public final /* synthetic */ b k;

    public b$a(b bVar, Camera camera) {
        this.k = bVar;
        this.j = camera;
    }

    @Override // java.lang.Runnable
    public void run() {
        b bVar = this.k;
        a aVar = bVar.k.j;
        Camera camera = this.j;
        aVar.setupCameraPreview(camera == null ? null : new e(camera, bVar.j));
    }
}
