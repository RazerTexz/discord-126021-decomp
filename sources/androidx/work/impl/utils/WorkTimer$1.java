package androidx.work.impl.utils;

import androidx.annotation.NonNull;
import b.d.b.a.a;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
public class WorkTimer$1 implements ThreadFactory {
    private int mThreadsCreated = 0;
    public final /* synthetic */ WorkTimer this$0;

    public WorkTimer$1(WorkTimer workTimer) {
        this.this$0 = workTimer;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(@NonNull Runnable runnable) {
        Thread threadNewThread = Executors.defaultThreadFactory().newThread(runnable);
        StringBuilder sbU = a.U("WorkManager-WorkTimer-thread-");
        sbU.append(this.mThreadsCreated);
        threadNewThread.setName(sbU.toString());
        this.mThreadsCreated++;
        return threadNewThread;
    }
}
