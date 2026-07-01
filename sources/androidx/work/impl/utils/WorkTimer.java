package androidx.work.impl.utils;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import androidx.annotation.VisibleForTesting;
import androidx.work.Logger;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo$Scope.LIBRARY_GROUP})
public class WorkTimer {
    private static final String TAG = Logger.tagWithPrefix("WorkTimer");
    private final ThreadFactory mBackgroundThreadFactory;
    private final ScheduledExecutorService mExecutorService;
    public final Map<String, WorkTimer$TimeLimitExceededListener> mListeners;
    public final Object mLock;
    public final Map<String, WorkTimer$WorkTimerRunnable> mTimerMap;

    public WorkTimer() {
        WorkTimer$1 workTimer$1 = new WorkTimer$1(this);
        this.mBackgroundThreadFactory = workTimer$1;
        this.mTimerMap = new HashMap();
        this.mListeners = new HashMap();
        this.mLock = new Object();
        this.mExecutorService = Executors.newSingleThreadScheduledExecutor(workTimer$1);
    }

    @NonNull
    @VisibleForTesting
    public ScheduledExecutorService getExecutorService() {
        return this.mExecutorService;
    }

    @NonNull
    @VisibleForTesting
    public synchronized Map<String, WorkTimer$TimeLimitExceededListener> getListeners() {
        return this.mListeners;
    }

    @NonNull
    @VisibleForTesting
    public synchronized Map<String, WorkTimer$WorkTimerRunnable> getTimerMap() {
        return this.mTimerMap;
    }

    public void onDestroy() {
        if (this.mExecutorService.isShutdown()) {
            return;
        }
        this.mExecutorService.shutdownNow();
    }

    public void startTimer(@NonNull String str, long j, @NonNull WorkTimer$TimeLimitExceededListener workTimer$TimeLimitExceededListener) {
        synchronized (this.mLock) {
            Logger.get().debug(TAG, String.format("Starting timer for %s", str), new Throwable[0]);
            stopTimer(str);
            WorkTimer$WorkTimerRunnable workTimer$WorkTimerRunnable = new WorkTimer$WorkTimerRunnable(this, str);
            this.mTimerMap.put(str, workTimer$WorkTimerRunnable);
            this.mListeners.put(str, workTimer$TimeLimitExceededListener);
            this.mExecutorService.schedule(workTimer$WorkTimerRunnable, j, TimeUnit.MILLISECONDS);
        }
    }

    public void stopTimer(@NonNull String str) {
        synchronized (this.mLock) {
            if (this.mTimerMap.remove(str) != null) {
                Logger.get().debug(TAG, String.format("Stopping timer for %s", str), new Throwable[0]);
                this.mListeners.remove(str);
            }
        }
    }
}
