package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Base64;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import b.i.a.b.j.AutoValue_TransportContext;
import b.i.a.b.j.TransportContext;
import b.i.a.b.j.TransportRuntime;
import b.i.a.b.j.t.h.Uploader;
import b.i.a.b.j.t.h.Uploader6;
import b.i.a.b.j.w.PriorityMapping;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;

/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(api = 21)
public class JobInfoSchedulerService extends JobService {
    public static final /* synthetic */ int j = 0;

    @Override // android.app.job.JobService
    public boolean onStartJob(final JobParameters jobParameters) {
        String string = jobParameters.getExtras().getString("backendName");
        String string2 = jobParameters.getExtras().getString(NotificationCompat.MessagingStyle.Message.KEY_EXTRAS_BUNDLE);
        int i = jobParameters.getExtras().getInt("priority");
        int i2 = jobParameters.getExtras().getInt("attemptNumber");
        TransportRuntime.b(getApplicationContext());
        TransportContext.a aVarA = TransportContext.a();
        aVarA.b(string);
        aVarA.c(PriorityMapping.b(i));
        if (string2 != null) {
            ((AutoValue_TransportContext.b) aVarA).f764b = Base64.decode(string2, 0);
        }
        Uploader6 uploader6 = TransportRuntime.a().e;
        uploader6.e.execute(new Uploader(uploader6, aVarA.a(), i2, new Runnable(this, jobParameters) { // from class: b.i.a.b.j.t.h.e
            public final JobInfoSchedulerService j;
            public final JobParameters k;

            {
                this.j = this;
                this.k = jobParameters;
            }

            @Override // java.lang.Runnable
            public void run() {
                JobInfoSchedulerService jobInfoSchedulerService = this.j;
                JobParameters jobParameters2 = this.k;
                int i3 = JobInfoSchedulerService.j;
                jobInfoSchedulerService.jobFinished(jobParameters2, false);
            }
        }));
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
