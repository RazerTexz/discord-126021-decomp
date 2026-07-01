package b.i.a.f.i.b;

import com.google.android.gms.measurement.internal.zzn;
import com.google.android.gms.measurement.internal.zzz;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class g8 implements Runnable {
    public final /* synthetic */ boolean j;
    public final /* synthetic */ zzz k;
    public final /* synthetic */ zzn l;
    public final /* synthetic */ zzz m;
    public final /* synthetic */ q7 n;

    public g8(q7 q7Var, boolean z2, zzz zzzVar, zzn zznVar, zzz zzzVar2) {
        this.n = q7Var;
        this.j = z2;
        this.k = zzzVar;
        this.l = zznVar;
        this.m = zzzVar2;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        q7 q7Var = this.n;
        i3 i3Var = q7Var.d;
        if (i3Var == null) {
            q7Var.g().f.a("Discarding data. Failed to send conditional user property to service");
        } else {
            q7Var.w(i3Var, this.j ? null : this.k, this.l);
            this.n.F();
        }
    }
}
