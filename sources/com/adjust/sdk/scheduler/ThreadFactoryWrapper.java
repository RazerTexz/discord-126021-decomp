package com.adjust.sdk.scheduler;

import com.adjust.sdk.AdjustFactory;
import com.adjust.sdk.Constants;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: loaded from: classes.dex */
public class ThreadFactoryWrapper implements ThreadFactory {
    private String source;

    public ThreadFactoryWrapper(String str) {
        this.source = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread threadNewThread = Executors.defaultThreadFactory().newThread(runnable);
        threadNewThread.setPriority(9);
        StringBuilder sbM833U = C1643a.m833U(Constants.THREAD_PREFIX);
        sbM833U.append(threadNewThread.getName());
        sbM833U.append("-");
        sbM833U.append(this.source);
        threadNewThread.setName(sbM833U.toString());
        threadNewThread.setDaemon(true);
        threadNewThread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: com.adjust.sdk.scheduler.ThreadFactoryWrapper.1
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                AdjustFactory.getLogger().error("Thread [%s] with error [%s]", thread.getName(), th.getMessage());
            }
        });
        return threadNewThread;
    }
}
