package p007b.p225i.p226a.p288f.p330i.p332b;

import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;
import p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3660fc;

/* JADX INFO: renamed from: b.i.a.f.i.b.a7 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC3976a7 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ InterfaceC3660fc f10545j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ String f10546k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ String f10547l;

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ boolean f10548m;

    /* JADX INFO: renamed from: n */
    public final /* synthetic */ AppMeasurementDynamiteService f10549n;

    public RunnableC3976a7(AppMeasurementDynamiteService appMeasurementDynamiteService, InterfaceC3660fc interfaceC3660fc, String str, String str2, boolean z2) {
        this.f10549n = appMeasurementDynamiteService;
        this.f10545j = interfaceC3660fc;
        this.f10546k = str;
        this.f10547l = str2;
        this.f10548m = z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C4161q7 c4161q7M5953x = this.f10549n.f20659a.m5953x();
        InterfaceC3660fc interfaceC3660fc = this.f10545j;
        String str = this.f10546k;
        String str2 = this.f10547l;
        boolean z2 = this.f10548m;
        c4161q7M5953x.mo5848b();
        c4161q7M5953x.m5497t();
        c4161q7M5953x.m5814z(new RunnableC4183s7(c4161q7M5953x, str, str2, z2, c4161q7M5953x.m5811I(false), interfaceC3660fc));
    }
}
