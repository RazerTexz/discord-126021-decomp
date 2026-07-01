package com.discord.utilities.rx;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.j.b.AndroidSchedulers;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;

/* JADX INFO: compiled from: OnDelayedEmissionHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class OnDelayedEmissionHandler<T> implements Observable.b<T, T> {
    private Subscription delaySubscription;
    private final AtomicBoolean hasFinished;
    private final Function1<Boolean, Unit> onDelayCallback;
    private final Scheduler scheduler;
    private final long timeout;
    private final TimeUnit unit;

    /* JADX INFO: renamed from: com.discord.utilities.rx.OnDelayedEmissionHandler$call$1, reason: invalid class name */
    /* JADX INFO: compiled from: OnDelayedEmissionHandler.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Long, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            if (OnDelayedEmissionHandler.this.hasFinished.get()) {
                return;
            }
            OnDelayedEmissionHandler.this.onDelayCallback.invoke(Boolean.TRUE);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.rx.OnDelayedEmissionHandler$call$2, reason: invalid class name */
    /* JADX INFO: compiled from: OnDelayedEmissionHandler.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ OnDelayedEmissionHandler2 $wrappedSubscriber;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(OnDelayedEmissionHandler2 onDelayedEmissionHandler2) {
            super(1);
            this.$wrappedSubscriber = onDelayedEmissionHandler2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "error");
            OnDelayedEmissionHandler2 onDelayedEmissionHandler2 = this.$wrappedSubscriber;
            Throwable throwable = error.getThrowable();
            Intrinsics3.checkNotNullExpressionValue(throwable, "error.throwable");
            onDelayedEmissionHandler2.onError(throwable);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.rx.OnDelayedEmissionHandler$call$3, reason: invalid class name */
    /* JADX INFO: compiled from: OnDelayedEmissionHandler.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, "it");
            OnDelayedEmissionHandler.this.delaySubscription = subscription;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OnDelayedEmissionHandler(Function1<? super Boolean, Unit> function1, long j, TimeUnit timeUnit, Scheduler scheduler) {
        Intrinsics3.checkNotNullParameter(function1, "onDelayCallback");
        Intrinsics3.checkNotNullParameter(timeUnit, "unit");
        Intrinsics3.checkNotNullParameter(scheduler, "scheduler");
        this.onDelayCallback = function1;
        this.timeout = j;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.hasFinished = new AtomicBoolean(false);
    }

    @Override // j0.k.Func1
    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        Intrinsics3.checkNotNullParameter(subscriber, "subscriber");
        OnDelayedEmissionHandler2 onDelayedEmissionHandler2 = new OnDelayedEmissionHandler2(this, subscriber);
        Observable<Long> observableJ = Observable.d0(this.timeout, this.unit).J(this.scheduler);
        Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable\n        .time…    .observeOn(scheduler)");
        ObservableExtensionsKt.appSubscribe(observableJ, (Class<?>) OnDelayedEmissionHandler.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new AnonymousClass3()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass2(onDelayedEmissionHandler2)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
        return onDelayedEmissionHandler2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ OnDelayedEmissionHandler(Function1 function1, long j, TimeUnit timeUnit, Scheduler scheduler, int i, DefaultConstructorMarker defaultConstructorMarker) {
        long j2 = (i & 2) != 0 ? 0L : j;
        TimeUnit timeUnit2 = (i & 4) != 0 ? TimeUnit.MILLISECONDS : timeUnit;
        if ((i & 8) != 0) {
            scheduler = AndroidSchedulers.a();
            Intrinsics3.checkNotNullExpressionValue(scheduler, "AndroidSchedulers.mainThread()");
        }
        this(function1, j2, timeUnit2, scheduler);
    }
}
