package com.adjust.sdk.scheduler;

import com.adjust.sdk.AdjustFactory;

/* JADX INFO: loaded from: classes.dex */
public class SingleThreadCachedScheduler$2 implements Runnable {
    public final /* synthetic */ SingleThreadCachedScheduler this$0;
    public final /* synthetic */ long val$millisecondsDelay;
    public final /* synthetic */ Runnable val$task;

    public SingleThreadCachedScheduler$2(SingleThreadCachedScheduler singleThreadCachedScheduler, long j, Runnable runnable) {
        this.this$0 = singleThreadCachedScheduler;
        this.val$millisecondsDelay = j;
        this.val$task = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            Thread.sleep(this.val$millisecondsDelay);
        } catch (InterruptedException e) {
            AdjustFactory.getLogger().warn("Sleep delay exception: %s", e.getMessage());
        }
        this.this$0.submit(this.val$task);
    }
}
