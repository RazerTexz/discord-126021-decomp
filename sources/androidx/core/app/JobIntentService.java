package androidx.core.app;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build$VERSION;
import android.os.IBinder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class JobIntentService extends Service {
    public static final boolean DEBUG = false;
    public static final String TAG = "JobIntentService";
    public final ArrayList<JobIntentService$CompatWorkItem> mCompatQueue;
    public JobIntentService$WorkEnqueuer mCompatWorkEnqueuer;
    public JobIntentService$CommandProcessor mCurProcessor;
    public JobIntentService$CompatJobEngine mJobImpl;
    public static final Object sLock = new Object();
    public static final HashMap<ComponentName, JobIntentService$WorkEnqueuer> sClassWorkEnqueuer = new HashMap<>();
    public boolean mInterruptIfStopped = false;
    public boolean mStopped = false;
    public boolean mDestroyed = false;

    public JobIntentService() {
        if (Build$VERSION.SDK_INT >= 26) {
            this.mCompatQueue = null;
        } else {
            this.mCompatQueue = new ArrayList<>();
        }
    }

    public static void enqueueWork(@NonNull Context context, @NonNull Class<?> cls, int i, @NonNull Intent intent) {
        enqueueWork(context, new ComponentName(context, cls), i, intent);
    }

    public static JobIntentService$WorkEnqueuer getWorkEnqueuer(Context context, ComponentName componentName, boolean z2, int i) {
        JobIntentService$WorkEnqueuer jobIntentService$CompatWorkEnqueuer;
        HashMap<ComponentName, JobIntentService$WorkEnqueuer> map = sClassWorkEnqueuer;
        JobIntentService$WorkEnqueuer jobIntentService$WorkEnqueuer = map.get(componentName);
        if (jobIntentService$WorkEnqueuer != null) {
            return jobIntentService$WorkEnqueuer;
        }
        if (Build$VERSION.SDK_INT < 26) {
            jobIntentService$CompatWorkEnqueuer = new JobIntentService$CompatWorkEnqueuer(context, componentName);
        } else {
            if (!z2) {
                throw new IllegalArgumentException("Can't be here without a job id");
            }
            jobIntentService$CompatWorkEnqueuer = new JobIntentService$JobWorkEnqueuer(context, componentName, i);
        }
        JobIntentService$WorkEnqueuer jobIntentService$WorkEnqueuer2 = jobIntentService$CompatWorkEnqueuer;
        map.put(componentName, jobIntentService$WorkEnqueuer2);
        return jobIntentService$WorkEnqueuer2;
    }

    public JobIntentService$GenericWorkItem dequeueWork() {
        JobIntentService$CompatJobEngine jobIntentService$CompatJobEngine = this.mJobImpl;
        if (jobIntentService$CompatJobEngine != null) {
            return jobIntentService$CompatJobEngine.dequeueWork();
        }
        synchronized (this.mCompatQueue) {
            if (this.mCompatQueue.size() <= 0) {
                return null;
            }
            return this.mCompatQueue.remove(0);
        }
    }

    public boolean doStopCurrentWork() {
        JobIntentService$CommandProcessor jobIntentService$CommandProcessor = this.mCurProcessor;
        if (jobIntentService$CommandProcessor != null) {
            jobIntentService$CommandProcessor.cancel(this.mInterruptIfStopped);
        }
        this.mStopped = true;
        return onStopCurrentWork();
    }

    public void ensureProcessorRunningLocked(boolean z2) {
        if (this.mCurProcessor == null) {
            this.mCurProcessor = new JobIntentService$CommandProcessor(this);
            JobIntentService$WorkEnqueuer jobIntentService$WorkEnqueuer = this.mCompatWorkEnqueuer;
            if (jobIntentService$WorkEnqueuer != null && z2) {
                jobIntentService$WorkEnqueuer.serviceProcessingStarted();
            }
            this.mCurProcessor.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    public boolean isStopped() {
        return this.mStopped;
    }

    @Override // android.app.Service
    public IBinder onBind(@NonNull Intent intent) {
        JobIntentService$CompatJobEngine jobIntentService$CompatJobEngine = this.mJobImpl;
        if (jobIntentService$CompatJobEngine != null) {
            return jobIntentService$CompatJobEngine.compatGetBinder();
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (Build$VERSION.SDK_INT >= 26) {
            this.mJobImpl = new JobIntentService$JobServiceEngineImpl(this);
            this.mCompatWorkEnqueuer = null;
        } else {
            this.mJobImpl = null;
            this.mCompatWorkEnqueuer = getWorkEnqueuer(this, new ComponentName(this, getClass()), false, 0);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        ArrayList<JobIntentService$CompatWorkItem> arrayList = this.mCompatQueue;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.mDestroyed = true;
                this.mCompatWorkEnqueuer.serviceProcessingFinished();
            }
        }
    }

    public abstract void onHandleWork(@NonNull Intent intent);

    @Override // android.app.Service
    public int onStartCommand(@Nullable Intent intent, int i, int i2) {
        if (this.mCompatQueue == null) {
            return 2;
        }
        this.mCompatWorkEnqueuer.serviceStartReceived();
        synchronized (this.mCompatQueue) {
            ArrayList<JobIntentService$CompatWorkItem> arrayList = this.mCompatQueue;
            if (intent == null) {
                intent = new Intent();
            }
            arrayList.add(new JobIntentService$CompatWorkItem(this, intent, i2));
            ensureProcessorRunningLocked(true);
        }
        return 3;
    }

    public boolean onStopCurrentWork() {
        return true;
    }

    public void processorFinished() {
        ArrayList<JobIntentService$CompatWorkItem> arrayList = this.mCompatQueue;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.mCurProcessor = null;
                ArrayList<JobIntentService$CompatWorkItem> arrayList2 = this.mCompatQueue;
                if (arrayList2 != null && arrayList2.size() > 0) {
                    ensureProcessorRunningLocked(false);
                } else if (!this.mDestroyed) {
                    this.mCompatWorkEnqueuer.serviceProcessingFinished();
                }
            }
        }
    }

    public void setInterruptIfStopped(boolean z2) {
        this.mInterruptIfStopped = z2;
    }

    public static void enqueueWork(@NonNull Context context, @NonNull ComponentName componentName, int i, @NonNull Intent intent) {
        if (intent == null) {
            throw new IllegalArgumentException("work must not be null");
        }
        synchronized (sLock) {
            JobIntentService$WorkEnqueuer workEnqueuer = getWorkEnqueuer(context, componentName, true, i);
            workEnqueuer.ensureJobId(i);
            workEnqueuer.enqueueWork(intent);
        }
    }
}
