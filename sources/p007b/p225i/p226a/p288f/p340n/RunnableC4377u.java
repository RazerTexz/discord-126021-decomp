package p007b.p225i.p226a.p288f.p340n;

import com.google.android.gms.tasks.Task;

/* JADX INFO: renamed from: b.i.a.f.n.u */
/* JADX INFO: compiled from: com.google.android.gms:play-services-tasks@@17.2.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC4377u implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ Task f11514j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ C4378v f11515k;

    public RunnableC4377u(C4378v c4378v, Task task) {
        this.f11515k = c4378v;
        this.f11514j = task;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f11515k.f11517b) {
            InterfaceC4361e<? super TResult> interfaceC4361e = this.f11515k.f11518c;
            if (interfaceC4361e != 0) {
                interfaceC4361e.onSuccess((Object) this.f11514j.mo6017l());
            }
        }
    }
}
