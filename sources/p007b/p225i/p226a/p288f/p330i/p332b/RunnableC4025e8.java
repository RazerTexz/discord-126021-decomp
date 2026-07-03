package p007b.p225i.p226a.p288f.p330i.p332b;

import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzn;

/* JADX INFO: renamed from: b.i.a.f.i.b.e8 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC4025e8 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ zzn f10694j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ C4161q7 f10695k;

    public RunnableC4025e8(C4161q7 c4161q7, zzn zznVar) {
        this.f10695k = c4161q7;
        this.f10694j = zznVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C4161q7 c4161q7 = this.f10695k;
        InterfaceC4068i3 interfaceC4068i3 = c4161q7.f11154d;
        if (interfaceC4068i3 == null) {
            c4161q7.mo5726g().f11141f.m5860a("Failed to send consent settings to service");
            return;
        }
        try {
            interfaceC4068i3.mo5676m(this.f10694j);
            this.f10695k.m5808F();
        } catch (RemoteException e) {
            this.f10695k.mo5726g().f11141f.m5861b("Failed to send consent settings to the service", e);
        }
    }
}
