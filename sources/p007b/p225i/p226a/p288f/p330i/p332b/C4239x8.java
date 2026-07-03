package p007b.p225i.p226a.p288f.p330i.p332b;

import androidx.annotation.WorkerThread;

/* JADX INFO: renamed from: b.i.a.f.i.b.x8 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4239x8 {

    /* JADX INFO: renamed from: a */
    public RunnableC3990b9 f11351a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ C4228w8 f11352b;

    public C4239x8(C4228w8 c4228w8) {
        this.f11352b = c4228w8;
    }

    @WorkerThread
    /* JADX INFO: renamed from: a */
    public final void m5964a() {
        this.f11352b.mo5848b();
        RunnableC3990b9 runnableC3990b9 = this.f11351a;
        if (runnableC3990b9 != null) {
            this.f11352b.f11328c.removeCallbacks(runnableC3990b9);
        }
        if (this.f11352b.f11202a.f11260h.m5526o(C4142p.f11104v0)) {
            this.f11352b.m5867l().f10654x.m5596a(false);
        }
    }
}
