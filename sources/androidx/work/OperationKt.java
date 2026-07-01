package androidx.work;

import b.i.b.d.a.a;
import d0.w.h.b;
import d0.w.h.c;
import d0.w.i.a.g;
import d0.z.d.m;
import java.util.concurrent.ExecutionException;
import kotlin.coroutines.Continuation;
import s.a.l;

/* JADX INFO: compiled from: Operation.kt */
/* JADX INFO: loaded from: classes.dex */
public final class OperationKt {
    public static final Object await(Operation operation, Continuation<? super Operation$State$SUCCESS> continuation) throws Throwable {
        a<Operation$State$SUCCESS> result = operation.getResult();
        m.checkExpressionValueIsNotNull(result, "result");
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
        l lVar = new l(b.intercepted(continuation), 1);
        result.addListener(new OperationKt$await$$inlined$suspendCancellableCoroutine$lambda$1(lVar, result), DirectExecutor.INSTANCE);
        Object objU = lVar.u();
        if (objU != c.getCOROUTINE_SUSPENDED()) {
            return objU;
        }
        g.probeCoroutineSuspended(continuation);
        return objU;
    }

    private static final Object await$$forInline(Operation operation, Continuation continuation) throws Throwable {
        a<Operation$State$SUCCESS> result = operation.getResult();
        m.checkExpressionValueIsNotNull(result, "result");
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
        d0.z.d.l.mark(0);
        l lVar = new l(b.intercepted(continuation), 1);
        result.addListener(new OperationKt$await$$inlined$suspendCancellableCoroutine$lambda$1(lVar, result), DirectExecutor.INSTANCE);
        Object objU = lVar.u();
        if (objU == c.getCOROUTINE_SUSPENDED()) {
            g.probeCoroutineSuspended(continuation);
        }
        d0.z.d.l.mark(1);
        return objU;
    }
}
