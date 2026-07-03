package androidx.work;

import androidx.work.Operation;
import java.util.concurrent.ExecutionException;
import kotlin.coroutines.Continuation;
import p007b.p225i.p355b.p359d.p360a.InterfaceFutureC4539a;
import p507d0.p584w.p585h.C12182b;
import p507d0.p584w.p585h.C12183c;
import p507d0.p584w.p586i.p587a.C12190g;
import p507d0.p592z.p594d.C12237l;
import p507d0.p592z.p594d.C12238m;
import p659s.p660a.C13126l;

/* JADX INFO: compiled from: Operation.kt */
/* JADX INFO: loaded from: classes.dex */
public final class OperationKt {
    public static final Object await(Operation operation, Continuation<? super Operation.State.SUCCESS> continuation) throws Throwable {
        InterfaceFutureC4539a<Operation.State.SUCCESS> result = operation.getResult();
        C12238m.checkExpressionValueIsNotNull(result, "result");
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
        C13126l c13126l = new C13126l(C12182b.intercepted(continuation), 1);
        result.addListener(new OperationKt$await$$inlined$suspendCancellableCoroutine$lambda$1(c13126l, result), DirectExecutor.INSTANCE);
        Object objM11326u = c13126l.m11326u();
        if (objM11326u != C12183c.getCOROUTINE_SUSPENDED()) {
            return objM11326u;
        }
        C12190g.probeCoroutineSuspended(continuation);
        return objM11326u;
    }

    private static final Object await$$forInline(Operation operation, Continuation continuation) throws Throwable {
        InterfaceFutureC4539a<Operation.State.SUCCESS> result = operation.getResult();
        C12238m.checkExpressionValueIsNotNull(result, "result");
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
        C12237l.mark(0);
        C13126l c13126l = new C13126l(C12182b.intercepted(continuation), 1);
        result.addListener(new OperationKt$await$$inlined$suspendCancellableCoroutine$lambda$1(c13126l, result), DirectExecutor.INSTANCE);
        Object objM11326u = c13126l.m11326u();
        if (objM11326u == C12183c.getCOROUTINE_SUSPENDED()) {
            C12190g.probeCoroutineSuspended(continuation);
        }
        C12237l.mark(1);
        return objM11326u;
    }
}
