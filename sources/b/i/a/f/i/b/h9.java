package b.i.a.f.i.b;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobScheduler;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class h9 extends i9 {
    public final AlarmManager d;
    public final i e;
    public Integer f;

    public h9(k9 k9Var) {
        super(k9Var);
        this.d = (AlarmManager) this.a.f1570b.getSystemService(NotificationCompat.CATEGORY_ALARM);
        this.e = new g9(this, k9Var.k, k9Var);
    }

    @Override // b.i.a.f.i.b.i9
    public final boolean p() {
        this.d.cancel(u());
        if (Build.VERSION.SDK_INT < 24) {
            return false;
        }
        ((JobScheduler) this.a.f1570b.getSystemService("jobscheduler")).cancel(t());
        return false;
    }

    public final void s() {
        n();
        g().n.a("Unscheduling upload");
        this.d.cancel(u());
        this.e.c();
        if (Build.VERSION.SDK_INT >= 24) {
            ((JobScheduler) this.a.f1570b.getSystemService("jobscheduler")).cancel(t());
        }
    }

    public final int t() {
        if (this.f == null) {
            String strValueOf = String.valueOf(this.a.f1570b.getPackageName());
            this.f = Integer.valueOf((strValueOf.length() != 0 ? "measurement".concat(strValueOf) : new String("measurement")).hashCode());
        }
        return this.f.intValue();
    }

    public final PendingIntent u() {
        Context context = this.a.f1570b;
        return PendingIntent.getBroadcast(context, 0, new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementReceiver").setAction("com.google.android.gms.measurement.UPLOAD"), 0);
    }
}
