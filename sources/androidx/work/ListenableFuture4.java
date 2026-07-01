package androidx.work;

import b.i.b.d.a.ListenableFuture8;
import d0.Result2;
import d0.Result3;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.CancellableContinuation;

/* JADX INFO: renamed from: androidx.work.ListenableFutureKt$await$$inlined$suspendCancellableCoroutine$lambda$1, reason: use source file name */
/* JADX INFO: compiled from: ListenableFuture.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ListenableFuture4 implements Runnable {
    public final /* synthetic */ CancellableContinuation $cancellableContinuation;
    public final /* synthetic */ ListenableFuture8 $this_await$inlined;

    public ListenableFuture4(CancellableContinuation cancellableContinuation, ListenableFuture8 listenableFuture8) {
        this.$cancellableContinuation = cancellableContinuation;
        this.$this_await$inlined = listenableFuture8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            CancellableContinuation cancellableContinuation = this.$cancellableContinuation;
            V v = this.$this_await$inlined.get();
            Result2.a aVar = Result2.j;
            cancellableContinuation.resumeWith(Result2.m97constructorimpl(v));
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
            Result2.a aVar2 = Result2.j;
            cancellableContinuation2.resumeWith(Result2.m97constructorimpl(Result3.createFailure(cause)));
        }
    }
}
