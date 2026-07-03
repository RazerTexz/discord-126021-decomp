package p007b.p225i.p226a.p288f.p330i.p332b;

import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;
import com.google.android.gms.measurement.internal.zzaq;
import java.util.Objects;
import p007b.p225i.p226a.p288f.p299e.C3256c;
import p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3660fc;

/* JADX INFO: renamed from: b.i.a.f.i.b.y7 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC4249y7 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ InterfaceC3660fc f11380j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ zzaq f11381k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ String f11382l;

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ AppMeasurementDynamiteService f11383m;

    public RunnableC4249y7(AppMeasurementDynamiteService appMeasurementDynamiteService, InterfaceC3660fc interfaceC3660fc, zzaq zzaqVar, String str) {
        this.f11383m = appMeasurementDynamiteService;
        this.f11380j = interfaceC3660fc;
        this.f11381k = zzaqVar;
        this.f11382l = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C4161q7 c4161q7M5953x = this.f11383m.f20659a.m5953x();
        InterfaceC3660fc interfaceC3660fc = this.f11380j;
        zzaq zzaqVar = this.f11381k;
        String str = this.f11382l;
        c4161q7M5953x.mo5848b();
        c4161q7M5953x.m5497t();
        C4196t9 c4196t9M5866e = c4161q7M5953x.m5866e();
        Objects.requireNonNull(c4196t9M5866e);
        if (C3256c.f9307b.mo4018b(c4196t9M5866e.f11202a.f11254b, 12451000) == 0) {
            c4161q7M5953x.m5814z(new RunnableC4001c8(c4161q7M5953x, zzaqVar, str, interfaceC3660fc));
        } else {
            c4161q7M5953x.mo5726g().f11144i.m5860a("Not bundling data. Service unavailable or out of date");
            c4161q7M5953x.m5866e().m5902P(interfaceC3660fc, new byte[0]);
        }
    }
}
