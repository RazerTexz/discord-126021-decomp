package com.discord.widgets.channels.list;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.utilities.channel.GuildChannelsInfo;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.widgets.channels.list.WidgetChannelListModel;
import com.discord.widgets.channels.list.items.ChannelListItemTextChannel;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetChannelListModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$3 extends Lambda implements Function0<ChannelListItemTextChannel> {
    public final /* synthetic */ WidgetChannelListModel$Companion$guildListBuilder$4 $areAllChildThreadsRead$4$inlined;
    public final /* synthetic */ WidgetChannelListModel$Companion$guildListBuilder$5 $areAnyChildThreadsSelected$5$inlined;
    public final /* synthetic */ boolean $canSeeGuildRoleSubscriptions$inlined;
    public final /* synthetic */ Channel $channel;
    public final /* synthetic */ Set $channelsWithActiveThreads$inlined;
    public final /* synthetic */ Set $collapsedCategories$inlined;
    public final /* synthetic */ Map $directories$inlined;
    public final /* synthetic */ Map $directoryEvents$inlined;
    public final /* synthetic */ HashSet $forceViewCategories$inlined;
    public final /* synthetic */ WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$1 $getTextLikeChannelData$1;
    public final /* synthetic */ GuildChannelsInfo $guild$inlined;
    public final /* synthetic */ List $guildScheduledEvents$inlined;
    public final /* synthetic */ HashSet $hiddenChannelsIds$inlined;
    public final /* synthetic */ boolean $isGuildHub$inlined;
    public final /* synthetic */ WidgetChannelListModel$Companion$guildListBuilder$3 $isThreadUnread$3$inlined;
    public final /* synthetic */ ArrayList $items$inlined;
    public final /* synthetic */ Map $joinedThreads$inlined;
    public final /* synthetic */ Map $mentionCounts$inlined;
    public final /* synthetic */ Map $messageAcks$inlined;
    public final /* synthetic */ boolean $muted;
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
    public WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$3(Channel channel, Long l, WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$1 widgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$1, boolean z2, GuildChannelsInfo guildChannelsInfo, HashSet hashSet, boolean z3, Channel channel2, Map map, Set set, long j, WidgetChannelListModel$Companion$guildListBuilder$5 widgetChannelListModel$Companion$guildListBuilder$5, Set set2, WidgetChannelListModel$Companion$guildListBuilder$3 widgetChannelListModel$Companion$guildListBuilder$3, HashSet hashSet2, WidgetChannelListModel$Companion$guildListBuilder$4 widgetChannelListModel$Companion$guildListBuilder$4, long j2, Map map2, boolean z4, Set set3, List list, Map map3, Map map4, Map map5, Map map6, ArrayList arrayList, WidgetChannelListModel$Companion$guildListBuilder$2 widgetChannelListModel$Companion$guildListBuilder$2, Map map7, Map map8, Map map9) {
        super(0);
        this.$channel = channel;
        this.$permissions = l;
        this.$getTextLikeChannelData$1 = widgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$1;
        this.$muted = z2;
        this.$guild$inlined = guildChannelsInfo;
        this.$forceViewCategories$inlined = hashSet;
        this.$isGuildHub$inlined = z3;
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
        this.$canSeeGuildRoleSubscriptions$inlined = z4;
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
    @Override // kotlin.jvm.functions.Function0
    public final ChannelListItemTextChannel invoke() {
        boolean z2 = this.$canSeeGuildRoleSubscriptions$inlined && ChannelUtils.t(this.$channel, this.$guild$inlined.getGuild(), this.$guild$inlined.getEveryoneRole(), this.$guild$inlined.getGuildRoles());
        boolean zHasAccess = PermissionUtils.INSTANCE.hasAccess(this.$channel, this.$permissions);
        if (!zHasAccess && !z2) {
            return null;
        }
        WidgetChannelListModel.Companion.TextLikeChannelData textLikeChannelDataInvoke$default = WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$1.invoke$default(this.$getTextLikeChannelData$1, this.$channel, this.$muted, null, 4, null);
        if (textLikeChannelDataInvoke$default.getHide()) {
            return null;
        }
        return new ChannelListItemTextChannel(this.$channel, textLikeChannelDataInvoke$default.getSelected(), textLikeChannelDataInvoke$default.getMentionCount(), textLikeChannelDataInvoke$default.getUnread(), this.$muted, textLikeChannelDataInvoke$default.getLocked(), this.$channelsWithActiveThreads$inlined.contains(Long.valueOf(this.$channel.getId())), !zHasAccess && z2, z2);
    }
}
