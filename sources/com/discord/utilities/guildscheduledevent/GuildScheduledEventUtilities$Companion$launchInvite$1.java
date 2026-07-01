package com.discord.utilities.guildscheduledevent;

import androidx.fragment.app.Fragment;
import com.discord.api.channel.Channel;
import com.discord.utilities.channel.ChannelInviteLaunchUtils;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GuildScheduledEventUtilities.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildScheduledEventUtilities$Companion$launchInvite$1 extends o implements Function1<Channel, Unit> {
    public final /* synthetic */ Channel $channel;
    public final /* synthetic */ Fragment $fragment;
    public final /* synthetic */ long $guildEventId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildScheduledEventUtilities$Companion$launchInvite$1(Fragment fragment, Channel channel, long j) {
        super(1);
        this.$fragment = fragment;
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
        ChannelInviteLaunchUtils channelInviteLaunchUtils = ChannelInviteLaunchUtils.INSTANCE;
        Fragment fragment = this.$fragment;
        Channel channel2 = this.$channel;
        if (channel2 == null) {
            channel2 = channel;
        }
        ChannelInviteLaunchUtils.inviteToChannel$default(channelInviteLaunchUtils, fragment, channel2, GuildScheduledEventUtilities.ANALYTICS_SOURCE, Long.valueOf(this.$guildEventId), null, 16, null);
    }
}
