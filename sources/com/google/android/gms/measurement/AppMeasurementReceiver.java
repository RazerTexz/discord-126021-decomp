package com.google.android.gms.measurement;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.MainThread;
import androidx.legacy.content.WakefulBroadcastReceiver;
import java.util.Objects;
import p007b.p225i.p226a.p288f.p330i.p332b.C4125n4;
import p007b.p225i.p226a.p288f.p330i.p332b.C4157q3;
import p007b.p225i.p226a.p288f.p330i.p332b.C4202u4;
import p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC4158q4;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class AppMeasurementReceiver extends WakefulBroadcastReceiver implements InterfaceC4158q4 {

    /* JADX INFO: renamed from: j */
    public C4125n4 f20657j;

    @Override // android.content.BroadcastReceiver
    @MainThread
    public final void onReceive(Context context, Intent intent) {
        if (this.f20657j == null) {
            this.f20657j = new C4125n4(this);
        }
        C4125n4 c4125n4 = this.f20657j;
        Objects.requireNonNull(c4125n4);
        C4157q3 c4157q3Mo5726g = C4202u4.m5933b(context, null, null).mo5726g();
        if (intent == null) {
            c4157q3Mo5726g.f11144i.m5860a("Receiver called with null intent");
            return;
        }
        String action = intent.getAction();
        c4157q3Mo5726g.f11149n.m5861b("Local receiver got", action);
        if (!"com.google.android.gms.measurement.UPLOAD".equals(action)) {
            if ("com.android.vending.INSTALL_REFERRER".equals(action)) {
                c4157q3Mo5726g.f11144i.m5860a("Install Referrer Broadcasts are deprecated");
            }
        } else {
            Intent className = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
            className.setAction("com.google.android.gms.measurement.UPLOAD");
            c4157q3Mo5726g.f11149n.m5860a("Starting wakeful intent.");
            Objects.requireNonNull((AppMeasurementReceiver) c4125n4.f10990a);
            WakefulBroadcastReceiver.startWakefulService(context, className);
        }
    }
}
