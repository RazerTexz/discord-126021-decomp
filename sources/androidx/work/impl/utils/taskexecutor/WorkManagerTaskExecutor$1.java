package androidx.work.impl.utils.taskexecutor;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class WorkManagerTaskExecutor$1 implements Executor {
    public final /* synthetic */ WorkManagerTaskExecutor this$0;

    public WorkManagerTaskExecutor$1(WorkManagerTaskExecutor workManagerTaskExecutor) {
        this.this$0 = workManagerTaskExecutor;
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NonNull Runnable runnable) {
        this.this$0.postToMainThread(runnable);
    }
}
