package b.i.a.f.i.b;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzn;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class a8 implements Runnable {
    public final /* synthetic */ Bundle j;
    public final /* synthetic */ zzn k;
    public final /* synthetic */ q7 l;

    public a8(q7 q7Var, Bundle bundle, zzn zznVar) {
        this.l = q7Var;
        this.j = bundle;
        this.k = zznVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        q7 q7Var = this.l;
        i3 i3Var = q7Var.d;
        if (i3Var == null) {
            q7Var.g().f.a("Failed to send default event parameters to service");
            return;
        }
        try {
            i3Var.m0(this.j, this.k);
        } catch (RemoteException e) {
            this.l.g().f.b("Failed to send default event parameters to service", e);
        }
    }
}
