package p007b.p225i.p226a.p228b.p231j.p236t.p237h;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import android.util.Base64;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import com.adjust.sdk.Constants;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;
import java.util.zip.Adler32;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p228b.EnumC2409d;
import p007b.p225i.p226a.p228b.p231j.AbstractC2442i;
import p007b.p225i.p226a.p228b.p231j.p236t.p237h.AbstractC2478f;
import p007b.p225i.p226a.p228b.p231j.p236t.p238i.InterfaceC2494c;
import p007b.p225i.p226a.p228b.p231j.p241w.C2524a;

/* JADX INFO: renamed from: b.i.a.b.j.t.h.d */
/* JADX INFO: compiled from: JobInfoScheduler.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(api = 21)
public class C2476d implements InterfaceC2490r {

    /* JADX INFO: renamed from: a */
    public final Context f5361a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC2494c f5362b;

    /* JADX INFO: renamed from: c */
    public final AbstractC2478f f5363c;

    public C2476d(Context context, InterfaceC2494c interfaceC2494c, AbstractC2478f abstractC2478f) {
        this.f5361a = context;
        this.f5362b = interfaceC2494c;
        this.f5363c = abstractC2478f;
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p236t.p237h.InterfaceC2490r
    /* JADX INFO: renamed from: a */
    public void mo2382a(AbstractC2442i abstractC2442i, int i) {
        boolean z2;
        boolean z3;
        char c;
        ComponentName componentName = new ComponentName(this.f5361a, (Class<?>) JobInfoSchedulerService.class);
        JobScheduler jobScheduler = (JobScheduler) this.f5361a.getSystemService("jobscheduler");
        Adler32 adler32 = new Adler32();
        adler32.update(this.f5361a.getPackageName().getBytes(Charset.forName(Constants.ENCODING)));
        adler32.update(abstractC2442i.mo2348b().getBytes(Charset.forName(Constants.ENCODING)));
        adler32.update(ByteBuffer.allocate(4).putInt(C2524a.m2414a(abstractC2442i.mo2350d())).array());
        if (abstractC2442i.mo2349c() != null) {
            adler32.update(abstractC2442i.mo2349c());
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
            C1460d.m486X("JobInfoScheduler", "Upload for context %s is already scheduled. Returning...", abstractC2442i);
            return;
        }
        long jMo2395h0 = this.f5362b.mo2395h0(abstractC2442i);
        AbstractC2478f abstractC2478f = this.f5363c;
        JobInfo.Builder builder = new JobInfo.Builder(value, componentName);
        EnumC2409d enumC2409dMo2350d = abstractC2442i.mo2350d();
        builder.setMinimumLatency(abstractC2478f.m2383b(enumC2409dMo2350d, jMo2395h0, i));
        Set<AbstractC2478f.b> setMo2377c = abstractC2478f.mo2375c().get(enumC2409dMo2350d).mo2377c();
        if (setMo2377c.contains(AbstractC2478f.b.NETWORK_UNMETERED)) {
            builder.setRequiredNetworkType(2);
            z3 = true;
        } else {
            z3 = true;
            builder.setRequiredNetworkType(1);
        }
        if (setMo2377c.contains(AbstractC2478f.b.DEVICE_CHARGING)) {
            builder.setRequiresCharging(z3);
        }
        if (setMo2377c.contains(AbstractC2478f.b.DEVICE_IDLE)) {
            builder.setRequiresDeviceIdle(z3);
        }
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putInt("attemptNumber", i);
        persistableBundle.putString("backendName", abstractC2442i.mo2348b());
        persistableBundle.putInt("priority", C2524a.m2414a(abstractC2442i.mo2350d()));
        if (abstractC2442i.mo2349c() != null) {
            c = 0;
            persistableBundle.putString(NotificationCompat.MessagingStyle.Message.KEY_EXTRAS_BUNDLE, Base64.encodeToString(abstractC2442i.mo2349c(), 0));
        } else {
            c = 0;
        }
        builder.setExtras(persistableBundle);
        Object[] objArr = new Object[5];
        objArr[c] = abstractC2442i;
        objArr[1] = Integer.valueOf(value);
        objArr[2] = Long.valueOf(this.f5363c.m2383b(abstractC2442i.mo2350d(), jMo2395h0, i));
        objArr[3] = Long.valueOf(jMo2395h0);
        objArr[4] = Integer.valueOf(i);
        C1460d.m489Y("JobInfoScheduler", "Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", objArr);
        jobScheduler.schedule(builder.build());
    }
}
