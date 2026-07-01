package b.o.a;

import com.otaliastudios.cameraview.CameraView$b;
import java.util.Iterator;

/* JADX INFO: compiled from: CameraView.java */
/* JADX INFO: loaded from: classes3.dex */
public class g implements Runnable {
    public final /* synthetic */ CameraView$b j;

    public g(CameraView$b cameraView$b) {
        this.j = cameraView$b;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator<a> it = this.j.c.D.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }
}
