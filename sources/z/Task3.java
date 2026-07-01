package z;

import bolts.ExecutorException;
import java.util.concurrent.Executor;

/* JADX INFO: Add missing generic type declarations: [TResult] */
/* JADX INFO: renamed from: z.d, reason: use source file name */
/* JADX INFO: compiled from: Task.java */
/* JADX INFO: loaded from: classes.dex */
public class Task3<TResult> implements Continuation3<TResult, Void> {
    public final /* synthetic */ TaskCompletionSource2 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Continuation3 f3859b;
    public final /* synthetic */ Executor c;

    public Task3(Task6 task6, TaskCompletionSource2 taskCompletionSource2, Continuation3 continuation3, Executor executor) {
        this.a = taskCompletionSource2;
        this.f3859b = continuation3;
        this.c = executor;
    }

    @Override // z.Continuation3
    public Void a(Task6 task6) throws Exception {
        TaskCompletionSource2 taskCompletionSource2 = this.a;
        Continuation3 continuation3 = this.f3859b;
        try {
            this.c.execute(new Task4(taskCompletionSource2, continuation3, task6));
            return null;
        } catch (Exception e) {
            taskCompletionSource2.b(new ExecutorException(e));
            return null;
        }
    }
}
