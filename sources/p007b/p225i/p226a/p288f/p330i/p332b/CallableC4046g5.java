package p007b.p225i.p226a.p288f.p330i.p332b;

import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: renamed from: b.i.a.f.i.b.g5 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class CallableC4046g5 implements Callable<List<C4207u9>> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ String f10749j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ String f10750k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ String f10751l;

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ BinderC4257z4 f10752m;

    public CallableC4046g5(BinderC4257z4 binderC4257z4, String str, String str2, String str3) {
        this.f10752m = binderC4257z4;
        this.f10749j = str;
        this.f10750k = str2;
        this.f10751l = str3;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<C4207u9> call() throws Exception {
        this.f10752m.f11390a.m5717R();
        return this.f10752m.f11390a.m5710K().m5608E(this.f10749j, this.f10750k, this.f10751l);
    }
}
