package p007b.p225i.p226a.p288f.p330i.p332b;

import com.google.android.gms.measurement.internal.zzn;
import com.google.android.gms.measurement.internal.zzz;

/* JADX INFO: renamed from: b.i.a.f.i.b.b5 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC3986b5 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ zzz f10564j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ zzn f10565k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ BinderC4257z4 f10566l;

    public RunnableC3986b5(BinderC4257z4 binderC4257z4, zzz zzzVar, zzn zznVar) {
        this.f10566l = binderC4257z4;
        this.f10564j = zzzVar;
        this.f10565k = zznVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        this.f10566l.f11390a.m5717R();
        if (this.f10564j.f20702l.m9117w0() == null) {
            this.f10566l.f11390a.m5705F(this.f10564j, this.f10565k);
        } else {
            this.f10566l.f11390a.m5736q(this.f10564j, this.f10565k);
        }
    }
}
