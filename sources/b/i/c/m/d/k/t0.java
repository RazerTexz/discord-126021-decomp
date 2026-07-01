package b.i.c.m.d.k;

import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: ExecutorUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class t0 extends d {
    public final /* synthetic */ String j;
    public final /* synthetic */ ExecutorService k;
    public final /* synthetic */ long l;
    public final /* synthetic */ TimeUnit m;

    public t0(String str, ExecutorService executorService, long j, TimeUnit timeUnit) {
        this.j = str;
        this.k = executorService;
        this.l = j;
        this.m = timeUnit;
    }

    @Override // b.i.c.m.d.k.d
    public void a() {
        try {
            b.i.c.m.d.b bVar = b.i.c.m.d.b.a;
            bVar.b("Executing shutdown hook for " + this.j);
            this.k.shutdown();
            if (this.k.awaitTermination(this.l, this.m)) {
                return;
            }
            bVar.b(this.j + " did not shut down in the allocated time. Requesting immediate shutdown.");
            this.k.shutdownNow();
        } catch (InterruptedException unused) {
            b.i.c.m.d.b.a.b(String.format(Locale.US, "Interrupted while waiting for %s to shut down. Requesting immediate shutdown.", this.j));
            this.k.shutdownNow();
        }
    }
}
