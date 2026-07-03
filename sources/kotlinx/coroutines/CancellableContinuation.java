package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: CancellableContinuation.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface CancellableContinuation<T> extends Continuation<T> {
    /* JADX INFO: renamed from: a */
    boolean mo10900a();

    /* JADX INFO: renamed from: c */
    Object mo10901c(T value, Object idempotent);

    /* JADX INFO: renamed from: f */
    void mo10902f(Function1<? super Throwable, Unit> handler);

    /* JADX INFO: renamed from: g */
    Object mo10903g(Throwable exception);

    /* JADX INFO: renamed from: h */
    Object mo10904h(T value, Object idempotent, Function1<? super Throwable, Unit> onCancellation);

    /* JADX INFO: renamed from: i */
    void mo10905i(CoroutineDispatcher coroutineDispatcher, T t);

    /* JADX INFO: renamed from: k */
    boolean mo10906k(Throwable cause);

    /* JADX INFO: renamed from: r */
    void mo10907r(Object token);
}
