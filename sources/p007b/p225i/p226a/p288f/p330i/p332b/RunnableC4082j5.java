package p007b.p225i.p226a.p288f.p330i.p332b;

import com.google.android.gms.measurement.internal.zzap;
import com.google.android.gms.measurement.internal.zzaq;
import com.google.android.gms.measurement.internal.zzn;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.f.i.b.j5 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC4082j5 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ zzaq f10849j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ zzn f10850k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ BinderC4257z4 f10851l;

    public RunnableC4082j5(BinderC4257z4 binderC4257z4, zzaq zzaqVar, zzn zznVar) {
        this.f10851l = binderC4257z4;
        this.f10849j = zzaqVar;
        this.f10850k = zznVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        zzap zzapVar;
        BinderC4257z4 binderC4257z4 = this.f10851l;
        zzaq zzaqVar = this.f10849j;
        Objects.requireNonNull(binderC4257z4);
        boolean z2 = false;
        if ("_cmp".equals(zzaqVar.f20666j) && (zzapVar = zzaqVar.f20667k) != null && zzapVar.f20665j.size() != 0) {
            String string = zzaqVar.f20667k.f20665j.getString("_cis");
            if ("referrer broadcast".equals(string) || "referrer API".equals(string)) {
                z2 = true;
            }
        }
        if (z2) {
            binderC4257z4.f11390a.mo5726g().f11147l.m5861b("Event has been filtered ", zzaqVar.toString());
            zzaqVar = new zzaq("_cmpx", zzaqVar.f20667k, zzaqVar.f20668l, zzaqVar.f20669m);
        }
        this.f10851l.f11390a.m5717R();
        this.f10851l.f11390a.m5731l(zzaqVar, this.f10850k);
    }
}
