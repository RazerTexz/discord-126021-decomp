package b.c.a;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: LottieTask.java */
/* JADX INFO: loaded from: classes.dex */
public class r$a<T> extends FutureTask<p<T>> {
    public final /* synthetic */ r j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r$a(r rVar, Callable<p<T>> callable) {
        super(callable);
        this.j = rVar;
    }

    @Override // java.util.concurrent.FutureTask
    public void done() {
        if (isCancelled()) {
            return;
        }
        try {
            this.j.c(get());
        } catch (InterruptedException | ExecutionException e) {
            this.j.c(new p<>(e));
        }
    }
}
