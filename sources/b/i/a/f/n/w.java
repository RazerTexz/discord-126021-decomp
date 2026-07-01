package b.i.a.f.n;

import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tasks@@17.2.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class w implements Runnable {
    public final /* synthetic */ Task j;
    public final /* synthetic */ x k;

    public w(x xVar, Task task) {
        this.k = xVar;
        this.j = task;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // java.lang.Runnable
    public final void run() {
        try {
            Task taskA = this.k.f1601b.a((TResult) this.j.l());
            if (taskA == null) {
                x xVar = this.k;
                xVar.c.t(new NullPointerException("Continuation returned null"));
            } else {
                Executor executor = g.f1593b;
                taskA.g(executor, this.k);
                taskA.e(executor, this.k);
                taskA.a(executor, this.k);
            }
        } catch (RuntimeExecutionException e) {
            if (!(e.getCause() instanceof Exception)) {
                this.k.c.t(e);
                return;
            }
            x xVar2 = this.k;
            xVar2.c.t((Exception) e.getCause());
        } catch (CancellationException unused) {
            this.k.c.u();
        } catch (Exception e2) {
            this.k.c.t(e2);
        }
    }
}
