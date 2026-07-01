package b.i.a.f.i.b;

import com.google.android.gms.measurement.internal.zzz;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class i5 implements Callable<List<zzz>> {
    public final /* synthetic */ String j;
    public final /* synthetic */ String k;
    public final /* synthetic */ String l;
    public final /* synthetic */ z4 m;

    public i5(z4 z4Var, String str, String str2, String str3) {
        this.m = z4Var;
        this.j = str;
        this.k = str2;
        this.l = str3;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<zzz> call() throws Exception {
        this.m.a.R();
        return this.m.a.K().U(this.j, this.k, this.l);
    }
}
