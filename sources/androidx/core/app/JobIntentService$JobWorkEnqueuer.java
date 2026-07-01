package androidx.core.app;

import android.app.job.JobInfo;
import android.app.job.JobInfo$Builder;
import android.app.job.JobScheduler;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(26)
public final class JobIntentService$JobWorkEnqueuer extends JobIntentService$WorkEnqueuer {
    private final JobInfo mJobInfo;
    private final JobScheduler mJobScheduler;

    public JobIntentService$JobWorkEnqueuer(Context context, ComponentName componentName, int i) {
        super(componentName);
        ensureJobId(i);
        this.mJobInfo = new JobInfo$Builder(i, this.mComponentName).setOverrideDeadline(0L).build();
        this.mJobScheduler = (JobScheduler) context.getApplicationContext().getSystemService("jobscheduler");
    }

    @Override // androidx.core.app.JobIntentService$WorkEnqueuer
    public void enqueueWork(Intent intent) {
        this.mJobScheduler.enqueue(this.mJobInfo, new JobWorkItem(intent));
    }
}
