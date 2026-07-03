package p007b.p225i.p226a.p288f.p330i.p332b;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobScheduler;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;

/* JADX INFO: renamed from: b.i.a.f.i.b.h9 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4062h9 extends AbstractC4074i9 {

    /* JADX INFO: renamed from: d */
    public final AlarmManager f10793d;

    /* JADX INFO: renamed from: e */
    public final AbstractC4064i f10794e;

    /* JADX INFO: renamed from: f */
    public Integer f10795f;

    public C4062h9(C4097k9 c4097k9) {
        super(c4097k9);
        this.f10793d = (AlarmManager) this.f11202a.f11254b.getSystemService(NotificationCompat.CATEGORY_ALARM);
        this.f10794e = new C4050g9(this, c4097k9.f10906k, c4097k9);
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.AbstractC4074i9
    /* JADX INFO: renamed from: p */
    public final boolean mo5515p() {
        this.f10793d.cancel(m5661u());
        if (Build.VERSION.SDK_INT < 24) {
            return false;
        }
        ((JobScheduler) this.f11202a.f11254b.getSystemService("jobscheduler")).cancel(m5660t());
        return false;
    }

    /* JADX INFO: renamed from: s */
    public final void m5659s() {
        m5684n();
        mo5726g().f11149n.m5860a("Unscheduling upload");
        this.f10793d.cancel(m5661u());
        this.f10794e.m5664c();
        if (Build.VERSION.SDK_INT >= 24) {
            ((JobScheduler) this.f11202a.f11254b.getSystemService("jobscheduler")).cancel(m5660t());
        }
    }

    /* JADX INFO: renamed from: t */
    public final int m5660t() {
        if (this.f10795f == null) {
            String strValueOf = String.valueOf(this.f11202a.f11254b.getPackageName());
            this.f10795f = Integer.valueOf((strValueOf.length() != 0 ? "measurement".concat(strValueOf) : new String("measurement")).hashCode());
        }
        return this.f10795f.intValue();
    }

    /* JADX INFO: renamed from: u */
    public final PendingIntent m5661u() {
        Context context = this.f11202a.f11254b;
        return PendingIntent.getBroadcast(context, 0, new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementReceiver").setAction("com.google.android.gms.measurement.UPLOAD"), 0);
    }
}
