package com.adjust.sdk.scheduler;

import com.adjust.sdk.AdjustFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class SingleThreadCachedScheduler implements ThreadScheduler {
    private ThreadPoolExecutor threadPoolExecutor;
    private final List<Runnable> queue = new ArrayList();
    private boolean isThreadProcessing = false;
    private boolean isTeardown = false;

    public SingleThreadCachedScheduler(final String str) {
        this.threadPoolExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), new ThreadFactoryWrapper(str), new RejectedExecutionHandler() { // from class: com.adjust.sdk.scheduler.SingleThreadCachedScheduler.1
            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                AdjustFactory.getLogger().warn("Runnable [%s] rejected from [%s] ", runnable.toString(), str);
            }
        });
    }

    private void processQueue(final Runnable runnable) {
        this.threadPoolExecutor.submit(new Runnable() { // from class: com.adjust.sdk.scheduler.SingleThreadCachedScheduler.3
            @Override // java.lang.Runnable
            public void run() {
                Runnable runnable2;
                SingleThreadCachedScheduler.this.tryExecuteRunnable(runnable);
                while (true) {
                    synchronized (SingleThreadCachedScheduler.this.queue) {
                        if (SingleThreadCachedScheduler.this.isTeardown) {
                            return;
                        }
                        if (SingleThreadCachedScheduler.this.queue.isEmpty()) {
                            SingleThreadCachedScheduler.this.isThreadProcessing = false;
                            return;
                        } else {
                            runnable2 = (Runnable) SingleThreadCachedScheduler.this.queue.get(0);
                            SingleThreadCachedScheduler.this.queue.remove(0);
                        }
                    }
                    SingleThreadCachedScheduler.this.tryExecuteRunnable(runnable2);
                }
            }
        });
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
    public void schedule(final Runnable runnable, final long j) {
        synchronized (this.queue) {
            if (this.isTeardown) {
                return;
            }
            this.threadPoolExecutor.submit(new Runnable() { // from class: com.adjust.sdk.scheduler.SingleThreadCachedScheduler.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Thread.sleep(j);
                    } catch (InterruptedException e) {
                        AdjustFactory.getLogger().warn("Sleep delay exception: %s", e.getMessage());
                    }
                    SingleThreadCachedScheduler.this.submit(runnable);
                }
            });
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
