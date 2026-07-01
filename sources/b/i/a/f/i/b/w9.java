package b.i.a.f.i.b;

import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class w9 implements Runnable {
    public final /* synthetic */ AppMeasurementDynamiteService.a j;
    public final /* synthetic */ AppMeasurementDynamiteService k;

    public w9(AppMeasurementDynamiteService appMeasurementDynamiteService, AppMeasurementDynamiteService.a aVar) {
        this.k = appMeasurementDynamiteService;
        this.j = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.k.a.s().B(this.j);
    }
}
