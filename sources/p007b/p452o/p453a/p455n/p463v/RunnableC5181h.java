package p007b.p452o.p453a.p455n.p463v;

/* JADX INFO: renamed from: b.o.a.n.v.h */
/* JADX INFO: compiled from: CameraStateOrchestrator.java */
/* JADX INFO: loaded from: classes3.dex */
public class RunnableC5181h implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ EnumC5178e f14040j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ Runnable f14041k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ C5179f f14042l;

    public RunnableC5181h(C5179f c5179f, EnumC5178e enumC5178e, Runnable runnable) {
        this.f14042l = c5179f;
        this.f14040j = enumC5178e;
        this.f14041k = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f14042l.f14028f.m7367f(this.f14040j)) {
            this.f14041k.run();
        }
    }
}
