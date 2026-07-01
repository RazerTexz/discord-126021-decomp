package com.discord.stores;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreStream$storeThreadScheduler$1 implements ThreadFactory {
    public static final StoreStream$storeThreadScheduler$1 INSTANCE = new StoreStream$storeThreadScheduler$1();

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Thread thread = new Thread(runnable, storeStream$Companion.getSTORE_THREAD_NAME());
        thread.setPriority((int) 8.0d);
        storeStream$Companion.setSTORE_THREAD_ID(thread.getId());
        return thread;
    }
}
