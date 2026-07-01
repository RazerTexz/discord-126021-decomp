package b.i.a.f.i.b;

import android.os.RemoteException;
import b.i.a.f.h.l.fc;
import com.google.android.gms.measurement.internal.zzn;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class u7 implements Runnable {
    public final /* synthetic */ zzn j;
    public final /* synthetic */ fc k;
    public final /* synthetic */ q7 l;

    public u7(q7 q7Var, zzn zznVar, fc fcVar) {
        this.l = q7Var;
        this.j = zznVar;
        this.k = fcVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            try {
                if (b.i.a.f.h.l.t8.b() && this.l.a.h.o(p.H0) && !this.l.l().y().k()) {
                    this.l.g().k.a("Analytics storage consent denied; will not get app instance id");
                    this.l.n().g.set(null);
                    this.l.l().m.b(null);
                    this.l.e().M(this.k, null);
                    return;
                }
                q7 q7Var = this.l;
                i3 i3Var = q7Var.d;
                if (i3Var == null) {
                    q7Var.g().f.a("Failed to get app instance id");
                    this.l.e().M(this.k, null);
                    return;
                }
                String strA = i3Var.A(this.j);
                if (strA != null) {
                    this.l.n().g.set(strA);
                    this.l.l().m.b(strA);
                }
                this.l.F();
                this.l.e().M(this.k, strA);
            } catch (RemoteException e) {
                this.l.g().f.b("Failed to get app instance id", e);
                this.l.e().M(this.k, null);
            }
        } catch (Throwable th) {
            this.l.e().M(this.k, null);
            throw th;
        }
    }
}
