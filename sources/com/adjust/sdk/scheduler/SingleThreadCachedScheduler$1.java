package com.adjust.sdk.scheduler;

import com.adjust.sdk.AdjustFactory;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes.dex */
public class SingleThreadCachedScheduler$1 implements RejectedExecutionHandler {
    public final /* synthetic */ SingleThreadCachedScheduler this$0;
    public final /* synthetic */ String val$source;

    public SingleThreadCachedScheduler$1(SingleThreadCachedScheduler singleThreadCachedScheduler, String str) {
        this.this$0 = singleThreadCachedScheduler;
        this.val$source = str;
    }

    @Override // java.util.concurrent.RejectedExecutionHandler
    public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        AdjustFactory.getLogger().warn("Runnable [%s] rejected from [%s] ", runnable.toString(), this.val$source);
    }
}
