package b.i.a.b.j.t.h;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import android.util.Base64;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.b.Priority3;
import b.i.a.b.j.TransportContext;
import b.i.a.b.j.t.h.SchedulerConfig;
import b.i.a.b.j.t.i.EventStore;
import b.i.a.b.j.w.PriorityMapping;
import com.adjust.sdk.Constants;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;
import java.util.zip.Adler32;

/* JADX INFO: renamed from: b.i.a.b.j.t.h.d, reason: use source file name */
/* JADX INFO: compiled from: JobInfoScheduler.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(api = 21)
public class JobInfoScheduler implements WorkScheduler {
    public final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final EventStore f787b;
    public final SchedulerConfig c;

    public JobInfoScheduler(Context context, EventStore eventStore, SchedulerConfig schedulerConfig) {
        this.a = context;
        this.f787b = eventStore;
        this.c = schedulerConfig;
    }

    @Override // b.i.a.b.j.t.h.WorkScheduler
    public void a(TransportContext transportContext, int i) {
        boolean z2;
        boolean z3;
        char c;
        ComponentName componentName = new ComponentName(this.a, (Class<?>) JobInfoSchedulerService.class);
        JobScheduler jobScheduler = (JobScheduler) this.a.getSystemService("jobscheduler");
        Adler32 adler32 = new Adler32();
        adler32.update(this.a.getPackageName().getBytes(Charset.forName(Constants.ENCODING)));
        adler32.update(transportContext.b().getBytes(Charset.forName(Constants.ENCODING)));
        adler32.update(ByteBuffer.allocate(4).putInt(PriorityMapping.a(transportContext.d())).array());
        if (transportContext.c() != null) {
            adler32.update(transportContext.c());
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
            AnimatableValueParser.X("JobInfoScheduler", "Upload for context %s is already scheduled. Returning...", transportContext);
            return;
        }
        long jH0 = this.f787b.h0(transportContext);
        SchedulerConfig schedulerConfig = this.c;
        JobInfo.Builder builder = new JobInfo.Builder(value, componentName);
        Priority3 priority3D = transportContext.d();
        builder.setMinimumLatency(schedulerConfig.b(priority3D, jH0, i));
        Set<SchedulerConfig.b> setC = schedulerConfig.c().get(priority3D).c();
        if (setC.contains(SchedulerConfig.b.NETWORK_UNMETERED)) {
            builder.setRequiredNetworkType(2);
            z3 = true;
        } else {
            z3 = true;
            builder.setRequiredNetworkType(1);
        }
        if (setC.contains(SchedulerConfig.b.DEVICE_CHARGING)) {
            builder.setRequiresCharging(z3);
        }
        if (setC.contains(SchedulerConfig.b.DEVICE_IDLE)) {
            builder.setRequiresDeviceIdle(z3);
        }
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putInt("attemptNumber", i);
        persistableBundle.putString("backendName", transportContext.b());
        persistableBundle.putInt("priority", PriorityMapping.a(transportContext.d()));
        if (transportContext.c() != null) {
            c = 0;
            persistableBundle.putString(NotificationCompat.MessagingStyle.Message.KEY_EXTRAS_BUNDLE, Base64.encodeToString(transportContext.c(), 0));
        } else {
            c = 0;
        }
        builder.setExtras(persistableBundle);
        Object[] objArr = new Object[5];
        objArr[c] = transportContext;
        objArr[1] = Integer.valueOf(value);
        objArr[2] = Long.valueOf(this.c.b(transportContext.d(), jH0, i));
        objArr[3] = Long.valueOf(jH0);
        objArr[4] = Integer.valueOf(i);
        AnimatableValueParser.Y("JobInfoScheduler", "Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", objArr);
        jobScheduler.schedule(builder.build());
    }
}
