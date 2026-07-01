package com.discord.restapi.utils;

import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import j0.k.b;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$LongRef;
import rx.Observable;

/* JADX INFO: compiled from: RetryWithDelay.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RetryWithDelay$retryWithDelay$1<T, R> implements b<Throwable, Observable<? extends Object>> {
    public final /* synthetic */ Ref$LongRef $currentDelayMillis;
    public final /* synthetic */ Ref$IntRef $currentHalfLife;
    public final /* synthetic */ Ref$IntRef $currentRetry;
    public final /* synthetic */ int $maxHalfLives;
    public final /* synthetic */ int $maxRetries;
    public final /* synthetic */ Function1 $retryPredicate;

    public RetryWithDelay$retryWithDelay$1(int i, Ref$IntRef ref$IntRef, Function1 function1, int i2, Ref$IntRef ref$IntRef2, Ref$LongRef ref$LongRef) {
        this.$maxRetries = i;
        this.$currentRetry = ref$IntRef;
        this.$retryPredicate = function1;
        this.$maxHalfLives = i2;
        this.$currentHalfLife = ref$IntRef2;
        this.$currentDelayMillis = ref$LongRef;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends Object> call(Throwable th) {
        return call2(th);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Object> call2(Throwable th) {
        Ref$IntRef ref$IntRef = this.$currentRetry;
        int i = ref$IntRef.element;
        ref$IntRef.element = i + 1;
        if (i < this.$maxRetries) {
            Function1 function1 = this.$retryPredicate;
            m.checkNotNullExpressionValue(th, "it");
            if (((Boolean) function1.invoke(th)).booleanValue()) {
                Ref$IntRef ref$IntRef2 = this.$currentHalfLife;
                int i2 = ref$IntRef2.element;
                int i3 = i2 + 1;
                ref$IntRef2.element = i3;
                if (i2 < this.$maxHalfLives && i3 > 1) {
                    this.$currentDelayMillis.element *= (long) 2;
                }
                return Observable.d0(this.$currentDelayMillis.element, TimeUnit.MILLISECONDS);
            }
        }
        return Observable.x(th);
    }
}
