package b.o.a;

import com.otaliastudios.cameraview.CameraView$b;
import java.util.Iterator;

/* JADX INFO: compiled from: CameraView.java */
/* JADX INFO: loaded from: classes3.dex */
public class i implements Runnable {
    public final /* synthetic */ l$a j;
    public final /* synthetic */ CameraView$b k;

    public i(CameraView$b cameraView$b, l$a l_a) {
        this.k = cameraView$b;
        this.j = l_a;
    }

    @Override // java.lang.Runnable
    public void run() {
        l lVar = new l(this.j);
        Iterator<a> it = this.k.c.D.iterator();
        while (it.hasNext()) {
            it.next().d(lVar);
        }
    }
}
