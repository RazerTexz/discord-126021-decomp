package com.discord.utilities.threading;

import d0.z.d.Intrinsics3;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: PriorityThreadFactory.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PriorityThreadFactory implements ThreadFactory {
    private final int threadPriority;

    public PriorityThreadFactory(int i) {
        this.threadPriority = i;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Intrinsics3.checkNotNullParameter(runnable, "runnable");
        Thread thread = new Thread(runnable);
        thread.setPriority(this.threadPriority);
        return thread;
    }
}
