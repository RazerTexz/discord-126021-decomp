package p007b.p225i.p226a.p288f.p330i.p332b;

import android.os.Bundle;

/* JADX INFO: renamed from: b.i.a.f.i.b.b9 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC3990b9 implements Runnable {

    /* JADX INFO: renamed from: j */
    public long f10571j;

    /* JADX INFO: renamed from: k */
    public long f10572k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ C4239x8 f10573l;

    public RunnableC3990b9(C4239x8 c4239x8, long j, long j2) {
        this.f10573l = c4239x8;
        this.f10571j = j;
        this.f10572k = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f10573l.f11352b.mo5725f().m5852v(new Runnable(this) { // from class: b.i.a.f.i.b.a9

            /* JADX INFO: renamed from: j */
            public final RunnableC3990b9 f10553j;

            {
                this.f10553j = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                RunnableC3990b9 runnableC3990b9 = this.f10553j;
                C4239x8 c4239x8 = runnableC3990b9.f10573l;
                long j = runnableC3990b9.f10571j;
                long j2 = runnableC3990b9.f10572k;
                c4239x8.f11352b.mo5848b();
                c4239x8.f11352b.mo5726g().f11148m.m5860a("Application going to the background");
                boolean z2 = true;
                if (c4239x8.f11352b.f11202a.f11260h.m5526o(C4142p.f11104v0)) {
                    c4239x8.f11352b.m5867l().f10654x.m5596a(true);
                }
                Bundle bundle = new Bundle();
                if (!c4239x8.f11352b.f11202a.f11260h.m5537z().booleanValue()) {
                    c4239x8.f11352b.f11330e.f10670c.m5664c();
                    if (c4239x8.f11352b.f11202a.f11260h.m5526o(C4142p.f11086m0)) {
                        C4014d9 c4014d9 = c4239x8.f11352b.f11330e;
                        long j3 = j2 - c4014d9.f10669b;
                        c4014d9.f10669b = j2;
                        bundle.putLong("_et", j3);
                        C4060h7.m5650A(c4239x8.f11352b.m5972q().m5656w(true), bundle, true);
                    } else {
                        z2 = false;
                    }
                    c4239x8.f11352b.m5959w(false, z2, j2);
                }
                c4239x8.f11352b.m5969n().m5542E("auto", "_ab", j, bundle);
            }
        });
    }
}
