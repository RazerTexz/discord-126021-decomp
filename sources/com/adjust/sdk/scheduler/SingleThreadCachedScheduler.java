package com.adjust.sdk.scheduler;

import com.adjust.sdk.AdjustFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class SingleThreadCachedScheduler implements ThreadScheduler {
    private ThreadPoolExecutor threadPoolExecutor;
    private final List<Runnable> queue = new ArrayList();
    private boolean isThreadProcessing = false;
    private boolean isTeardown = false;

    public SingleThreadCachedScheduler(String str) {
        this.threadPoolExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), new ThreadFactoryWrapper(str), new SingleThreadCachedScheduler$1(this, str));
    }

    public static /* synthetic */ void access$000(SingleThreadCachedScheduler singleThreadCachedScheduler, Runnable runnable) {
        singleThreadCachedScheduler.tryExecuteRunnable(runnable);
    }

    public static /* synthetic */ List access$100(SingleThreadCachedScheduler singleThreadCachedScheduler) {
        return singleThreadCachedScheduler.queue;
    }

    public static /* synthetic */ boolean access$200(SingleThreadCachedScheduler singleThreadCachedScheduler) {
        return singleThreadCachedScheduler.isTeardown;
    }

    public static /* synthetic */ boolean access$302(SingleThreadCachedScheduler singleThreadCachedScheduler, boolean z2) {
        singleThreadCachedScheduler.isThreadProcessing = z2;
        return z2;
    }

    private void processQueue(Runnable runnable) {
        this.threadPoolExecutor.submit(new SingleThreadCachedScheduler$3(this, runnable));
    }

    private void tryExecuteRunnable(Runnable runnable) {
        try {
            if (this.isTeardown) {
                return;
            }
            runnable.run();
        } catch (Throwable th) {
            AdjustFactory.getLogger().warn("Execution failed: %s", th.getMessage());
        }
    }

    @Override // com.adjust.sdk.scheduler.ThreadScheduler
    public void schedule(Runnable runnable, long j) {
        synchronized (this.queue) {
            if (this.isTeardown) {
                return;
            }
            this.threadPoolExecutor.submit(new SingleThreadCachedScheduler$2(this, j, runnable));
        }
    }

    @Override // com.adjust.sdk.scheduler.ThreadExecutor
    public void submit(Runnable runnable) {
        synchronized (this.queue) {
            if (this.isTeardown) {
                return;
            }
            if (this.isThreadProcessing) {
                this.queue.add(runnable);
            } else {
                this.isThreadProcessing = true;
                processQueue(runnable);
            }
        }
    }

    @Override // com.adjust.sdk.scheduler.ThreadExecutor
    public void teardown() {
        synchronized (this.queue) {
            this.isTeardown = true;
            this.queue.clear();
            this.threadPoolExecutor.shutdown();
        }
    }
}
