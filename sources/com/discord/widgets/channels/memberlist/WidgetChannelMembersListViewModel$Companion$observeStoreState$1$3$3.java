package com.discord.widgets.channels.memberlist;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.role.GuildRole;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.stores.StoreThreadsJoined$JoinedThread;
import d0.z.d.m;
import java.util.Map;
import java.util.Set;
import rx.functions.Func9;

/* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelMembersListViewModel$Companion$observeStoreState$1$3$3<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> implements Func9<Set<? extends Long>, Boolean, Map<Long, ? extends GuildRole>, Map<Long, ? extends GuildMember>, Guild, Map<Long, ? extends User>, Map<Long, ? extends Presence>, Map<Long, ? extends ModelApplicationStream>, StoreThreadsJoined$JoinedThread, WidgetChannelMembersListViewModel$StoreState$Thread> {
    public final /* synthetic */ Channel $parentChannel;
    public final /* synthetic */ WidgetChannelMembersListViewModel$Companion$observeStoreState$1$3 this$0;

    public WidgetChannelMembersListViewModel$Companion$observeStoreState$1$3$3(WidgetChannelMembersListViewModel$Companion$observeStoreState$1$3 widgetChannelMembersListViewModel$Companion$observeStoreState$1$3, Channel channel) {
        this.this$0 = widgetChannelMembersListViewModel$Companion$observeStoreState$1$3;
        this.$parentChannel = channel;
    }

    @Override // rx.functions.Func9
    public /* bridge */ /* synthetic */ WidgetChannelMembersListViewModel$StoreState$Thread call(Set<? extends Long> set, Boolean bool, Map<Long, ? extends GuildRole> map, Map<Long, ? extends GuildMember> map2, Guild guild, Map<Long, ? extends User> map3, Map<Long, ? extends Presence> map4, Map<Long, ? extends ModelApplicationStream> map5, StoreThreadsJoined$JoinedThread storeThreadsJoined$JoinedThread) {
        return call2((Set<Long>) set, bool, (Map<Long, GuildRole>) map, (Map<Long, GuildMember>) map2, guild, map3, (Map<Long, Presence>) map4, map5, storeThreadsJoined$JoinedThread);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetChannelMembersListViewModel$StoreState$Thread call2(Set<Long> set, Boolean bool, Map<Long, GuildRole> map, Map<Long, GuildMember> map2, Guild guild, Map<Long, ? extends User> map3, Map<Long, Presence> map4, Map<Long, ? extends ModelApplicationStream> map5, StoreThreadsJoined$JoinedThread storeThreadsJoined$JoinedThread) {
        m.checkNotNullExpressionValue(bool, "isPanelOpen");
        boolean zBooleanValue = bool.booleanValue();
        Channel channel = this.this$0.$channel;
        Channel channel2 = this.$parentChannel;
        m.checkNotNullExpressionValue(map, "roles");
        m.checkNotNullExpressionValue(map2, "guildMembers");
        m.checkNotNullExpressionValue(map3, "users");
        m.checkNotNullExpressionValue(map4, "presences");
        m.checkNotNullExpressionValue(map5, "streams");
        m.checkNotNullExpressionValue(set, "threadMembers");
        return new WidgetChannelMembersListViewModel$StoreState$Thread(zBooleanValue, channel, channel2, guild, map, map2, map3, map4, map5, set, storeThreadsJoined$JoinedThread);
    }
}
