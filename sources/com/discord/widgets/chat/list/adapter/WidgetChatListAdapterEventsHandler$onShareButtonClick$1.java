package com.discord.widgets.chat.list.adapter;

import com.discord.api.channel.Channel;
import com.discord.app.AppFragment;
import com.discord.utilities.channel.ChannelInviteLaunchUtils;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities;
import d0.z.d.m;
import d0.z.d.o;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListAdapterEventsHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterEventsHandler$onShareButtonClick$1 extends o implements Function1<Channel, Unit> {
    public final /* synthetic */ Channel $channel;
    public final /* synthetic */ long $guildEventId;
    public final /* synthetic */ WeakReference $weakFragment;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterEventsHandler$onShareButtonClick$1(WeakReference weakReference, Channel channel, long j) {
        super(1);
        this.$weakFragment = weakReference;
        this.$channel = channel;
        this.$guildEventId = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
        invoke2(channel);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Channel channel) {
        AppFragment appFragment = (AppFragment) this.$weakFragment.get();
        if (appFragment != null) {
            ChannelInviteLaunchUtils channelInviteLaunchUtils = ChannelInviteLaunchUtils.INSTANCE;
            m.checkNotNullExpressionValue(appFragment, "fragment");
            Channel channel2 = this.$channel;
            ChannelInviteLaunchUtils.inviteToChannel$default(channelInviteLaunchUtils, appFragment, channel2 != null ? channel2 : channel, GuildScheduledEventUtilities.ANALYTICS_SOURCE, Long.valueOf(this.$guildEventId), null, 16, null);
        }
    }
}
