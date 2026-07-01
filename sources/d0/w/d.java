package d0.w;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext$Element;

/* JADX INFO: compiled from: ContinuationInterceptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface d extends CoroutineContext$Element {
    public static final /* synthetic */ int e = 0;

    <T> Continuation<T> interceptContinuation(Continuation<? super T> continuation);

    void releaseInterceptedContinuation(Continuation<?> continuation);
}
