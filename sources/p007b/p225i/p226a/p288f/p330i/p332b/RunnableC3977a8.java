package p007b.p225i.p226a.p288f.p330i.p332b;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzn;

/* JADX INFO: renamed from: b.i.a.f.i.b.a8 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC3977a8 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ Bundle f10550j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ zzn f10551k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ C4161q7 f10552l;

    public RunnableC3977a8(C4161q7 c4161q7, Bundle bundle, zzn zznVar) {
        this.f10552l = c4161q7;
        this.f10550j = bundle;
        this.f10551k = zznVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C4161q7 c4161q7 = this.f10552l;
        InterfaceC4068i3 interfaceC4068i3 = c4161q7.f11154d;
        if (interfaceC4068i3 == null) {
            c4161q7.mo5726g().f11141f.m5860a("Failed to send default event parameters to service");
            return;
        }
        try {
            interfaceC4068i3.mo5677m0(this.f10550j, this.f10551k);
        } catch (RemoteException e) {
            this.f10552l.mo5726g().f11141f.m5861b("Failed to send default event parameters to service", e);
        }
    }
}
