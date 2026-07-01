package com.discord.utilities.coroutines;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import b.i.a.f.e.o.f;
import d0.z.d.m;
import kotlin.coroutines.Continuation;
import rx.Observable;

/* JADX INFO: compiled from: RxCoroutineExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RxCoroutineExtensionsKt {
    public static final <T> Object appAwaitFirst(Observable<T> observable, Context context, Continuation<? super T> continuation) {
        Observable<T> observableZ = observable.z();
        m.checkNotNullExpressionValue(observableZ, "first()");
        return appAwaitSingle$default(observableZ, context, null, continuation, 2, null);
    }

    public static /* synthetic */ Object appAwaitFirst$default(Observable observable, Context context, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            context = null;
        }
        return appAwaitFirst(observable, context, continuation);
    }

    public static final <T> Object appAwaitSingle(Observable<T> observable, Context context, Boolean bool, Continuation<? super T> continuation) {
        return f.M(new RxCoroutineExtensionsKt$appAwaitSingle$2(observable, context, bool, null), continuation);
    }

    public static /* synthetic */ Object appAwaitSingle$default(Observable observable, Context context, Boolean bool, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            context = null;
        }
        if ((i & 2) != 0) {
            bool = Boolean.FALSE;
        }
        return appAwaitSingle(observable, context, bool, continuation);
    }
}
