package com.discord.widgets.guildcommunicationdisabled.start;

import com.discord.utilities.analytics.Traits$Payment$Type;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetEnableGuildCommunication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEnableGuildCommunication$configureCommunicationDisabledTimer$2 extends o implements Function1<Subscription, Unit> {
    public final /* synthetic */ WidgetEnableGuildCommunication this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetEnableGuildCommunication$configureCommunicationDisabledTimer$2(WidgetEnableGuildCommunication widgetEnableGuildCommunication) {
        super(1);
        this.this$0 = widgetEnableGuildCommunication;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
        invoke2(subscription);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Subscription subscription) {
        m.checkNotNullParameter(subscription, Traits$Payment$Type.SUBSCRIPTION);
        WidgetEnableGuildCommunication.access$setCommunicationDisabledCountdownSubscription$p(this.this$0, subscription);
    }
}
