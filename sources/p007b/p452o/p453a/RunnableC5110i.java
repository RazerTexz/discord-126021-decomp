package p007b.p452o.p453a;

import com.otaliastudios.cameraview.CameraView;
import java.util.Iterator;
import p007b.p452o.p453a.C5113l;

/* JADX INFO: renamed from: b.o.a.i */
/* JADX INFO: compiled from: CameraView.java */
/* JADX INFO: loaded from: classes3.dex */
public class RunnableC5110i implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ C5113l.a f13710j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ CameraView.C11195b f13711k;

    public RunnableC5110i(CameraView.C11195b c11195b, C5113l.a aVar) {
        this.f13711k = c11195b;
        this.f13710j = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        C5113l c5113l = new C5113l(this.f13710j);
        Iterator<AbstractC5102a> it = CameraView.this.f22113D.iterator();
        while (it.hasNext()) {
            it.next().mo7158d(c5113l);
        }
    }
}
