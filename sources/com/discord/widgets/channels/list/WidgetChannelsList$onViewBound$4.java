package com.discord.widgets.channels.list;

import com.discord.api.channel.Channel;
import com.discord.widgets.guild_role_subscriptions.entrypoint.WidgetGuildRoleSubscriptionEntryPoint;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChannelsList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsList$onViewBound$4 extends o implements Function1<Channel, Unit> {
    public final /* synthetic */ WidgetChannelsList this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelsList$onViewBound$4(WidgetChannelsList widgetChannelsList) {
        super(1);
        this.this$0 = widgetChannelsList;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
        invoke2(channel);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Channel channel) {
        Long lAccess$getSelectedGuildId$p = WidgetChannelsList.access$getSelectedGuildId$p(this.this$0);
        if (lAccess$getSelectedGuildId$p != null) {
            WidgetGuildRoleSubscriptionEntryPoint.Companion.launch(this.this$0.requireContext(), lAccess$getSelectedGuildId$p.longValue(), "Role Subscription Gated Channel");
        }
    }
}
