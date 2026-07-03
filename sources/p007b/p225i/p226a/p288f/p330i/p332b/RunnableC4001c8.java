package p007b.p225i.p226a.p288f.p330i.p332b;

import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzaq;
import p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3660fc;

/* JADX INFO: renamed from: b.i.a.f.i.b.c8 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC4001c8 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ zzaq f10613j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ String f10614k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ InterfaceC3660fc f10615l;

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ C4161q7 f10616m;

    public RunnableC4001c8(C4161q7 c4161q7, zzaq zzaqVar, String str, InterfaceC3660fc interfaceC3660fc) {
        this.f10616m = c4161q7;
        this.f10613j = zzaqVar;
        this.f10614k = str;
        this.f10615l = interfaceC3660fc;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            try {
                C4161q7 c4161q7 = this.f10616m;
                InterfaceC4068i3 interfaceC4068i3 = c4161q7.f11154d;
                if (interfaceC4068i3 == null) {
                    c4161q7.mo5726g().f11141f.m5860a("Discarding data. Failed to send event to service to bundle");
                    this.f10616m.m5866e().m5902P(this.f10615l, null);
                } else {
                    byte[] bArrMo5674j = interfaceC4068i3.mo5674j(this.f10613j, this.f10614k);
                    this.f10616m.m5808F();
                    this.f10616m.m5866e().m5902P(this.f10615l, bArrMo5674j);
                }
            } catch (RemoteException e) {
                this.f10616m.mo5726g().f11141f.m5861b("Failed to send event to the service to bundle", e);
                this.f10616m.m5866e().m5902P(this.f10615l, null);
            }
        } catch (Throwable th) {
            this.f10616m.m5866e().m5902P(this.f10615l, null);
            throw th;
        }
    }
}
