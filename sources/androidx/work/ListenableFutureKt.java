package androidx.work;

import androidx.annotation.RestrictTo;
import java.util.concurrent.ExecutionException;
import kotlin.coroutines.Continuation;
import p007b.p225i.p355b.p359d.p360a.InterfaceFutureC4539a;
import p507d0.p584w.p585h.C12182b;
import p507d0.p584w.p585h.C12183c;
import p507d0.p584w.p586i.p587a.C12190g;
import p507d0.p592z.p594d.C12237l;
import p659s.p660a.C13126l;

/* JADX INFO: compiled from: ListenableFuture.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ListenableFutureKt {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final <R> Object await(InterfaceFutureC4539a<R> interfaceFutureC4539a, Continuation<? super R> continuation) throws Throwable {
        if (interfaceFutureC4539a.isDone()) {
            try {
                return interfaceFutureC4539a.get();
            } catch (ExecutionException e) {
                Throwable cause = e.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw e;
            }
        }
        C13126l c13126l = new C13126l(C12182b.intercepted(continuation), 1);
        interfaceFutureC4539a.addListener(new RunnableC0716x6ec15468(c13126l, interfaceFutureC4539a), DirectExecutor.INSTANCE);
        Object objM11326u = c13126l.m11326u();
        if (objM11326u == C12183c.getCOROUTINE_SUSPENDED()) {
            C12190g.probeCoroutineSuspended(continuation);
        }
        return objM11326u;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    private static final Object await$$forInline(InterfaceFutureC4539a interfaceFutureC4539a, Continuation continuation) throws Throwable {
        if (interfaceFutureC4539a.isDone()) {
            try {
                return interfaceFutureC4539a.get();
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
        interfaceFutureC4539a.addListener(new RunnableC0716x6ec15468(c13126l, interfaceFutureC4539a), DirectExecutor.INSTANCE);
        Object objM11326u = c13126l.m11326u();
        if (objM11326u == C12183c.getCOROUTINE_SUSPENDED()) {
            C12190g.probeCoroutineSuspended(continuation);
        }
        C12237l.mark(1);
        return objM11326u;
    }
}
