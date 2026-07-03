package p007b.p225i.p226a.p288f.p330i.p332b;

/* JADX INFO: renamed from: b.i.a.f.i.b.i6 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC4071i6 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ long f10814j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ C3999c6 f10815k;

    public RunnableC4071i6(C3999c6 c3999c6, long j) {
        this.f10815k = c3999c6;
        this.f10814j = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f10815k.m5867l().f10647q.m5649b(this.f10814j);
        this.f10815k.mo5726g().f11148m.m5861b("Minimum session duration set", Long.valueOf(this.f10814j));
    }
}
