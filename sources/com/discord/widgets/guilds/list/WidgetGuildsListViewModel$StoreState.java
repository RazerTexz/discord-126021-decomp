package com.discord.widgets.guilds.list;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.guildjoinrequest.GuildJoinRequest;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreGuildsSorted$Entry;
import com.discord.utilities.streams.StreamContext;
import d0.z.d.m;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: WidgetGuildsListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetGuildsListViewModel$StoreState {
    private final Map<Long, StreamContext> allApplicationStreamContexts;
    private final Map<Long, Long> allChannelPermissions;
    private final Map<Long, List<Long>> channelIds;
    private final Map<Long, Channel> channels;
    private final Set<Long> guildIds;
    private final Set<Long> guildIdsWithActiveScheduledEvents;
    private final Set<Long> guildIdsWithActiveStageEvents;
    private final Map<Long, GuildJoinRequest> guildJoinRequests;
    private final Map<Long, ModelNotificationSettings> guildSettings;
    private final boolean isLeftPanelOpened;
    private final boolean isNewUser;
    private final boolean isOnHomeTab;
    private final Set<Long> lurkingGuildIds;
    private final Map<Long, Integer> mentionCounts;
    private final Set<Long> openFolderIds;
    private final List<Guild> pendingGuilds;
    private final Map<Long, Channel> privateChannels;
    private final long selectedGuildId;
    private final long selectedVoiceChannelId;
    private final boolean showHubSparkle;
    private final List<StoreGuildsSorted$Entry> sortedGuilds;
    private final Set<Long> unavailableGuilds;
    private final Set<Long> unreadGuildIds;

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetGuildsListViewModel$StoreState(long j, long j2, Map<Long, ? extends ModelNotificationSettings> map, Set<Long> set, Map<Long, Integer> map2, Map<Long, ? extends List<Long>> map3, Set<Long> set2, Map<Long, Channel> map4, List<? extends StoreGuildsSorted$Entry> list, Map<Long, GuildJoinRequest> map5, List<Guild> list2, Set<Long> set3, Set<Long> set4, Set<Long> set5, Set<Long> set6, Map<Long, Channel> map6, Set<Long> set7, boolean z2, Map<Long, StreamContext> map7, Map<Long, Long> map8, boolean z3, boolean z4, boolean z5) {
        m.checkNotNullParameter(map, "guildSettings");
        m.checkNotNullParameter(set, "unreadGuildIds");
        m.checkNotNullParameter(map2, "mentionCounts");
        m.checkNotNullParameter(map3, "channelIds");
        m.checkNotNullParameter(set2, "unavailableGuilds");
        m.checkNotNullParameter(map4, "privateChannels");
        m.checkNotNullParameter(list, "sortedGuilds");
        m.checkNotNullParameter(map5, "guildJoinRequests");
        m.checkNotNullParameter(list2, "pendingGuilds");
        m.checkNotNullParameter(set3, "guildIds");
        m.checkNotNullParameter(set4, "lurkingGuildIds");
        m.checkNotNullParameter(set5, "guildIdsWithActiveStageEvents");
        m.checkNotNullParameter(set6, "guildIdsWithActiveScheduledEvents");
        m.checkNotNullParameter(map6, "channels");
        m.checkNotNullParameter(set7, "openFolderIds");
        m.checkNotNullParameter(map7, "allApplicationStreamContexts");
        m.checkNotNullParameter(map8, "allChannelPermissions");
        this.selectedGuildId = j;
        this.selectedVoiceChannelId = j2;
        this.guildSettings = map;
        this.unreadGuildIds = set;
        this.mentionCounts = map2;
        this.channelIds = map3;
        this.unavailableGuilds = set2;
        this.privateChannels = map4;
        this.sortedGuilds = list;
        this.guildJoinRequests = map5;
        this.pendingGuilds = list2;
        this.guildIds = set3;
        this.lurkingGuildIds = set4;
        this.guildIdsWithActiveStageEvents = set5;
        this.guildIdsWithActiveScheduledEvents = set6;
        this.channels = map6;
        this.openFolderIds = set7;
        this.isNewUser = z2;
        this.allApplicationStreamContexts = map7;
        this.allChannelPermissions = map8;
        this.isLeftPanelOpened = z3;
        this.isOnHomeTab = z4;
        this.showHubSparkle = z5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetGuildsListViewModel$StoreState copy$default(WidgetGuildsListViewModel$StoreState widgetGuildsListViewModel$StoreState, long j, long j2, Map map, Set set, Map map2, Map map3, Set set2, Map map4, List list, Map map5, List list2, Set set3, Set set4, Set set5, Set set6, Map map6, Set set7, boolean z2, Map map7, Map map8, boolean z3, boolean z4, boolean z5, int i, Object obj) {
        return widgetGuildsListViewModel$StoreState.copy((i & 1) != 0 ? widgetGuildsListViewModel$StoreState.selectedGuildId : j, (i & 2) != 0 ? widgetGuildsListViewModel$StoreState.selectedVoiceChannelId : j2, (i & 4) != 0 ? widgetGuildsListViewModel$StoreState.guildSettings : map, (i & 8) != 0 ? widgetGuildsListViewModel$StoreState.unreadGuildIds : set, (i & 16) != 0 ? widgetGuildsListViewModel$StoreState.mentionCounts : map2, (i & 32) != 0 ? widgetGuildsListViewModel$StoreState.channelIds : map3, (i & 64) != 0 ? widgetGuildsListViewModel$StoreState.unavailableGuilds : set2, (i & 128) != 0 ? widgetGuildsListViewModel$StoreState.privateChannels : map4, (i & 256) != 0 ? widgetGuildsListViewModel$StoreState.sortedGuilds : list, (i & 512) != 0 ? widgetGuildsListViewModel$StoreState.guildJoinRequests : map5, (i & 1024) != 0 ? widgetGuildsListViewModel$StoreState.pendingGuilds : list2, (i & 2048) != 0 ? widgetGuildsListViewModel$StoreState.guildIds : set3, (i & 4096) != 0 ? widgetGuildsListViewModel$StoreState.lurkingGuildIds : set4, (i & 8192) != 0 ? widgetGuildsListViewModel$StoreState.guildIdsWithActiveStageEvents : set5, (i & 16384) != 0 ? widgetGuildsListViewModel$StoreState.guildIdsWithActiveScheduledEvents : set6, (i & 32768) != 0 ? widgetGuildsListViewModel$StoreState.channels : map6, (i & 65536) != 0 ? widgetGuildsListViewModel$StoreState.openFolderIds : set7, (i & 131072) != 0 ? widgetGuildsListViewModel$StoreState.isNewUser : z2, (i & 262144) != 0 ? widgetGuildsListViewModel$StoreState.allApplicationStreamContexts : map7, (i & 524288) != 0 ? widgetGuildsListViewModel$StoreState.allChannelPermissions : map8, (i & 1048576) != 0 ? widgetGuildsListViewModel$StoreState.isLeftPanelOpened : z3, (i & 2097152) != 0 ? widgetGuildsListViewModel$StoreState.isOnHomeTab : z4, (i & 4194304) != 0 ? widgetGuildsListViewModel$StoreState.showHubSparkle : z5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getSelectedGuildId() {
        return this.selectedGuildId;
    }

    public final Map<Long, GuildJoinRequest> component10() {
        return this.guildJoinRequests;
    }

    public final List<Guild> component11() {
        return this.pendingGuilds;
    }

    public final Set<Long> component12() {
        return this.guildIds;
    }

    public final Set<Long> component13() {
        return this.lurkingGuildIds;
    }

    public final Set<Long> component14() {
        return this.guildIdsWithActiveStageEvents;
    }

    public final Set<Long> component15() {
        return this.guildIdsWithActiveScheduledEvents;
    }

    public final Map<Long, Channel> component16() {
        return this.channels;
    }

    public final Set<Long> component17() {
        return this.openFolderIds;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final boolean getIsNewUser() {
        return this.isNewUser;
    }

    public final Map<Long, StreamContext> component19() {
        return this.allApplicationStreamContexts;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getSelectedVoiceChannelId() {
        return this.selectedVoiceChannelId;
    }

    public final Map<Long, Long> component20() {
        return this.allChannelPermissions;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final boolean getIsLeftPanelOpened() {
        return this.isLeftPanelOpened;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final boolean getIsOnHomeTab() {
        return this.isOnHomeTab;
    }

    /* JADX INFO: renamed from: component23, reason: from getter */
    public final boolean getShowHubSparkle() {
        return this.showHubSparkle;
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

    public final WidgetGuildsListViewModel$StoreState copy(long selectedGuildId, long selectedVoiceChannelId, Map<Long, ? extends ModelNotificationSettings> guildSettings, Set<Long> unreadGuildIds, Map<Long, Integer> mentionCounts, Map<Long, ? extends List<Long>> channelIds, Set<Long> unavailableGuilds, Map<Long, Channel> privateChannels, List<? extends StoreGuildsSorted$Entry> sortedGuilds, Map<Long, GuildJoinRequest> guildJoinRequests, List<Guild> pendingGuilds, Set<Long> guildIds, Set<Long> lurkingGuildIds, Set<Long> guildIdsWithActiveStageEvents, Set<Long> guildIdsWithActiveScheduledEvents, Map<Long, Channel> channels, Set<Long> openFolderIds, boolean isNewUser, Map<Long, StreamContext> allApplicationStreamContexts, Map<Long, Long> allChannelPermissions, boolean isLeftPanelOpened, boolean isOnHomeTab, boolean showHubSparkle) {
        m.checkNotNullParameter(guildSettings, "guildSettings");
        m.checkNotNullParameter(unreadGuildIds, "unreadGuildIds");
        m.checkNotNullParameter(mentionCounts, "mentionCounts");
        m.checkNotNullParameter(channelIds, "channelIds");
        m.checkNotNullParameter(unavailableGuilds, "unavailableGuilds");
        m.checkNotNullParameter(privateChannels, "privateChannels");
        m.checkNotNullParameter(sortedGuilds, "sortedGuilds");
        m.checkNotNullParameter(guildJoinRequests, "guildJoinRequests");
        m.checkNotNullParameter(pendingGuilds, "pendingGuilds");
        m.checkNotNullParameter(guildIds, "guildIds");
        m.checkNotNullParameter(lurkingGuildIds, "lurkingGuildIds");
        m.checkNotNullParameter(guildIdsWithActiveStageEvents, "guildIdsWithActiveStageEvents");
        m.checkNotNullParameter(guildIdsWithActiveScheduledEvents, "guildIdsWithActiveScheduledEvents");
        m.checkNotNullParameter(channels, "channels");
        m.checkNotNullParameter(openFolderIds, "openFolderIds");
        m.checkNotNullParameter(allApplicationStreamContexts, "allApplicationStreamContexts");
        m.checkNotNullParameter(allChannelPermissions, "allChannelPermissions");
        return new WidgetGuildsListViewModel$StoreState(selectedGuildId, selectedVoiceChannelId, guildSettings, unreadGuildIds, mentionCounts, channelIds, unavailableGuilds, privateChannels, sortedGuilds, guildJoinRequests, pendingGuilds, guildIds, lurkingGuildIds, guildIdsWithActiveStageEvents, guildIdsWithActiveScheduledEvents, channels, openFolderIds, isNewUser, allApplicationStreamContexts, allChannelPermissions, isLeftPanelOpened, isOnHomeTab, showHubSparkle);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetGuildsListViewModel$StoreState)) {
            return false;
        }
        WidgetGuildsListViewModel$StoreState widgetGuildsListViewModel$StoreState = (WidgetGuildsListViewModel$StoreState) other;
        return this.selectedGuildId == widgetGuildsListViewModel$StoreState.selectedGuildId && this.selectedVoiceChannelId == widgetGuildsListViewModel$StoreState.selectedVoiceChannelId && m.areEqual(this.guildSettings, widgetGuildsListViewModel$StoreState.guildSettings) && m.areEqual(this.unreadGuildIds, widgetGuildsListViewModel$StoreState.unreadGuildIds) && m.areEqual(this.mentionCounts, widgetGuildsListViewModel$StoreState.mentionCounts) && m.areEqual(this.channelIds, widgetGuildsListViewModel$StoreState.channelIds) && m.areEqual(this.unavailableGuilds, widgetGuildsListViewModel$StoreState.unavailableGuilds) && m.areEqual(this.privateChannels, widgetGuildsListViewModel$StoreState.privateChannels) && m.areEqual(this.sortedGuilds, widgetGuildsListViewModel$StoreState.sortedGuilds) && m.areEqual(this.guildJoinRequests, widgetGuildsListViewModel$StoreState.guildJoinRequests) && m.areEqual(this.pendingGuilds, widgetGuildsListViewModel$StoreState.pendingGuilds) && m.areEqual(this.guildIds, widgetGuildsListViewModel$StoreState.guildIds) && m.areEqual(this.lurkingGuildIds, widgetGuildsListViewModel$StoreState.lurkingGuildIds) && m.areEqual(this.guildIdsWithActiveStageEvents, widgetGuildsListViewModel$StoreState.guildIdsWithActiveStageEvents) && m.areEqual(this.guildIdsWithActiveScheduledEvents, widgetGuildsListViewModel$StoreState.guildIdsWithActiveScheduledEvents) && m.areEqual(this.channels, widgetGuildsListViewModel$StoreState.channels) && m.areEqual(this.openFolderIds, widgetGuildsListViewModel$StoreState.openFolderIds) && this.isNewUser == widgetGuildsListViewModel$StoreState.isNewUser && m.areEqual(this.allApplicationStreamContexts, widgetGuildsListViewModel$StoreState.allApplicationStreamContexts) && m.areEqual(this.allChannelPermissions, widgetGuildsListViewModel$StoreState.allChannelPermissions) && this.isLeftPanelOpened == widgetGuildsListViewModel$StoreState.isLeftPanelOpened && this.isOnHomeTab == widgetGuildsListViewModel$StoreState.isOnHomeTab && this.showHubSparkle == widgetGuildsListViewModel$StoreState.showHubSparkle;
    }

    public final Map<Long, StreamContext> getAllApplicationStreamContexts() {
        return this.allApplicationStreamContexts;
    }

    public final Map<Long, Long> getAllChannelPermissions() {
        return this.allChannelPermissions;
    }

    public final Map<Long, List<Long>> getChannelIds() {
        return this.channelIds;
    }

    public final Map<Long, Channel> getChannels() {
        return this.channels;
    }

    public final Set<Long> getGuildIds() {
        return this.guildIds;
    }

    public final Set<Long> getGuildIdsWithActiveScheduledEvents() {
        return this.guildIdsWithActiveScheduledEvents;
    }

    public final Set<Long> getGuildIdsWithActiveStageEvents() {
        return this.guildIdsWithActiveStageEvents;
    }

    public final Map<Long, GuildJoinRequest> getGuildJoinRequests() {
        return this.guildJoinRequests;
    }

    public final Map<Long, ModelNotificationSettings> getGuildSettings() {
        return this.guildSettings;
    }

    public final Set<Long> getLurkingGuildIds() {
        return this.lurkingGuildIds;
    }

    public final Map<Long, Integer> getMentionCounts() {
        return this.mentionCounts;
    }

    public final Set<Long> getOpenFolderIds() {
        return this.openFolderIds;
    }

    public final List<Guild> getPendingGuilds() {
        return this.pendingGuilds;
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

    public final boolean getShowHubSparkle() {
        return this.showHubSparkle;
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v49, types: [int] */
    /* JADX WARN: Type inference failed for: r0v55, types: [int] */
    /* JADX WARN: Type inference failed for: r0v57, types: [int] */
    /* JADX WARN: Type inference failed for: r0v59 */
    /* JADX WARN: Type inference failed for: r0v60 */
    /* JADX WARN: Type inference failed for: r0v62 */
    /* JADX WARN: Type inference failed for: r0v78 */
    /* JADX WARN: Type inference failed for: r0v79 */
    /* JADX WARN: Type inference failed for: r0v80 */
    /* JADX WARN: Type inference failed for: r1v34, types: [int] */
    /* JADX WARN: Type inference failed for: r1v40, types: [int] */
    /* JADX WARN: Type inference failed for: r1v42, types: [int] */
    /* JADX WARN: Type inference failed for: r1v44, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
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
        int iHashCode7 = (iHashCode6 + (list != null ? list.hashCode() : 0)) * 31;
        Map<Long, GuildJoinRequest> map5 = this.guildJoinRequests;
        int iHashCode8 = (iHashCode7 + (map5 != null ? map5.hashCode() : 0)) * 31;
        List<Guild> list2 = this.pendingGuilds;
        int iHashCode9 = (iHashCode8 + (list2 != null ? list2.hashCode() : 0)) * 31;
        Set<Long> set3 = this.guildIds;
        int iHashCode10 = (iHashCode9 + (set3 != null ? set3.hashCode() : 0)) * 31;
        Set<Long> set4 = this.lurkingGuildIds;
        int iHashCode11 = (iHashCode10 + (set4 != null ? set4.hashCode() : 0)) * 31;
        Set<Long> set5 = this.guildIdsWithActiveStageEvents;
        int iHashCode12 = (iHashCode11 + (set5 != null ? set5.hashCode() : 0)) * 31;
        Set<Long> set6 = this.guildIdsWithActiveScheduledEvents;
        int iHashCode13 = (iHashCode12 + (set6 != null ? set6.hashCode() : 0)) * 31;
        Map<Long, Channel> map6 = this.channels;
        int iHashCode14 = (iHashCode13 + (map6 != null ? map6.hashCode() : 0)) * 31;
        Set<Long> set7 = this.openFolderIds;
        int iHashCode15 = (iHashCode14 + (set7 != null ? set7.hashCode() : 0)) * 31;
        boolean z2 = this.isNewUser;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = (iHashCode15 + r0) * 31;
        Map<Long, StreamContext> map7 = this.allApplicationStreamContexts;
        int iHashCode16 = (i + (map7 != null ? map7.hashCode() : 0)) * 31;
        Map<Long, Long> map8 = this.allChannelPermissions;
        int iHashCode17 = (iHashCode16 + (map8 != null ? map8.hashCode() : 0)) * 31;
        boolean z3 = this.isLeftPanelOpened;
        ?? r1 = z3;
        if (z3) {
            r1 = 1;
        }
        int i2 = (iHashCode17 + r1) * 31;
        boolean z4 = this.isOnHomeTab;
        ?? r2 = z4;
        if (z4) {
            r2 = 1;
        }
        int i3 = (i2 + r2) * 31;
        boolean z5 = this.showHubSparkle;
        return i3 + (z5 ? 1 : z5);
    }

    public final boolean isLeftPanelOpened() {
        return this.isLeftPanelOpened;
    }

    public final boolean isNewUser() {
        return this.isNewUser;
    }

    public final boolean isOnHomeTab() {
        return this.isOnHomeTab;
    }

    public String toString() {
        StringBuilder sbU = a.U("StoreState(selectedGuildId=");
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
        sbU.append(this.sortedGuilds);
        sbU.append(", guildJoinRequests=");
        sbU.append(this.guildJoinRequests);
        sbU.append(", pendingGuilds=");
        sbU.append(this.pendingGuilds);
        sbU.append(", guildIds=");
        sbU.append(this.guildIds);
        sbU.append(", lurkingGuildIds=");
        sbU.append(this.lurkingGuildIds);
        sbU.append(", guildIdsWithActiveStageEvents=");
        sbU.append(this.guildIdsWithActiveStageEvents);
        sbU.append(", guildIdsWithActiveScheduledEvents=");
        sbU.append(this.guildIdsWithActiveScheduledEvents);
        sbU.append(", channels=");
        sbU.append(this.channels);
        sbU.append(", openFolderIds=");
        sbU.append(this.openFolderIds);
        sbU.append(", isNewUser=");
        sbU.append(this.isNewUser);
        sbU.append(", allApplicationStreamContexts=");
        sbU.append(this.allApplicationStreamContexts);
        sbU.append(", allChannelPermissions=");
        sbU.append(this.allChannelPermissions);
        sbU.append(", isLeftPanelOpened=");
        sbU.append(this.isLeftPanelOpened);
        sbU.append(", isOnHomeTab=");
        sbU.append(this.isOnHomeTab);
        sbU.append(", showHubSparkle=");
        return a.O(sbU, this.showHubSparkle, ")");
    }
}
