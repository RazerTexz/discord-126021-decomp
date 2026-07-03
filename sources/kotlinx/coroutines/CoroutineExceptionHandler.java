package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;

/* JADX INFO: compiled from: CoroutineExceptionHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface CoroutineExceptionHandler extends CoroutineContext.Element {

    /* JADX INFO: renamed from: g */
    public static final /* synthetic */ int f27455g = 0;

    /* JADX INFO: renamed from: kotlinx.coroutines.CoroutineExceptionHandler$a */
    /* JADX INFO: compiled from: CoroutineExceptionHandler.kt */
    public static final class C12804a implements CoroutineContext.Key<CoroutineExceptionHandler> {

        /* JADX INFO: renamed from: a */
        public static final /* synthetic */ C12804a f27456a = new C12804a();
    }

    void handleException(CoroutineContext coroutineContext, Throwable th);
}
