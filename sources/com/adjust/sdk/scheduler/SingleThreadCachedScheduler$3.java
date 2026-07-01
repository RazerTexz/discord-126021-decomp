package com.adjust.sdk.scheduler;

/* JADX INFO: loaded from: classes.dex */
public class SingleThreadCachedScheduler$3 implements Runnable {
    public final /* synthetic */ SingleThreadCachedScheduler this$0;
    public final /* synthetic */ Runnable val$firstRunnable;

    public SingleThreadCachedScheduler$3(SingleThreadCachedScheduler singleThreadCachedScheduler, Runnable runnable) {
        this.this$0 = singleThreadCachedScheduler;
        this.val$firstRunnable = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable runnable;
        SingleThreadCachedScheduler.access$000(this.this$0, this.val$firstRunnable);
        while (true) {
            synchronized (SingleThreadCachedScheduler.access$100(this.this$0)) {
                if (SingleThreadCachedScheduler.access$200(this.this$0)) {
                    return;
                }
                if (SingleThreadCachedScheduler.access$100(this.this$0).isEmpty()) {
                    SingleThreadCachedScheduler.access$302(this.this$0, false);
                    return;
                } else {
                    runnable = (Runnable) SingleThreadCachedScheduler.access$100(this.this$0).get(0);
                    SingleThreadCachedScheduler.access$100(this.this$0).remove(0);
                }
            }
            SingleThreadCachedScheduler.access$000(this.this$0, runnable);
        }
    }
}
