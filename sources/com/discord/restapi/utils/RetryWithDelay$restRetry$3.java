package com.discord.restapi.utils;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import d0.z.d.m;
import j0.k.b;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* JADX INFO: compiled from: RetryWithDelay.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RetryWithDelay$restRetry$3<T, R> implements b<Observable<? extends Throwable>, Observable<?>> {
    public final /* synthetic */ long $delayMillis;
    public final /* synthetic */ Integer $maxHalfLives;
    public final /* synthetic */ Integer $maxRetries;
    public final /* synthetic */ Function1 $predicate;

    public RetryWithDelay$restRetry$3(long j, Integer num, Integer num2, Function1 function1) {
        this.$delayMillis = j;
        this.$maxHalfLives = num;
        this.$maxRetries = num2;
        this.$predicate = function1;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<?> call(Observable<? extends Throwable> observable) {
        return call2(observable);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<?> call2(Observable<? extends Throwable> observable) {
        RetryWithDelay retryWithDelay = RetryWithDelay.INSTANCE;
        m.checkNotNullExpressionValue(observable, "it");
        return RetryWithDelay.access$retryWithDelay(retryWithDelay, observable, this.$delayMillis, this.$maxHalfLives, this.$maxRetries, this.$predicate);
    }
}
