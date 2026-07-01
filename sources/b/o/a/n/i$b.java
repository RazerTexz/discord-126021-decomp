package b.o.a.n;

import com.google.android.gms.tasks.Task;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: CameraEngine.java */
/* JADX INFO: loaded from: classes3.dex */
public class i$b implements Callable<Task<Void>> {
    public final /* synthetic */ i j;

    public i$b(i iVar) {
        this.j = iVar;
    }

    @Override // java.util.concurrent.Callable
    public Task<Void> call() throws Exception {
        return this.j.U();
    }
}
