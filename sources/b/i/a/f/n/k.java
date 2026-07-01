package b.i.a.f.n;

import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.Task;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tasks@@17.2.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class k implements Runnable {
    public final /* synthetic */ Task j;
    public final /* synthetic */ l k;

    public k(l lVar, Task task) {
        this.k = lVar;
        this.j = task;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // java.lang.Runnable
    public final void run() {
        if (this.j.n()) {
            this.k.c.u();
            return;
        }
        try {
            this.k.c.s((TContinuationResult) this.k.f1595b.a((Task<TResult>) this.j));
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
