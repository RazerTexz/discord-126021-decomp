package com.adjust.sdk.scheduler;

import b.d.b.a.a;
import com.adjust.sdk.Constants;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

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
        StringBuilder sbU = a.U(Constants.THREAD_PREFIX);
        sbU.append(threadNewThread.getName());
        sbU.append("-");
        sbU.append(this.source);
        threadNewThread.setName(sbU.toString());
        threadNewThread.setDaemon(true);
        threadNewThread.setUncaughtExceptionHandler(new ThreadFactoryWrapper$1(this));
        return threadNewThread;
    }
}
