package d0.w;

import b.d.b.a.outline;
import d0.Result2;
import d0.w.h.Intrinsics;
import d0.w.h.Intrinsics2;
import d0.z.d.Intrinsics3;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.w.g, reason: use source file name */
/* JADX INFO: compiled from: SafeContinuationJvm.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SafeContinuationJvm<T> implements Continuation<T>, CoroutineStackFrame {

    @Deprecated
    public static final AtomicReferenceFieldUpdater<SafeContinuationJvm<?>, Object> j;
    public final Continuation<T> k;
    public volatile Object result;

    /* JADX INFO: renamed from: d0.w.g$a */
    /* JADX INFO: compiled from: SafeContinuationJvm.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    static {
        new a(null);
        j = AtomicReferenceFieldUpdater.newUpdater(SafeContinuationJvm.class, Object.class, "result");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SafeContinuationJvm(Continuation<? super T> continuation, Object obj) {
        Intrinsics3.checkNotNullParameter(continuation, "delegate");
        this.k = continuation;
        this.result = obj;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.k.getContext();
    }

    public final Object getOrThrow() throws Throwable {
        Object obj = this.result;
        Intrinsics intrinsics = Intrinsics.UNDECIDED;
        if (obj == intrinsics) {
            if (j.compareAndSet(this, intrinsics, Intrinsics2.getCOROUTINE_SUSPENDED())) {
                return Intrinsics2.getCOROUTINE_SUSPENDED();
            }
            obj = this.result;
        }
        if (obj == Intrinsics.RESUMED) {
            return Intrinsics2.getCOROUTINE_SUSPENDED();
        }
        if (obj instanceof Result2.b) {
            throw ((Result2.b) obj).exception;
        }
        return obj;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
        while (true) {
            Object obj2 = this.result;
            Intrinsics intrinsics = Intrinsics.UNDECIDED;
            if (obj2 == intrinsics) {
                if (j.compareAndSet(this, intrinsics, obj)) {
                    return;
                }
            } else {
                if (obj2 != Intrinsics2.getCOROUTINE_SUSPENDED()) {
                    throw new IllegalStateException("Already resumed");
                }
                if (j.compareAndSet(this, Intrinsics2.getCOROUTINE_SUSPENDED(), Intrinsics.RESUMED)) {
                    this.k.resumeWith(obj);
                    return;
                }
            }
        }
    }

    public String toString() {
        StringBuilder sbU = outline.U("SafeContinuation for ");
        sbU.append(this.k);
        return sbU.toString();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SafeContinuationJvm(Continuation<? super T> continuation) {
        this(continuation, Intrinsics.UNDECIDED);
        Intrinsics3.checkNotNullParameter(continuation, "delegate");
    }
}
