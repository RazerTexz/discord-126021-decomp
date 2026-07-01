package com.adjust.sdk.scheduler;

import com.adjust.sdk.AdjustFactory;
import java.util.concurrent.Callable;

/* JADX INFO: Add missing generic type declarations: [V] */
/* JADX INFO: loaded from: classes.dex */
public class SingleThreadFutureScheduler$2<V> implements Callable<V> {
    public final /* synthetic */ SingleThreadFutureScheduler this$0;
    public final /* synthetic */ Callable val$callable;

    public SingleThreadFutureScheduler$2(SingleThreadFutureScheduler singleThreadFutureScheduler, Callable callable) {
        this.this$0 = singleThreadFutureScheduler;
        this.val$callable = callable;
    }

    @Override // java.util.concurrent.Callable
    public V call() {
        try {
            return (V) this.val$callable.call();
        } catch (Throwable th) {
            AdjustFactory.getLogger().error("Callable error [%s] of type [%s]", th.getMessage(), th.getClass().getCanonicalName());
            return null;
        }
    }
}
