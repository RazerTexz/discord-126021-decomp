package p007b.p225i.p226a.p288f.p330i.p332b;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: b.i.a.f.i.b.o6 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC4138o6 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ AtomicReference f11010j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ String f11011k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ String f11012l;

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ C3999c6 f11013m;

    public RunnableC4138o6(C3999c6 c3999c6, AtomicReference atomicReference, String str, String str2) {
        this.f11013m = c3999c6;
        this.f11010j = atomicReference;
        this.f11011k = str;
        this.f11012l = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C4161q7 c4161q7M5953x = this.f11013m.f11202a.m5953x();
        AtomicReference atomicReference = this.f11010j;
        String str = this.f11011k;
        String str2 = this.f11012l;
        c4161q7M5953x.mo5848b();
        c4161q7M5953x.m5497t();
        c4161q7M5953x.m5814z(new RunnableC4037f8(c4161q7M5953x, atomicReference, null, str, str2, c4161q7M5953x.m5811I(false)));
    }
}
