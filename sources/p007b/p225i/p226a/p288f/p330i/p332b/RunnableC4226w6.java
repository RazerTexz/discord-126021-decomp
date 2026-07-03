package p007b.p225i.p226a.p288f.p330i.p332b;

/* JADX INFO: renamed from: b.i.a.f.i.b.w6 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC4226w6 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ C4004d f11321j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ int f11322k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ long f11323l;

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ boolean f11324m;

    /* JADX INFO: renamed from: n */
    public final /* synthetic */ C3999c6 f11325n;

    public RunnableC4226w6(C3999c6 c3999c6, C4004d c4004d, int i, long j, boolean z2) {
        this.f11325n = c3999c6;
        this.f11321j = c4004d;
        this.f11322k = i;
        this.f11323l = j;
        this.f11324m = z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f11325n.m5559z(this.f11321j);
        C3999c6.m5538C(this.f11325n, this.f11321j, this.f11322k, this.f11323l, false, this.f11324m);
    }
}
