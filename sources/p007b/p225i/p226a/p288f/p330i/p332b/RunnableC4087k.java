package p007b.p225i.p226a.p288f.p330i.p332b;

/* JADX INFO: renamed from: b.i.a.f.i.b.k */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC4087k implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ InterfaceC4192t5 f10866j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ AbstractC4064i f10867k;

    public RunnableC4087k(AbstractC4064i abstractC4064i, InterfaceC4192t5 interfaceC4192t5) {
        this.f10867k = abstractC4064i;
        this.f10866j = interfaceC4192t5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f10866j.mo5730k();
        if (C4051ga.m5647a()) {
            this.f10866j.mo5725f().m5852v(this);
            return;
        }
        boolean z2 = this.f10867k.f10801d != 0;
        this.f10867k.f10801d = 0L;
        if (z2) {
            this.f10867k.mo5560a();
        }
    }
}
