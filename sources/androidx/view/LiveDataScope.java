package androidx.view;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import p659s.p660a.InterfaceC13130m0;

/* JADX INFO: compiled from: CoroutineLiveData.kt */
/* JADX INFO: loaded from: classes.dex */
public interface LiveDataScope<T> {
    Object emit(T t, Continuation<? super Unit> continuation);

    Object emitSource(LiveData<T> liveData, Continuation<? super InterfaceC13130m0> continuation);

    T getLatestValue();
}
