package b.o.a.n.v;

import com.google.android.gms.tasks.Task;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: CameraOrchestrator.java */
/* JADX INFO: loaded from: classes3.dex */
public class a$a implements Callable<Task<Void>> {
    public final /* synthetic */ Runnable j;

    public a$a(a aVar, Runnable runnable) {
        this.j = runnable;
    }

    @Override // java.util.concurrent.Callable
    public Task<Void> call() throws Exception {
        this.j.run();
        return b.i.a.f.e.o.f.Z(null);
    }
}
