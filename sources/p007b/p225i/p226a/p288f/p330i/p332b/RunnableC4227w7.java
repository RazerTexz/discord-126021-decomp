package p007b.p225i.p226a.p288f.p330i.p332b;

import android.os.RemoteException;

/* JADX INFO: renamed from: b.i.a.f.i.b.w7 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC4227w7 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ C4072i7 f11326j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ C4161q7 f11327k;

    public RunnableC4227w7(C4161q7 c4161q7, C4072i7 c4072i7) {
        this.f11327k = c4161q7;
        this.f11326j = c4072i7;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C4161q7 c4161q7 = this.f11327k;
        InterfaceC4068i3 interfaceC4068i3 = c4161q7.f11154d;
        if (interfaceC4068i3 == null) {
            c4161q7.mo5726g().f11141f.m5860a("Failed to send current screen to service");
            return;
        }
        try {
            C4072i7 c4072i7 = this.f11326j;
            if (c4072i7 == null) {
                interfaceC4068i3.mo5667G(0L, null, null, c4161q7.f11202a.f11254b.getPackageName());
            } else {
                interfaceC4068i3.mo5667G(c4072i7.f10818c, c4072i7.f10816a, c4072i7.f10817b, c4161q7.f11202a.f11254b.getPackageName());
            }
            this.f11327k.m5808F();
        } catch (RemoteException e) {
            this.f11327k.mo5726g().f11141f.m5861b("Failed to send current screen to the service", e);
        }
    }
}
