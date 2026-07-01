package androidx.work;

import b.i.b.d.a.a;
import d0.k;
import d0.k$a;
import d0.l;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.CancellableContinuation;

/* JADX INFO: compiled from: ListenableFuture.kt */
/* JADX INFO: loaded from: classes.dex */
public final class OperationKt$await$$inlined$suspendCancellableCoroutine$lambda$1 implements Runnable {
    public final /* synthetic */ CancellableContinuation $cancellableContinuation;
    public final /* synthetic */ a $this_await$inlined;

    public OperationKt$await$$inlined$suspendCancellableCoroutine$lambda$1(CancellableContinuation cancellableContinuation, a aVar) {
        this.$cancellableContinuation = cancellableContinuation;
        this.$this_await$inlined = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            CancellableContinuation cancellableContinuation = this.$cancellableContinuation;
            V v = this.$this_await$inlined.get();
            k$a k_a = k.j;
            cancellableContinuation.resumeWith(k.m97constructorimpl(v));
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                cause = th;
            }
            if (th instanceof CancellationException) {
                this.$cancellableContinuation.k(cause);
                return;
            }
            CancellableContinuation cancellableContinuation2 = this.$cancellableContinuation;
            k$a k_a2 = k.j;
            cancellableContinuation2.resumeWith(k.m97constructorimpl(l.createFailure(cause)));
        }
    }
}
