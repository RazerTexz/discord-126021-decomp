package androidx.core.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.PowerManager$WakeLock;
import androidx.work.impl.background.systemalarm.CommandHandler;

/* JADX INFO: loaded from: classes.dex */
public final class JobIntentService$CompatWorkEnqueuer extends JobIntentService$WorkEnqueuer {
    private final Context mContext;
    private final PowerManager$WakeLock mLaunchWakeLock;
    public boolean mLaunchingService;
    private final PowerManager$WakeLock mRunWakeLock;
    public boolean mServiceProcessing;

    public JobIntentService$CompatWorkEnqueuer(Context context, ComponentName componentName) {
        super(componentName);
        this.mContext = context.getApplicationContext();
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        PowerManager$WakeLock powerManager$WakeLockNewWakeLock = powerManager.newWakeLock(1, componentName.getClassName() + ":launch");
        this.mLaunchWakeLock = powerManager$WakeLockNewWakeLock;
        powerManager$WakeLockNewWakeLock.setReferenceCounted(false);
        PowerManager$WakeLock powerManager$WakeLockNewWakeLock2 = powerManager.newWakeLock(1, componentName.getClassName() + ":run");
        this.mRunWakeLock = powerManager$WakeLockNewWakeLock2;
        powerManager$WakeLockNewWakeLock2.setReferenceCounted(false);
    }

    @Override // androidx.core.app.JobIntentService$WorkEnqueuer
    public void enqueueWork(Intent intent) {
        Intent intent2 = new Intent(intent);
        intent2.setComponent(this.mComponentName);
        if (this.mContext.startService(intent2) != null) {
            synchronized (this) {
                if (!this.mLaunchingService) {
                    this.mLaunchingService = true;
                    if (!this.mServiceProcessing) {
                        this.mLaunchWakeLock.acquire(60000L);
                    }
                }
            }
        }
    }

    @Override // androidx.core.app.JobIntentService$WorkEnqueuer
    public void serviceProcessingFinished() {
        synchronized (this) {
            if (this.mServiceProcessing) {
                if (this.mLaunchingService) {
                    this.mLaunchWakeLock.acquire(60000L);
                }
                this.mServiceProcessing = false;
                this.mRunWakeLock.release();
            }
        }
    }

    @Override // androidx.core.app.JobIntentService$WorkEnqueuer
    public void serviceProcessingStarted() {
        synchronized (this) {
            if (!this.mServiceProcessing) {
                this.mServiceProcessing = true;
                this.mRunWakeLock.acquire(CommandHandler.WORK_PROCESSING_TIME_IN_MS);
                this.mLaunchWakeLock.release();
            }
        }
    }

    @Override // androidx.core.app.JobIntentService$WorkEnqueuer
    public void serviceStartReceived() {
        synchronized (this) {
            this.mLaunchingService = false;
        }
    }
}
