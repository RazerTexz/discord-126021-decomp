package p007b.p225i.p226a.p288f.p330i.p332b;

/* JADX INFO: renamed from: b.i.a.f.i.b.j6 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC4083j6 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ String f10852j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ String f10853k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ Object f10854l;

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ long f10855m;

    /* JADX INFO: renamed from: n */
    public final /* synthetic */ C3999c6 f10856n;

    public RunnableC4083j6(C3999c6 c3999c6, String str, String str2, Object obj, long j) {
        this.f10856n = c3999c6;
        this.f10852j = str;
        this.f10853k = str2;
        this.f10854l = obj;
        this.f10855m = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f10856n.m5548K(this.f10852j, this.f10853k, this.f10854l, this.f10855m);
    }
}
