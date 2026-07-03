package p686z;

import java.util.concurrent.CancellationException;

/* JADX INFO: renamed from: z.e */
/* JADX INFO: compiled from: Task.java */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC13200e implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ C13203h f27972j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ InterfaceC13198c f27973k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ C13202g f27974l;

    public RunnableC13200e(C13203h c13203h, InterfaceC13198c interfaceC13198c, C13202g c13202g) {
        this.f27972j = c13203h;
        this.f27973k = interfaceC13198c;
        this.f27974l = c13202g;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f27972j.m11376c(this.f27973k.mo1510a(this.f27974l));
        } catch (CancellationException unused) {
            this.f27972j.m11374a();
        } catch (Exception e) {
            this.f27972j.m11375b(e);
        }
    }
}
