package b.i.a.b.j.t.h;

import android.app.job.JobParameters;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;

/* JADX INFO: compiled from: JobInfoSchedulerService.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class e implements Runnable {
    public final JobInfoSchedulerService j;
    public final JobParameters k;

    public e(JobInfoSchedulerService jobInfoSchedulerService, JobParameters jobParameters) {
        this.j = jobInfoSchedulerService;
        this.k = jobParameters;
    }

    @Override // java.lang.Runnable
    public void run() {
        JobInfoSchedulerService jobInfoSchedulerService = this.j;
        JobParameters jobParameters = this.k;
        int i = JobInfoSchedulerService.j;
        jobInfoSchedulerService.jobFinished(jobParameters, false);
    }
}
