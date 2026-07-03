package com.discord.utilities.threading;

import java.util.concurrent.ThreadFactory;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: PriorityThreadFactory.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PriorityThreadFactory implements ThreadFactory {
    private final int threadPriority;

    public PriorityThreadFactory(int i) {
        this.threadPriority = i;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        C12238m.checkNotNullParameter(runnable, "runnable");
        Thread thread = new Thread(runnable);
        thread.setPriority(this.threadPriority);
        return thread;
    }
}
