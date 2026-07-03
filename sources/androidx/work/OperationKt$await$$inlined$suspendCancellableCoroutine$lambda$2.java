package androidx.work;

import java.util.concurrent.CancellationException;
import kotlinx.coroutines.CancellableContinuation;
import p007b.p225i.p355b.p359d.p360a.InterfaceFutureC4539a;
import p507d0.C12112k;
import p507d0.C12113l;

/* JADX INFO: compiled from: ListenableFuture.kt */
/* JADX INFO: loaded from: classes.dex */
public final class OperationKt$await$$inlined$suspendCancellableCoroutine$lambda$2 implements Runnable {
    public final /* synthetic */ CancellableContinuation $cancellableContinuation;
    public final /* synthetic */ InterfaceFutureC4539a $this_await$inlined;

    public OperationKt$await$$inlined$suspendCancellableCoroutine$lambda$2(CancellableContinuation cancellableContinuation, InterfaceFutureC4539a interfaceFutureC4539a) {
        this.$cancellableContinuation = cancellableContinuation;
        this.$this_await$inlined = interfaceFutureC4539a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            CancellableContinuation cancellableContinuation = this.$cancellableContinuation;
            V v = this.$this_await$inlined.get();
            C12112k.a aVar = C12112k.f25169j;
            cancellableContinuation.resumeWith(C12112k.m11474constructorimpl(v));
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                cause = th;
            }
            if (th instanceof CancellationException) {
                this.$cancellableContinuation.mo10906k(cause);
                return;
            }
            CancellableContinuation cancellableContinuation2 = this.$cancellableContinuation;
            C12112k.a aVar2 = C12112k.f25169j;
            cancellableContinuation2.resumeWith(C12112k.m11474constructorimpl(C12113l.createFailure(cause)));
        }
    }
}
