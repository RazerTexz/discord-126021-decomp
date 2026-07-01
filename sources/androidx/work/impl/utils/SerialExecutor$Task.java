package androidx.work.impl.utils;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class SerialExecutor$Task implements Runnable {
    public final Runnable mRunnable;
    public final SerialExecutor mSerialExecutor;

    public SerialExecutor$Task(@NonNull SerialExecutor serialExecutor, @NonNull Runnable runnable) {
        this.mSerialExecutor = serialExecutor;
        this.mRunnable = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.mRunnable.run();
        } finally {
            this.mSerialExecutor.scheduleNext();
        }
    }
}
