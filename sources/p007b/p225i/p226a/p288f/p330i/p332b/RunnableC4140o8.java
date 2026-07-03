package p007b.p225i.p226a.p288f.p330i.p332b;

import android.content.ComponentName;

/* JADX INFO: renamed from: b.i.a.f.i.b.o8 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC4140o8 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ ServiceConnectionC4096k8 f11017j;

    public RunnableC4140o8(ServiceConnectionC4096k8 serviceConnectionC4096k8) {
        this.f11017j = serviceConnectionC4096k8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C4161q7.m5802x(this.f11017j.f10894l, new ComponentName(this.f11017j.f10894l.f11202a.f11254b, "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
