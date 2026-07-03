package p686z;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;

/* JADX INFO: renamed from: z.f */
/* JADX INFO: compiled from: Task.java */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC13201f implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ C13203h f27975j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ Callable f27976k;

    public RunnableC13201f(C13203h c13203h, Callable callable) {
        this.f27975j = c13203h;
        this.f27976k = callable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f27975j.m11376c(this.f27976k.call());
        } catch (CancellationException unused) {
            this.f27975j.m11374a();
        } catch (Exception e) {
            this.f27975j.m11375b(e);
        }
    }
}
