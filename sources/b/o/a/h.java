package b.o.a;

import com.otaliastudios.cameraview.CameraView$b;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: CameraView.java */
/* JADX INFO: loaded from: classes3.dex */
public class h implements Runnable {
    public final /* synthetic */ CameraView$b j;

    public h(CameraView$b cameraView$b) {
        this.j = cameraView$b;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator<a> it = this.j.c.D.iterator();
        while (it.hasNext()) {
            Objects.requireNonNull(it.next());
        }
    }
}
