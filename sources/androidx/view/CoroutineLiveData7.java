package androidx.view;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import s.a.Job2;

/* JADX INFO: renamed from: androidx.lifecycle.LiveDataScope, reason: use source file name */
/* JADX INFO: compiled from: CoroutineLiveData.kt */
/* JADX INFO: loaded from: classes.dex */
public interface CoroutineLiveData7<T> {
    Object emit(T t, Continuation<? super Unit> continuation);

    Object emitSource(LiveData<T> liveData, Continuation<? super Job2> continuation);

    T getLatestValue();
}
