package p007b.p225i.p226a.p288f.p330i.p332b;

import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;
import p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3660fc;

/* JADX INFO: renamed from: b.i.a.f.i.b.z8 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC4261z8 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ InterfaceC3660fc f11399j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ String f11400k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ String f11401l;

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ AppMeasurementDynamiteService f11402m;

    public RunnableC4261z8(AppMeasurementDynamiteService appMeasurementDynamiteService, InterfaceC3660fc interfaceC3660fc, String str, String str2) {
        this.f11402m = appMeasurementDynamiteService;
        this.f11399j = interfaceC3660fc;
        this.f11400k = str;
        this.f11401l = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C4161q7 c4161q7M5953x = this.f11402m.f20659a.m5953x();
        InterfaceC3660fc interfaceC3660fc = this.f11399j;
        String str = this.f11400k;
        String str2 = this.f11401l;
        c4161q7M5953x.mo5848b();
        c4161q7M5953x.m5497t();
        c4161q7M5953x.m5814z(new RunnableC4073i8(c4161q7M5953x, str, str2, c4161q7M5953x.m5811I(false), interfaceC3660fc));
    }
}
