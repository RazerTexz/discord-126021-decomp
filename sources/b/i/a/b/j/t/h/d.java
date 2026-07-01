package b.i.a.b.j.t.h;

import android.app.job.JobInfo;
import android.app.job.JobInfo$Builder;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import android.util.Base64;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import com.adjust.sdk.Constants;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;
import java.util.zip.Adler32;

/* JADX INFO: compiled from: JobInfoScheduler.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(api = 21)
public class d implements r {
    public final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.i.a.b.j.t.i.c f787b;
    public final f c;

    public d(Context context, b.i.a.b.j.t.i.c cVar, f fVar) {
        this.a = context;
        this.f787b = cVar;
        this.c = fVar;
    }

    @Override // b.i.a.b.j.t.h.r
    public void a(b.i.a.b.j.i iVar, int i) {
        boolean z2;
        boolean z3;
        char c;
        ComponentName componentName = new ComponentName(this.a, (Class<?>) JobInfoSchedulerService.class);
        JobScheduler jobScheduler = (JobScheduler) this.a.getSystemService("jobscheduler");
        Adler32 adler32 = new Adler32();
        adler32.update(this.a.getPackageName().getBytes(Charset.forName(Constants.ENCODING)));
        adler32.update(iVar.b().getBytes(Charset.forName(Constants.ENCODING)));
        adler32.update(ByteBuffer.allocate(4).putInt(b.i.a.b.j.w.a.a(iVar.d())).array());
        if (iVar.c() != null) {
            adler32.update(iVar.c());
        }
        int value = (int) adler32.getValue();
        Iterator<JobInfo> it = jobScheduler.getAllPendingJobs().iterator();
        while (true) {
            if (it.hasNext()) {
                JobInfo next = it.next();
                int i2 = next.getExtras().getInt("attemptNumber");
                if (next.getId() == value) {
                    if (i2 >= i) {
                        z2 = true;
                        break;
                    }
                }
            }
            z2 = false;
            break;
        }
        if (z2) {
            b.c.a.a0.d.X("JobInfoScheduler", "Upload for context %s is already scheduled. Returning...", iVar);
            return;
        }
        long jH0 = this.f787b.h0(iVar);
        f fVar = this.c;
        JobInfo$Builder jobInfo$Builder = new JobInfo$Builder(value, componentName);
        b.i.a.b.d dVarD = iVar.d();
        jobInfo$Builder.setMinimumLatency(fVar.b(dVarD, jH0, i));
        Set<f$b> setC = fVar.c().get(dVarD).c();
        if (setC.contains(f$b.NETWORK_UNMETERED)) {
            jobInfo$Builder.setRequiredNetworkType(2);
            z3 = true;
        } else {
            z3 = true;
            jobInfo$Builder.setRequiredNetworkType(1);
        }
        if (setC.contains(f$b.DEVICE_CHARGING)) {
            jobInfo$Builder.setRequiresCharging(z3);
        }
        if (setC.contains(f$b.DEVICE_IDLE)) {
            jobInfo$Builder.setRequiresDeviceIdle(z3);
        }
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putInt("attemptNumber", i);
        persistableBundle.putString("backendName", iVar.b());
        persistableBundle.putInt("priority", b.i.a.b.j.w.a.a(iVar.d()));
        if (iVar.c() != null) {
            c = 0;
            persistableBundle.putString(NotificationCompat$MessagingStyle$Message.KEY_EXTRAS_BUNDLE, Base64.encodeToString(iVar.c(), 0));
        } else {
            c = 0;
        }
        jobInfo$Builder.setExtras(persistableBundle);
        Object[] objArr = new Object[5];
        objArr[c] = iVar;
        objArr[1] = Integer.valueOf(value);
        objArr[2] = Long.valueOf(this.c.b(iVar.d(), jH0, i));
        objArr[3] = Long.valueOf(jH0);
        objArr[4] = Integer.valueOf(i);
        b.c.a.a0.d.Y("JobInfoScheduler", "Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", objArr);
        jobScheduler.schedule(jobInfo$Builder.build());
    }
}
