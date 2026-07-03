package p007b.p225i.p226a.p288f.p330i.p332b;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: b.i.a.f.i.b.r6 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC4171r6 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ AtomicReference f11177j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ String f11178k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ String f11179l;

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ boolean f11180m;

    /* JADX INFO: renamed from: n */
    public final /* synthetic */ C3999c6 f11181n;

    public RunnableC4171r6(C3999c6 c3999c6, AtomicReference atomicReference, String str, String str2, boolean z2) {
        this.f11181n = c3999c6;
        this.f11177j = atomicReference;
        this.f11178k = str;
        this.f11179l = str2;
        this.f11180m = z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C4161q7 c4161q7M5953x = this.f11181n.f11202a.m5953x();
        AtomicReference atomicReference = this.f11177j;
        String str = this.f11178k;
        String str2 = this.f11179l;
        boolean z2 = this.f11180m;
        c4161q7M5953x.mo5848b();
        c4161q7M5953x.m5497t();
        c4161q7M5953x.m5814z(new RunnableC4061h8(c4161q7M5953x, atomicReference, null, str, str2, z2, c4161q7M5953x.m5811I(false)));
    }
}
