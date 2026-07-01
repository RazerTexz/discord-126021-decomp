package com.discord.utilities.rx;

import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.Intrinsics3;
import j0.l.e.ScalarSynchronousObservable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: com.discord.utilities.rx.OnDelayedEmissionHandler$call$wrappedSubscriber$1, reason: use source file name */
/* JADX INFO: compiled from: OnDelayedEmissionHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class OnDelayedEmissionHandler2<T> extends Subscriber<T> {
    public final /* synthetic */ Subscriber $subscriber;
    public final /* synthetic */ OnDelayedEmissionHandler this$0;

    public OnDelayedEmissionHandler2(OnDelayedEmissionHandler onDelayedEmissionHandler, Subscriber subscriber) {
        this.this$0 = onDelayedEmissionHandler;
        this.$subscriber = subscriber;
    }

    private final void tryFinish() {
        Subscription subscription = this.this$0.delaySubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        Observable<T> observableJ = new ScalarSynchronousObservable(null).J(this.this$0.scheduler);
        Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable\n            .…    .observeOn(scheduler)");
        ObservableExtensionsKt.appSubscribe(observableJ, (Class<?>) OnDelayedEmissionHandler2.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new OnDelayedEmissionHandler4(this)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new OnDelayedEmissionHandler3(this));
    }

    @Override // j0.Observer2
    public void onCompleted() {
        if (this.$subscriber.isUnsubscribed()) {
            return;
        }
        tryFinish();
        this.$subscriber.onCompleted();
    }

    @Override // j0.Observer2
    public void onError(Throwable e) {
        Intrinsics3.checkNotNullParameter(e, "e");
        if (this.$subscriber.isUnsubscribed()) {
            return;
        }
        tryFinish();
        this.$subscriber.onError(e);
    }

    @Override // j0.Observer2
    public void onNext(T t) {
        if (this.$subscriber.isUnsubscribed()) {
            return;
        }
        tryFinish();
        this.$subscriber.onNext(t);
    }
}
