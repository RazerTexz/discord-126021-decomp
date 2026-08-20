package com.discord.widgets.user;

import com.discord.utilities.analytics.Traits;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetUserMentions.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserMentions$Model$MessageLoader$retry$1 extends AbstractC12240o implements Function1<Subscription, Unit> {
    public final /* synthetic */ WidgetUserMentions.Model.MessageLoader this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserMentions$Model$MessageLoader$retry$1(WidgetUserMentions.Model.MessageLoader messageLoader) {
        super(1);
        this.this$0 = messageLoader;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
        invoke2(subscription);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Subscription subscription) {
        C12238m.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
        this.this$0.retrySubscription = subscription;
    }
}
