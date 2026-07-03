package p007b.p452o.p453a;

import com.otaliastudios.cameraview.CameraView;
import java.util.Iterator;

/* JADX INFO: renamed from: b.o.a.f */
/* JADX INFO: compiled from: CameraView.java */
/* JADX INFO: loaded from: classes3.dex */
public class RunnableC5107f implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ AbstractC5104c f13706j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ CameraView.C11195b f13707k;

    public RunnableC5107f(CameraView.C11195b c11195b, AbstractC5104c abstractC5104c) {
        this.f13707k = c11195b;
        this.f13706j = abstractC5104c;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator<AbstractC5102a> it = CameraView.this.f22113D.iterator();
        while (it.hasNext()) {
            it.next().mo7157c(this.f13706j);
        }
    }
}
