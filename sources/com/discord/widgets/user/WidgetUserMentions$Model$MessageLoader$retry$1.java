package com.discord.widgets.user;

import com.discord.utilities.analytics.Traits$Payment$Type;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetUserMentions.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserMentions$Model$MessageLoader$retry$1 extends o implements Function1<Subscription, Unit> {
    public final /* synthetic */ WidgetUserMentions$Model$MessageLoader this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserMentions$Model$MessageLoader$retry$1(WidgetUserMentions$Model$MessageLoader widgetUserMentions$Model$MessageLoader) {
        super(1);
        this.this$0 = widgetUserMentions$Model$MessageLoader;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
        invoke2(subscription);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Subscription subscription) {
        m.checkNotNullParameter(subscription, Traits$Payment$Type.SUBSCRIPTION);
        WidgetUserMentions$Model$MessageLoader.access$setRetrySubscription$p(this.this$0, subscription);
    }
}
