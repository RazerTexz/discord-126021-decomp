package com.discord.utilities.rx;

import android.content.Context;
import d0.z.d.m;
import j0.l.e.k;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;

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
        Subscription subscriptionAccess$getDelaySubscription$p = OnDelayedEmissionHandler.access$getDelaySubscription$p(this.this$0);
        if (subscriptionAccess$getDelaySubscription$p != null) {
            subscriptionAccess$getDelaySubscription$p.unsubscribe();
        }
        Observable<T> observableJ = new k(null).J(OnDelayedEmissionHandler.access$getScheduler$p(this.this$0));
        m.checkNotNullExpressionValue(observableJ, "Observable\n            .…    .observeOn(scheduler)");
        ObservableExtensionsKt.appSubscribe$default(observableJ, OnDelayedEmissionHandler$call$wrappedSubscriber$1.class, (Context) null, (Function1) null, new OnDelayedEmissionHandler$call$wrappedSubscriber$1$tryFinish$2(this), (Function0) null, (Function0) null, new OnDelayedEmissionHandler$call$wrappedSubscriber$1$tryFinish$1(this), 54, (Object) null);
    }

    @Override // j0.g
    public void onCompleted() {
        if (this.$subscriber.isUnsubscribed()) {
            return;
        }
        tryFinish();
        this.$subscriber.onCompleted();
    }

    @Override // j0.g
    public void onError(Throwable e) {
        m.checkNotNullParameter(e, "e");
        if (this.$subscriber.isUnsubscribed()) {
            return;
        }
        tryFinish();
        this.$subscriber.onError(e);
    }

    @Override // j0.g
    public void onNext(T t) {
        if (this.$subscriber.isUnsubscribed()) {
            return;
        }
        tryFinish();
        this.$subscriber.onNext(t);
    }
}
