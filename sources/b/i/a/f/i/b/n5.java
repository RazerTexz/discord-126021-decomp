package b.i.a.f.i.b;

import com.google.android.gms.measurement.internal.zzn;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class n5 implements Callable<List<u9>> {
    public final /* synthetic */ zzn j;
    public final /* synthetic */ z4 k;

    public n5(z4 z4Var, zzn zznVar) {
        this.k = z4Var;
        this.j = zznVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<u9> call() throws Exception {
        this.k.a.R();
        return this.k.a.K().C(this.j.j);
    }
}
