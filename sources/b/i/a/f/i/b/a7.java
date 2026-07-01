package b.i.a.f.i.b;

import b.i.a.f.h.l.fc;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class a7 implements Runnable {
    public final /* synthetic */ fc j;
    public final /* synthetic */ String k;
    public final /* synthetic */ String l;
    public final /* synthetic */ boolean m;
    public final /* synthetic */ AppMeasurementDynamiteService n;

    public a7(AppMeasurementDynamiteService appMeasurementDynamiteService, fc fcVar, String str, String str2, boolean z2) {
        this.n = appMeasurementDynamiteService;
        this.j = fcVar;
        this.k = str;
        this.l = str2;
        this.m = z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        q7 q7VarX = this.n.a.x();
        fc fcVar = this.j;
        String str = this.k;
        String str2 = this.l;
        boolean z2 = this.m;
        q7VarX.b();
        q7VarX.t();
        q7VarX.z(new s7(q7VarX, str, str2, z2, q7VarX.I(false), fcVar));
    }
}
