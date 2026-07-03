package p007b.p225i.p226a.p288f.p330i.p332b;

import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.f.i.b.j8 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC4085j8 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ InterfaceC4068i3 f10862j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ ServiceConnectionC4096k8 f10863k;

    public RunnableC4085j8(ServiceConnectionC4096k8 serviceConnectionC4096k8, InterfaceC4068i3 interfaceC4068i3) {
        this.f10863k = serviceConnectionC4096k8;
        this.f10862j = interfaceC4068i3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f10863k) {
            this.f10863k.f10892j = false;
            if (!this.f10863k.f10894l.m5804B()) {
                this.f10863k.f10894l.mo5726g().f11149n.m5860a("Connected to service");
                C4161q7 c4161q7 = this.f10863k.f10894l;
                InterfaceC4068i3 interfaceC4068i3 = this.f10862j;
                c4161q7.mo5848b();
                Objects.requireNonNull(interfaceC4068i3, "null reference");
                c4161q7.f11154d = interfaceC4068i3;
                c4161q7.m5808F();
                c4161q7.m5810H();
            }
        }
    }
}
