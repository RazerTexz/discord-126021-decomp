package b.i.a.f.i.b;

import b.i.a.f.h.l.fc;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class a6 implements Runnable {
    public final /* synthetic */ fc j;
    public final /* synthetic */ AppMeasurementDynamiteService k;

    public a6(AppMeasurementDynamiteService appMeasurementDynamiteService, fc fcVar) {
        this.k = appMeasurementDynamiteService;
        this.j = fcVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        q7 q7VarX = this.k.a.x();
        fc fcVar = this.j;
        q7VarX.b();
        q7VarX.t();
        q7VarX.z(new u7(q7VarX, q7VarX.I(false), fcVar));
    }
}
