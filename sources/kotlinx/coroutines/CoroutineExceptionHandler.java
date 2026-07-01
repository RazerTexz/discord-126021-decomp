package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext$Element;

/* JADX INFO: compiled from: CoroutineExceptionHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface CoroutineExceptionHandler extends CoroutineContext$Element {
    public static final /* synthetic */ int g = 0;

    void handleException(CoroutineContext coroutineContext, Throwable th);
}
