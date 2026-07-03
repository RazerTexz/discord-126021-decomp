package p007b.p109f.p129e;

/* JADX INFO: renamed from: b.f.e.a */
/* JADX INFO: compiled from: AbstractDataSource.java */
/* JADX INFO: loaded from: classes.dex */
public class RunnableC1721a implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ boolean f3146j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ InterfaceC1726f f3147k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ boolean f3148l;

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ AbstractC1723c f3149m;

    public RunnableC1721a(AbstractC1723c abstractC1723c, boolean z2, InterfaceC1726f interfaceC1726f, boolean z3) {
        this.f3149m = abstractC1723c;
        this.f3146j = z2;
        this.f3147k = interfaceC1726f;
        this.f3148l = z3;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3146j) {
            this.f3147k.onFailure(this.f3149m);
        } else if (this.f3148l) {
            this.f3147k.onCancellation(this.f3149m);
        } else {
            this.f3147k.onNewResult(this.f3149m);
        }
    }
}
