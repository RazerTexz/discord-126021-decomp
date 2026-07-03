package com.discord.utilities.p501rx;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p638j.p640b.C12586a;
import p658rx.Observable;
import p658rx.Scheduler;
import p658rx.Subscriber;
import p658rx.Subscription;

/* JADX INFO: compiled from: OnDelayedEmissionHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class OnDelayedEmissionHandler<T> implements Observable.InterfaceC13006b<T, T> {
    private Subscription delaySubscription;
    private final AtomicBoolean hasFinished;
    private final Function1<Boolean, Unit> onDelayCallback;
    private final Scheduler scheduler;
    private final long timeout;
    private final TimeUnit unit;

    /* JADX INFO: renamed from: com.discord.utilities.rx.OnDelayedEmissionHandler$call$1 */
    /* JADX INFO: compiled from: OnDelayedEmissionHandler.kt */
    public static final class C68941 extends AbstractC12240o implements Function1<Long, Unit> {
        public C68941() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            if (OnDelayedEmissionHandler.this.hasFinished.get()) {
                return;
            }
            OnDelayedEmissionHandler.this.onDelayCallback.invoke(Boolean.TRUE);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.rx.OnDelayedEmissionHandler$call$2 */
    /* JADX INFO: compiled from: OnDelayedEmissionHandler.kt */
    public static final class C68952 extends AbstractC12240o implements Function1<Error, Unit> {
        public final /* synthetic */ OnDelayedEmissionHandler$call$wrappedSubscriber$1 $wrappedSubscriber;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C68952(OnDelayedEmissionHandler$call$wrappedSubscriber$1 onDelayedEmissionHandler$call$wrappedSubscriber$1) {
            super(1);
            this.$wrappedSubscriber = onDelayedEmissionHandler$call$wrappedSubscriber$1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            C12238m.checkNotNullParameter(error, "error");
            OnDelayedEmissionHandler$call$wrappedSubscriber$1 onDelayedEmissionHandler$call$wrappedSubscriber$1 = this.$wrappedSubscriber;
            Throwable throwable = error.getThrowable();
            C12238m.checkNotNullExpressionValue(throwable, "error.throwable");
            onDelayedEmissionHandler$call$wrappedSubscriber$1.onError(throwable);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.rx.OnDelayedEmissionHandler$call$3 */
    /* JADX INFO: compiled from: OnDelayedEmissionHandler.kt */
    public static final class C68963 extends AbstractC12240o implements Function1<Subscription, Unit> {
        public C68963() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            C12238m.checkNotNullParameter(subscription, "it");
            OnDelayedEmissionHandler.this.delaySubscription = subscription;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OnDelayedEmissionHandler(Function1<? super Boolean, Unit> function1, long j, TimeUnit timeUnit, Scheduler scheduler) {
        C12238m.checkNotNullParameter(function1, "onDelayCallback");
        C12238m.checkNotNullParameter(timeUnit, "unit");
        C12238m.checkNotNullParameter(scheduler, "scheduler");
        this.onDelayCallback = function1;
        this.timeout = j;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.hasFinished = new AtomicBoolean(false);
    }

    @Override // p637j0.p641k.InterfaceC12589b
    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        C12238m.checkNotNullParameter(subscriber, "subscriber");
        OnDelayedEmissionHandler$call$wrappedSubscriber$1 onDelayedEmissionHandler$call$wrappedSubscriber$1 = new OnDelayedEmissionHandler$call$wrappedSubscriber$1(this, subscriber);
        Observable<Long> observableM11084J = Observable.m11068d0(this.timeout, this.unit).m11084J(this.scheduler);
        C12238m.checkNotNullExpressionValue(observableM11084J, "Observable\n        .time…    .observeOn(scheduler)");
        ObservableExtensionsKt.appSubscribe(observableM11084J, (Class<?>) OnDelayedEmissionHandler.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new C68963()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C68952(onDelayedEmissionHandler$call$wrappedSubscriber$1)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C68941());
        return onDelayedEmissionHandler$call$wrappedSubscriber$1;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ OnDelayedEmissionHandler(Function1 function1, long j, TimeUnit timeUnit, Scheduler scheduler, int i, DefaultConstructorMarker defaultConstructorMarker) {
        long j2 = (i & 2) != 0 ? 0L : j;
        TimeUnit timeUnit2 = (i & 4) != 0 ? TimeUnit.MILLISECONDS : timeUnit;
        if ((i & 8) != 0) {
            scheduler = C12586a.m10738a();
            C12238m.checkNotNullExpressionValue(scheduler, "AndroidSchedulers.mainThread()");
        }
        this(function1, j2, timeUnit2, scheduler);
    }
}
