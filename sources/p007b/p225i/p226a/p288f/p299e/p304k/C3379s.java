package p007b.p225i.p226a.p288f.p299e.p304k;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p299e.p300h.AbstractC3269d;

/* JADX INFO: renamed from: b.i.a.f.e.k.s */
/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3379s implements AbstractC3269d.a {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ AbstractC3269d f9560a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ TaskCompletionSource f9561b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ C3363k.a f9562c;

    public C3379s(AbstractC3269d abstractC3269d, TaskCompletionSource taskCompletionSource, C3363k.a aVar, C3363k.b bVar) {
        this.f9560a = abstractC3269d;
        this.f9561b = taskCompletionSource;
        this.f9562c = aVar;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // p007b.p225i.p226a.p288f.p299e.p300h.AbstractC3269d.a
    /* JADX INFO: renamed from: a */
    public final void mo4052a(Status status) {
        if (!status.m9030w0()) {
            this.f9561b.f20845a.m6025t(C1460d.m540l0(status));
            return;
        }
        AbstractC3269d abstractC3269d = this.f9560a;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        BasePendingResult basePendingResult = (BasePendingResult) abstractC3269d;
        Objects.requireNonNull(basePendingResult);
        C1460d.m435G(!basePendingResult.f20507i, "Result has already been consumed.");
        C1460d.m435G(true, "Cannot await if then() has been called.");
        try {
            if (!basePendingResult.f20502d.await(0L, timeUnit)) {
                basePendingResult.m9033e(Status.f20492m);
            }
        } catch (InterruptedException unused) {
            basePendingResult.m9033e(Status.f20490k);
        }
        C1460d.m435G(basePendingResult.m9034f(), "Result is not ready.");
        this.f9561b.f20845a.m6024s((TResult) this.f9562c.mo4165a(basePendingResult.m9037j()));
    }
}
