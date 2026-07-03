package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Base64;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import p007b.p225i.p226a.p228b.p231j.AbstractC2442i;
import p007b.p225i.p226a.p228b.p231j.C2435b;
import p007b.p225i.p226a.p228b.p231j.C2447n;
import p007b.p225i.p226a.p228b.p231j.p236t.p237h.C2484l;
import p007b.p225i.p226a.p228b.p231j.p236t.p237h.RunnableC2479g;
import p007b.p225i.p226a.p228b.p231j.p241w.C2524a;

/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(api = 21)
public class JobInfoSchedulerService extends JobService {

    /* JADX INFO: renamed from: j */
    public static final /* synthetic */ int f19693j = 0;

    @Override // android.app.job.JobService
    public boolean onStartJob(final JobParameters jobParameters) {
        String string = jobParameters.getExtras().getString("backendName");
        String string2 = jobParameters.getExtras().getString(NotificationCompat.MessagingStyle.Message.KEY_EXTRAS_BUNDLE);
        int i = jobParameters.getExtras().getInt("priority");
        int i2 = jobParameters.getExtras().getInt("attemptNumber");
        C2447n.m2360b(getApplicationContext());
        AbstractC2442i.a aVarM2358a = AbstractC2442i.m2358a();
        aVarM2358a.mo2352b(string);
        aVarM2358a.mo2353c(C2524a.m2415b(i));
        if (string2 != null) {
            ((C2435b.b) aVarM2358a).f5262b = Base64.decode(string2, 0);
        }
        C2484l c2484l = C2447n.m2359a().f5294e;
        c2484l.f5389e.execute(new RunnableC2479g(c2484l, aVarM2358a.mo2351a(), i2, new Runnable(this, jobParameters) { // from class: b.i.a.b.j.t.h.e

            /* JADX INFO: renamed from: j */
            public final JobInfoSchedulerService f5364j;

            /* JADX INFO: renamed from: k */
            public final JobParameters f5365k;

            {
                this.f5364j = this;
                this.f5365k = jobParameters;
            }

            @Override // java.lang.Runnable
            public void run() {
                JobInfoSchedulerService jobInfoSchedulerService = this.f5364j;
                JobParameters jobParameters2 = this.f5365k;
                int i3 = JobInfoSchedulerService.f19693j;
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
