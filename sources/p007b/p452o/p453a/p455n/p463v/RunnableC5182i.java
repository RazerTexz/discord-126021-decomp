package p007b.p452o.p453a.p455n.p463v;

/* JADX INFO: renamed from: b.o.a.n.v.i */
/* JADX INFO: compiled from: CameraStateOrchestrator.java */
/* JADX INFO: loaded from: classes3.dex */
public class RunnableC5182i implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ EnumC5178e f14043j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ Runnable f14044k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ C5179f f14045l;

    public RunnableC5182i(C5179f c5179f, EnumC5178e enumC5178e, Runnable runnable) {
        this.f14045l = c5179f;
        this.f14043j = enumC5178e;
        this.f14044k = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f14045l.f14028f.m7367f(this.f14043j)) {
            this.f14044k.run();
        }
    }
}
