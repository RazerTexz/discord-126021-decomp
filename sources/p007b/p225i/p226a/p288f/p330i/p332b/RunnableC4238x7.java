package p007b.p225i.p226a.p288f.p330i.p332b;

import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzn;

/* JADX INFO: renamed from: b.i.a.f.i.b.x7 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC4238x7 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ zzn f11349j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ C4161q7 f11350k;

    public RunnableC4238x7(C4161q7 c4161q7, zzn zznVar) {
        this.f11350k = c4161q7;
        this.f11349j = zznVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        C4161q7 c4161q7 = this.f11350k;
        InterfaceC4068i3 interfaceC4068i3 = c4161q7.f11154d;
        if (interfaceC4068i3 == null) {
            c4161q7.mo5726g().f11141f.m5860a("Discarding data. Failed to send app launch");
            return;
        }
        try {
            interfaceC4068i3.mo5672T(this.f11349j);
            this.f11350k.m5973r().m5757z();
            this.f11350k.m5812w(interfaceC4068i3, null, this.f11349j);
            this.f11350k.m5808F();
        } catch (RemoteException e) {
            this.f11350k.mo5726g().f11141f.m5861b("Failed to send app launch to the service", e);
        }
    }
}
