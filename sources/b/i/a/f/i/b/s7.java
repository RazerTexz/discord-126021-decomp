package b.i.a.f.i.b;

import android.os.Bundle;
import android.os.RemoteException;
import b.i.a.f.h.l.fc;
import com.google.android.gms.measurement.internal.zzn;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class s7 implements Runnable {
    public final /* synthetic */ String j;
    public final /* synthetic */ String k;
    public final /* synthetic */ boolean l;
    public final /* synthetic */ zzn m;
    public final /* synthetic */ fc n;
    public final /* synthetic */ q7 o;

    public s7(q7 q7Var, String str, String str2, boolean z2, zzn zznVar, fc fcVar) {
        this.o = q7Var;
        this.j = str;
        this.k = str2;
        this.l = z2;
        this.m = zznVar;
        this.n = fcVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bundle bundle = new Bundle();
        try {
            try {
                q7 q7Var = this.o;
                i3 i3Var = q7Var.d;
                if (i3Var == null) {
                    q7Var.g().f.c("Failed to get user properties; not connected to service", this.j, this.k);
                    this.o.e().L(this.n, bundle);
                } else {
                    Bundle bundleA = t9.A(i3Var.R(this.j, this.k, this.l, this.m));
                    this.o.F();
                    this.o.e().L(this.n, bundleA);
                }
            } catch (RemoteException e) {
                this.o.g().f.c("Failed to get user properties; remote exception", this.j, e);
                this.o.e().L(this.n, bundle);
            }
        } catch (Throwable th) {
            this.o.e().L(this.n, bundle);
            throw th;
        }
    }
}
