package b.i.a.f.i.b;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class w7 implements Runnable {
    public final /* synthetic */ i7 j;
    public final /* synthetic */ q7 k;

    public w7(q7 q7Var, i7 i7Var) {
        this.k = q7Var;
        this.j = i7Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        q7 q7Var = this.k;
        i3 i3Var = q7Var.d;
        if (i3Var == null) {
            q7Var.g().f.a("Failed to send current screen to service");
            return;
        }
        try {
            i7 i7Var = this.j;
            if (i7Var == null) {
                i3Var.G(0L, null, null, q7Var.a.f1570b.getPackageName());
            } else {
                i3Var.G(i7Var.c, i7Var.a, i7Var.f1537b, q7Var.a.f1570b.getPackageName());
            }
            this.k.F();
        } catch (RemoteException e) {
            this.k.g().f.b("Failed to send current screen to the service", e);
        }
    }
}
