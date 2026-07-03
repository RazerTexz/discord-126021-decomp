package p007b.p225i.p226a.p288f.p330i.p332b;

/* JADX INFO: renamed from: b.i.a.f.i.b.x6 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC4237x6 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ C4004d f11343j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ long f11344k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ int f11345l;

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ long f11346m;

    /* JADX INFO: renamed from: n */
    public final /* synthetic */ boolean f11347n;

    /* JADX INFO: renamed from: o */
    public final /* synthetic */ C3999c6 f11348o;

    public RunnableC4237x6(C3999c6 c3999c6, C4004d c4004d, long j, int i, long j2, boolean z2) {
        this.f11348o = c3999c6;
        this.f11343j = c4004d;
        this.f11344k = j;
        this.f11345l = i;
        this.f11346m = j2;
        this.f11347n = z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f11348o.m5559z(this.f11343j);
        this.f11348o.m5556w(this.f11344k, false);
        C3999c6.m5538C(this.f11348o, this.f11343j, this.f11345l, this.f11346m, true, this.f11347n);
    }
}
