package androidx.core.provider;

import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.core.util.Preconditions;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes.dex */
public class RequestExecutor$HandlerExecutor implements Executor {
    private final Handler mHandler;

    public RequestExecutor$HandlerExecutor(@NonNull Handler handler) {
        this.mHandler = (Handler) Preconditions.checkNotNull(handler);
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NonNull Runnable runnable) {
        if (this.mHandler.post((Runnable) Preconditions.checkNotNull(runnable))) {
            return;
        }
        throw new RejectedExecutionException(this.mHandler + " is shutting down");
    }
}
