package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import b.i.a.f.e.o.f;
import com.discord.widgets.chat.input.MentionUtilsKt;
import d0.w.a;
import d0.w.d;
import d0.w.d$a;
import d0.w.d$b;
import java.util.Objects;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.coroutines.CoroutineContext$Key;
import s.a.a.g;
import s.a.l;

/* JADX INFO: compiled from: CoroutineDispatcher.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class CoroutineDispatcher extends a implements d {
    public static final CoroutineDispatcher$a Key = new CoroutineDispatcher$a(null);

    public CoroutineDispatcher() {
        super(d$b.a);
    }

    public abstract void dispatch(CoroutineContext context, Runnable block);

    public void dispatchYield(CoroutineContext context, Runnable block) {
        dispatch(context, block);
    }

    @Override // d0.w.a, kotlin.coroutines.CoroutineContext$Element, kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext$Element> E get(CoroutineContext$Key<E> coroutineContext$Key) {
        return (E) d$a.get(this, coroutineContext$Key);
    }

    @Override // d0.w.d
    public final <T> Continuation<T> interceptContinuation(Continuation<? super T> continuation) {
        return new g(this, continuation);
    }

    public boolean isDispatchNeeded(CoroutineContext context) {
        return true;
    }

    @Override // d0.w.a, kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext$Key<?> coroutineContext$Key) {
        return d$a.minusKey(this, coroutineContext$Key);
    }

    public final CoroutineDispatcher plus(CoroutineDispatcher other) {
        return other;
    }

    @Override // d0.w.d
    public void releaseInterceptedContinuation(Continuation<?> continuation) {
        Objects.requireNonNull(continuation, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        Object obj = ((g) continuation)._reusableCancellableContinuation;
        if (!(obj instanceof l)) {
            obj = null;
        }
        l lVar = (l) obj;
        if (lVar != null) {
            lVar.q();
        }
    }

    public String toString() {
        return getClass().getSimpleName() + MentionUtilsKt.MENTIONS_CHAR + f.l0(this);
    }
}
