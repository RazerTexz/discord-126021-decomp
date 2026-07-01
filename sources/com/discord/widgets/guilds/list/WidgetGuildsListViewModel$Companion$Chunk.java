package com.discord.widgets.guilds.list;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.stores.StoreGuildsSorted$Entry;
import d0.z.d.m;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: WidgetGuildsListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetGuildsListViewModel$Companion$Chunk {
    private final Map<Long, List<Long>> channelIds;
    private final Map<Long, ModelNotificationSettings> guildSettings;
    private final Map<Long, Integer> mentionCounts;
    private final Map<Long, Channel> privateChannels;
    private final long selectedGuildId;
    private final long selectedVoiceChannelId;
    private final List<StoreGuildsSorted$Entry> sortedGuilds;
    private final Set<Long> unavailableGuilds;
    private final Set<Long> unreadGuildIds;

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetGuildsListViewModel$Companion$Chunk(long j, long j2, Map<Long, ? extends ModelNotificationSettings> map, Set<Long> set, Map<Long, Integer> map2, Map<Long, ? extends List<Long>> map3, Set<Long> set2, Map<Long, Channel> map4, List<? extends StoreGuildsSorted$Entry> list) {
        m.checkNotNullParameter(map, "guildSettings");
        m.checkNotNullParameter(set, "unreadGuildIds");
        m.checkNotNullParameter(map2, "mentionCounts");
        m.checkNotNullParameter(map3, "channelIds");
        m.checkNotNullParameter(set2, "unavailableGuilds");
        m.checkNotNullParameter(map4, "privateChannels");
        m.checkNotNullParameter(list, "sortedGuilds");
        this.selectedGuildId = j;
        this.selectedVoiceChannelId = j2;
        this.guildSettings = map;
        this.unreadGuildIds = set;
        this.mentionCounts = map2;
        this.channelIds = map3;
        this.unavailableGuilds = set2;
        this.privateChannels = map4;
        this.sortedGuilds = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetGuildsListViewModel$Companion$Chunk copy$default(WidgetGuildsListViewModel$Companion$Chunk widgetGuildsListViewModel$Companion$Chunk, long j, long j2, Map map, Set set, Map map2, Map map3, Set set2, Map map4, List list, int i, Object obj) {
        return widgetGuildsListViewModel$Companion$Chunk.copy((i & 1) != 0 ? widgetGuildsListViewModel$Companion$Chunk.selectedGuildId : j, (i & 2) != 0 ? widgetGuildsListViewModel$Companion$Chunk.selectedVoiceChannelId : j2, (i & 4) != 0 ? widgetGuildsListViewModel$Companion$Chunk.guildSettings : map, (i & 8) != 0 ? widgetGuildsListViewModel$Companion$Chunk.unreadGuildIds : set, (i & 16) != 0 ? widgetGuildsListViewModel$Companion$Chunk.mentionCounts : map2, (i & 32) != 0 ? widgetGuildsListViewModel$Companion$Chunk.channelIds : map3, (i & 64) != 0 ? widgetGuildsListViewModel$Companion$Chunk.unavailableGuilds : set2, (i & 128) != 0 ? widgetGuildsListViewModel$Companion$Chunk.privateChannels : map4, (i & 256) != 0 ? widgetGuildsListViewModel$Companion$Chunk.sortedGuilds : list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getSelectedGuildId() {
        return this.selectedGuildId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getSelectedVoiceChannelId() {
        return this.selectedVoiceChannelId;
    }

    public final Map<Long, ModelNotificationSettings> component3() {
        return this.guildSettings;
    }

    public final Set<Long> component4() {
        return this.unreadGuildIds;
    }

    public final Map<Long, Integer> component5() {
        return this.mentionCounts;
    }

    public final Map<Long, List<Long>> component6() {
        return this.channelIds;
    }

    public final Set<Long> component7() {
        return this.unavailableGuilds;
    }

    public final Map<Long, Channel> component8() {
        return this.privateChannels;
    }

    public final List<StoreGuildsSorted$Entry> component9() {
        return this.sortedGuilds;
    }

    public final WidgetGuildsListViewModel$Companion$Chunk copy(long selectedGuildId, long selectedVoiceChannelId, Map<Long, ? extends ModelNotificationSettings> guildSettings, Set<Long> unreadGuildIds, Map<Long, Integer> mentionCounts, Map<Long, ? extends List<Long>> channelIds, Set<Long> unavailableGuilds, Map<Long, Channel> privateChannels, List<? extends StoreGuildsSorted$Entry> sortedGuilds) {
        m.checkNotNullParameter(guildSettings, "guildSettings");
        m.checkNotNullParameter(unreadGuildIds, "unreadGuildIds");
        m.checkNotNullParameter(mentionCounts, "mentionCounts");
        m.checkNotNullParameter(channelIds, "channelIds");
        m.checkNotNullParameter(unavailableGuilds, "unavailableGuilds");
        m.checkNotNullParameter(privateChannels, "privateChannels");
        m.checkNotNullParameter(sortedGuilds, "sortedGuilds");
        return new WidgetGuildsListViewModel$Companion$Chunk(selectedGuildId, selectedVoiceChannelId, guildSettings, unreadGuildIds, mentionCounts, channelIds, unavailableGuilds, privateChannels, sortedGuilds);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetGuildsListViewModel$Companion$Chunk)) {
            return false;
        }
        WidgetGuildsListViewModel$Companion$Chunk widgetGuildsListViewModel$Companion$Chunk = (WidgetGuildsListViewModel$Companion$Chunk) other;
        return this.selectedGuildId == widgetGuildsListViewModel$Companion$Chunk.selectedGuildId && this.selectedVoiceChannelId == widgetGuildsListViewModel$Companion$Chunk.selectedVoiceChannelId && m.areEqual(this.guildSettings, widgetGuildsListViewModel$Companion$Chunk.guildSettings) && m.areEqual(this.unreadGuildIds, widgetGuildsListViewModel$Companion$Chunk.unreadGuildIds) && m.areEqual(this.mentionCounts, widgetGuildsListViewModel$Companion$Chunk.mentionCounts) && m.areEqual(this.channelIds, widgetGuildsListViewModel$Companion$Chunk.channelIds) && m.areEqual(this.unavailableGuilds, widgetGuildsListViewModel$Companion$Chunk.unavailableGuilds) && m.areEqual(this.privateChannels, widgetGuildsListViewModel$Companion$Chunk.privateChannels) && m.areEqual(this.sortedGuilds, widgetGuildsListViewModel$Companion$Chunk.sortedGuilds);
    }

    public final Map<Long, List<Long>> getChannelIds() {
        return this.channelIds;
    }

    public final Map<Long, ModelNotificationSettings> getGuildSettings() {
        return this.guildSettings;
    }

    public final Map<Long, Integer> getMentionCounts() {
        return this.mentionCounts;
    }

    public final Map<Long, Channel> getPrivateChannels() {
        return this.privateChannels;
    }

    public final long getSelectedGuildId() {
        return this.selectedGuildId;
    }

    public final long getSelectedVoiceChannelId() {
        return this.selectedVoiceChannelId;
    }

    public final List<StoreGuildsSorted$Entry> getSortedGuilds() {
        return this.sortedGuilds;
    }

    public final Set<Long> getUnavailableGuilds() {
        return this.unavailableGuilds;
    }

    public final Set<Long> getUnreadGuildIds() {
        return this.unreadGuildIds;
    }

    public int hashCode() {
        int iA = (b.a(this.selectedVoiceChannelId) + (b.a(this.selectedGuildId) * 31)) * 31;
        Map<Long, ModelNotificationSettings> map = this.guildSettings;
        int iHashCode = (iA + (map != null ? map.hashCode() : 0)) * 31;
        Set<Long> set = this.unreadGuildIds;
        int iHashCode2 = (iHashCode + (set != null ? set.hashCode() : 0)) * 31;
        Map<Long, Integer> map2 = this.mentionCounts;
        int iHashCode3 = (iHashCode2 + (map2 != null ? map2.hashCode() : 0)) * 31;
        Map<Long, List<Long>> map3 = this.channelIds;
        int iHashCode4 = (iHashCode3 + (map3 != null ? map3.hashCode() : 0)) * 31;
        Set<Long> set2 = this.unavailableGuilds;
        int iHashCode5 = (iHashCode4 + (set2 != null ? set2.hashCode() : 0)) * 31;
        Map<Long, Channel> map4 = this.privateChannels;
        int iHashCode6 = (iHashCode5 + (map4 != null ? map4.hashCode() : 0)) * 31;
        List<StoreGuildsSorted$Entry> list = this.sortedGuilds;
        return iHashCode6 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Chunk(selectedGuildId=");
        sbU.append(this.selectedGuildId);
        sbU.append(", selectedVoiceChannelId=");
        sbU.append(this.selectedVoiceChannelId);
        sbU.append(", guildSettings=");
        sbU.append(this.guildSettings);
        sbU.append(", unreadGuildIds=");
        sbU.append(this.unreadGuildIds);
        sbU.append(", mentionCounts=");
        sbU.append(this.mentionCounts);
        sbU.append(", channelIds=");
        sbU.append(this.channelIds);
        sbU.append(", unavailableGuilds=");
        sbU.append(this.unavailableGuilds);
        sbU.append(", privateChannels=");
        sbU.append(this.privateChannels);
        sbU.append(", sortedGuilds=");
        return a.L(sbU, this.sortedGuilds, ")");
    }
}
