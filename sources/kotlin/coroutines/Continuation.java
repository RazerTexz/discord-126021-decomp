package kotlin.coroutines;

import androidx.exifinterface.media.ExifInterface;

/* JADX INFO: compiled from: Continuation.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface Continuation<T> {
    CoroutineContext getContext();

    void resumeWith(Object result);
}
