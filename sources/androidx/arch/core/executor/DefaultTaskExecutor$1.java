package androidx.arch.core.executor;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class DefaultTaskExecutor$1 implements ThreadFactory {
    private static final String THREAD_NAME_STEM = "arch_disk_io_%d";
    private final AtomicInteger mThreadId = new AtomicInteger(0);
    public final /* synthetic */ DefaultTaskExecutor this$0;

    public DefaultTaskExecutor$1(DefaultTaskExecutor defaultTaskExecutor) {
        this.this$0 = defaultTaskExecutor;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setName(String.format(THREAD_NAME_STEM, Integer.valueOf(this.mThreadId.getAndIncrement())));
        return thread;
    }
}
