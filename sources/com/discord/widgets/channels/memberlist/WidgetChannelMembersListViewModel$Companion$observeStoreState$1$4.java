package com.discord.widgets.channels.memberlist;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.role.GuildRole;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.utilities.lazy.memberlist.ChannelMemberList;
import d0.z.d.m;
import java.util.Map;
import rx.functions.Func5;

/* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelMembersListViewModel$Companion$observeStoreState$1$4<T1, T2, T3, T4, T5, R> implements Func5<Guild, Map<Long, ? extends GuildRole>, Long, ChannelMemberList, Boolean, WidgetChannelMembersListViewModel$StoreState$Guild> {
    public final /* synthetic */ Channel $channel;

    public WidgetChannelMembersListViewModel$Companion$observeStoreState$1$4(Channel channel) {
        this.$channel = channel;
    }

    @Override // rx.functions.Func5
    public /* bridge */ /* synthetic */ WidgetChannelMembersListViewModel$StoreState$Guild call(Guild guild, Map<Long, ? extends GuildRole> map, Long l, ChannelMemberList channelMemberList, Boolean bool) {
        return call2(guild, (Map<Long, GuildRole>) map, l, channelMemberList, bool);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetChannelMembersListViewModel$StoreState$Guild call2(Guild guild, Map<Long, GuildRole> map, Long l, ChannelMemberList channelMemberList, Boolean bool) {
        m.checkNotNullExpressionValue(bool, "isPanelOpen");
        boolean zBooleanValue = bool.booleanValue();
        Channel channel = this.$channel;
        m.checkNotNullExpressionValue(channelMemberList, "channelMemberList");
        m.checkNotNullExpressionValue(map, "guildRoles");
        return new WidgetChannelMembersListViewModel$StoreState$Guild(zBooleanValue, channel, guild, channelMemberList, l, map);
    }
}
