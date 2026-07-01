package com.discord.widgets.channels.list;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.guild.GuildMaxVideoChannelUsers;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.guildscheduledevent.GuildScheduledEventStatus;
import com.discord.models.guild.Guild;
import com.discord.utilities.channel.GuildChannelsInfo;
import com.discord.widgets.channels.list.WidgetChannelListModel;
import com.discord.widgets.channels.list.items.ChannelListItemVoiceChannel;
import com.discord.widgets.channels.list.items.ChannelListItemVoiceUser;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetChannelListModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$5 extends Lambda implements Function0<ChannelListItemVoiceChannel> {
    public final /* synthetic */ WidgetChannelListModel$Companion$guildListBuilder$4 $areAllChildThreadsRead$4$inlined;
    public final /* synthetic */ WidgetChannelListModel$Companion$guildListBuilder$5 $areAnyChildThreadsSelected$5$inlined;
    public final /* synthetic */ boolean $canSeeGuildRoleSubscriptions$inlined;
    public final /* synthetic */ Channel $channel;
    public final /* synthetic */ Set $channelsWithActiveThreads$inlined;
    public final /* synthetic */ Set $collapsedCategories$inlined;
    public final /* synthetic */ Map $directories$inlined;
    public final /* synthetic */ Map $directoryEvents$inlined;
    public final /* synthetic */ HashSet $forceViewCategories$inlined;
    public final /* synthetic */ WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$2 $getVocalChannelData$2;
    public final /* synthetic */ GuildChannelsInfo $guild$inlined;
    public final /* synthetic */ List $guildScheduledEvents$inlined;
    public final /* synthetic */ HashSet $hiddenChannelsIds$inlined;
    public final /* synthetic */ boolean $isGuildHub$inlined;
    public final /* synthetic */ WidgetChannelListModel$Companion$guildListBuilder$3 $isThreadUnread$3$inlined;
    public final /* synthetic */ ArrayList $items$inlined;
    public final /* synthetic */ Map $joinedThreads$inlined;
    public final /* synthetic */ Map $mentionCounts$inlined;
    public final /* synthetic */ Map $messageAcks$inlined;
    public final /* synthetic */ Long $permissions;
    public final /* synthetic */ Channel $selectedChannel$inlined;
    public final /* synthetic */ long $selectedGuildId$inlined;
    public final /* synthetic */ long $selectedVoiceChannelId$inlined;
    public final /* synthetic */ Map $stageChannels$inlined;
    public final /* synthetic */ Map $stageInstances$inlined;
    public final /* synthetic */ Map $threadParentMap$inlined;
    public final /* synthetic */ WidgetChannelListModel$Companion$guildListBuilder$2 $tryRemoveEmptyCategory$2$inlined;
    public final /* synthetic */ Set $unreadChannelIds$inlined;
    public final /* synthetic */ Map $voiceStates$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$5(WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$2 widgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$2, Channel channel, Long l, GuildChannelsInfo guildChannelsInfo, HashSet hashSet, boolean z2, Channel channel2, Map map, Set set, long j, WidgetChannelListModel$Companion$guildListBuilder$5 widgetChannelListModel$Companion$guildListBuilder$5, Set set2, WidgetChannelListModel$Companion$guildListBuilder$3 widgetChannelListModel$Companion$guildListBuilder$3, HashSet hashSet2, WidgetChannelListModel$Companion$guildListBuilder$4 widgetChannelListModel$Companion$guildListBuilder$4, long j2, Map map2, boolean z3, Set set3, List list, Map map3, Map map4, Map map5, Map map6, ArrayList arrayList, WidgetChannelListModel$Companion$guildListBuilder$2 widgetChannelListModel$Companion$guildListBuilder$2, Map map7, Map map8, Map map9) {
        super(0);
        this.$getVocalChannelData$2 = widgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$2;
        this.$channel = channel;
        this.$permissions = l;
        this.$guild$inlined = guildChannelsInfo;
        this.$forceViewCategories$inlined = hashSet;
        this.$isGuildHub$inlined = z2;
        this.$selectedChannel$inlined = channel2;
        this.$mentionCounts$inlined = map;
        this.$unreadChannelIds$inlined = set;
        this.$selectedGuildId$inlined = j;
        this.$areAnyChildThreadsSelected$5$inlined = widgetChannelListModel$Companion$guildListBuilder$5;
        this.$collapsedCategories$inlined = set2;
        this.$isThreadUnread$3$inlined = widgetChannelListModel$Companion$guildListBuilder$3;
        this.$hiddenChannelsIds$inlined = hashSet2;
        this.$areAllChildThreadsRead$4$inlined = widgetChannelListModel$Companion$guildListBuilder$4;
        this.$selectedVoiceChannelId$inlined = j2;
        this.$voiceStates$inlined = map2;
        this.$canSeeGuildRoleSubscriptions$inlined = z3;
        this.$channelsWithActiveThreads$inlined = set3;
        this.$guildScheduledEvents$inlined = list;
        this.$stageInstances$inlined = map3;
        this.$stageChannels$inlined = map4;
        this.$threadParentMap$inlined = map5;
        this.$joinedThreads$inlined = map6;
        this.$items$inlined = arrayList;
        this.$tryRemoveEmptyCategory$2$inlined = widgetChannelListModel$Companion$guildListBuilder$2;
        this.$messageAcks$inlined = map7;
        this.$directories$inlined = map8;
        this.$directoryEvents$inlined = map9;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Code duplicated, block: B:15:0x0040  */
    /* JADX WARN: Code duplicated, block: B:32:0x007e  */
    @Override // kotlin.jvm.functions.Function0
    public final ChannelListItemVoiceChannel invoke() {
        boolean z2;
        GuildMaxVideoChannelUsers maxVideoChannelUsers;
        boolean z3;
        boolean z4;
        WidgetChannelListModel.Companion.VocalChannelData vocalChannelDataInvoke = this.$getVocalChannelData$2.invoke(this.$channel);
        ChannelListItemVoiceChannel channelListItemVoiceChannel = null;
        Object obj = null;
        if (vocalChannelDataInvoke != null) {
            for (Object obj2 : this.$guildScheduledEvents$inlined) {
                GuildScheduledEvent guildScheduledEvent = (GuildScheduledEvent) obj2;
                if (guildScheduledEvent.getStatus() == GuildScheduledEventStatus.ACTIVE) {
                    Long channelId = guildScheduledEvent.getChannelId();
                    long id2 = this.$channel.getId();
                    if (channelId != null && channelId.longValue() == id2) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                } else {
                    z4 = false;
                }
                if (z4) {
                    obj = obj2;
                    break;
                }
            }
            GuildScheduledEvent guildScheduledEvent2 = (GuildScheduledEvent) obj;
            Collection collection = (Collection) outline.d(this.$channel, this.$voiceStates$inlined);
            if (collection == null) {
                z2 = false;
            } else {
                if (collection.isEmpty()) {
                    z3 = false;
                    break;
                }
                Iterator it = collection.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z3 = false;
                        break;
                    }
                    if (((ChannelListItemVoiceUser) it.next()).getVoiceState().getSelfVideo()) {
                        z3 = true;
                        break;
                    }
                }
                if (z3) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            }
            Channel channel = this.$channel;
            boolean textChannelSelected = vocalChannelDataInvoke.getTextChannelSelected();
            boolean voiceChannelSelected = vocalChannelDataInvoke.getVoiceChannelSelected();
            Long l = this.$permissions;
            int mentionCount = vocalChannelDataInvoke.getMentionCount();
            boolean unread = vocalChannelDataInvoke.getUnread();
            int numUsersConnected = vocalChannelDataInvoke.getNumUsersConnected();
            boolean locked = vocalChannelDataInvoke.getLocked();
            boolean nsfw = vocalChannelDataInvoke.getNsfw();
            Guild guild = this.$guild$inlined.getGuild();
            if (guild == null || (maxVideoChannelUsers = guild.getMaxVideoChannelUsers()) == null) {
                maxVideoChannelUsers = GuildMaxVideoChannelUsers.Unlimited.INSTANCE;
            }
            channelListItemVoiceChannel = new ChannelListItemVoiceChannel(channel, textChannelSelected, voiceChannelSelected, l, mentionCount, unread, numUsersConnected, locked, nsfw, z2, maxVideoChannelUsers, vocalChannelDataInvoke.isGuildRoleSubscriptionLockedChannel(), vocalChannelDataInvoke.isGuildRoleSubscriptionChannel(), guildScheduledEvent2);
        }
        return channelListItemVoiceChannel;
    }
}
