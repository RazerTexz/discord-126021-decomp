package p007b.p225i.p226a.p288f.p330i.p332b;

import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzn;
import java.util.concurrent.atomic.AtomicReference;
import p007b.p225i.p226a.p288f.p313h.p325l.C3842t8;

/* JADX INFO: renamed from: b.i.a.f.i.b.v7 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC4216v7 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ AtomicReference f11310j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ zzn f11311k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ C4161q7 f11312l;

    public RunnableC4216v7(C4161q7 c4161q7, AtomicReference atomicReference, zzn zznVar) {
        this.f11312l = c4161q7;
        this.f11310j = atomicReference;
        this.f11311k = zznVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f11310j) {
            try {
                try {
                    if (C3842t8.m5293b() && this.f11312l.f11202a.f11260h.m5526o(C4142p.f11035H0) && !this.f11312l.m5867l().m5581y().m5572k()) {
                        this.f11312l.mo5726g().f11146k.m5860a("Analytics storage consent denied; will not get app instance id");
                        this.f11312l.m5969n().f10598g.set(null);
                        this.f11312l.m5867l().f10643m.m5695b(null);
                        this.f11310j.set(null);
                        this.f11310j.notify();
                        return;
                    }
                    C4161q7 c4161q7 = this.f11312l;
                    InterfaceC4068i3 interfaceC4068i3 = c4161q7.f11154d;
                    if (interfaceC4068i3 == null) {
                        c4161q7.mo5726g().f11141f.m5860a("Failed to get app instance id");
                        this.f11310j.notify();
                        return;
                    }
                    this.f11310j.set(interfaceC4068i3.mo5666A(this.f11311k));
                    String str = (String) this.f11310j.get();
                    if (str != null) {
                        this.f11312l.m5969n().f10598g.set(str);
                        this.f11312l.m5867l().f10643m.m5695b(str);
                    }
                    this.f11312l.m5808F();
                    this.f11310j.notify();
                } catch (RemoteException e) {
                    this.f11312l.mo5726g().f11141f.m5861b("Failed to get app instance id", e);
                    this.f11310j.notify();
                }
            } catch (Throwable th) {
                this.f11310j.notify();
                throw th;
            }
        }
    }
}
