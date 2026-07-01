package com.discord.widgets.forums;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import rx.Subscription;

/* JADX INFO: compiled from: ForumPostReadStateManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class ForumPostReadStateManager$initialize$2 extends k implements Function1<Subscription, Unit> {
    public ForumPostReadStateManager$initialize$2(ForumPostReadStateManager forumPostReadStateManager) {
        super(1, forumPostReadStateManager, ForumPostReadStateManager.class, "handleSubscription", "handleSubscription(Lrx/Subscription;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
        invoke2(subscription);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Subscription subscription) {
        m.checkNotNullParameter(subscription, "p1");
        ForumPostReadStateManager.access$handleSubscription((ForumPostReadStateManager) this.receiver, subscription);
    }
}
