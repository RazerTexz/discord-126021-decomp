package kotlin.coroutines;

import androidx.exifinterface.media.ExifInterface;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: CoroutineContext.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface CoroutineContext {
    <R> R fold(R initial, Function2<? super R, ? super CoroutineContext$Element, ? extends R> operation);

    <E extends CoroutineContext$Element> E get(CoroutineContext$Key<E> key);

    CoroutineContext minusKey(CoroutineContext$Key<?> key);

    CoroutineContext plus(CoroutineContext context);
}
