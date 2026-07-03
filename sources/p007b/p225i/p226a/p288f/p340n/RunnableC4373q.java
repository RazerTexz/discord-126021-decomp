package p007b.p225i.p226a.p288f.p340n;

import com.google.android.gms.tasks.Task;

/* JADX INFO: renamed from: b.i.a.f.n.q */
/* JADX INFO: compiled from: com.google.android.gms:play-services-tasks@@17.2.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC4373q implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ Task f11504j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ C4374r f11505k;

    public RunnableC4373q(C4374r c4374r, Task task) {
        this.f11505k = c4374r;
        this.f11504j = task;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f11505k.f11507b) {
            InterfaceC4357c<TResult> interfaceC4357c = this.f11505k.f11508c;
            if (interfaceC4357c != 0) {
                interfaceC4357c.onComplete((Task<TResult>) this.f11504j);
            }
        }
    }
}
