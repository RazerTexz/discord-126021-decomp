package b.d.a.a;

import java.util.concurrent.Future;

/* JADX INFO: compiled from: com.android.billingclient:billing@@4.0.0 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a0 implements Runnable {
    public final /* synthetic */ Future j;
    public final /* synthetic */ Runnable k;

    public /* synthetic */ a0(Future future, Runnable runnable) {
        this.j = future;
        this.k = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Future future = this.j;
        Runnable runnable = this.k;
        if (future.isDone() || future.isCancelled()) {
            return;
        }
        future.cancel(true);
        b.i.a.f.h.n.a.f("BillingClient", "Async task is taking too long, cancel it!");
        if (runnable != null) {
            runnable.run();
        }
    }
}
