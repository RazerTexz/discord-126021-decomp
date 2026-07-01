package b.i.c.m.d.k;

import b.i.c.m.d.Logger3;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: b.i.c.m.d.k.t0, reason: use source file name */
/* JADX INFO: compiled from: ExecutorUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class ExecutorUtils2 extends BackgroundPriorityRunnable {
    public final /* synthetic */ String j;
    public final /* synthetic */ ExecutorService k;
    public final /* synthetic */ long l;
    public final /* synthetic */ TimeUnit m;

    public ExecutorUtils2(String str, ExecutorService executorService, long j, TimeUnit timeUnit) {
        this.j = str;
        this.k = executorService;
        this.l = j;
        this.m = timeUnit;
    }

    @Override // b.i.c.m.d.k.BackgroundPriorityRunnable
    public void a() {
        try {
            Logger3 logger3 = Logger3.a;
            logger3.b("Executing shutdown hook for " + this.j);
            this.k.shutdown();
            if (this.k.awaitTermination(this.l, this.m)) {
                return;
            }
            logger3.b(this.j + " did not shut down in the allocated time. Requesting immediate shutdown.");
            this.k.shutdownNow();
        } catch (InterruptedException unused) {
            Logger3.a.b(String.format(Locale.US, "Interrupted while waiting for %s to shut down. Requesting immediate shutdown.", this.j));
            this.k.shutdownNow();
        }
    }
}
