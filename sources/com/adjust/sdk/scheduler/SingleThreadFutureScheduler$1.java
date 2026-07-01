package com.adjust.sdk.scheduler;

import com.adjust.sdk.AdjustFactory;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes.dex */
public class SingleThreadFutureScheduler$1 implements RejectedExecutionHandler {
    public final /* synthetic */ SingleThreadFutureScheduler this$0;
    public final /* synthetic */ String val$source;

    public SingleThreadFutureScheduler$1(SingleThreadFutureScheduler singleThreadFutureScheduler, String str) {
        this.this$0 = singleThreadFutureScheduler;
        this.val$source = str;
    }

    @Override // java.util.concurrent.RejectedExecutionHandler
    public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        AdjustFactory.getLogger().warn("Runnable [%s] rejected from [%s] ", runnable.toString(), this.val$source);
    }
}
