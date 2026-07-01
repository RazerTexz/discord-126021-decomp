package com.discord.utilities.rx;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import d0.z.d.m;
import j0.j.b.a;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Observable$b;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;

/* JADX INFO: compiled from: OnDelayedEmissionHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class OnDelayedEmissionHandler<T> implements Observable$b<T, T> {
    private Subscription delaySubscription;
    private final AtomicBoolean hasFinished;
    private final Function1<Boolean, Unit> onDelayCallback;
    private final Scheduler scheduler;
    private final long timeout;
    private final TimeUnit unit;

    /* JADX WARN: Multi-variable type inference failed */
    public OnDelayedEmissionHandler(Function1<? super Boolean, Unit> function1, long j, TimeUnit timeUnit, Scheduler scheduler) {
        m.checkNotNullParameter(function1, "onDelayCallback");
        m.checkNotNullParameter(timeUnit, "unit");
        m.checkNotNullParameter(scheduler, "scheduler");
        this.onDelayCallback = function1;
        this.timeout = j;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.hasFinished = new AtomicBoolean(false);
    }

    public static final /* synthetic */ Subscription access$getDelaySubscription$p(OnDelayedEmissionHandler onDelayedEmissionHandler) {
        return onDelayedEmissionHandler.delaySubscription;
    }

    public static final /* synthetic */ AtomicBoolean access$getHasFinished$p(OnDelayedEmissionHandler onDelayedEmissionHandler) {
        return onDelayedEmissionHandler.hasFinished;
    }

    public static final /* synthetic */ Function1 access$getOnDelayCallback$p(OnDelayedEmissionHandler onDelayedEmissionHandler) {
        return onDelayedEmissionHandler.onDelayCallback;
    }

    public static final /* synthetic */ Scheduler access$getScheduler$p(OnDelayedEmissionHandler onDelayedEmissionHandler) {
        return onDelayedEmissionHandler.scheduler;
    }

    public static final /* synthetic */ void access$setDelaySubscription$p(OnDelayedEmissionHandler onDelayedEmissionHandler, Subscription subscription) {
        onDelayedEmissionHandler.delaySubscription = subscription;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) obj);
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        m.checkNotNullParameter(subscriber, "subscriber");
        OnDelayedEmissionHandler$call$wrappedSubscriber$1 onDelayedEmissionHandler$call$wrappedSubscriber$1 = new OnDelayedEmissionHandler$call$wrappedSubscriber$1(this, subscriber);
        Observable<Long> observableJ = Observable.d0(this.timeout, this.unit).J(this.scheduler);
        m.checkNotNullExpressionValue(observableJ, "Observable\n        .time…    .observeOn(scheduler)");
        OnDelayedEmissionHandler$call$1 onDelayedEmissionHandler$call$1 = new OnDelayedEmissionHandler$call$1(this);
        ObservableExtensionsKt.appSubscribe$default(observableJ, OnDelayedEmissionHandler.class, (Context) null, new OnDelayedEmissionHandler$call$3(this), new OnDelayedEmissionHandler$call$2(onDelayedEmissionHandler$call$wrappedSubscriber$1), (Function0) null, (Function0) null, onDelayedEmissionHandler$call$1, 50, (Object) null);
        return onDelayedEmissionHandler$call$wrappedSubscriber$1;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ OnDelayedEmissionHandler(Function1 function1, long j, TimeUnit timeUnit, Scheduler scheduler, int i, DefaultConstructorMarker defaultConstructorMarker) {
        long j2 = (i & 2) != 0 ? 0L : j;
        TimeUnit timeUnit2 = (i & 4) != 0 ? TimeUnit.MILLISECONDS : timeUnit;
        if ((i & 8) != 0) {
            scheduler = a.a();
            m.checkNotNullExpressionValue(scheduler, "AndroidSchedulers.mainThread()");
        }
        this(function1, j2, timeUnit2, scheduler);
    }
}
