package b.o.a;

import com.otaliastudios.cameraview.CameraView$b;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: CameraView.java */
/* JADX INFO: loaded from: classes3.dex */
public class j implements Runnable {
    public final /* synthetic */ int j;
    public final /* synthetic */ CameraView$b k;

    public j(CameraView$b cameraView$b, int i) {
        this.k = cameraView$b;
        this.j = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator<a> it = this.k.c.D.iterator();
        while (it.hasNext()) {
            Objects.requireNonNull(it.next());
        }
    }
}
