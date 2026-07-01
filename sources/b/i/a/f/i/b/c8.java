package b.i.a.f.i.b;

import android.os.RemoteException;
import b.i.a.f.h.l.fc;
import com.google.android.gms.measurement.internal.zzaq;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class c8 implements Runnable {
    public final /* synthetic */ zzaq j;
    public final /* synthetic */ String k;
    public final /* synthetic */ fc l;
    public final /* synthetic */ q7 m;

    public c8(q7 q7Var, zzaq zzaqVar, String str, fc fcVar) {
        this.m = q7Var;
        this.j = zzaqVar;
        this.k = str;
        this.l = fcVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            try {
                q7 q7Var = this.m;
                i3 i3Var = q7Var.d;
                if (i3Var == null) {
                    q7Var.g().f.a("Discarding data. Failed to send event to service to bundle");
                    this.m.e().P(this.l, null);
                } else {
                    byte[] bArrJ = i3Var.j(this.j, this.k);
                    this.m.F();
                    this.m.e().P(this.l, bArrJ);
                }
            } catch (RemoteException e) {
                this.m.g().f.b("Failed to send event to the service to bundle", e);
                this.m.e().P(this.l, null);
            }
        } catch (Throwable th) {
            this.m.e().P(this.l, null);
            throw th;
        }
    }
}
