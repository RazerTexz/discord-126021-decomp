package p007b.p225i.p226a.p288f.p330i.p332b;

import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzn;

/* JADX INFO: renamed from: b.i.a.f.i.b.t7 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC4194t7 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ zzn f11229j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ C4161q7 f11230k;

    public RunnableC4194t7(C4161q7 c4161q7, zzn zznVar) {
        this.f11230k = c4161q7;
        this.f11229j = zznVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C4161q7 c4161q7 = this.f11230k;
        InterfaceC4068i3 interfaceC4068i3 = c4161q7.f11154d;
        if (interfaceC4068i3 == null) {
            c4161q7.mo5726g().f11141f.m5860a("Failed to reset data on the service: not connected to service");
            return;
        }
        try {
            interfaceC4068i3.mo5668I(this.f11229j);
        } catch (RemoteException e) {
            this.f11230k.mo5726g().f11141f.m5861b("Failed to reset data on the service: remote exception", e);
        }
        this.f11230k.m5808F();
    }
}
