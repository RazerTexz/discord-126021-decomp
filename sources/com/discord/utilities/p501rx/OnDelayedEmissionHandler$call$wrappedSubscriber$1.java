package com.discord.utilities.p501rx;

import com.discord.utilities.error.Error;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12238m;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;
import p658rx.Subscriber;
import p658rx.Subscription;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: OnDelayedEmissionHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class OnDelayedEmissionHandler$call$wrappedSubscriber$1<T> extends Subscriber<T> {
    public final /* synthetic */ Subscriber $subscriber;
    public final /* synthetic */ OnDelayedEmissionHandler this$0;

    public OnDelayedEmissionHandler$call$wrappedSubscriber$1(OnDelayedEmissionHandler onDelayedEmissionHandler, Subscriber subscriber) {
        this.this$0 = onDelayedEmissionHandler;
        this.$subscriber = subscriber;
    }

    private final void tryFinish() {
        Subscription subscription = this.this$0.delaySubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        Observable<T> observableM11084J = new C12721k(null).m11084J(this.this$0.scheduler);
        C12238m.checkNotNullExpressionValue(observableM11084J, "Observable\n            .…    .observeOn(scheduler)");
        ObservableExtensionsKt.appSubscribe(observableM11084J, (Class<?>) OnDelayedEmissionHandler$call$wrappedSubscriber$1.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new OnDelayedEmissionHandler$call$wrappedSubscriber$1$tryFinish$2(this)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new OnDelayedEmissionHandler$call$wrappedSubscriber$1$tryFinish$1(this));
    }

    @Override // p637j0.InterfaceC12581g
    public void onCompleted() {
        if (this.$subscriber.isUnsubscribed()) {
            return;
        }
        tryFinish();
        this.$subscriber.onCompleted();
    }

    @Override // p637j0.InterfaceC12581g
    public void onError(Throwable e) {
        C12238m.checkNotNullParameter(e, "e");
        if (this.$subscriber.isUnsubscribed()) {
            return;
        }
        tryFinish();
        this.$subscriber.onError(e);
    }

    @Override // p637j0.InterfaceC12581g
    public void onNext(T t) {
        if (this.$subscriber.isUnsubscribed()) {
            return;
        }
        tryFinish();
        this.$subscriber.onNext(t);
    }
}
