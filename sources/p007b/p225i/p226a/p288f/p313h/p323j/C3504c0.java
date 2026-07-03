package p007b.p225i.p226a.p288f.p313h.p323j;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.core.app.NotificationCompat;

/* JADX INFO: renamed from: b.i.a.f.h.j.c0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3504c0 extends AbstractC3509e {

    /* JADX INFO: renamed from: l */
    public boolean f9679l;

    /* JADX INFO: renamed from: m */
    public boolean f9680m;

    /* JADX INFO: renamed from: n */
    public final AlarmManager f9681n;

    /* JADX INFO: renamed from: o */
    public Integer f9682o;

    public C3504c0(C3515g c3515g) {
        super(c3515g);
        this.f9681n = (AlarmManager) this.f9684j.f9722b.getSystemService(NotificationCompat.CATEGORY_ALARM);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p323j.AbstractC3509e
    /* JADX INFO: renamed from: L */
    public final void mo4414L() {
        try {
            m4421O();
            if (C3554z.m4508b() > 0) {
                Context context = this.f9684j.f9722b;
                ActivityInfo receiverInfo = context.getPackageManager().getReceiverInfo(new ComponentName(context, "com.google.android.gms.analytics.AnalyticsReceiver"), 0);
                if (receiverInfo == null || !receiverInfo.enabled) {
                    return;
                }
                m4427C("Receiver registered for local dispatch.");
                this.f9679l = true;
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    /* JADX INFO: renamed from: O */
    public final void m4421O() {
        this.f9680m = false;
        this.f9681n.cancel(m4423S());
        if (Build.VERSION.SDK_INT >= 24) {
            JobScheduler jobScheduler = (JobScheduler) this.f9684j.f9722b.getSystemService("jobscheduler");
            int iM4422R = m4422R();
            m4431b("Cancelling job. JobID", Integer.valueOf(iM4422R));
            jobScheduler.cancel(iM4422R);
        }
    }

    /* JADX INFO: renamed from: R */
    public final int m4422R() {
        if (this.f9682o == null) {
            String strValueOf = String.valueOf(this.f9684j.f9722b.getPackageName());
            this.f9682o = Integer.valueOf((strValueOf.length() != 0 ? "analytics".concat(strValueOf) : new String("analytics")).hashCode());
        }
        return this.f9682o.intValue();
    }

    /* JADX INFO: renamed from: S */
    public final PendingIntent m4423S() {
        Context context = this.f9684j.f9722b;
        return PendingIntent.getBroadcast(context, 0, new Intent("com.google.android.gms.analytics.ANALYTICS_DISPATCH").setComponent(new ComponentName(context, "com.google.android.gms.analytics.AnalyticsReceiver")), 0);
    }
}
