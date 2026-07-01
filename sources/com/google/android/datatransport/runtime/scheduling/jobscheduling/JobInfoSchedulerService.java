package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Base64;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import b.i.a.b.j.b$b;
import b.i.a.b.j.i;
import b.i.a.b.j.i$a;
import b.i.a.b.j.n;
import b.i.a.b.j.t.h.e;
import b.i.a.b.j.t.h.g;
import b.i.a.b.j.t.h.l;
import b.i.a.b.j.w.a;

/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(api = 21)
public class JobInfoSchedulerService extends JobService {
    public static final /* synthetic */ int j = 0;

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        String string = jobParameters.getExtras().getString("backendName");
        String string2 = jobParameters.getExtras().getString(NotificationCompat$MessagingStyle$Message.KEY_EXTRAS_BUNDLE);
        int i = jobParameters.getExtras().getInt("priority");
        int i2 = jobParameters.getExtras().getInt("attemptNumber");
        n.b(getApplicationContext());
        i$a i_aA = i.a();
        i_aA.b(string);
        i_aA.c(a.b(i));
        if (string2 != null) {
            ((b$b) i_aA).f764b = Base64.decode(string2, 0);
        }
        l lVar = n.a().e;
        lVar.e.execute(new g(lVar, i_aA.a(), i2, new e(this, jobParameters)));
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
