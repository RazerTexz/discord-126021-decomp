package b.o.a;

import com.otaliastudios.cameraview.CameraView;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: renamed from: b.o.a.j, reason: use source file name */
/* JADX INFO: compiled from: CameraView.java */
/* JADX INFO: loaded from: classes3.dex */
public class CameraView6 implements Runnable {
    public final /* synthetic */ int j;
    public final /* synthetic */ CameraView.b k;

    public CameraView6(CameraView.b bVar, int i) {
        this.k = bVar;
        this.j = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator<CameraListener> it = CameraView.this.D.iterator();
        while (it.hasNext()) {
            Objects.requireNonNull(it.next());
        }
    }
}
