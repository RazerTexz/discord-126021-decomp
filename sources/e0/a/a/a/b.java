package e0.a.a.a;

import android.hardware.Camera;
import android.os.Handler;
import android.os.Looper;

/* JADX INFO: compiled from: CameraHandlerThread.java */
/* JADX INFO: loaded from: classes3.dex */
public class b implements Runnable {
    public final /* synthetic */ int j;
    public final /* synthetic */ c k;

    public b(c cVar, int i) {
        this.k = cVar;
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
        new Handler(Looper.getMainLooper()).post(new b$a(this, cameraOpen));
    }
}
