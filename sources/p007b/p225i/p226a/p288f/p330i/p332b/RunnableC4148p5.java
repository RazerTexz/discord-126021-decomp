package p007b.p225i.p226a.p288f.p330i.p332b;

/* JADX INFO: renamed from: b.i.a.f.i.b.p5 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC4148p5 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ String f11123j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ String f11124k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ String f11125l;

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ long f11126m;

    /* JADX INFO: renamed from: n */
    public final /* synthetic */ BinderC4257z4 f11127n;

    public RunnableC4148p5(BinderC4257z4 binderC4257z4, String str, String str2, String str3, long j) {
        this.f11127n = binderC4257z4;
        this.f11123j = str;
        this.f11124k = str2;
        this.f11125l = str3;
        this.f11126m = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f11123j == null) {
            this.f11127n.f11390a.f10906k.m5952w().m5654D(this.f11124k, null);
            return;
        }
        C4060h7 c4060h7M5952w = this.f11127n.f11390a.f10906k.m5952w();
        String str = this.f11124k;
        c4060h7M5952w.mo5848b();
        synchronized (c4060h7M5952w) {
            String str2 = c4060h7M5952w.f10785m;
            if (str2 != null) {
                str2.equals(str);
            }
            c4060h7M5952w.f10785m = str;
        }
    }
}
