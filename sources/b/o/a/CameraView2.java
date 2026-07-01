package b.o.a;

import com.otaliastudios.cameraview.CameraView;
import java.util.Iterator;

/* JADX INFO: renamed from: b.o.a.f, reason: use source file name */
/* JADX INFO: compiled from: CameraView.java */
/* JADX INFO: loaded from: classes3.dex */
public class CameraView2 implements Runnable {
    public final /* synthetic */ CameraOptions j;
    public final /* synthetic */ CameraView.b k;

    public CameraView2(CameraView.b bVar, CameraOptions cameraOptions) {
        this.k = bVar;
        this.j = cameraOptions;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator<CameraListener> it = CameraView.this.D.iterator();
        while (it.hasNext()) {
            it.next().c(this.j);
        }
    }
}
