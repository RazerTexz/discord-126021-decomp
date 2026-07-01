package com.discord.utilities.rx;

import androidx.exifinterface.media.ExifInterface;
import d0.z.d.m;
import j0.l.a.r;
import j0.p.a;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Scheduler;

/* JADX INFO: compiled from: OperatorBufferedDelay.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class OperatorBufferedDelay$Companion {
    private OperatorBufferedDelay$Companion() {
    }

    public static /* synthetic */ Observable bufferedDelay$default(OperatorBufferedDelay$Companion operatorBufferedDelay$Companion, Observable observable, long j, TimeUnit timeUnit, int i, Scheduler scheduler, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            timeUnit = TimeUnit.MILLISECONDS;
        }
        TimeUnit timeUnit2 = timeUnit;
        if ((i2 & 8) != 0) {
            scheduler = a.a();
            m.checkNotNullExpressionValue(scheduler, "Schedulers.computation()");
        }
        return operatorBufferedDelay$Companion.bufferedDelay(observable, j, timeUnit2, i, scheduler);
    }

    public final <T> Observable<List<T>> bufferedDelay(Observable<T> observable, long j, TimeUnit timeUnit, int i, Scheduler scheduler) {
        m.checkNotNullParameter(observable, "$this$bufferedDelay");
        m.checkNotNullParameter(timeUnit, "timeUnit");
        m.checkNotNullParameter(scheduler, "scheduler");
        Observable<List<T>> observableH0 = Observable.h0(new r(observable.j, new OperatorBufferedDelay(j, timeUnit, i, scheduler)));
        m.checkNotNullExpressionValue(observableH0, "this.lift(OperatorBuffer…meUnit, size, scheduler))");
        return observableH0;
    }

    public /* synthetic */ OperatorBufferedDelay$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
