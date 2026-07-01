package com.discord.widgets.user.presence;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import rx.Subscription;

/* JADX INFO: compiled from: ViewHolderUserRichPresence.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ViewHolderUserRichPresence$configureUiTimestamp$1 extends o implements Function1<Subscription, Unit> {
    public final /* synthetic */ ViewHolderUserRichPresence this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewHolderUserRichPresence$configureUiTimestamp$1(ViewHolderUserRichPresence viewHolderUserRichPresence) {
        super(1);
        this.this$0 = viewHolderUserRichPresence;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
        invoke2(subscription);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Subscription subscription) {
        m.checkNotNullParameter(subscription, "it");
        ViewHolderUserRichPresence.access$setPerSecondTimerSubscription$p(this.this$0, subscription);
    }
}
