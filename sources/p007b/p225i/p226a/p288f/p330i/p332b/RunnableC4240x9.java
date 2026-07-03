package p007b.p225i.p226a.p288f.p330i.p332b;

import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;
import p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3660fc;

/* JADX INFO: renamed from: b.i.a.f.i.b.x9 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC4240x9 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ InterfaceC3660fc f11353j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ AppMeasurementDynamiteService f11354k;

    public RunnableC4240x9(AppMeasurementDynamiteService appMeasurementDynamiteService, InterfaceC3660fc interfaceC3660fc) {
        this.f11354k = appMeasurementDynamiteService;
        this.f11353j = interfaceC3660fc;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f11354k.f20659a.m5949t().m5901O(this.f11353j, this.f11354k.f20659a.m5938B());
    }
}
