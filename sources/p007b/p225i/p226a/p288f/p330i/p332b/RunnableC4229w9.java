package p007b.p225i.p226a.p288f.p330i.p332b;

import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;

/* JADX INFO: renamed from: b.i.a.f.i.b.w9 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC4229w9 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ AppMeasurementDynamiteService.C10806a f11332j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ AppMeasurementDynamiteService f11333k;

    public RunnableC4229w9(AppMeasurementDynamiteService appMeasurementDynamiteService, AppMeasurementDynamiteService.C10806a c10806a) {
        this.f11333k = appMeasurementDynamiteService;
        this.f11332j = c10806a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f11333k.f20659a.m5948s().m5540B(this.f11332j);
    }
}
