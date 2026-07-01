package com.discord.widgets.guildscheduledevent;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.models.guild.UserGuildMember;
import d0.z.d.m;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: GuildScheduledEventListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildScheduledEventListViewModel$StoreState {
    private final boolean canCreateEvents;
    private final Map<Long, Long> channelPermissions;
    private final Map<Long, UserGuildMember> creators;
    private final Map<Long, Channel> guildChannels;
    private final List<GuildScheduledEvent> guildScheduledEvents;
    private final Long selectedVoiceChannelId;
    private final Set<Long> userGuildScheduledEventIds;

    public GuildScheduledEventListViewModel$StoreState(List<GuildScheduledEvent> list, Set<Long> set, Map<Long, Channel> map, Map<Long, UserGuildMember> map2, boolean z2, Long l, Map<Long, Long> map3) {
        m.checkNotNullParameter(list, "guildScheduledEvents");
        m.checkNotNullParameter(set, "userGuildScheduledEventIds");
        m.checkNotNullParameter(map, "guildChannels");
        m.checkNotNullParameter(map2, "creators");
        m.checkNotNullParameter(map3, "channelPermissions");
        this.guildScheduledEvents = list;
        this.userGuildScheduledEventIds = set;
        this.guildChannels = map;
        this.creators = map2;
        this.canCreateEvents = z2;
        this.selectedVoiceChannelId = l;
        this.channelPermissions = map3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GuildScheduledEventListViewModel$StoreState copy$default(GuildScheduledEventListViewModel$StoreState guildScheduledEventListViewModel$StoreState, List list, Set set, Map map, Map map2, boolean z2, Long l, Map map3, int i, Object obj) {
        if ((i & 1) != 0) {
            list = guildScheduledEventListViewModel$StoreState.guildScheduledEvents;
        }
        if ((i & 2) != 0) {
            set = guildScheduledEventListViewModel$StoreState.userGuildScheduledEventIds;
        }
        Set set2 = set;
        if ((i & 4) != 0) {
            map = guildScheduledEventListViewModel$StoreState.guildChannels;
        }
        Map map4 = map;
        if ((i & 8) != 0) {
            map2 = guildScheduledEventListViewModel$StoreState.creators;
        }
        Map map5 = map2;
        if ((i & 16) != 0) {
            z2 = guildScheduledEventListViewModel$StoreState.canCreateEvents;
        }
        boolean z3 = z2;
        if ((i & 32) != 0) {
            l = guildScheduledEventListViewModel$StoreState.selectedVoiceChannelId;
        }
        Long l2 = l;
        if ((i & 64) != 0) {
            map3 = guildScheduledEventListViewModel$StoreState.channelPermissions;
        }
        return guildScheduledEventListViewModel$StoreState.copy(list, set2, map4, map5, z3, l2, map3);
    }

    public final List<GuildScheduledEvent> component1() {
        return this.guildScheduledEvents;
    }

    public final Set<Long> component2() {
        return this.userGuildScheduledEventIds;
    }

    public final Map<Long, Channel> component3() {
        return this.guildChannels;
    }

    public final Map<Long, UserGuildMember> component4() {
        return this.creators;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getCanCreateEvents() {
        return this.canCreateEvents;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Long getSelectedVoiceChannelId() {
        return this.selectedVoiceChannelId;
    }

    public final Map<Long, Long> component7() {
        return this.channelPermissions;
    }

    public final GuildScheduledEventListViewModel$StoreState copy(List<GuildScheduledEvent> guildScheduledEvents, Set<Long> userGuildScheduledEventIds, Map<Long, Channel> guildChannels, Map<Long, UserGuildMember> creators, boolean canCreateEvents, Long selectedVoiceChannelId, Map<Long, Long> channelPermissions) {
        m.checkNotNullParameter(guildScheduledEvents, "guildScheduledEvents");
        m.checkNotNullParameter(userGuildScheduledEventIds, "userGuildScheduledEventIds");
        m.checkNotNullParameter(guildChannels, "guildChannels");
        m.checkNotNullParameter(creators, "creators");
        m.checkNotNullParameter(channelPermissions, "channelPermissions");
        return new GuildScheduledEventListViewModel$StoreState(guildScheduledEvents, userGuildScheduledEventIds, guildChannels, creators, canCreateEvents, selectedVoiceChannelId, channelPermissions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildScheduledEventListViewModel$StoreState)) {
            return false;
        }
        GuildScheduledEventListViewModel$StoreState guildScheduledEventListViewModel$StoreState = (GuildScheduledEventListViewModel$StoreState) other;
        return m.areEqual(this.guildScheduledEvents, guildScheduledEventListViewModel$StoreState.guildScheduledEvents) && m.areEqual(this.userGuildScheduledEventIds, guildScheduledEventListViewModel$StoreState.userGuildScheduledEventIds) && m.areEqual(this.guildChannels, guildScheduledEventListViewModel$StoreState.guildChannels) && m.areEqual(this.creators, guildScheduledEventListViewModel$StoreState.creators) && this.canCreateEvents == guildScheduledEventListViewModel$StoreState.canCreateEvents && m.areEqual(this.selectedVoiceChannelId, guildScheduledEventListViewModel$StoreState.selectedVoiceChannelId) && m.areEqual(this.channelPermissions, guildScheduledEventListViewModel$StoreState.channelPermissions);
    }

    public final boolean getCanCreateEvents() {
        return this.canCreateEvents;
    }

    public final Map<Long, Long> getChannelPermissions() {
        return this.channelPermissions;
    }

    public final Map<Long, UserGuildMember> getCreators() {
        return this.creators;
    }

    public final Map<Long, Channel> getGuildChannels() {
        return this.guildChannels;
    }

    public final List<GuildScheduledEvent> getGuildScheduledEvents() {
        return this.guildScheduledEvents;
    }

    public final Long getSelectedVoiceChannelId() {
        return this.selectedVoiceChannelId;
    }

    public final Set<Long> getUserGuildScheduledEventIds() {
        return this.userGuildScheduledEventIds;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v20 */
    public int hashCode() {
        List<GuildScheduledEvent> list = this.guildScheduledEvents;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        Set<Long> set = this.userGuildScheduledEventIds;
        int iHashCode2 = (iHashCode + (set != null ? set.hashCode() : 0)) * 31;
        Map<Long, Channel> map = this.guildChannels;
        int iHashCode3 = (iHashCode2 + (map != null ? map.hashCode() : 0)) * 31;
        Map<Long, UserGuildMember> map2 = this.creators;
        int iHashCode4 = (iHashCode3 + (map2 != null ? map2.hashCode() : 0)) * 31;
        boolean z2 = this.canCreateEvents;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode4 + r2) * 31;
        Long l = this.selectedVoiceChannelId;
        int iHashCode5 = (i + (l != null ? l.hashCode() : 0)) * 31;
        Map<Long, Long> map3 = this.channelPermissions;
        return iHashCode5 + (map3 != null ? map3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("StoreState(guildScheduledEvents=");
        sbU.append(this.guildScheduledEvents);
        sbU.append(", userGuildScheduledEventIds=");
        sbU.append(this.userGuildScheduledEventIds);
        sbU.append(", guildChannels=");
        sbU.append(this.guildChannels);
        sbU.append(", creators=");
        sbU.append(this.creators);
        sbU.append(", canCreateEvents=");
        sbU.append(this.canCreateEvents);
        sbU.append(", selectedVoiceChannelId=");
        sbU.append(this.selectedVoiceChannelId);
        sbU.append(", channelPermissions=");
        return a.M(sbU, this.channelPermissions, ")");
    }
}
