package p007b.p225i.p361c.p369m.p370d.p373k;

import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import p007b.p225i.p361c.p369m.p370d.C4592b;

/* JADX INFO: renamed from: b.i.c.m.d.k.t0 */
/* JADX INFO: compiled from: ExecutorUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4656t0 extends AbstractRunnableC4616d {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ String f12391j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ ExecutorService f12392k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ long f12393l;

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ TimeUnit f12394m;

    public C4656t0(String str, ExecutorService executorService, long j, TimeUnit timeUnit) {
        this.f12391j = str;
        this.f12392k = executorService;
        this.f12393l = j;
        this.f12394m = timeUnit;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p373k.AbstractRunnableC4616d
    /* JADX INFO: renamed from: a */
    public void mo6398a() {
        try {
            C4592b c4592b = C4592b.f12227a;
            c4592b.m6371b("Executing shutdown hook for " + this.f12391j);
            this.f12392k.shutdown();
            if (this.f12392k.awaitTermination(this.f12393l, this.f12394m)) {
                return;
            }
            c4592b.m6371b(this.f12391j + " did not shut down in the allocated time. Requesting immediate shutdown.");
            this.f12392k.shutdownNow();
        } catch (InterruptedException unused) {
            C4592b.f12227a.m6371b(String.format(Locale.US, "Interrupted while waiting for %s to shut down. Requesting immediate shutdown.", this.f12391j));
            this.f12392k.shutdownNow();
        }
    }
}
