package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: CancellableContinuation.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface CancellableContinuation<T> extends Continuation<T> {
    boolean a();

    Object c(T value, Object idempotent);

    void f(Function1<? super Throwable, Unit> handler);

    Object g(Throwable exception);

    Object h(T value, Object idempotent, Function1<? super Throwable, Unit> onCancellation);

    void i(CoroutineDispatcher coroutineDispatcher, T t);

    boolean k(Throwable cause);

    void r(Object token);
}
