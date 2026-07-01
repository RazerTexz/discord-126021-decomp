package androidx.work.impl.background.systemalarm;

import android.content.Intent;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class SystemAlarmDispatcher$AddRunnable implements Runnable {
    private final SystemAlarmDispatcher mDispatcher;
    private final Intent mIntent;
    private final int mStartId;

    public SystemAlarmDispatcher$AddRunnable(@NonNull SystemAlarmDispatcher systemAlarmDispatcher, @NonNull Intent intent, int i) {
        this.mDispatcher = systemAlarmDispatcher;
        this.mIntent = intent;
        this.mStartId = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.mDispatcher.add(this.mIntent, this.mStartId);
    }
}
