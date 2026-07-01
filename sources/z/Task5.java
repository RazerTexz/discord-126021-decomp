package z;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;

/* JADX INFO: renamed from: z.f, reason: use source file name */
/* JADX INFO: compiled from: Task.java */
/* JADX INFO: loaded from: classes.dex */
public final class Task5 implements Runnable {
    public final /* synthetic */ TaskCompletionSource2 j;
    public final /* synthetic */ Callable k;

    public Task5(TaskCompletionSource2 taskCompletionSource2, Callable callable) {
        this.j = taskCompletionSource2;
        this.k = callable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.j.c(this.k.call());
        } catch (CancellationException unused) {
            this.j.a();
        } catch (Exception e) {
            this.j.b(e);
        }
    }
}
