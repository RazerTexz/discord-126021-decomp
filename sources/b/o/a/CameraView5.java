package b.o.a;

import b.o.a.PictureResult;
import com.otaliastudios.cameraview.CameraView;
import java.util.Iterator;

/* JADX INFO: renamed from: b.o.a.i, reason: use source file name */
/* JADX INFO: compiled from: CameraView.java */
/* JADX INFO: loaded from: classes3.dex */
public class CameraView5 implements Runnable {
    public final /* synthetic */ PictureResult.a j;
    public final /* synthetic */ CameraView.b k;

    public CameraView5(CameraView.b bVar, PictureResult.a aVar) {
        this.k = bVar;
        this.j = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        PictureResult pictureResult = new PictureResult(this.j);
        Iterator<CameraListener> it = CameraView.this.D.iterator();
        while (it.hasNext()) {
            it.next().d(pictureResult);
        }
    }
}
