package p007b.p452o.p453a.p455n;

import com.google.android.gms.tasks.Task;
import java.util.concurrent.Callable;

/* JADX INFO: renamed from: b.o.a.n.n */
/* JADX INFO: compiled from: CameraEngine.java */
/* JADX INFO: loaded from: classes3.dex */
public class CallableC5140n implements Callable<Task<Void>> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ AbstractC5135i f13935j;

    public CallableC5140n(AbstractC5135i abstractC5135i) {
        this.f13935j = abstractC5135i;
    }

    @Override // java.util.concurrent.Callable
    public Task<Void> call() throws Exception {
        return this.f13935j.mo7197T();
    }
}
