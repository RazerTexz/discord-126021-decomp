package b.i.a.f.n;

import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tasks@@17.2.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class m implements Runnable {
    public final /* synthetic */ Task j;
    public final /* synthetic */ n k;

    public m(n nVar, Task task) {
        this.k = nVar;
        this.j = task;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // java.lang.Runnable
    public final void run() {
        try {
            Task task = (Task) this.k.f1596b.a((Task<TResult>) this.j);
            if (task == null) {
                n nVar = this.k;
                nVar.c.t(new NullPointerException("Continuation returned null"));
            } else {
                Executor executor = g.f1593b;
                task.g(executor, this.k);
                task.e(executor, this.k);
                task.a(executor, this.k);
            }
        } catch (RuntimeExecutionException e) {
            if (e.getCause() instanceof Exception) {
                this.k.c.t((Exception) e.getCause());
            } else {
                this.k.c.t(e);
            }
        } catch (Exception e2) {
            this.k.c.t(e2);
        }
    }
}
