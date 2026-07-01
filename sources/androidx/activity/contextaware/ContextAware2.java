package androidx.activity.contextaware;

import android.content.Context;
import d0.w.h.Intrinsics2;
import d0.w.h.IntrinsicsJvm;
import d0.w.i.a.DebugProbes;
import d0.z.d.InlineMarker;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import s.a.CancellableContinuationImpl5;

/* JADX INFO: renamed from: androidx.activity.contextaware.ContextAwareKt, reason: use source file name */
/* JADX INFO: compiled from: ContextAware.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ContextAware2 {
    public static final <R> Object withContextAvailable(ContextAware contextAware, Function1<? super Context, ? extends R> function1, Continuation<? super R> continuation) {
        Context contextPeekAvailableContext = contextAware.peekAvailableContext();
        if (contextPeekAvailableContext != null) {
            return function1.invoke(contextPeekAvailableContext);
        }
        CancellableContinuationImpl5 cancellableContinuationImpl5 = new CancellableContinuationImpl5(IntrinsicsJvm.intercepted(continuation), 1);
        cancellableContinuationImpl5.A();
        ContextAware3 contextAware3 = new ContextAware3(cancellableContinuationImpl5, contextAware, function1);
        contextAware.addOnContextAvailableListener(contextAware3);
        cancellableContinuationImpl5.f(new ContextAware4(contextAware3, contextAware, function1));
        Object objU = cancellableContinuationImpl5.u();
        if (objU != Intrinsics2.getCOROUTINE_SUSPENDED()) {
            return objU;
        }
        DebugProbes.probeCoroutineSuspended(continuation);
        return objU;
    }

    private static final Object withContextAvailable$$forInline(ContextAware contextAware, Function1 function1, Continuation continuation) {
        Context contextPeekAvailableContext = contextAware.peekAvailableContext();
        if (contextPeekAvailableContext != null) {
            return function1.invoke(contextPeekAvailableContext);
        }
        InlineMarker.mark(0);
        CancellableContinuationImpl5 cancellableContinuationImpl5 = new CancellableContinuationImpl5(IntrinsicsJvm.intercepted(continuation), 1);
        cancellableContinuationImpl5.A();
        ContextAware3 contextAware3 = new ContextAware3(cancellableContinuationImpl5, contextAware, function1);
        contextAware.addOnContextAvailableListener(contextAware3);
        cancellableContinuationImpl5.f(new ContextAware4(contextAware3, contextAware, function1));
        Object objU = cancellableContinuationImpl5.u();
        if (objU == Intrinsics2.getCOROUTINE_SUSPENDED()) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        InlineMarker.mark(1);
        return objU;
    }
}
