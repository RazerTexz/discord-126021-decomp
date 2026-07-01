package b.o.a.n;

import b.i.a.f.n.c0;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: CameraEngine.java */
/* JADX INFO: loaded from: classes3.dex */
public class i$e implements Callable<Task<Void>> {
    public final /* synthetic */ i j;

    public i$e(i iVar) {
        this.j = iVar;
    }

    @Override // java.util.concurrent.Callable
    public Task<Void> call() throws Exception {
        if (this.j.z() != null && this.j.z().m()) {
            return this.j.P();
        }
        c0 c0Var = new c0();
        c0Var.u();
        return c0Var;
    }
}
