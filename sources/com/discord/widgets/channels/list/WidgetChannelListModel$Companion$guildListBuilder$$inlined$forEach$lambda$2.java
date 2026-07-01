package com.discord.widgets.channels.list;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.permission.Permission;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.api.role.GuildRole;
import com.discord.utilities.channel.GuildChannelsInfo;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.widgets.channels.list.WidgetChannelListModel;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChannelListModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$2 extends Lambda implements Function1<Channel, WidgetChannelListModel.Companion.VocalChannelData> {
    public final /* synthetic */ WidgetChannelListModel$Companion$guildListBuilder$4 $areAllChildThreadsRead$4$inlined;
    public final /* synthetic */ WidgetChannelListModel$Companion$guildListBuilder$5 $areAnyChildThreadsSelected$5$inlined;
    public final /* synthetic */ boolean $canSeeGuildRoleSubscriptions$inlined;
    public final /* synthetic */ Channel $channel;
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ Set $channelsWithActiveThreads$inlined;
    public final /* synthetic */ Set $collapsedCategories$inlined;
    public final /* synthetic */ Map $directories$inlined;
    public final /* synthetic */ Map $directoryEvents$inlined;
    public final /* synthetic */ HashSet $forceViewCategories$inlined;
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
    public WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$2(long j, Channel channel, Long l, GuildChannelsInfo guildChannelsInfo, HashSet hashSet, boolean z2, Channel channel2, Map map, Set set, long j2, WidgetChannelListModel$Companion$guildListBuilder$5 widgetChannelListModel$Companion$guildListBuilder$5, Set set2, WidgetChannelListModel$Companion$guildListBuilder$3 widgetChannelListModel$Companion$guildListBuilder$3, HashSet hashSet2, WidgetChannelListModel$Companion$guildListBuilder$4 widgetChannelListModel$Companion$guildListBuilder$4, long j3, Map map2, boolean z3, Set set3, List list, Map map3, Map map4, Map map5, Map map6, ArrayList arrayList, WidgetChannelListModel$Companion$guildListBuilder$2 widgetChannelListModel$Companion$guildListBuilder$2, Map map7, Map map8, Map map9) {
        super(1);
        this.$channelId = j;
        this.$channel = channel;
        this.$permissions = l;
        this.$guild$inlined = guildChannelsInfo;
        this.$forceViewCategories$inlined = hashSet;
        this.$isGuildHub$inlined = z2;
        this.$selectedChannel$inlined = channel2;
        this.$mentionCounts$inlined = map;
        this.$unreadChannelIds$inlined = set;
        this.$selectedGuildId$inlined = j2;
        this.$areAnyChildThreadsSelected$5$inlined = widgetChannelListModel$Companion$guildListBuilder$5;
        this.$collapsedCategories$inlined = set2;
        this.$isThreadUnread$3$inlined = widgetChannelListModel$Companion$guildListBuilder$3;
        this.$hiddenChannelsIds$inlined = hashSet2;
        this.$areAllChildThreadsRead$4$inlined = widgetChannelListModel$Companion$guildListBuilder$4;
        this.$selectedVoiceChannelId$inlined = j3;
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

    @Override // kotlin.jvm.functions.Function1
    public final WidgetChannelListModel.Companion.VocalChannelData invoke(Channel channel) {
        PermissionOverwrite permissionOverwrite;
        Object obj;
        Intrinsics3.checkNotNullParameter(channel, "vocalChannel");
        long j = this.$channelId;
        boolean z2 = j == this.$selectedVoiceChannelId$inlined;
        Channel channel2 = this.$selectedChannel$inlined;
        boolean z3 = channel2 != null && j == channel2.getId();
        Collection collection = (Collection) outline.d(this.$channel, this.$voiceStates$inlined);
        int size = collection != null ? collection.size() : 0;
        boolean zCan = PermissionUtils.can(Permission.VIEW_CHANNEL, this.$permissions);
        boolean z4 = this.$canSeeGuildRoleSubscriptions$inlined && ChannelUtils.t(channel, this.$guild$inlined.getGuild(), this.$guild$inlined.getEveryoneRole(), this.$guild$inlined.getGuildRoles());
        PermissionUtils permissionUtils = PermissionUtils.INSTANCE;
        GuildRole everyoneRole = this.$guild$inlined.getEveryoneRole();
        List<PermissionOverwrite> listV = channel.v();
        if (listV != null) {
            Iterator<T> it = listV.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                Object next = it.next();
                if (((PermissionOverwrite) next).e() == this.$selectedGuildId$inlined) {
                    obj = next;
                    break;
                }
            }
            permissionOverwrite = (PermissionOverwrite) obj;
        } else {
            permissionOverwrite = null;
        }
        boolean z5 = !permissionUtils.canRole(Permission.CONNECT, everyoneRole, permissionOverwrite) || (!zCan && z4);
        boolean nsfw = this.$channel.getNsfw();
        Integer num = (Integer) this.$mentionCounts$inlined.get(Long.valueOf(this.$channelId));
        int iIntValue = num != null ? num.intValue() : 0;
        boolean zContains = this.$unreadChannelIds$inlined.contains(Long.valueOf(this.$channelId));
        if (!zCan && !z2 && !z4) {
            return null;
        }
        if (this.$collapsedCategories$inlined.contains(Long.valueOf(channel.getParentId())) && size == 0 && !z2) {
            return null;
        }
        return new WidgetChannelListModel.Companion.VocalChannelData(z2, z3, iIntValue, zContains, z5, nsfw, this.$permissions, size, !(zCan && PermissionUtils.can(Permission.CONNECT, this.$permissions)) && z4, z4);
    }
}
