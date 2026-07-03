package p007b.p452o.p453a;

import com.otaliastudios.cameraview.CameraView;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: renamed from: b.o.a.j */
/* JADX INFO: compiled from: CameraView.java */
/* JADX INFO: loaded from: classes3.dex */
public class RunnableC5111j implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ int f13712j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ CameraView.C11195b f13713k;

    public RunnableC5111j(CameraView.C11195b c11195b, int i) {
        this.f13713k = c11195b;
        this.f13712j = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator<AbstractC5102a> it = CameraView.this.f22113D.iterator();
        while (it.hasNext()) {
            Objects.requireNonNull(it.next());
        }
    }
}
