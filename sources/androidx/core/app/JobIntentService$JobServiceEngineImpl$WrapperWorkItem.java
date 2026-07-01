package androidx.core.app;

import android.app.job.JobParameters;
import android.app.job.JobWorkItem;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public final class JobIntentService$JobServiceEngineImpl$WrapperWorkItem implements JobIntentService$GenericWorkItem {
    public final JobWorkItem mJobWork;
    public final /* synthetic */ JobIntentService$JobServiceEngineImpl this$0;

    public JobIntentService$JobServiceEngineImpl$WrapperWorkItem(JobIntentService$JobServiceEngineImpl jobIntentService$JobServiceEngineImpl, JobWorkItem jobWorkItem) {
        this.this$0 = jobIntentService$JobServiceEngineImpl;
        this.mJobWork = jobWorkItem;
    }

    @Override // androidx.core.app.JobIntentService$GenericWorkItem
    public void complete() {
        synchronized (this.this$0.mLock) {
            JobParameters jobParameters = this.this$0.mParams;
            if (jobParameters != null) {
                jobParameters.completeWork(this.mJobWork);
            }
        }
    }

    @Override // androidx.core.app.JobIntentService$GenericWorkItem
    public Intent getIntent() {
        return this.mJobWork.getIntent();
    }
}
