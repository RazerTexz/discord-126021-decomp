package b.i.a.f.i.b;

import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzn;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class v7 implements Runnable {
    public final /* synthetic */ AtomicReference j;
    public final /* synthetic */ zzn k;
    public final /* synthetic */ q7 l;

    public v7(q7 q7Var, AtomicReference atomicReference, zzn zznVar) {
        this.l = q7Var;
        this.j = atomicReference;
        this.k = zznVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.j) {
            try {
                try {
                    if (b.i.a.f.h.l.t8.b() && this.l.a.h.o(p.H0) && !this.l.l().y().k()) {
                        this.l.g().k.a("Analytics storage consent denied; will not get app instance id");
                        this.l.n().g.set(null);
                        this.l.l().m.b(null);
                        this.j.set(null);
                        this.j.notify();
                        return;
                    }
                    q7 q7Var = this.l;
                    i3 i3Var = q7Var.d;
                    if (i3Var == null) {
                        q7Var.g().f.a("Failed to get app instance id");
                        this.j.notify();
                        return;
                    }
                    this.j.set(i3Var.A(this.k));
                    String str = (String) this.j.get();
                    if (str != null) {
                        this.l.n().g.set(str);
                        this.l.l().m.b(str);
                    }
                    this.l.F();
                    this.j.notify();
                } catch (RemoteException e) {
                    this.l.g().f.b("Failed to get app instance id", e);
                    this.j.notify();
                }
            } catch (Throwable th) {
                this.j.notify();
                throw th;
            }
        }
    }
}
