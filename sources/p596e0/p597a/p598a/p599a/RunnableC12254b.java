package p596e0.p597a.p598a.p599a;

import android.hardware.Camera;
import android.os.Handler;
import android.os.Looper;

/* JADX INFO: renamed from: e0.a.a.a.b */
/* JADX INFO: compiled from: CameraHandlerThread.java */
/* JADX INFO: loaded from: classes3.dex */
public class RunnableC12254b implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ int f25316j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ HandlerThreadC12255c f25317k;

    /* JADX INFO: renamed from: e0.a.a.a.b$a */
    /* JADX INFO: compiled from: CameraHandlerThread.java */
    public class a implements Runnable {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ Camera f25318j;

        public a(Camera camera) {
            this.f25318j = camera;
        }

        @Override // java.lang.Runnable
        public void run() {
            RunnableC12254b runnableC12254b = RunnableC12254b.this;
            AbstractC12253a abstractC12253a = runnableC12254b.f25317k.f25320j;
            Camera camera = this.f25318j;
            abstractC12253a.setupCameraPreview(camera == null ? null : new C12257e(camera, runnableC12254b.f25316j));
        }
    }

    public RunnableC12254b(HandlerThreadC12255c handlerThreadC12255c, int i) {
        this.f25317k = handlerThreadC12255c;
        this.f25316j = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        Camera cameraOpen;
        int i = this.f25316j;
        try {
            cameraOpen = i == -1 ? Camera.open() : Camera.open(i);
        } catch (Exception unused) {
            cameraOpen = null;
        }
        new Handler(Looper.getMainLooper()).post(new a(cameraOpen));
    }
}
