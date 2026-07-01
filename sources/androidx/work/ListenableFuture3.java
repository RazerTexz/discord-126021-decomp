package androidx.work;

import androidx.annotation.RestrictTo;
import b.i.b.d.a.ListenableFuture8;
import d0.w.h.Intrinsics2;
import d0.w.h.IntrinsicsJvm;
import d0.w.i.a.DebugProbes;
import d0.z.d.InlineMarker;
import java.util.concurrent.ExecutionException;
import kotlin.coroutines.Continuation;
import s.a.CancellableContinuationImpl5;

/* JADX INFO: renamed from: androidx.work.ListenableFutureKt, reason: use source file name */
/* JADX INFO: compiled from: ListenableFuture.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ListenableFuture3 {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final <R> Object await(ListenableFuture8<R> listenableFuture8, Continuation<? super R> continuation) throws Throwable {
        if (listenableFuture8.isDone()) {
            try {
                return listenableFuture8.get();
            } catch (ExecutionException e) {
                Throwable cause = e.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw e;
            }
        }
        CancellableContinuationImpl5 cancellableContinuationImpl5 = new CancellableContinuationImpl5(IntrinsicsJvm.intercepted(continuation), 1);
        listenableFuture8.addListener(new ListenableFuture4(cancellableContinuationImpl5, listenableFuture8), DirectExecutor.INSTANCE);
        Object objU = cancellableContinuationImpl5.u();
        if (objU == Intrinsics2.getCOROUTINE_SUSPENDED()) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return objU;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    private static final Object await$$forInline(ListenableFuture8 listenableFuture8, Continuation continuation) throws Throwable {
        if (listenableFuture8.isDone()) {
            try {
                return listenableFuture8.get();
            } catch (ExecutionException e) {
                Throwable cause = e.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw e;
            }
        }
        InlineMarker.mark(0);
        CancellableContinuationImpl5 cancellableContinuationImpl5 = new CancellableContinuationImpl5(IntrinsicsJvm.intercepted(continuation), 1);
        listenableFuture8.addListener(new ListenableFuture4(cancellableContinuationImpl5, listenableFuture8), DirectExecutor.INSTANCE);
        Object objU = cancellableContinuationImpl5.u();
        if (objU == Intrinsics2.getCOROUTINE_SUSPENDED()) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        InlineMarker.mark(1);
        return objU;
    }
}
