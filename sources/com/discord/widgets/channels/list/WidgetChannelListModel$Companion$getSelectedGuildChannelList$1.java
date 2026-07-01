package com.discord.widgets.channels.list;

import com.discord.api.channel.Channel;
import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.api.directory.DirectoryEntryGuild2;
import com.discord.api.guildjoinrequest.GuildJoinRequest;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.stageinstance.StageInstance;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.stores.StoreMessageAck;
import com.discord.stores.StoreNux;
import com.discord.stores.StoreThreadsActiveJoined;
import com.discord.stores.StoreThreadsJoined;
import com.discord.stores.utilities.RestCallState;
import com.discord.utilities.channel.GuildChannelsInfo;
import com.discord.widgets.channels.list.items.ChannelListBottomNavSpaceItem;
import com.discord.widgets.channels.list.items.ChannelListItemVoiceUser;
import com.discord.widgets.stage.model.StageChannel;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function22;

/* JADX INFO: compiled from: WidgetChannelListModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelListModel$Companion$getSelectedGuildChannelList$1 extends Lambda implements Function22<GuildChannelsInfo, Map<Long, ? extends Channel>, Map<Long, ? extends StoreThreadsJoined.JoinedThread>, Map<Long, ? extends Map<Long, ? extends StoreThreadsActiveJoined.ActiveJoinedThread>>, Set<? extends Long>, Channel, Long, Map<Long, ? extends List<? extends ChannelListItemVoiceUser>>, Map<Long, ? extends Integer>, Set<? extends Long>, Set<? extends Long>, StoreNux.NuxState, Map<Long, ? extends StageChannel>, Map<Long, ? extends StageInstance>, List<? extends GuildScheduledEvent>, Boolean, Boolean, Map<Long, ? extends RestCallState<? extends List<? extends DirectoryEntryGuild>>>, Map<Long, ? extends StoreMessageAck.Ack>, Map<Long, ? extends RestCallState<? extends List<? extends DirectoryEntryGuild2>>>, GuildJoinRequest, GuildMember, WidgetChannelListModel> {
    public final /* synthetic */ long $selectedGuildId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelListModel$Companion$getSelectedGuildChannelList$1(long j) {
        super(22);
        this.$selectedGuildId = j;
    }

    @Override // kotlin.jvm.functions.Function22
    public /* bridge */ /* synthetic */ WidgetChannelListModel invoke(GuildChannelsInfo guildChannelsInfo, Map<Long, ? extends Channel> map, Map<Long, ? extends StoreThreadsJoined.JoinedThread> map2, Map<Long, ? extends Map<Long, ? extends StoreThreadsActiveJoined.ActiveJoinedThread>> map3, Set<? extends Long> set, Channel channel, Long l, Map<Long, ? extends List<? extends ChannelListItemVoiceUser>> map4, Map<Long, ? extends Integer> map5, Set<? extends Long> set2, Set<? extends Long> set3, StoreNux.NuxState nuxState, Map<Long, ? extends StageChannel> map6, Map<Long, ? extends StageInstance> map7, List<? extends GuildScheduledEvent> list, Boolean bool, Boolean bool2, Map<Long, ? extends RestCallState<? extends List<? extends DirectoryEntryGuild>>> map8, Map<Long, ? extends StoreMessageAck.Ack> map9, Map<Long, ? extends RestCallState<? extends List<? extends DirectoryEntryGuild2>>> map10, GuildJoinRequest guildJoinRequest, GuildMember guildMember) {
        return invoke(guildChannelsInfo, (Map<Long, Channel>) map, (Map<Long, StoreThreadsJoined.JoinedThread>) map2, (Map<Long, ? extends Map<Long, StoreThreadsActiveJoined.ActiveJoinedThread>>) map3, (Set<Long>) set, channel, l.longValue(), (Map<Long, ? extends List<ChannelListItemVoiceUser>>) map4, (Map<Long, Integer>) map5, (Set<Long>) set2, (Set<Long>) set3, nuxState, (Map<Long, StageChannel>) map6, (Map<Long, StageInstance>) map7, (List<GuildScheduledEvent>) list, bool.booleanValue(), bool2.booleanValue(), (Map<Long, ? extends RestCallState<? extends List<DirectoryEntryGuild>>>) map8, (Map<Long, StoreMessageAck.Ack>) map9, (Map<Long, ? extends RestCallState<? extends List<DirectoryEntryGuild2>>>) map10, guildJoinRequest, guildMember);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x00d5  */
    public final WidgetChannelListModel invoke(GuildChannelsInfo guildChannelsInfo, Map<Long, Channel> map, Map<Long, StoreThreadsJoined.JoinedThread> map2, Map<Long, ? extends Map<Long, StoreThreadsActiveJoined.ActiveJoinedThread>> map3, Set<Long> set, Channel channel, long j, Map<Long, ? extends List<ChannelListItemVoiceUser>> map4, Map<Long, Integer> map5, Set<Long> set2, Set<Long> set3, StoreNux.NuxState nuxState, Map<Long, StageChannel> map6, Map<Long, StageInstance> map7, List<GuildScheduledEvent> list, boolean z2, boolean z3, Map<Long, ? extends RestCallState<? extends List<DirectoryEntryGuild>>> map8, Map<Long, StoreMessageAck.Ack> map9, Map<Long, ? extends RestCallState<? extends List<DirectoryEntryGuild2>>> map10, GuildJoinRequest guildJoinRequest, GuildMember guildMember) {
        boolean z4;
        Intrinsics3.checkNotNullParameter(guildChannelsInfo, "guildChannelsInfo");
        Intrinsics3.checkNotNullParameter(map, "guildChannels");
        Intrinsics3.checkNotNullParameter(map2, "joinedThreads");
        Intrinsics3.checkNotNullParameter(map3, "activeJoinedGuildThreads");
        Intrinsics3.checkNotNullParameter(set, "channelsWithActiveThreads");
        Intrinsics3.checkNotNullParameter(map4, "voiceStates");
        Intrinsics3.checkNotNullParameter(map5, "mentionCounts");
        Intrinsics3.checkNotNullParameter(set2, "unreadChannelIds");
        Intrinsics3.checkNotNullParameter(set3, "collapsedCategories");
        Intrinsics3.checkNotNullParameter(nuxState, "nuxState");
        Intrinsics3.checkNotNullParameter(map6, "stageChannels");
        Intrinsics3.checkNotNullParameter(map7, "stageInstances");
        Intrinsics3.checkNotNullParameter(list, "guildScheduledEvents");
        Intrinsics3.checkNotNullParameter(map8, "directories");
        Intrinsics3.checkNotNullParameter(map9, "messageAcks");
        Intrinsics3.checkNotNullParameter(map10, "directoryEvents");
        List listPlus = _Collections.plus((Collection<? extends ChannelListBottomNavSpaceItem>) WidgetChannelListModel.INSTANCE.guildListBuilder(this.$selectedGuildId, guildChannelsInfo, map, map3, map2, set, channel, j, map4, map5, set2, set3, map6, map7, list, z2, z3, map8, map9, map10, guildJoinRequest, guildMember), new ChannelListBottomNavSpaceItem(this.$selectedGuildId));
        if (nuxState.getGuildBoostHintGuildId() != null) {
            Long guildBoostHintGuildId = nuxState.getGuildBoostHintGuildId();
            Guild guild = guildChannelsInfo.getGuild();
            if (Intrinsics3.areEqual(guildBoostHintGuildId, guild != null ? Long.valueOf(guild.getId()) : null)) {
                z4 = true;
            } else {
                z4 = false;
            }
        } else {
            z4 = false;
        }
        return new WidgetChannelListModel(guildChannelsInfo.getGuild(), listPlus, true, z4, false, null, 32, null);
    }
}
