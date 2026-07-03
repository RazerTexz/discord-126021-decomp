package p007b.p225i.p226a.p288f.p330i.p332b;

import java.util.Objects;
import p007b.p225i.p226a.p288f.p299e.p308o.C3401c;

/* JADX INFO: renamed from: b.i.a.f.i.b.y8 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC4250y8 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ long f11384j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ C4228w8 f11385k;

    public RunnableC4250y8(C4228w8 c4228w8, long j) {
        this.f11385k = c4228w8;
        this.f11384j = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C4228w8 c4228w8 = this.f11385k;
        long j = this.f11384j;
        c4228w8.mo5848b();
        c4228w8.m5960x();
        c4228w8.mo5726g().f11149n.m5861b("Activity paused, time", Long.valueOf(j));
        C4239x8 c4239x8 = c4228w8.f11331f;
        Objects.requireNonNull((C3401c) c4239x8.f11352b.f11202a.f11267o);
        RunnableC3990b9 runnableC3990b9 = new RunnableC3990b9(c4239x8, System.currentTimeMillis(), j);
        c4239x8.f11351a = runnableC3990b9;
        c4239x8.f11352b.f11328c.postDelayed(runnableC3990b9, 2000L);
        if (c4228w8.f11202a.f11260h.m5537z().booleanValue()) {
            c4228w8.f11330e.f10670c.m5664c();
        }
        C4038f9 c4038f9 = c4228w8.f11329d;
        if (c4038f9.f10732a.f11202a.f11260h.m5526o(C4142p.f11104v0)) {
            return;
        }
        c4038f9.f10732a.m5867l().f10654x.m5596a(true);
    }
}
