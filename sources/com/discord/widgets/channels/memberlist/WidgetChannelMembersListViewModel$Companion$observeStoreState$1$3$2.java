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
public final class WidgetChannelMembersListViewModel$Companion$observeStoreState$1$3$2<T1, T2, T3, T4, T5, R> implements Func5<Long, ChannelMemberList, Boolean, Map<Long, ? extends GuildRole>, Guild, WidgetChannelMembersListViewModel$StoreState$Guild> {
    public final /* synthetic */ Channel $parentChannel;

    public WidgetChannelMembersListViewModel$Companion$observeStoreState$1$3$2(Channel channel) {
        this.$parentChannel = channel;
    }

    @Override // rx.functions.Func5
    public /* bridge */ /* synthetic */ WidgetChannelMembersListViewModel$StoreState$Guild call(Long l, ChannelMemberList channelMemberList, Boolean bool, Map<Long, ? extends GuildRole> map, Guild guild) {
        return call2(l, channelMemberList, bool, (Map<Long, GuildRole>) map, guild);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetChannelMembersListViewModel$StoreState$Guild call2(Long l, ChannelMemberList channelMemberList, Boolean bool, Map<Long, GuildRole> map, Guild guild) {
        m.checkNotNullExpressionValue(bool, "isPanelOpen");
        boolean zBooleanValue = bool.booleanValue();
        Channel channel = this.$parentChannel;
        m.checkNotNullExpressionValue(channelMemberList, "channelMemberList");
        m.checkNotNullExpressionValue(map, "roles");
        return new WidgetChannelMembersListViewModel$StoreState$Guild(zBooleanValue, channel, guild, channelMemberList, l, map);
    }
}
