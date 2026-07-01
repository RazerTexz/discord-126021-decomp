package b.i.a.f.i.b;

import com.google.android.gms.measurement.internal.zzn;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class o9 implements Callable<String> {
    public final /* synthetic */ zzn j;
    public final /* synthetic */ k9 k;

    public o9(k9 k9Var, zzn zznVar) {
        this.k = k9Var;
        this.j = zznVar;
    }

    @Override // java.util.concurrent.Callable
    public final String call() throws Exception {
        if (!b.i.a.f.h.l.t8.b() || !this.k.k.h.o(p.J0) || (this.k.a(this.j.j).k() && d.b(this.j.F).k())) {
            return this.k.G(this.j).s();
        }
        this.k.g().n.a("Analytics storage consent denied. Returning null app instance id");
        return null;
    }
}
