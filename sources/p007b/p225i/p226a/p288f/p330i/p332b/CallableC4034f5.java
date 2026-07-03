package p007b.p225i.p226a.p288f.p330i.p332b;

import com.google.android.gms.measurement.internal.zzn;
import com.google.android.gms.measurement.internal.zzz;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: renamed from: b.i.a.f.i.b.f5 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class CallableC4034f5 implements Callable<List<zzz>> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ zzn f10717j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ String f10718k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ String f10719l;

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ BinderC4257z4 f10720m;

    public CallableC4034f5(BinderC4257z4 binderC4257z4, zzn zznVar, String str, String str2) {
        this.f10720m = binderC4257z4;
        this.f10717j = zznVar;
        this.f10718k = str;
        this.f10719l = str2;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<zzz> call() throws Exception {
        this.f10720m.f11390a.m5717R();
        return this.f10720m.f11390a.m5710K().m5623U(this.f10717j.f20683j, this.f10718k, this.f10719l);
    }
}
