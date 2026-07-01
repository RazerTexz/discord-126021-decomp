package com.discord.utilities.rx;

import androidx.exifinterface.media.ExifInterface;
import d0.w.h.b;
import d0.w.h.c;
import d0.w.i.a.g;
import d0.z.d.m;
import kotlin.coroutines.Continuation;
import rx.Observable;
import s.a.d2.d;
import s.a.l;

/* JADX INFO: compiled from: RxCoroutineUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RxCoroutineUtilsKt {
    public static final <T> Object awaitFirst(Observable<T> observable, Continuation<? super T> continuation) {
        Observable<T> observableZ = observable.z();
        m.checkNotNullExpressionValue(observableZ, "first()");
        return awaitSingle(observableZ, continuation);
    }

    public static final <T> Object awaitSingle(Observable<T> observable, Continuation<? super T> continuation) {
        l lVar = new l(b.intercepted(continuation), 1);
        lVar.A();
        lVar.f(new RxCoroutineUtilsKt$awaitSingle$2$1(observable.R().W(new RxCoroutineUtilsKt$awaitSingle$2$subscription$1(lVar), new RxCoroutineUtilsKt$awaitSingle$2$subscription$2(lVar))));
        Object objU = lVar.u();
        if (objU == c.getCOROUTINE_SUSPENDED()) {
            g.probeCoroutineSuspended(continuation);
        }
        return objU;
    }

    public static final <T> Object toFlow(Observable<T> observable, Continuation<? super d<? extends T>> continuation) {
        return new s.a.d2.b(new RxCoroutineUtilsKt$toFlow$2(observable, null), null, 0, null, 14);
    }
}
