package androidx.work.impl.background.systemalarm;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class SystemAlarmDispatcher$DequeueAndCheckForCompletion implements Runnable {
    private final SystemAlarmDispatcher mDispatcher;

    public SystemAlarmDispatcher$DequeueAndCheckForCompletion(@NonNull SystemAlarmDispatcher systemAlarmDispatcher) {
        this.mDispatcher = systemAlarmDispatcher;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.mDispatcher.dequeueAndCheckForCompletion();
    }
}
