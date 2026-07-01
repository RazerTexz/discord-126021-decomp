package b.i.a.f.e.k;

import b.i.a.f.e.h.d$a;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class s implements d$a {
    public final /* synthetic */ b.i.a.f.e.h.d a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f1393b;
    public final /* synthetic */ k$a c;

    public s(b.i.a.f.e.h.d dVar, TaskCompletionSource taskCompletionSource, k$a k_a, k$b k_b) {
        this.a = dVar;
        this.f1393b = taskCompletionSource;
        this.c = k_a;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // b.i.a.f.e.h.d$a
    public final void a(Status status) {
        if (!status.w0()) {
            this.f1393b.a.t(b.c.a.a0.d.l0(status));
            return;
        }
        b.i.a.f.e.h.d dVar = this.a;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        BasePendingResult basePendingResult = (BasePendingResult) dVar;
        Objects.requireNonNull(basePendingResult);
        b.c.a.a0.d.G(!basePendingResult.i, "Result has already been consumed.");
        b.c.a.a0.d.G(true, "Cannot await if then() has been called.");
        try {
            if (!basePendingResult.d.await(0L, timeUnit)) {
                basePendingResult.e(Status.m);
            }
        } catch (InterruptedException unused) {
            basePendingResult.e(Status.k);
        }
        b.c.a.a0.d.G(basePendingResult.f(), "Result is not ready.");
        this.f1393b.a.s((TResult) this.c.a(basePendingResult.j()));
    }
}
