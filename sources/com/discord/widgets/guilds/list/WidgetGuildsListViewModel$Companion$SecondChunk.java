package com.discord.widgets.guilds.list;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.guildjoinrequest.GuildJoinRequest;
import com.discord.models.guild.Guild;
import d0.z.d.m;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: WidgetGuildsListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetGuildsListViewModel$Companion$SecondChunk {
    private final Map<Long, Channel> channels;
    private final Set<Long> guildIds;
    private final Set<Long> guildIdsWithActiveScheduledEvents;
    private final Set<Long> guildIdsWithActiveStageEvents;
    private final Map<Long, GuildJoinRequest> guildJoinRequests;
    private final List<Guild> pendingGuilds;
    private final boolean showHubSparkle;

    public WidgetGuildsListViewModel$Companion$SecondChunk(Map<Long, GuildJoinRequest> map, List<Guild> list, Set<Long> set, Set<Long> set2, Set<Long> set3, Map<Long, Channel> map2, boolean z2) {
        m.checkNotNullParameter(map, "guildJoinRequests");
        m.checkNotNullParameter(list, "pendingGuilds");
        m.checkNotNullParameter(set, "guildIds");
        m.checkNotNullParameter(set2, "guildIdsWithActiveStageEvents");
        m.checkNotNullParameter(set3, "guildIdsWithActiveScheduledEvents");
        m.checkNotNullParameter(map2, "channels");
        this.guildJoinRequests = map;
        this.pendingGuilds = list;
        this.guildIds = set;
        this.guildIdsWithActiveStageEvents = set2;
        this.guildIdsWithActiveScheduledEvents = set3;
        this.channels = map2;
        this.showHubSparkle = z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetGuildsListViewModel$Companion$SecondChunk copy$default(WidgetGuildsListViewModel$Companion$SecondChunk widgetGuildsListViewModel$Companion$SecondChunk, Map map, List list, Set set, Set set2, Set set3, Map map2, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            map = widgetGuildsListViewModel$Companion$SecondChunk.guildJoinRequests;
        }
        if ((i & 2) != 0) {
            list = widgetGuildsListViewModel$Companion$SecondChunk.pendingGuilds;
        }
        List list2 = list;
        if ((i & 4) != 0) {
            set = widgetGuildsListViewModel$Companion$SecondChunk.guildIds;
        }
        Set set4 = set;
        if ((i & 8) != 0) {
            set2 = widgetGuildsListViewModel$Companion$SecondChunk.guildIdsWithActiveStageEvents;
        }
        Set set5 = set2;
        if ((i & 16) != 0) {
            set3 = widgetGuildsListViewModel$Companion$SecondChunk.guildIdsWithActiveScheduledEvents;
        }
        Set set6 = set3;
        if ((i & 32) != 0) {
            map2 = widgetGuildsListViewModel$Companion$SecondChunk.channels;
        }
        Map map3 = map2;
        if ((i & 64) != 0) {
            z2 = widgetGuildsListViewModel$Companion$SecondChunk.showHubSparkle;
        }
        return widgetGuildsListViewModel$Companion$SecondChunk.copy(map, list2, set4, set5, set6, map3, z2);
    }

    public final Map<Long, GuildJoinRequest> component1() {
        return this.guildJoinRequests;
    }

    public final List<Guild> component2() {
        return this.pendingGuilds;
    }

    public final Set<Long> component3() {
        return this.guildIds;
    }

    public final Set<Long> component4() {
        return this.guildIdsWithActiveStageEvents;
    }

    public final Set<Long> component5() {
        return this.guildIdsWithActiveScheduledEvents;
    }

    public final Map<Long, Channel> component6() {
        return this.channels;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getShowHubSparkle() {
        return this.showHubSparkle;
    }

    public final WidgetGuildsListViewModel$Companion$SecondChunk copy(Map<Long, GuildJoinRequest> guildJoinRequests, List<Guild> pendingGuilds, Set<Long> guildIds, Set<Long> guildIdsWithActiveStageEvents, Set<Long> guildIdsWithActiveScheduledEvents, Map<Long, Channel> channels, boolean showHubSparkle) {
        m.checkNotNullParameter(guildJoinRequests, "guildJoinRequests");
        m.checkNotNullParameter(pendingGuilds, "pendingGuilds");
        m.checkNotNullParameter(guildIds, "guildIds");
        m.checkNotNullParameter(guildIdsWithActiveStageEvents, "guildIdsWithActiveStageEvents");
        m.checkNotNullParameter(guildIdsWithActiveScheduledEvents, "guildIdsWithActiveScheduledEvents");
        m.checkNotNullParameter(channels, "channels");
        return new WidgetGuildsListViewModel$Companion$SecondChunk(guildJoinRequests, pendingGuilds, guildIds, guildIdsWithActiveStageEvents, guildIdsWithActiveScheduledEvents, channels, showHubSparkle);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetGuildsListViewModel$Companion$SecondChunk)) {
            return false;
        }
        WidgetGuildsListViewModel$Companion$SecondChunk widgetGuildsListViewModel$Companion$SecondChunk = (WidgetGuildsListViewModel$Companion$SecondChunk) other;
        return m.areEqual(this.guildJoinRequests, widgetGuildsListViewModel$Companion$SecondChunk.guildJoinRequests) && m.areEqual(this.pendingGuilds, widgetGuildsListViewModel$Companion$SecondChunk.pendingGuilds) && m.areEqual(this.guildIds, widgetGuildsListViewModel$Companion$SecondChunk.guildIds) && m.areEqual(this.guildIdsWithActiveStageEvents, widgetGuildsListViewModel$Companion$SecondChunk.guildIdsWithActiveStageEvents) && m.areEqual(this.guildIdsWithActiveScheduledEvents, widgetGuildsListViewModel$Companion$SecondChunk.guildIdsWithActiveScheduledEvents) && m.areEqual(this.channels, widgetGuildsListViewModel$Companion$SecondChunk.channels) && this.showHubSparkle == widgetGuildsListViewModel$Companion$SecondChunk.showHubSparkle;
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

    public final List<Guild> getPendingGuilds() {
        return this.pendingGuilds;
    }

    public final boolean getShowHubSparkle() {
        return this.showHubSparkle;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        Map<Long, GuildJoinRequest> map = this.guildJoinRequests;
        int iHashCode = (map != null ? map.hashCode() : 0) * 31;
        List<Guild> list = this.pendingGuilds;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        Set<Long> set = this.guildIds;
        int iHashCode3 = (iHashCode2 + (set != null ? set.hashCode() : 0)) * 31;
        Set<Long> set2 = this.guildIdsWithActiveStageEvents;
        int iHashCode4 = (iHashCode3 + (set2 != null ? set2.hashCode() : 0)) * 31;
        Set<Long> set3 = this.guildIdsWithActiveScheduledEvents;
        int iHashCode5 = (iHashCode4 + (set3 != null ? set3.hashCode() : 0)) * 31;
        Map<Long, Channel> map2 = this.channels;
        int iHashCode6 = (iHashCode5 + (map2 != null ? map2.hashCode() : 0)) * 31;
        boolean z2 = this.showHubSparkle;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode6 + r1;
    }

    public String toString() {
        StringBuilder sbU = a.U("SecondChunk(guildJoinRequests=");
        sbU.append(this.guildJoinRequests);
        sbU.append(", pendingGuilds=");
        sbU.append(this.pendingGuilds);
        sbU.append(", guildIds=");
        sbU.append(this.guildIds);
        sbU.append(", guildIdsWithActiveStageEvents=");
        sbU.append(this.guildIdsWithActiveStageEvents);
        sbU.append(", guildIdsWithActiveScheduledEvents=");
        sbU.append(this.guildIdsWithActiveScheduledEvents);
        sbU.append(", channels=");
        sbU.append(this.channels);
        sbU.append(", showHubSparkle=");
        return a.O(sbU, this.showHubSparkle, ")");
    }
}
