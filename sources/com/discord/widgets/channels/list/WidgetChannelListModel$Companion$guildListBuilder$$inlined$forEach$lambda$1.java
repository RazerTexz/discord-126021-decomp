package com.discord.widgets.channels.list;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.permission.Permission;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.stores.StoreStream;
import com.discord.utilities.PermissionOverwriteUtils;
import com.discord.utilities.channel.GuildChannelsInfo;
import com.discord.widgets.channels.list.WidgetChannelListModel;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: WidgetChannelListModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$1 extends Lambda implements Function3<Channel, Boolean, Boolean, WidgetChannelListModel.Companion.TextLikeChannelData> {
    public final /* synthetic */ WidgetChannelListModel$Companion$guildListBuilder$4 $areAllChildThreadsRead$4$inlined;
    public final /* synthetic */ WidgetChannelListModel$Companion$guildListBuilder$5 $areAnyChildThreadsSelected$5$inlined;
    public final /* synthetic */ boolean $canSeeGuildRoleSubscriptions$inlined;
    public final /* synthetic */ Set $channelsWithActiveThreads$inlined;
    public final /* synthetic */ Set $collapsedCategories$inlined;
    public final /* synthetic */ Map $directories$inlined;
    public final /* synthetic */ Map $directoryEvents$inlined;
    public final /* synthetic */ HashSet $forceViewCategories$inlined;
    public final /* synthetic */ GuildChannelsInfo $guild$inlined;
    public final /* synthetic */ List $guildScheduledEvents$inlined;
    public final /* synthetic */ HashSet $hiddenChannelsIds$inlined;
    public final /* synthetic */ boolean $isCategoryMuted;
    public final /* synthetic */ boolean $isGuildHub$inlined;
    public final /* synthetic */ WidgetChannelListModel$Companion$guildListBuilder$3 $isThreadUnread$3$inlined;
    public final /* synthetic */ ArrayList $items$inlined;
    public final /* synthetic */ Map $joinedThreads$inlined;
    public final /* synthetic */ Map $mentionCounts$inlined;
    public final /* synthetic */ Map $messageAcks$inlined;
    public final /* synthetic */ Channel $selectedChannel$inlined;
    public final /* synthetic */ long $selectedGuildId$inlined;
    public final /* synthetic */ long $selectedVoiceChannelId$inlined;
    public final /* synthetic */ Map $stageChannels$inlined;
    public final /* synthetic */ Map $stageInstances$inlined;
    public final /* synthetic */ Map $threadParentMap$inlined;
    public final /* synthetic */ WidgetChannelListModel$Companion$guildListBuilder$2 $tryRemoveEmptyCategory$2$inlined;
    public final /* synthetic */ Set $unreadChannelIds$inlined;
    public final /* synthetic */ Map $voiceStates$inlined;

    /* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelListModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Boolean> {
        public final /* synthetic */ Boolean $isParentMuted;
        public final /* synthetic */ Channel $textChannel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Channel channel, Boolean bool) {
            super(0);
            this.$textChannel = channel;
            this.$isParentMuted = bool;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(invoke2());
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2() {
            Channel channel = StoreStream.INSTANCE.getChannels().getChannel(this.$textChannel.getParentId());
            if (channel == null) {
                return true;
            }
            long id2 = channel.getId();
            Channel channel2 = WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$1.this.$selectedChannel$inlined;
            boolean z2 = (channel2 != null && (id2 > channel2.getId() ? 1 : (id2 == channel2.getId() ? 0 : -1)) == 0) || WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$1.this.$areAnyChildThreadsSelected$5$inlined.invoke(channel.getId());
            boolean zContains = WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$1.this.$collapsedCategories$inlined.contains(Long.valueOf(channel.getParentId()));
            return WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$1.this.$hiddenChannelsIds$inlined.contains(Long.valueOf(this.$textChannel.getParentId())) || (!z2 && !WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$1.this.$isThreadUnread$3$inlined.invoke2(this.$textChannel) && (zContains || Intrinsics3.areEqual(this.$isParentMuted, Boolean.TRUE)));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelListModel.kt */
    public static final class AnonymousClass2 extends Lambda implements Function0<Boolean> {
        public final /* synthetic */ boolean $channelSelected;
        public final /* synthetic */ boolean $isMuted;
        public final /* synthetic */ int $mentionCount;
        public final /* synthetic */ Channel $textChannel;
        public final /* synthetic */ long $textChannelId;
        public final /* synthetic */ boolean $unread;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(int i, Channel channel, boolean z2, boolean z3, boolean z4, long j) {
            super(0);
            this.$mentionCount = i;
            this.$textChannel = channel;
            this.$channelSelected = z2;
            this.$isMuted = z3;
            this.$unread = z4;
            this.$textChannelId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(invoke2());
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2() {
            boolean z2 = this.$mentionCount <= 0;
            boolean zContains = WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$1.this.$collapsedCategories$inlined.contains(Long.valueOf(this.$textChannel.getParentId()));
            boolean z3 = !(this.$channelSelected || WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$1.this.$areAnyChildThreadsSelected$5$inlined.invoke(this.$textChannel.getId())) && WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$1.this.$areAllChildThreadsRead$4$inlined.invoke(this.$textChannel.getId()) && ((zContains && z2 && (WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$1.this.$isCategoryMuted || this.$isMuted || !this.$unread)) || (this.$isMuted && WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$1.this.$guild$inlined.getHideMutedChannels()));
            if (z3) {
                WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$1.this.$hiddenChannelsIds$inlined.add(Long.valueOf(this.$textChannelId));
            }
            return z3;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$1(boolean z2, GuildChannelsInfo guildChannelsInfo, HashSet hashSet, boolean z3, Channel channel, Map map, Set set, long j, WidgetChannelListModel$Companion$guildListBuilder$5 widgetChannelListModel$Companion$guildListBuilder$5, Set set2, WidgetChannelListModel$Companion$guildListBuilder$3 widgetChannelListModel$Companion$guildListBuilder$3, HashSet hashSet2, WidgetChannelListModel$Companion$guildListBuilder$4 widgetChannelListModel$Companion$guildListBuilder$4, long j2, Map map2, boolean z4, Set set3, List list, Map map3, Map map4, Map map5, Map map6, ArrayList arrayList, WidgetChannelListModel$Companion$guildListBuilder$2 widgetChannelListModel$Companion$guildListBuilder$2, Map map7, Map map8, Map map9) {
        super(3);
        this.$isCategoryMuted = z2;
        this.$guild$inlined = guildChannelsInfo;
        this.$forceViewCategories$inlined = hashSet;
        this.$isGuildHub$inlined = z3;
        this.$selectedChannel$inlined = channel;
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

    public static /* synthetic */ WidgetChannelListModel.Companion.TextLikeChannelData invoke$default(WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$1 widgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$1, Channel channel, boolean z2, Boolean bool, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        if ((i & 4) != 0) {
            bool = null;
        }
        return widgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$1.invoke(channel, z2, bool);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ WidgetChannelListModel.Companion.TextLikeChannelData invoke(Channel channel, Boolean bool, Boolean bool2) {
        return invoke(channel, bool.booleanValue(), bool2);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0074  */
    public final WidgetChannelListModel.Companion.TextLikeChannelData invoke(Channel channel, boolean z2, Boolean bool) {
        boolean z3;
        Object next;
        Intrinsics3.checkNotNullParameter(channel, "textChannel");
        long id2 = channel.getId();
        Channel channel2 = this.$selectedChannel$inlined;
        boolean z4 = channel2 != null && id2 == channel2.getId();
        Integer num = (Integer) this.$mentionCounts$inlined.get(Long.valueOf(id2));
        int iIntValue = num != null ? num.intValue() : 0;
        boolean zContains = this.$unreadChannelIds$inlined.contains(Long.valueOf(id2));
        List<PermissionOverwrite> listV = channel.v();
        if (listV != null) {
            Iterator<T> it = listV.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!(((PermissionOverwrite) next).e() == this.$selectedGuildId$inlined));
            PermissionOverwrite permissionOverwrite = (PermissionOverwrite) next;
            if (permissionOverwrite == null || !PermissionOverwriteUtils.denies(permissionOverwrite, Permission.VIEW_CHANNEL)) {
                z3 = false;
            } else {
                z3 = true;
            }
        } else {
            z3 = false;
        }
        return new WidgetChannelListModel.Companion.TextLikeChannelData(z4, iIntValue, zContains, z3, ChannelUtils.H(channel) ? new AnonymousClass1(channel, bool).invoke2() : new AnonymousClass2(iIntValue, channel, z4, z2, zContains, id2).invoke2());
    }
}
