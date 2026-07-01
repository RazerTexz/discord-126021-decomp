package b.i.a.f.i.b;

import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzn;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class t7 implements Runnable {
    public final /* synthetic */ zzn j;
    public final /* synthetic */ q7 k;

    public t7(q7 q7Var, zzn zznVar) {
        this.k = q7Var;
        this.j = zznVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        q7 q7Var = this.k;
        i3 i3Var = q7Var.d;
        if (i3Var == null) {
            q7Var.g().f.a("Failed to reset data on the service: not connected to service");
            return;
        }
        try {
            i3Var.I(this.j);
        } catch (RemoteException e) {
            this.k.g().f.b("Failed to reset data on the service: remote exception", e);
        }
        this.k.F();
    }
}
