package b.i.a.f.i.b;

import com.google.android.gms.measurement.internal.zzku;
import com.google.android.gms.measurement.internal.zzn;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class o5 implements Runnable {
    public final /* synthetic */ zzku j;
    public final /* synthetic */ zzn k;
    public final /* synthetic */ z4 l;

    public o5(z4 z4Var, zzku zzkuVar, zzn zznVar) {
        this.l = z4Var;
        this.j = zzkuVar;
        this.k = zznVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        this.l.a.R();
        if (this.j.w0() == null) {
            this.l.a.D(this.j, this.k);
        } else {
            this.l.a.o(this.j, this.k);
        }
    }
}
