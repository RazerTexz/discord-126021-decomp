package b.i.a.f.i.b;

import com.google.android.gms.measurement.internal.zzn;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class d5 implements Callable<List<u9>> {
    public final /* synthetic */ zzn j;
    public final /* synthetic */ String k;
    public final /* synthetic */ String l;
    public final /* synthetic */ z4 m;

    public d5(z4 z4Var, zzn zznVar, String str, String str2) {
        this.m = z4Var;
        this.j = zznVar;
        this.k = str;
        this.l = str2;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<u9> call() throws Exception {
        this.m.a.R();
        return this.m.a.K().E(this.j.j, this.k, this.l);
    }
}
