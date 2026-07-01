package b.i.a.f.i.b;

import b.i.a.f.h.l.fc;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;
import com.google.android.gms.measurement.internal.zzaq;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class y7 implements Runnable {
    public final /* synthetic */ fc j;
    public final /* synthetic */ zzaq k;
    public final /* synthetic */ String l;
    public final /* synthetic */ AppMeasurementDynamiteService m;

    public y7(AppMeasurementDynamiteService appMeasurementDynamiteService, fc fcVar, zzaq zzaqVar, String str) {
        this.m = appMeasurementDynamiteService;
        this.j = fcVar;
        this.k = zzaqVar;
        this.l = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        q7 q7VarX = this.m.a.x();
        fc fcVar = this.j;
        zzaq zzaqVar = this.k;
        String str = this.l;
        q7VarX.b();
        q7VarX.t();
        t9 t9VarE = q7VarX.e();
        Objects.requireNonNull(t9VarE);
        if (b.i.a.f.e.c.f1346b.b(t9VarE.a.f1570b, 12451000) == 0) {
            q7VarX.z(new c8(q7VarX, zzaqVar, str, fcVar));
        } else {
            q7VarX.g().i.a("Not bundling data. Service unavailable or out of date");
            q7VarX.e().P(fcVar, new byte[0]);
        }
    }
}
