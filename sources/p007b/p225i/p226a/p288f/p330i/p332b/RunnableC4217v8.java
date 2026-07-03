package p007b.p225i.p226a.p288f.p330i.p332b;

import java.util.Objects;
import p007b.p225i.p226a.p288f.p299e.p308o.C3401c;

/* JADX INFO: renamed from: b.i.a.f.i.b.v8 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC4217v8 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ long f11313j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ C4228w8 f11314k;

    public RunnableC4217v8(C4228w8 c4228w8, long j) {
        this.f11314k = c4228w8;
        this.f11313j = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C4228w8 c4228w8 = this.f11314k;
        long j = this.f11313j;
        c4228w8.mo5848b();
        c4228w8.m5960x();
        c4228w8.mo5726g().f11149n.m5861b("Activity resumed, time", Long.valueOf(j));
        if (c4228w8.f11202a.f11260h.m5526o(C4142p.f11104v0)) {
            if (c4228w8.f11202a.f11260h.m5537z().booleanValue() || c4228w8.m5867l().f10654x.m5597b()) {
                C4014d9 c4014d9 = c4228w8.f11330e;
                c4014d9.f10671d.mo5848b();
                c4014d9.f10670c.m5664c();
                c4014d9.f10668a = j;
                c4014d9.f10669b = j;
            }
            c4228w8.f11331f.m5964a();
        } else {
            c4228w8.f11331f.m5964a();
            if (c4228w8.f11202a.f11260h.m5537z().booleanValue()) {
                C4014d9 c4014d10 = c4228w8.f11330e;
                c4014d10.f10671d.mo5848b();
                c4014d10.f10670c.m5664c();
                c4014d10.f10668a = j;
                c4014d10.f10669b = j;
            }
        }
        C4038f9 c4038f9 = c4228w8.f11329d;
        c4038f9.f10732a.mo5848b();
        if (c4038f9.f10732a.f11202a.m5940d()) {
            if (!c4038f9.f10732a.f11202a.f11260h.m5526o(C4142p.f11104v0)) {
                c4038f9.f10732a.m5867l().f10654x.m5596a(false);
            }
            Objects.requireNonNull((C3401c) c4038f9.f10732a.f11202a.f11267o);
            c4038f9.m5600b(System.currentTimeMillis(), false);
        }
    }
}
