package b.i.a.f.h.j;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager$NameNotFoundException;
import android.os.Build$VERSION;
import androidx.core.app.NotificationCompat;

/* JADX INFO: loaded from: classes3.dex */
public final class c0 extends e {
    public boolean l;
    public boolean m;
    public final AlarmManager n;
    public Integer o;

    public c0(g gVar) {
        super(gVar);
        this.n = (AlarmManager) this.j.f1417b.getSystemService(NotificationCompat.CATEGORY_ALARM);
    }

    @Override // b.i.a.f.h.j.e
    public final void L() {
        try {
            O();
            if (z.b() > 0) {
                Context context = this.j.f1417b;
                ActivityInfo receiverInfo = context.getPackageManager().getReceiverInfo(new ComponentName(context, "com.google.android.gms.analytics.AnalyticsReceiver"), 0);
                if (receiverInfo == null || !receiverInfo.enabled) {
                    return;
                }
                C("Receiver registered for local dispatch.");
                this.l = true;
            }
        } catch (PackageManager$NameNotFoundException unused) {
        }
    }

    public final void O() {
        this.m = false;
        this.n.cancel(S());
        if (Build$VERSION.SDK_INT >= 24) {
            JobScheduler jobScheduler = (JobScheduler) this.j.f1417b.getSystemService("jobscheduler");
            int iR = R();
            b("Cancelling job. JobID", Integer.valueOf(iR));
            jobScheduler.cancel(iR);
        }
    }

    public final int R() {
        if (this.o == null) {
            String strValueOf = String.valueOf(this.j.f1417b.getPackageName());
            this.o = Integer.valueOf((strValueOf.length() != 0 ? "analytics".concat(strValueOf) : new String("analytics")).hashCode());
        }
        return this.o.intValue();
    }

    public final PendingIntent S() {
        Context context = this.j.f1417b;
        return PendingIntent.getBroadcast(context, 0, new Intent("com.google.android.gms.analytics.ANALYTICS_DISPATCH").setComponent(new ComponentName(context, "com.google.android.gms.analytics.AnalyticsReceiver")), 0);
    }
}
