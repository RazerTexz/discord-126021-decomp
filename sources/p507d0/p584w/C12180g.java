package p507d0.p584w;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12112k;
import p507d0.p584w.p585h.C12183c;
import p507d0.p584w.p585h.EnumC12181a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.w.g */
/* JADX INFO: compiled from: SafeContinuationJvm.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12180g<T> implements Continuation<T>, CoroutineStackFrame {

    /* JADX INFO: renamed from: j */
    @Deprecated
    public static final AtomicReferenceFieldUpdater<C12180g<?>, Object> f25238j;

    /* JADX INFO: renamed from: k */
    public final Continuation<T> f25239k;
    public volatile Object result;

    /* JADX INFO: renamed from: d0.w.g$a */
    /* JADX INFO: compiled from: SafeContinuationJvm.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    static {
        new a(null);
        f25238j = AtomicReferenceFieldUpdater.newUpdater(C12180g.class, Object.class, "result");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C12180g(Continuation<? super T> continuation, Object obj) {
        C12238m.checkNotNullParameter(continuation, "delegate");
        this.f25239k = continuation;
        this.result = obj;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.f25239k.getContext();
    }

    public final Object getOrThrow() throws Throwable {
        Object obj = this.result;
        EnumC12181a enumC12181a = EnumC12181a.UNDECIDED;
        if (obj == enumC12181a) {
            if (f25238j.compareAndSet(this, enumC12181a, C12183c.getCOROUTINE_SUSPENDED())) {
                return C12183c.getCOROUTINE_SUSPENDED();
            }
            obj = this.result;
        }
        if (obj == EnumC12181a.RESUMED) {
            return C12183c.getCOROUTINE_SUSPENDED();
        }
        if (obj instanceof C12112k.b) {
            throw ((C12112k.b) obj).exception;
        }
        return obj;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
        while (true) {
            Object obj2 = this.result;
            EnumC12181a enumC12181a = EnumC12181a.UNDECIDED;
            if (obj2 == enumC12181a) {
                if (f25238j.compareAndSet(this, enumC12181a, obj)) {
                    return;
                }
            } else {
                if (obj2 != C12183c.getCOROUTINE_SUSPENDED()) {
                    throw new IllegalStateException("Already resumed");
                }
                if (f25238j.compareAndSet(this, C12183c.getCOROUTINE_SUSPENDED(), EnumC12181a.RESUMED)) {
                    this.f25239k.resumeWith(obj);
                    return;
                }
            }
        }
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("SafeContinuation for ");
        sbM833U.append(this.f25239k);
        return sbM833U.toString();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C12180g(Continuation<? super T> continuation) {
        this(continuation, EnumC12181a.UNDECIDED);
        C12238m.checkNotNullParameter(continuation, "delegate");
    }
}
