package com.discord.restapi.utils;

import androidx.exifinterface.media.ExifInterface;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$LongRef;
import rx.Observable;

/* JADX INFO: compiled from: RetryWithDelay.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RetryWithDelay {
    public static final RetryWithDelay INSTANCE = new RetryWithDelay();

    private RetryWithDelay() {
    }

    public static final /* synthetic */ Observable access$retryWithDelay(RetryWithDelay retryWithDelay, Observable observable, long j, Integer num, Integer num2, Function1 function1) {
        return retryWithDelay.retryWithDelay(observable, j, num, num2, function1);
    }

    public static /* synthetic */ Observable restRetry$default(RetryWithDelay retryWithDelay, Observable observable, long j, Integer num, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 1000;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            num = 3;
        }
        Integer num3 = num;
        if ((i & 4) != 0) {
            num2 = 3;
        }
        return retryWithDelay.restRetry(observable, j2, num3, num2);
    }

    private final Observable<Object> retryWithDelay(Observable<? extends Throwable> observable, long j, Integer num, Integer num2, Function1<? super Throwable, Boolean> function1) {
        int iIntValue = num2 != null ? num2.intValue() : Integer.MAX_VALUE;
        int iIntValue2 = num != null ? num.intValue() : Integer.MAX_VALUE;
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        ref$IntRef.element = 0;
        Ref$IntRef ref$IntRef2 = new Ref$IntRef();
        ref$IntRef2.element = 0;
        Ref$LongRef ref$LongRef = new Ref$LongRef();
        ref$LongRef.element = j;
        Observable<R> observableA = observable.A(new RetryWithDelay$retryWithDelay$1(iIntValue, ref$IntRef, function1, iIntValue2, ref$IntRef2, ref$LongRef));
        m.checkNotNullExpressionValue(observableA, "flatMap {\n      if (curr…able.error<Any>(it)\n    }");
        return observableA;
    }

    public final <T> Observable<T> restRetry(Observable<T> observable, long j, Integer num, Integer num2) {
        m.checkNotNullParameter(observable, "$this$restRetry");
        RetryWithDelay$restRetry$1 retryWithDelay$restRetry$1 = RetryWithDelay$restRetry$1.INSTANCE;
        Observable<T> observableO = observable.O(new RetryWithDelay$restRetry$2(j, num, num2));
        m.checkNotNullExpressionValue(observableO, "retryWhen { it.retryWith…ries, ::isNetworkError) }");
        return observableO;
    }

    public static /* synthetic */ Observable restRetry$default(RetryWithDelay retryWithDelay, Observable observable, long j, Integer num, Integer num2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 1000;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            num = 3;
        }
        Integer num3 = num;
        if ((i & 4) != 0) {
            num2 = 3;
        }
        return retryWithDelay.restRetry(observable, j2, num3, num2, function1);
    }

    public final <T> Observable<T> restRetry(Observable<T> observable, long j, Integer num, Integer num2, Function1<? super Throwable, Boolean> function1) {
        m.checkNotNullParameter(observable, "$this$restRetry");
        m.checkNotNullParameter(function1, "predicate");
        Observable<T> observableO = observable.O(new RetryWithDelay$restRetry$3(j, num, num2, function1));
        m.checkNotNullExpressionValue(observableO, "retryWhen { it.retryWith… maxRetries, predicate) }");
        return observableO;
    }
}
