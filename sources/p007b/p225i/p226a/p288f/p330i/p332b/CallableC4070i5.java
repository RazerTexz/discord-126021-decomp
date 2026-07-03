package p007b.p225i.p226a.p288f.p330i.p332b;

import com.google.android.gms.measurement.internal.zzz;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: renamed from: b.i.a.f.i.b.i5 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class CallableC4070i5 implements Callable<List<zzz>> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ String f10810j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ String f10811k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ String f10812l;

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ BinderC4257z4 f10813m;

    public CallableC4070i5(BinderC4257z4 binderC4257z4, String str, String str2, String str3) {
        this.f10813m = binderC4257z4;
        this.f10810j = str;
        this.f10811k = str2;
        this.f10812l = str3;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<zzz> call() throws Exception {
        this.f10813m.f11390a.m5717R();
        return this.f10813m.f11390a.m5710K().m5623U(this.f10810j, this.f10811k, this.f10812l);
    }
}
