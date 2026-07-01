package kotlin.coroutines;

import androidx.exifinterface.media.ExifInterface;

/* JADX INFO: compiled from: CoroutineContext.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface CoroutineContext$Element extends CoroutineContext {
    @Override // kotlin.coroutines.CoroutineContext
    <E extends CoroutineContext$Element> E get(CoroutineContext$Key<E> key);

    CoroutineContext$Key<?> getKey();
}
