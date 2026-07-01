package androidx.work.impl.utils;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import androidx.work.Logger;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo$Scope.LIBRARY_GROUP})
public class WorkTimer$WorkTimerRunnable implements Runnable {
    public static final String TAG = "WrkTimerRunnable";
    private final String mWorkSpecId;
    private final WorkTimer mWorkTimer;

    public WorkTimer$WorkTimerRunnable(@NonNull WorkTimer workTimer, @NonNull String str) {
        this.mWorkTimer = workTimer;
        this.mWorkSpecId = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.mWorkTimer.mLock) {
            if (this.mWorkTimer.mTimerMap.remove(this.mWorkSpecId) != null) {
                WorkTimer$TimeLimitExceededListener workTimer$TimeLimitExceededListenerRemove = this.mWorkTimer.mListeners.remove(this.mWorkSpecId);
                if (workTimer$TimeLimitExceededListenerRemove != null) {
                    workTimer$TimeLimitExceededListenerRemove.onTimeLimitExceeded(this.mWorkSpecId);
                }
            } else {
                Logger.get().debug(TAG, String.format("Timer with %s is already marked as complete.", this.mWorkSpecId), new Throwable[0]);
            }
        }
    }
}
