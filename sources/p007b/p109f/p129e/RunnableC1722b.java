package p007b.p109f.p129e;

/* JADX INFO: renamed from: b.f.e.b */
/* JADX INFO: compiled from: AbstractDataSource.java */
/* JADX INFO: loaded from: classes.dex */
public class RunnableC1722b implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ InterfaceC1726f f3150j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ AbstractC1723c f3151k;

    public RunnableC1722b(AbstractC1723c abstractC1723c, InterfaceC1726f interfaceC1726f) {
        this.f3151k = abstractC1723c;
        this.f3150j = interfaceC1726f;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3150j.onProgressUpdate(this.f3151k);
    }
}
