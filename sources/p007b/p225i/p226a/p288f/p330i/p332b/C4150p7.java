package p007b.p225i.p226a.p288f.p330i.p332b;

/* JADX INFO: renamed from: b.i.a.f.i.b.p7 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4150p7 extends AbstractC4064i {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ C4161q7 f11130e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C4150p7(C4161q7 c4161q7, InterfaceC4192t5 interfaceC4192t5) {
        super(interfaceC4192t5);
        this.f11130e = c4161q7;
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.AbstractC4064i
    /* JADX INFO: renamed from: a */
    public final void mo5560a() {
        C4161q7 c4161q7 = this.f11130e;
        c4161q7.mo5848b();
        if (c4161q7.m5804B()) {
            c4161q7.mo5726g().f11149n.m5860a("Inactivity, disconnecting from the service");
            c4161q7.m5806D();
        }
    }
}
