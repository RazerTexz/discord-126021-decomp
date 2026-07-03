package p007b.p225i.p226a.p288f.p330i.p332b;

import com.google.android.gms.measurement.internal.zzaq;

/* JADX INFO: renamed from: b.i.a.f.i.b.m5 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC4115m5 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ zzaq f10964j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ String f10965k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ BinderC4257z4 f10966l;

    public RunnableC4115m5(BinderC4257z4 binderC4257z4, zzaq zzaqVar, String str) {
        this.f10966l = binderC4257z4;
        this.f10964j = zzaqVar;
        this.f10965k = str;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        this.f10966l.f11390a.m5717R();
        this.f10966l.f11390a.m5732m(this.f10964j, this.f10965k);
    }
}
