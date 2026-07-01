package androidx.core.app;

import android.app.job.JobParameters;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.os.IBinder;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(26)
public final class JobIntentService$JobServiceEngineImpl extends JobServiceEngine implements JobIntentService$CompatJobEngine {
    public static final boolean DEBUG = false;
    public static final String TAG = "JobServiceEngineImpl";
    public final Object mLock;
    public JobParameters mParams;
    public final JobIntentService mService;

    public JobIntentService$JobServiceEngineImpl(JobIntentService jobIntentService) {
        super(jobIntentService);
        this.mLock = new Object();
        this.mService = jobIntentService;
    }

    @Override // androidx.core.app.JobIntentService$CompatJobEngine
    public IBinder compatGetBinder() {
        return getBinder();
    }

    @Override // androidx.core.app.JobIntentService$CompatJobEngine
    public JobIntentService$GenericWorkItem dequeueWork() {
        synchronized (this.mLock) {
            JobParameters jobParameters = this.mParams;
            if (jobParameters == null) {
                return null;
            }
            JobWorkItem jobWorkItemDequeueWork = jobParameters.dequeueWork();
            if (jobWorkItemDequeueWork == null) {
                return null;
            }
            jobWorkItemDequeueWork.getIntent().setExtrasClassLoader(this.mService.getClassLoader());
            return new JobIntentService$JobServiceEngineImpl$WrapperWorkItem(this, jobWorkItemDequeueWork);
        }
    }

    @Override // android.app.job.JobServiceEngine
    public boolean onStartJob(JobParameters jobParameters) {
        this.mParams = jobParameters;
        this.mService.ensureProcessorRunningLocked(false);
        return true;
    }

    @Override // android.app.job.JobServiceEngine
    public boolean onStopJob(JobParameters jobParameters) {
        boolean zDoStopCurrentWork = this.mService.doStopCurrentWork();
        synchronized (this.mLock) {
            this.mParams = null;
        }
        return zDoStopCurrentWork;
    }
}
