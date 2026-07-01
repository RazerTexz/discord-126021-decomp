package com.adjust.sdk.scheduler;

import com.adjust.sdk.AdjustFactory;

/* JADX INFO: loaded from: classes.dex */
public class ThreadFactoryWrapper$1 implements Thread$UncaughtExceptionHandler {
    public final /* synthetic */ ThreadFactoryWrapper this$0;

    public ThreadFactoryWrapper$1(ThreadFactoryWrapper threadFactoryWrapper) {
        this.this$0 = threadFactoryWrapper;
    }

    @Override // java.lang.Thread$UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        AdjustFactory.getLogger().error("Thread [%s] with error [%s]", thread.getName(), th.getMessage());
    }
}
