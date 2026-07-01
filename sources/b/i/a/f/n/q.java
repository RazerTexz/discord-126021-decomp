package b.i.a.f.n;

import com.google.android.gms.tasks.Task;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tasks@@17.2.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class q implements Runnable {
    public final /* synthetic */ Task j;
    public final /* synthetic */ r k;

    public q(r rVar, Task task) {
        this.k = rVar;
        this.j = task;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.k.f1598b) {
            c<TResult> cVar = this.k.c;
            if (cVar != 0) {
                cVar.onComplete((Task<TResult>) this.j);
            }
        }
    }
}
