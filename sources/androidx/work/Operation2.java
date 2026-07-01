package androidx.work;

import androidx.work.Operation;
import b.i.b.d.a.ListenableFuture8;
import d0.w.h.Intrinsics2;
import d0.w.h.IntrinsicsJvm;
import d0.w.i.a.DebugProbes;
import d0.z.d.InlineMarker;
import d0.z.d.Intrinsics3;
import java.util.concurrent.ExecutionException;
import kotlin.coroutines.Continuation;
import s.a.CancellableContinuationImpl5;

/* JADX INFO: renamed from: androidx.work.OperationKt, reason: use source file name */
/* JADX INFO: compiled from: Operation.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Operation2 {
    public static final Object await(Operation operation, Continuation<? super Operation.State.SUCCESS> continuation) throws Throwable {
        ListenableFuture8<Operation.State.SUCCESS> result = operation.getResult();
        Intrinsics3.checkExpressionValueIsNotNull(result, "result");
        if (result.isDone()) {
            try {
                return result.get();
            } catch (ExecutionException e) {
                Throwable cause = e.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw e;
            }
        }
        CancellableContinuationImpl5 cancellableContinuationImpl5 = new CancellableContinuationImpl5(IntrinsicsJvm.intercepted(continuation), 1);
        result.addListener(new ListenableFuture6(cancellableContinuationImpl5, result), DirectExecutor.INSTANCE);
        Object objU = cancellableContinuationImpl5.u();
        if (objU != Intrinsics2.getCOROUTINE_SUSPENDED()) {
            return objU;
        }
        DebugProbes.probeCoroutineSuspended(continuation);
        return objU;
    }

    private static final Object await$$forInline(Operation operation, Continuation continuation) throws Throwable {
        ListenableFuture8<Operation.State.SUCCESS> result = operation.getResult();
        Intrinsics3.checkExpressionValueIsNotNull(result, "result");
        if (result.isDone()) {
            try {
                return result.get();
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
        result.addListener(new ListenableFuture6(cancellableContinuationImpl5, result), DirectExecutor.INSTANCE);
        Object objU = cancellableContinuationImpl5.u();
        if (objU == Intrinsics2.getCOROUTINE_SUSPENDED()) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        InlineMarker.mark(1);
        return objU;
    }
}
