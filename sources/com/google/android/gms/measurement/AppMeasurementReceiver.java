package com.google.android.gms.measurement;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.MainThread;
import androidx.legacy.content.WakefulBroadcastReceiver;
import b.i.a.f.i.b.n4;
import b.i.a.f.i.b.q3;
import b.i.a.f.i.b.q4;
import b.i.a.f.i.b.u4;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class AppMeasurementReceiver extends WakefulBroadcastReceiver implements q4 {
    public n4 j;

    @Override // android.content.BroadcastReceiver
    @MainThread
    public final void onReceive(Context context, Intent intent) {
        if (this.j == null) {
            this.j = new n4(this);
        }
        n4 n4Var = this.j;
        Objects.requireNonNull(n4Var);
        q3 q3VarG = u4.b(context, null, null).g();
        if (intent == null) {
            q3VarG.i.a("Receiver called with null intent");
            return;
        }
        String action = intent.getAction();
        q3VarG.n.b("Local receiver got", action);
        if (!"com.google.android.gms.measurement.UPLOAD".equals(action)) {
            if ("com.android.vending.INSTALL_REFERRER".equals(action)) {
                q3VarG.i.a("Install Referrer Broadcasts are deprecated");
            }
        } else {
            Intent className = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
            className.setAction("com.google.android.gms.measurement.UPLOAD");
            q3VarG.n.a("Starting wakeful intent.");
            Objects.requireNonNull((AppMeasurementReceiver) n4Var.a);
            WakefulBroadcastReceiver.startWakefulService(context, className);
        }
    }
}
