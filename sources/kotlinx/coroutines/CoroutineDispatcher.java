package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.discord.widgets.chat.input.MentionUtilsKt;
import java.util.Objects;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p584w.AbstractC12174a;
import p507d0.p584w.AbstractC12175b;
import p507d0.p584w.InterfaceC12177d;
import p659s.p660a.C13042a0;
import p659s.p660a.C13126l;
import p659s.p660a.p661a.C13024g;

/* JADX INFO: compiled from: CoroutineDispatcher.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class CoroutineDispatcher extends AbstractC12174a implements InterfaceC12177d {

    /* JADX INFO: renamed from: Key, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: kotlinx.coroutines.CoroutineDispatcher$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: CoroutineDispatcher.kt */
    public static final class Companion extends AbstractC12175b<InterfaceC12177d, CoroutineDispatcher> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super(InterfaceC12177d.b.f25236a, C13042a0.f27711j);
            int i = InterfaceC12177d.f25235e;
        }
    }

    public CoroutineDispatcher() {
        super(InterfaceC12177d.b.f25236a);
    }

    public abstract void dispatch(CoroutineContext context, Runnable block);

    public void dispatchYield(CoroutineContext context, Runnable block) {
        dispatch(context, block);
    }

    @Override // p507d0.p584w.AbstractC12174a, kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        return (E) InterfaceC12177d.a.get(this, key);
    }

    @Override // p507d0.p584w.InterfaceC12177d
    public final <T> Continuation<T> interceptContinuation(Continuation<? super T> continuation) {
        return new C13024g(this, continuation);
    }

    public boolean isDispatchNeeded(CoroutineContext context) {
        return true;
    }

    @Override // p507d0.p584w.AbstractC12174a, kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        return InterfaceC12177d.a.minusKey(this, key);
    }

    public final CoroutineDispatcher plus(CoroutineDispatcher other) {
        return other;
    }

    @Override // p507d0.p584w.InterfaceC12177d
    public void releaseInterceptedContinuation(Continuation<?> continuation) {
        Objects.requireNonNull(continuation, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        Object obj = ((C13024g) continuation)._reusableCancellableContinuation;
        if (!(obj instanceof C13126l)) {
            obj = null;
        }
        C13126l c13126l = (C13126l) obj;
        if (c13126l != null) {
            c13126l.m11323q();
        }
    }

    public String toString() {
        return getClass().getSimpleName() + MentionUtilsKt.MENTIONS_CHAR + C3404f.m4312l0(this);
    }
}
