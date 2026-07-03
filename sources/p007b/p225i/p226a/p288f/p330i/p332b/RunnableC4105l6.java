package p007b.p225i.p226a.p288f.p330i.p332b;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: b.i.a.f.i.b.l6 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC4105l6 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ long f10945j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ C3999c6 f10946k;

    public RunnableC4105l6(C3999c6 c3999c6, long j) {
        this.f10946k = c3999c6;
        this.f10945j = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f10946k.m5556w(this.f10945j, true);
        this.f10946k.m5971p().m5803A(new AtomicReference<>());
    }
}
