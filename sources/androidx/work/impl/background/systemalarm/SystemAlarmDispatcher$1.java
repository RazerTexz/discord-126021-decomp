package androidx.work.impl.background.systemalarm;

import android.content.Intent;
import android.os.PowerManager$WakeLock;
import androidx.work.Logger;
import androidx.work.impl.utils.WakeLocks;

/* JADX INFO: loaded from: classes.dex */
public class SystemAlarmDispatcher$1 implements Runnable {
    public final /* synthetic */ SystemAlarmDispatcher this$0;

    public SystemAlarmDispatcher$1(SystemAlarmDispatcher systemAlarmDispatcher) {
        this.this$0 = systemAlarmDispatcher;
    }

    @Override // java.lang.Runnable
    public void run() {
        SystemAlarmDispatcher systemAlarmDispatcher;
        SystemAlarmDispatcher$DequeueAndCheckForCompletion systemAlarmDispatcher$DequeueAndCheckForCompletion;
        synchronized (this.this$0.mIntents) {
            SystemAlarmDispatcher systemAlarmDispatcher2 = this.this$0;
            systemAlarmDispatcher2.mCurrentIntent = systemAlarmDispatcher2.mIntents.get(0);
        }
        Intent intent = this.this$0.mCurrentIntent;
        if (intent != null) {
            String action = intent.getAction();
            int intExtra = this.this$0.mCurrentIntent.getIntExtra("KEY_START_ID", 0);
            Logger logger = Logger.get();
            String str = SystemAlarmDispatcher.TAG;
            logger.debug(str, String.format("Processing command %s, %s", this.this$0.mCurrentIntent, Integer.valueOf(intExtra)), new Throwable[0]);
            PowerManager$WakeLock powerManager$WakeLockNewWakeLock = WakeLocks.newWakeLock(this.this$0.mContext, String.format("%s (%s)", action, Integer.valueOf(intExtra)));
            try {
                Logger.get().debug(str, String.format("Acquiring operation wake lock (%s) %s", action, powerManager$WakeLockNewWakeLock), new Throwable[0]);
                powerManager$WakeLockNewWakeLock.acquire();
                SystemAlarmDispatcher systemAlarmDispatcher3 = this.this$0;
                systemAlarmDispatcher3.mCommandHandler.onHandleIntent(systemAlarmDispatcher3.mCurrentIntent, intExtra, systemAlarmDispatcher3);
                Logger.get().debug(str, String.format("Releasing operation wake lock (%s) %s", action, powerManager$WakeLockNewWakeLock), new Throwable[0]);
                powerManager$WakeLockNewWakeLock.release();
                systemAlarmDispatcher = this.this$0;
                systemAlarmDispatcher$DequeueAndCheckForCompletion = new SystemAlarmDispatcher$DequeueAndCheckForCompletion(systemAlarmDispatcher);
            } catch (Throwable th) {
                try {
                    Logger logger2 = Logger.get();
                    String str2 = SystemAlarmDispatcher.TAG;
                    logger2.error(str2, "Unexpected error in onHandleIntent", th);
                    Logger.get().debug(str2, String.format("Releasing operation wake lock (%s) %s", action, powerManager$WakeLockNewWakeLock), new Throwable[0]);
                    powerManager$WakeLockNewWakeLock.release();
                    systemAlarmDispatcher = this.this$0;
                    systemAlarmDispatcher$DequeueAndCheckForCompletion = new SystemAlarmDispatcher$DequeueAndCheckForCompletion(systemAlarmDispatcher);
                } catch (Throwable th2) {
                    Logger.get().debug(SystemAlarmDispatcher.TAG, String.format("Releasing operation wake lock (%s) %s", action, powerManager$WakeLockNewWakeLock), new Throwable[0]);
                    powerManager$WakeLockNewWakeLock.release();
                    SystemAlarmDispatcher systemAlarmDispatcher4 = this.this$0;
                    systemAlarmDispatcher4.postOnMainThread(new SystemAlarmDispatcher$DequeueAndCheckForCompletion(systemAlarmDispatcher4));
                    throw th2;
                }
            }
            systemAlarmDispatcher.postOnMainThread(systemAlarmDispatcher$DequeueAndCheckForCompletion);
        }
    }
}
