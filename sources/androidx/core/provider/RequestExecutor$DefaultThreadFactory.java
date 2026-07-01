package androidx.core.provider;

import androidx.annotation.NonNull;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
public class RequestExecutor$DefaultThreadFactory implements ThreadFactory {
    private int mPriority;
    private String mThreadName;

    public RequestExecutor$DefaultThreadFactory(@NonNull String str, int i) {
        this.mThreadName = str;
        this.mPriority = i;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        return new RequestExecutor$DefaultThreadFactory$ProcessPriorityThread(runnable, this.mThreadName, this.mPriority);
    }
}
