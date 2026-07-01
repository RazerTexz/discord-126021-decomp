package b.i.a.f.i.b;

import com.google.android.gms.measurement.internal.zzaq;
import com.google.android.gms.measurement.internal.zzn;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class d8 implements Runnable {
    public final /* synthetic */ boolean j;
    public final /* synthetic */ zzaq k;
    public final /* synthetic */ zzn l;
    public final /* synthetic */ String m;
    public final /* synthetic */ q7 n;

    public d8(q7 q7Var, boolean z2, boolean z3, zzaq zzaqVar, zzn zznVar, String str) {
        this.n = q7Var;
        this.j = z3;
        this.k = zzaqVar;
        this.l = zznVar;
        this.m = str;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        q7 q7Var = this.n;
        i3 i3Var = q7Var.d;
        if (i3Var == null) {
            q7Var.g().f.a("Discarding data. Failed to send event to service");
        } else {
            q7Var.w(i3Var, this.j ? null : this.k, this.l);
            this.n.F();
        }
    }
}
