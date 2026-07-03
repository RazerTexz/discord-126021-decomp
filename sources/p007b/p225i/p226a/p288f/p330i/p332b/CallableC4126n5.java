package p007b.p225i.p226a.p288f.p330i.p332b;

import com.google.android.gms.measurement.internal.zzn;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: renamed from: b.i.a.f.i.b.n5 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class CallableC4126n5 implements Callable<List<C4207u9>> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ zzn f10991j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ BinderC4257z4 f10992k;

    public CallableC4126n5(BinderC4257z4 binderC4257z4, zzn zznVar) {
        this.f10992k = binderC4257z4;
        this.f10991j = zznVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<C4207u9> call() throws Exception {
        this.f10992k.f11390a.m5717R();
        return this.f10992k.f11390a.m5710K().m5606C(this.f10991j.f20683j);
    }
}
