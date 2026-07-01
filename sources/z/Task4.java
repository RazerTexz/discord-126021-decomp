package z;

import java.util.concurrent.CancellationException;

/* JADX INFO: renamed from: z.e, reason: use source file name */
/* JADX INFO: compiled from: Task.java */
/* JADX INFO: loaded from: classes.dex */
public final class Task4 implements Runnable {
    public final /* synthetic */ TaskCompletionSource2 j;
    public final /* synthetic */ Continuation3 k;
    public final /* synthetic */ Task6 l;

    public Task4(TaskCompletionSource2 taskCompletionSource2, Continuation3 continuation3, Task6 task6) {
        this.j = taskCompletionSource2;
        this.k = continuation3;
        this.l = task6;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.j.c(this.k.a(this.l));
        } catch (CancellationException unused) {
            this.j.a();
        } catch (Exception e) {
            this.j.b(e);
        }
    }
}
