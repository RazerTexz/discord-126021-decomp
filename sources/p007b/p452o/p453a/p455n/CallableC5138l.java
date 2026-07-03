package p007b.p452o.p453a.p455n;

import com.google.android.gms.tasks.Task;
import com.otaliastudios.cameraview.CameraException;
import java.util.concurrent.Callable;
import p007b.p452o.p453a.AbstractC5104c;

/* JADX INFO: renamed from: b.o.a.n.l */
/* JADX INFO: compiled from: CameraEngine.java */
/* JADX INFO: loaded from: classes3.dex */
public class CallableC5138l implements Callable<Task<AbstractC5104c>> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ AbstractC5135i f13933j;

    public CallableC5138l(AbstractC5135i abstractC5135i) {
        this.f13933j = abstractC5135i;
    }

    @Override // java.util.concurrent.Callable
    public Task<AbstractC5104c> call() throws Exception {
        AbstractC5135i abstractC5135i = this.f13933j;
        if (abstractC5135i.mo7205c(abstractC5135i.mo7292l())) {
            return this.f13933j.mo7194Q();
        }
        AbstractC5135i.f13918j.m7159a(3, "onStartEngine:", "No camera available for facing", this.f13933j.mo7292l());
        throw new CameraException(6);
    }
}
