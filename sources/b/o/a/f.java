package b.o.a;

import com.otaliastudios.cameraview.CameraView$b;
import java.util.Iterator;

/* JADX INFO: compiled from: CameraView.java */
/* JADX INFO: loaded from: classes3.dex */
public class f implements Runnable {
    public final /* synthetic */ c j;
    public final /* synthetic */ CameraView$b k;

    public f(CameraView$b cameraView$b, c cVar) {
        this.k = cameraView$b;
        this.j = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator<a> it = this.k.c.D.iterator();
        while (it.hasNext()) {
            it.next().c(this.j);
        }
    }
}
