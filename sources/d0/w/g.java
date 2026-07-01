package d0.w;

import d0.k$b;
import d0.z.d.m;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;

/* JADX INFO: compiled from: SafeContinuationJvm.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g<T> implements Continuation<T>, CoroutineStackFrame {

    @Deprecated
    public static final AtomicReferenceFieldUpdater<g<?>, Object> j;
    public final Continuation<T> k;
    public volatile Object result;

    static {
        new g$a(null);
        j = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "result");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(Continuation<? super T> continuation, Object obj) {
        m.checkNotNullParameter(continuation, "delegate");
        this.k = continuation;
        this.result = obj;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.k.getContext();
    }

    public final Object getOrThrow() throws Throwable {
        Object obj = this.result;
        d0.w.h.a aVar = d0.w.h.a.UNDECIDED;
        if (obj == aVar) {
            if (j.compareAndSet(this, aVar, d0.w.h.c.getCOROUTINE_SUSPENDED())) {
                return d0.w.h.c.getCOROUTINE_SUSPENDED();
            }
            obj = this.result;
        }
        if (obj == d0.w.h.a.RESUMED) {
            return d0.w.h.c.getCOROUTINE_SUSPENDED();
        }
        if (obj instanceof k$b) {
            throw ((k$b) obj).exception;
        }
        return obj;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
        while (true) {
            Object obj2 = this.result;
            d0.w.h.a aVar = d0.w.h.a.UNDECIDED;
            if (obj2 == aVar) {
                if (j.compareAndSet(this, aVar, obj)) {
                    return;
                }
            } else {
                if (obj2 != d0.w.h.c.getCOROUTINE_SUSPENDED()) {
                    throw new IllegalStateException("Already resumed");
                }
                if (j.compareAndSet(this, d0.w.h.c.getCOROUTINE_SUSPENDED(), d0.w.h.a.RESUMED)) {
                    this.k.resumeWith(obj);
                    return;
                }
            }
        }
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("SafeContinuation for ");
        sbU.append(this.k);
        return sbU.toString();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public g(Continuation<? super T> continuation) {
        this(continuation, d0.w.h.a.UNDECIDED);
        m.checkNotNullParameter(continuation, "delegate");
    }
}
