package p007b.p225i.p226a.p288f.p330i.p332b;

import com.google.android.gms.measurement.internal.zzku;
import com.google.android.gms.measurement.internal.zzn;

/* JADX INFO: renamed from: b.i.a.f.i.b.o5 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC4137o5 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ zzku f11007j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ zzn f11008k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ BinderC4257z4 f11009l;

    public RunnableC4137o5(BinderC4257z4 binderC4257z4, zzku zzkuVar, zzn zznVar) {
        this.f11009l = binderC4257z4;
        this.f11007j = zzkuVar;
        this.f11008k = zznVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        this.f11009l.f11390a.m5717R();
        if (this.f11007j.m9117w0() == null) {
            this.f11009l.f11390a.m5703D(this.f11007j, this.f11008k);
        } else {
            this.f11009l.f11390a.m5734o(this.f11007j, this.f11008k);
        }
    }
}
