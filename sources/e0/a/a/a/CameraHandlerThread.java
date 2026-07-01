package e0.a.a.a;

import android.hardware.Camera;
import android.os.Handler;
import android.os.Looper;

/* JADX INFO: renamed from: e0.a.a.a.b, reason: use source file name */
/* JADX INFO: compiled from: CameraHandlerThread.java */
/* JADX INFO: loaded from: classes3.dex */
public class CameraHandlerThread implements Runnable {
    public final /* synthetic */ int j;
    public final /* synthetic */ CameraHandlerThread2 k;

    /* JADX INFO: renamed from: e0.a.a.a.b$a */
    /* JADX INFO: compiled from: CameraHandlerThread.java */
    public class a implements Runnable {
        public final /* synthetic */ Camera j;

        public a(Camera camera) {
            this.j = camera;
        }

        @Override // java.lang.Runnable
        public void run() {
            CameraHandlerThread cameraHandlerThread = CameraHandlerThread.this;
            BarcodeScannerView barcodeScannerView = cameraHandlerThread.k.j;
            Camera camera = this.j;
            barcodeScannerView.setupCameraPreview(camera == null ? null : new CameraWrapper(camera, cameraHandlerThread.j));
        }
    }

    public CameraHandlerThread(CameraHandlerThread2 cameraHandlerThread2, int i) {
        this.k = cameraHandlerThread2;
        this.j = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        Camera cameraOpen;
        int i = this.j;
        try {
            cameraOpen = i == -1 ? Camera.open() : Camera.open(i);
        } catch (Exception unused) {
            cameraOpen = null;
        }
        new Handler(Looper.getMainLooper()).post(new a(cameraOpen));
    }
}
