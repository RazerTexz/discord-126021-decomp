package com.discord.widgets.user.search;

import a0.a.a.b;
import androidx.core.app.FrameMetricsAggregator;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.guild.Guild;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.widgets.user.search.WidgetGlobalSearchGuildsModel;
import d0.f0._Sequences2;
import d0.f0.n;
import d0.t._Collections;
import d0.u.a;
import d0.z.d.Intrinsics3;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.sequences.Sequence;

/* JADX INFO: compiled from: WidgetGlobalSearchGuildsModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetGlobalSearchGuildsModel {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final boolean hasChannels;
    private final List<Item> items;

    /* JADX INFO: compiled from: WidgetGlobalSearchGuildsModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Sequence<Item> asDirectMessageItems(Map<Long, Channel> map, Map<Long, Integer> map2, ModelNotificationSettings modelNotificationSettings) {
            return _Sequences2.map(_Sequences2.sortedWith(_Sequences2.filter(_Sequences2.filterNotNull(_Collections.asSequence(map.values())), new WidgetGlobalSearchGuildsModel2(modelNotificationSettings, map2)), ChannelUtils.h(Channel.INSTANCE)), new WidgetGlobalSearchGuildsModel3(map2));
        }

        private final Sequence<Item> asGuildItems(Sequence<Guild> sequence, Long l, long j, Set<Long> set, Map<Long, ? extends ModelNotificationSettings> map, Map<Long, Integer> map2, Map<Long, ? extends List<Long>> map3) {
            return _Sequences2.map(sequence, new WidgetGlobalSearchGuildsModel4(map3, map2, map, set, l, j));
        }

        public final WidgetGlobalSearchGuildsModel create(List<Long> recentGuildIds, long selectedVoiceChannelId, Set<Long> unreadGuildIds, Map<Long, Integer> mentionCounts, Map<Long, Channel> privateChannels, Map<Long, Guild> guilds, Map<Long, ? extends List<Long>> channelIds, Map<Long, ? extends ModelNotificationSettings> guildSettings) {
            Intrinsics3.checkNotNullParameter(recentGuildIds, "recentGuildIds");
            Intrinsics3.checkNotNullParameter(unreadGuildIds, "unreadGuildIds");
            Intrinsics3.checkNotNullParameter(mentionCounts, "mentionCounts");
            Intrinsics3.checkNotNullParameter(privateChannels, "privateChannels");
            Intrinsics3.checkNotNullParameter(guilds, "guilds");
            Intrinsics3.checkNotNullParameter(channelIds, "channelIds");
            Intrinsics3.checkNotNullParameter(guildSettings, "guildSettings");
            Sequence<Item> sequenceAsDirectMessageItems = asDirectMessageItems(privateChannels, mentionCounts, guildSettings.get(0L));
            return new WidgetGlobalSearchGuildsModel(_Sequences2.toList(_Sequences2.plus(_Sequences2.plus((Sequence) sequenceAsDirectMessageItems, _Sequences2.any(sequenceAsDirectMessageItems) ? n.sequenceOf(Item.INSTANCE.createDivider$app_productionGoogleRelease()) : n.emptySequence()), _Sequences2.sortedWith(asGuildItems(_Sequences2.mapNotNull(_Sequences2.drop(_Sequences2.distinct(_Collections.asSequence(_Collections.plus((Collection) recentGuildIds, (Iterable) guilds.keySet()))), 1), new WidgetGlobalSearchGuildsModel5(guilds)), (Long) _Collections.firstOrNull((List) recentGuildIds), selectedVoiceChannelId, unreadGuildIds, guildSettings, mentionCounts, channelIds), new Comparator() { // from class: com.discord.widgets.user.search.WidgetGlobalSearchGuildsModel$Companion$create$$inlined$sortedByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return a.compareValues(Integer.valueOf(((WidgetGlobalSearchGuildsModel.Item) t2).getMentionCount()), Integer.valueOf(((WidgetGlobalSearchGuildsModel.Item) t).getMentionCount()));
                }
            }))), !channelIds.isEmpty());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WidgetGlobalSearchGuildsModel(List<Item> list, boolean z2) {
        Intrinsics3.checkNotNullParameter(list, "items");
        this.items = list;
        this.hasChannels = z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetGlobalSearchGuildsModel copy$default(WidgetGlobalSearchGuildsModel widgetGlobalSearchGuildsModel, List list, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = widgetGlobalSearchGuildsModel.items;
        }
        if ((i & 2) != 0) {
            z2 = widgetGlobalSearchGuildsModel.hasChannels;
        }
        return widgetGlobalSearchGuildsModel.copy(list, z2);
    }

    public final List<Item> component1() {
        return this.items;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getHasChannels() {
        return this.hasChannels;
    }

    public final WidgetGlobalSearchGuildsModel copy(List<Item> items, boolean hasChannels) {
        Intrinsics3.checkNotNullParameter(items, "items");
        return new WidgetGlobalSearchGuildsModel(items, hasChannels);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetGlobalSearchGuildsModel)) {
            return false;
        }
        WidgetGlobalSearchGuildsModel widgetGlobalSearchGuildsModel = (WidgetGlobalSearchGuildsModel) other;
        return Intrinsics3.areEqual(this.items, widgetGlobalSearchGuildsModel.items) && this.hasChannels == widgetGlobalSearchGuildsModel.hasChannels;
    }

    public final boolean getHasChannels() {
        return this.hasChannels;
    }

    public final List<Item> getItems() {
        return this.items;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        List<Item> list = this.items;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        boolean z2 = this.hasChannels;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public String toString() {
        StringBuilder sbU = outline.U("WidgetGlobalSearchGuildsModel(items=");
        sbU.append(this.items);
        sbU.append(", hasChannels=");
        return outline.O(sbU, this.hasChannels, ")");
    }

    public /* synthetic */ WidgetGlobalSearchGuildsModel(List list, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? true : z2);
    }

    /* JADX INFO: compiled from: WidgetGlobalSearchGuildsModel.kt */
    public static final /* data */ class Item implements MGRecyclerDataPayload {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final int TYPE_DIVIDER = 1;
        public static final int TYPE_DM = 2;
        public static final int TYPE_GUILD = 3;
        private final int _type;
        private final Channel channel;
        private final boolean connectedToVoice;
        private final Guild guild;
        private final long id;
        private final boolean isSelected;
        private final boolean isUnread;
        private final String key;
        private final int mentionCount;
        private final int type;
        private final int unavailableGuildCount;

        /* JADX INFO: compiled from: WidgetGlobalSearchGuildsModel.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Item createDirectMessage$app_productionGoogleRelease(Channel channel, int mentionCount) {
                Intrinsics3.checkNotNullParameter(channel, "channel");
                return new Item(2, channel.getId(), channel, null, mentionCount, false, false, false, 0, 488, null);
            }

            public final Item createDivider$app_productionGoogleRelease() {
                return new Item(1, 1L, null, null, 0, false, false, false, 0, 508, null);
            }

            public final Item createGuild$app_productionGoogleRelease(Guild guild, int mentionCount, boolean hasUnread, boolean isSelected, boolean connectedToVoice) {
                Intrinsics3.checkNotNullParameter(guild, "guild");
                return new Item(3, guild.getId(), null, guild, mentionCount, hasUnread, isSelected, connectedToVoice, 0, 260, null);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Item() {
            this(0, 0L, null, null, 0, false, false, false, 0, FrameMetricsAggregator.EVERY_DURATION, null);
        }

        public Item(int i, long j, Channel channel, Guild guild, int i2, boolean z2, boolean z3, boolean z4, int i3) {
            this._type = i;
            this.id = j;
            this.channel = channel;
            this.guild = guild;
            this.mentionCount = i2;
            this.isUnread = z2;
            this.isSelected = z3;
            this.connectedToVoice = z4;
            this.unavailableGuildCount = i3;
            this.type = i;
            StringBuilder sb = new StringBuilder();
            sb.append(getType());
            sb.append('-');
            sb.append(j);
            this.key = sb.toString();
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        private final int get_type() {
            return this._type;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final int getMentionCount() {
            return this.mentionCount;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final boolean getIsUnread() {
            return this.isUnread;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final boolean getIsSelected() {
            return this.isSelected;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final boolean getConnectedToVoice() {
            return this.connectedToVoice;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final int getUnavailableGuildCount() {
            return this.unavailableGuildCount;
        }

        public final Item copy(int _type, long id2, Channel channel, Guild guild, int mentionCount, boolean isUnread, boolean isSelected, boolean connectedToVoice, int unavailableGuildCount) {
            return new Item(_type, id2, channel, guild, mentionCount, isUnread, isSelected, connectedToVoice, unavailableGuildCount);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Item)) {
                return false;
            }
            Item item = (Item) other;
            return this._type == item._type && this.id == item.id && Intrinsics3.areEqual(this.channel, item.channel) && Intrinsics3.areEqual(this.guild, item.guild) && this.mentionCount == item.mentionCount && this.isUnread == item.isUnread && this.isSelected == item.isSelected && this.connectedToVoice == item.connectedToVoice && this.unavailableGuildCount == item.unavailableGuildCount;
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final boolean getConnectedToVoice() {
            return this.connectedToVoice;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final long getId() {
            return this.id;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        public final int getMentionCount() {
            return this.mentionCount;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        public final int getUnavailableGuildCount() {
            return this.unavailableGuildCount;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v10, types: [int] */
        /* JADX WARN: Type inference failed for: r0v13 */
        /* JADX WARN: Type inference failed for: r0v14 */
        /* JADX WARN: Type inference failed for: r0v16 */
        /* JADX WARN: Type inference failed for: r0v17 */
        /* JADX WARN: Type inference failed for: r0v8, types: [int] */
        /* JADX WARN: Type inference failed for: r1v10, types: [int] */
        /* JADX WARN: Type inference failed for: r1v12, types: [int] */
        /* JADX WARN: Type inference failed for: r1v14, types: [int] */
        /* JADX WARN: Type inference failed for: r2v2 */
        /* JADX WARN: Type inference failed for: r2v3, types: [int] */
        /* JADX WARN: Type inference failed for: r2v4 */
        public int hashCode() {
            int iA = (b.a(this.id) + (this._type * 31)) * 31;
            Channel channel = this.channel;
            int iHashCode = (iA + (channel != null ? channel.hashCode() : 0)) * 31;
            Guild guild = this.guild;
            int iHashCode2 = (((iHashCode + (guild != null ? guild.hashCode() : 0)) * 31) + this.mentionCount) * 31;
            boolean z2 = this.isUnread;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = (iHashCode2 + r0) * 31;
            boolean z3 = this.isSelected;
            ?? r1 = z3;
            if (z3) {
                r1 = 1;
            }
            int i2 = (i + r1) * 31;
            boolean z4 = this.connectedToVoice;
            return ((i2 + (z4 ? 1 : z4)) * 31) + this.unavailableGuildCount;
        }

        public final boolean isSelected() {
            return this.isSelected;
        }

        public final boolean isUnread() {
            return this.isUnread;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Item(_type=");
            sbU.append(this._type);
            sbU.append(", id=");
            sbU.append(this.id);
            sbU.append(", channel=");
            sbU.append(this.channel);
            sbU.append(", guild=");
            sbU.append(this.guild);
            sbU.append(", mentionCount=");
            sbU.append(this.mentionCount);
            sbU.append(", isUnread=");
            sbU.append(this.isUnread);
            sbU.append(", isSelected=");
            sbU.append(this.isSelected);
            sbU.append(", connectedToVoice=");
            sbU.append(this.connectedToVoice);
            sbU.append(", unavailableGuildCount=");
            return outline.B(sbU, this.unavailableGuildCount, ")");
        }

        public /* synthetic */ Item(int i, long j, Channel channel, Guild guild, int i2, boolean z2, boolean z3, boolean z4, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? 0L : j, (i4 & 4) != 0 ? null : channel, (i4 & 8) == 0 ? guild : null, (i4 & 16) != 0 ? 0 : i2, (i4 & 32) != 0 ? false : z2, (i4 & 64) != 0 ? false : z3, (i4 & 128) != 0 ? false : z4, (i4 & 256) == 0 ? i3 : 0);
        }
    }
}
