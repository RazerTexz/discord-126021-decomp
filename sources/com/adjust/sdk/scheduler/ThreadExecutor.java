package com.adjust.sdk.scheduler;

/* JADX INFO: loaded from: classes.dex */
public interface ThreadExecutor {
    void submit(Runnable runnable);

    void teardown();
}
