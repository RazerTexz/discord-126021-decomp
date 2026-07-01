package com.discord.utilities.fcm;

import d0.z.d.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/* JADX INFO: compiled from: NotificationRenderer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class NotificationRenderer$displayAndUpdateCache$4 extends k implements Function1<Subscription, Unit> {
    public NotificationRenderer$displayAndUpdateCache$4(CompositeSubscription compositeSubscription) {
        super(1, compositeSubscription, CompositeSubscription.class, "add", "add(Lrx/Subscription;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
        invoke2(subscription);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Subscription subscription) {
        ((CompositeSubscription) this.receiver).a(subscription);
    }
}
