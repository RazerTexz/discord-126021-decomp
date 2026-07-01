package b.i.a.f.i.b;

import com.google.android.gms.measurement.internal.zzku;
import com.google.android.gms.measurement.internal.zzn;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class r7 implements Runnable {
    public final /* synthetic */ boolean j;
    public final /* synthetic */ zzku k;
    public final /* synthetic */ zzn l;
    public final /* synthetic */ q7 m;

    public r7(q7 q7Var, boolean z2, zzku zzkuVar, zzn zznVar) {
        this.m = q7Var;
        this.j = z2;
        this.k = zzkuVar;
        this.l = zznVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        q7 q7Var = this.m;
        i3 i3Var = q7Var.d;
        if (i3Var == null) {
            q7Var.g().f.a("Discarding data. Failed to set user property");
        } else {
            q7Var.w(i3Var, this.j ? null : this.k, this.l);
            this.m.F();
        }
    }
}
