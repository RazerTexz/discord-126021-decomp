package p007b.p225i.p226a.p288f.p330i.p332b;

import com.google.android.gms.measurement.internal.zzn;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: renamed from: b.i.a.f.i.b.d5 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class CallableC4010d5 implements Callable<List<C4207u9>> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ zzn f10657j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ String f10658k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ String f10659l;

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ BinderC4257z4 f10660m;

    public CallableC4010d5(BinderC4257z4 binderC4257z4, zzn zznVar, String str, String str2) {
        this.f10660m = binderC4257z4;
        this.f10657j = zznVar;
        this.f10658k = str;
        this.f10659l = str2;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<C4207u9> call() throws Exception {
        this.f10660m.f11390a.m5717R();
        return this.f10660m.f11390a.m5710K().m5608E(this.f10657j.f20683j, this.f10658k, this.f10659l);
    }
}
