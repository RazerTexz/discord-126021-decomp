package androidx.work.impl.utils;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteAccessPermException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.NotificationCompat;
import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabasePathHelper;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.background.systemjob.SystemJobScheduler;
import androidx.work.impl.model.WorkProgressDao;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ForceStopRunnable implements Runnable {

    @VisibleForTesting
    public static final String ACTION_FORCE_STOP_RESCHEDULE = "ACTION_FORCE_STOP_RESCHEDULE";
    private static final int ALARM_ID = -1;
    private static final String TAG = Logger.tagWithPrefix("ForceStopRunnable");
    private static final long TEN_YEARS = TimeUnit.DAYS.toMillis(3650);
    private final Context mContext;
    private final WorkManagerImpl mWorkManager;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class BroadcastReceiver extends android.content.BroadcastReceiver {
        private static final String TAG = Logger.tagWithPrefix("ForceStopRunnable$Rcvr");

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || !ForceStopRunnable.ACTION_FORCE_STOP_RESCHEDULE.equals(intent.getAction())) {
                return;
            }
            Logger.get().verbose(TAG, "Rescheduling alarm that keeps track of force-stops.", new Throwable[0]);
            ForceStopRunnable.setAlarm(context);
        }
    }

    public ForceStopRunnable(@NonNull Context context, @NonNull WorkManagerImpl workManagerImpl) {
        this.mContext = context.getApplicationContext();
        this.mWorkManager = workManagerImpl;
    }

    @VisibleForTesting
    public static Intent getIntent(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, (Class<?>) BroadcastReceiver.class));
        intent.setAction(ACTION_FORCE_STOP_RESCHEDULE);
        return intent;
    }

    private static PendingIntent getPendingIntent(Context context, int i) {
        return PendingIntent.getBroadcast(context, -1, getIntent(context), i);
    }

    public static void setAlarm(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        PendingIntent pendingIntent = getPendingIntent(context, 134217728);
        long jCurrentTimeMillis = System.currentTimeMillis() + TEN_YEARS;
        if (alarmManager != null) {
            alarmManager.setExact(0, jCurrentTimeMillis, pendingIntent);
        }
    }

    @VisibleForTesting
    public boolean cleanUp() {
        if (Build.VERSION.SDK_INT >= 23) {
            SystemJobScheduler.cancelInvalidJobs(this.mContext);
        }
        WorkDatabase workDatabase = this.mWorkManager.getWorkDatabase();
        WorkSpecDao workSpecDao = workDatabase.workSpecDao();
        WorkProgressDao workProgressDao = workDatabase.workProgressDao();
        workDatabase.beginTransaction();
        try {
            List<WorkSpec> runningWork = workSpecDao.getRunningWork();
            boolean z2 = (runningWork == null || runningWork.isEmpty()) ? false : true;
            if (z2) {
                for (WorkSpec workSpec : runningWork) {
                    workSpecDao.setState(WorkInfo.State.ENQUEUED, workSpec.f163id);
                    workSpecDao.markWorkSpecScheduled(workSpec.f163id, -1L);
                }
            }
            workProgressDao.deleteAll();
            workDatabase.setTransactionSuccessful();
            return z2;
        } finally {
            workDatabase.endTransaction();
        }
    }

    @VisibleForTesting
    public boolean isForceStopped() {
        if (getPendingIntent(this.mContext, 536870912) != null) {
            return false;
        }
        setAlarm(this.mContext);
        return true;
    }

    @Override // java.lang.Runnable
    public void run() {
        WorkDatabasePathHelper.migrateDatabase(this.mContext);
        Logger logger = Logger.get();
        String str = TAG;
        logger.debug(str, "Performing cleanup operations.", new Throwable[0]);
        try {
            boolean zCleanUp = cleanUp();
            if (shouldRescheduleWorkers()) {
                Logger.get().debug(str, "Rescheduling Workers.", new Throwable[0]);
                this.mWorkManager.rescheduleEligibleWork();
                this.mWorkManager.getPreferenceUtils().setNeedsReschedule(false);
            } else if (isForceStopped()) {
                Logger.get().debug(str, "Application was force-stopped, rescheduling.", new Throwable[0]);
                this.mWorkManager.rescheduleEligibleWork();
            } else if (zCleanUp) {
                Logger.get().debug(str, "Found unfinished work, scheduling it.", new Throwable[0]);
                Schedulers.schedule(this.mWorkManager.getConfiguration(), this.mWorkManager.getWorkDatabase(), this.mWorkManager.getSchedulers());
            }
            this.mWorkManager.onForceStopRunnableCompleted();
        } catch (SQLiteAccessPermException | SQLiteCantOpenDatabaseException | SQLiteDatabaseCorruptException e) {
            Logger.get().error(TAG, "The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e);
            throw new IllegalStateException("The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e);
        }
    }

    @VisibleForTesting
    public boolean shouldRescheduleWorkers() {
        return this.mWorkManager.getPreferenceUtils().getNeedsReschedule();
    }
}
