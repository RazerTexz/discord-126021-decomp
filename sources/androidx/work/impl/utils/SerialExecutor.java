package androidx.work.impl.utils;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class SerialExecutor implements Executor {
    private volatile Runnable mActive;
    private final Executor mExecutor;
    private final ArrayDeque<SerialExecutor$Task> mTasks = new ArrayDeque<>();
    private final Object mLock = new Object();

    public SerialExecutor(@NonNull Executor executor) {
        this.mExecutor = executor;
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NonNull Runnable runnable) {
        synchronized (this.mLock) {
            this.mTasks.add(new SerialExecutor$Task(this, runnable));
            if (this.mActive == null) {
                scheduleNext();
            }
        }
    }

    @NonNull
    @VisibleForTesting
    public Executor getDelegatedExecutor() {
        return this.mExecutor;
    }

    public boolean hasPendingTasks() {
        boolean z2;
        synchronized (this.mLock) {
            z2 = !this.mTasks.isEmpty();
        }
        return z2;
    }

    public void scheduleNext() {
        synchronized (this.mLock) {
            SerialExecutor$Task serialExecutor$TaskPoll = this.mTasks.poll();
            this.mActive = serialExecutor$TaskPoll;
            if (serialExecutor$TaskPoll != null) {
                this.mExecutor.execute(this.mActive);
            }
        }
    }
}
