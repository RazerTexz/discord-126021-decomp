package p007b.p225i.p226a.p288f.p330i.p332b;

import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;
import p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3660fc;

/* JADX INFO: renamed from: b.i.a.f.i.b.a6 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC3975a6 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ InterfaceC3660fc f10543j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ AppMeasurementDynamiteService f10544k;

    public RunnableC3975a6(AppMeasurementDynamiteService appMeasurementDynamiteService, InterfaceC3660fc interfaceC3660fc) {
        this.f10544k = appMeasurementDynamiteService;
        this.f10543j = interfaceC3660fc;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C4161q7 c4161q7M5953x = this.f10544k.f20659a.m5953x();
        InterfaceC3660fc interfaceC3660fc = this.f10543j;
        c4161q7M5953x.mo5848b();
        c4161q7M5953x.m5497t();
        c4161q7M5953x.m5814z(new RunnableC4205u7(c4161q7M5953x, c4161q7M5953x.m5811I(false), interfaceC3660fc));
    }
}
