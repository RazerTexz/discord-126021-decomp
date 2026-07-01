package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import b.i.a.f.e.o.f;
import com.discord.widgets.chat.input.MentionUtils;
import d0.w.ContinuationInterceptor;
import d0.w.CoroutineContextImpl;
import d0.w.CoroutineContextImpl2;
import java.util.Objects;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import s.a.CancellableContinuationImpl5;
import s.a.CoroutineDispatcher2;
import s.a.a.DispatchedContinuation;

/* JADX INFO: compiled from: CoroutineDispatcher.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class CoroutineDispatcher extends CoroutineContextImpl implements ContinuationInterceptor {

    /* JADX INFO: renamed from: Key, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: kotlinx.coroutines.CoroutineDispatcher$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: CoroutineDispatcher.kt */
    public static final class Companion extends CoroutineContextImpl2<ContinuationInterceptor, CoroutineDispatcher> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super(ContinuationInterceptor.b.a, CoroutineDispatcher2.j);
            int i = ContinuationInterceptor.e;
        }
    }

    public CoroutineDispatcher() {
        super(ContinuationInterceptor.b.a);
    }

    public abstract void dispatch(CoroutineContext context, Runnable block);

    public void dispatchYield(CoroutineContext context, Runnable block) {
        dispatch(context, block);
    }

    @Override // d0.w.CoroutineContextImpl, kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        return (E) ContinuationInterceptor.a.get(this, key);
    }

    @Override // d0.w.ContinuationInterceptor
    public final <T> Continuation<T> interceptContinuation(Continuation<? super T> continuation) {
        return new DispatchedContinuation(this, continuation);
    }

    public boolean isDispatchNeeded(CoroutineContext context) {
        return true;
    }

    @Override // d0.w.CoroutineContextImpl, kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        return ContinuationInterceptor.a.minusKey(this, key);
    }

    public final CoroutineDispatcher plus(CoroutineDispatcher other) {
        return other;
    }

    @Override // d0.w.ContinuationInterceptor
    public void releaseInterceptedContinuation(Continuation<?> continuation) {
        Objects.requireNonNull(continuation, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        Object obj = ((DispatchedContinuation) continuation)._reusableCancellableContinuation;
        if (!(obj instanceof CancellableContinuationImpl5)) {
            obj = null;
        }
        CancellableContinuationImpl5 cancellableContinuationImpl5 = (CancellableContinuationImpl5) obj;
        if (cancellableContinuationImpl5 != null) {
            cancellableContinuationImpl5.q();
        }
    }

    public String toString() {
        return getClass().getSimpleName() + MentionUtils.MENTIONS_CHAR + f.l0(this);
    }
}
