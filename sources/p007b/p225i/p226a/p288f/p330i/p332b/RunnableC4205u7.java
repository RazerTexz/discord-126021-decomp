package p007b.p225i.p226a.p288f.p330i.p332b;

import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzn;
import p007b.p225i.p226a.p288f.p313h.p325l.C3842t8;
import p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3660fc;

/* JADX INFO: renamed from: b.i.a.f.i.b.u7 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC4205u7 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ zzn f11285j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ InterfaceC3660fc f11286k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ C4161q7 f11287l;

    public RunnableC4205u7(C4161q7 c4161q7, zzn zznVar, InterfaceC3660fc interfaceC3660fc) {
        this.f11287l = c4161q7;
        this.f11285j = zznVar;
        this.f11286k = interfaceC3660fc;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            try {
                if (C3842t8.m5293b() && this.f11287l.f11202a.f11260h.m5526o(C4142p.f11035H0) && !this.f11287l.m5867l().m5581y().m5572k()) {
                    this.f11287l.mo5726g().f11146k.m5860a("Analytics storage consent denied; will not get app instance id");
                    this.f11287l.m5969n().f10598g.set(null);
                    this.f11287l.m5867l().f10643m.m5695b(null);
                    this.f11287l.m5866e().m5899M(this.f11286k, null);
                    return;
                }
                C4161q7 c4161q7 = this.f11287l;
                InterfaceC4068i3 interfaceC4068i3 = c4161q7.f11154d;
                if (interfaceC4068i3 == null) {
                    c4161q7.mo5726g().f11141f.m5860a("Failed to get app instance id");
                    this.f11287l.m5866e().m5899M(this.f11286k, null);
                    return;
                }
                String strMo5666A = interfaceC4068i3.mo5666A(this.f11285j);
                if (strMo5666A != null) {
                    this.f11287l.m5969n().f10598g.set(strMo5666A);
                    this.f11287l.m5867l().f10643m.m5695b(strMo5666A);
                }
                this.f11287l.m5808F();
                this.f11287l.m5866e().m5899M(this.f11286k, strMo5666A);
            } catch (RemoteException e) {
                this.f11287l.mo5726g().f11141f.m5861b("Failed to get app instance id", e);
                this.f11287l.m5866e().m5899M(this.f11286k, null);
            }
        } catch (Throwable th) {
            this.f11287l.m5866e().m5899M(this.f11286k, null);
            throw th;
        }
    }
}
