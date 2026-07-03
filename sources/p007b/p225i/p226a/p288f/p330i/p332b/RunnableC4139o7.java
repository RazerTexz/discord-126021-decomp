package p007b.p225i.p226a.p288f.p330i.p332b;

/* JADX INFO: renamed from: b.i.a.f.i.b.o7 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC4139o7 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ C4072i7 f11014j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ long f11015k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ C4060h7 f11016l;

    public RunnableC4139o7(C4060h7 c4060h7, C4072i7 c4072i7, long j) {
        this.f11016l = c4060h7;
        this.f11014j = c4072i7;
        this.f11015k = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f11016l.m5653C(this.f11014j, false, this.f11015k);
        C4060h7 c4060h7 = this.f11016l;
        c4060h7.f10777e = null;
        C4161q7 c4161q7M5971p = c4060h7.m5971p();
        c4161q7M5971p.mo5848b();
        c4161q7M5971p.m5497t();
        c4161q7M5971p.m5814z(new RunnableC4227w7(c4161q7M5971p, null));
    }
}
