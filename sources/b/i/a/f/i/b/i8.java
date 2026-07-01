package b.i.a.f.i.b;

import android.os.Bundle;
import android.os.RemoteException;
import b.i.a.f.h.l.fc;
import com.google.android.gms.measurement.internal.zzn;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class i8 implements Runnable {
    public final /* synthetic */ String j;
    public final /* synthetic */ String k;
    public final /* synthetic */ zzn l;
    public final /* synthetic */ fc m;
    public final /* synthetic */ q7 n;

    public i8(q7 q7Var, String str, String str2, zzn zznVar, fc fcVar) {
        this.n = q7Var;
        this.j = str;
        this.k = str2;
        this.l = zznVar;
        this.m = fcVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ArrayList<Bundle> arrayList = new ArrayList<>();
        try {
            try {
                q7 q7Var = this.n;
                i3 i3Var = q7Var.d;
                if (i3Var == null) {
                    q7Var.g().f.c("Failed to get conditional properties; not connected to service", this.j, this.k);
                    this.n.e().N(this.m, arrayList);
                } else {
                    ArrayList<Bundle> arrayListJ0 = t9.j0(i3Var.K(this.j, this.k, this.l));
                    this.n.F();
                    this.n.e().N(this.m, arrayListJ0);
                }
            } catch (RemoteException e) {
                this.n.g().f.d("Failed to get conditional properties; remote exception", this.j, this.k, e);
                this.n.e().N(this.m, arrayList);
            }
        } catch (Throwable th) {
            this.n.e().N(this.m, arrayList);
            throw th;
        }
    }
}
