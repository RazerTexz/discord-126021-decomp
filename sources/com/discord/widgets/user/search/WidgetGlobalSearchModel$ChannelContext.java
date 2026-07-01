package com.discord.widgets.user.search;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.models.guild.Guild;
import d0.z.d.m;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Set;

/* JADX INFO: compiled from: WidgetGlobalSearchModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetGlobalSearchModel$ChannelContext {
    private final Map<Long, Channel> activeJoinedThreads;
    private final Map<Long, Long> channelPerms;
    private final Map<Long, Channel> channels;
    private final Map<Long, Channel> channelsPrivate;
    private final Map<Long, List<Long>> guildToChannels;
    private final Map<Long, Guild> guilds;
    private final Set<Long> smallGuildIds;
    private final Set<Long> unreadChannelIds;
    private final Set<Long> unreadGuildIds;

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetGlobalSearchModel$ChannelContext(Map<Long, Guild> map, Map<Long, Channel> map2, Map<Long, Channel> map3, Map<Long, Long> map4, Map<Long, Channel> map5, Map<Long, ? extends List<Long>> map6, Set<Long> set, Set<Long> set2) {
        m.checkNotNullParameter(map, "guilds");
        m.checkNotNullParameter(map2, "channels");
        m.checkNotNullParameter(map3, "activeJoinedThreads");
        m.checkNotNullParameter(map4, "channelPerms");
        m.checkNotNullParameter(map5, "channelsPrivate");
        m.checkNotNullParameter(map6, "guildToChannels");
        m.checkNotNullParameter(set, "unreadChannelIds");
        m.checkNotNullParameter(set2, "unreadGuildIds");
        this.guilds = map;
        this.channels = map2;
        this.activeJoinedThreads = map3;
        this.channelPerms = map4;
        this.channelsPrivate = map5;
        this.guildToChannels = map6;
        this.unreadChannelIds = set;
        this.unreadGuildIds = set2;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map$Entry<Long, Guild> map$Entry : map.entrySet()) {
            if (map$Entry.getValue().getMemberCount() <= 200) {
                linkedHashMap.put(map$Entry.getKey(), map$Entry.getValue());
            }
        }
        this.smallGuildIds = linkedHashMap.keySet();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetGlobalSearchModel$ChannelContext copy$default(WidgetGlobalSearchModel$ChannelContext widgetGlobalSearchModel$ChannelContext, Map map, Map map2, Map map3, Map map4, Map map5, Map map6, Set set, Set set2, int i, Object obj) {
        return widgetGlobalSearchModel$ChannelContext.copy((i & 1) != 0 ? widgetGlobalSearchModel$ChannelContext.guilds : map, (i & 2) != 0 ? widgetGlobalSearchModel$ChannelContext.channels : map2, (i & 4) != 0 ? widgetGlobalSearchModel$ChannelContext.activeJoinedThreads : map3, (i & 8) != 0 ? widgetGlobalSearchModel$ChannelContext.channelPerms : map4, (i & 16) != 0 ? widgetGlobalSearchModel$ChannelContext.channelsPrivate : map5, (i & 32) != 0 ? widgetGlobalSearchModel$ChannelContext.guildToChannels : map6, (i & 64) != 0 ? widgetGlobalSearchModel$ChannelContext.unreadChannelIds : set, (i & 128) != 0 ? widgetGlobalSearchModel$ChannelContext.unreadGuildIds : set2);
    }

    public final Map<Long, Guild> component1() {
        return this.guilds;
    }

    public final Map<Long, Channel> component2() {
        return this.channels;
    }

    public final Map<Long, Channel> component3() {
        return this.activeJoinedThreads;
    }

    public final Map<Long, Long> component4() {
        return this.channelPerms;
    }

    public final Map<Long, Channel> component5() {
        return this.channelsPrivate;
    }

    public final Map<Long, List<Long>> component6() {
        return this.guildToChannels;
    }

    public final Set<Long> component7() {
        return this.unreadChannelIds;
    }

    public final Set<Long> component8() {
        return this.unreadGuildIds;
    }

    public final WidgetGlobalSearchModel$ChannelContext copy(Map<Long, Guild> guilds, Map<Long, Channel> channels, Map<Long, Channel> activeJoinedThreads, Map<Long, Long> channelPerms, Map<Long, Channel> channelsPrivate, Map<Long, ? extends List<Long>> guildToChannels, Set<Long> unreadChannelIds, Set<Long> unreadGuildIds) {
        m.checkNotNullParameter(guilds, "guilds");
        m.checkNotNullParameter(channels, "channels");
        m.checkNotNullParameter(activeJoinedThreads, "activeJoinedThreads");
        m.checkNotNullParameter(channelPerms, "channelPerms");
        m.checkNotNullParameter(channelsPrivate, "channelsPrivate");
        m.checkNotNullParameter(guildToChannels, "guildToChannels");
        m.checkNotNullParameter(unreadChannelIds, "unreadChannelIds");
        m.checkNotNullParameter(unreadGuildIds, "unreadGuildIds");
        return new WidgetGlobalSearchModel$ChannelContext(guilds, channels, activeJoinedThreads, channelPerms, channelsPrivate, guildToChannels, unreadChannelIds, unreadGuildIds);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetGlobalSearchModel$ChannelContext)) {
            return false;
        }
        WidgetGlobalSearchModel$ChannelContext widgetGlobalSearchModel$ChannelContext = (WidgetGlobalSearchModel$ChannelContext) other;
        return m.areEqual(this.guilds, widgetGlobalSearchModel$ChannelContext.guilds) && m.areEqual(this.channels, widgetGlobalSearchModel$ChannelContext.channels) && m.areEqual(this.activeJoinedThreads, widgetGlobalSearchModel$ChannelContext.activeJoinedThreads) && m.areEqual(this.channelPerms, widgetGlobalSearchModel$ChannelContext.channelPerms) && m.areEqual(this.channelsPrivate, widgetGlobalSearchModel$ChannelContext.channelsPrivate) && m.areEqual(this.guildToChannels, widgetGlobalSearchModel$ChannelContext.guildToChannels) && m.areEqual(this.unreadChannelIds, widgetGlobalSearchModel$ChannelContext.unreadChannelIds) && m.areEqual(this.unreadGuildIds, widgetGlobalSearchModel$ChannelContext.unreadGuildIds);
    }

    public final Map<Long, Channel> getActiveJoinedThreads() {
        return this.activeJoinedThreads;
    }

    public final Map<Long, Long> getChannelPerms() {
        return this.channelPerms;
    }

    public final Map<Long, Channel> getChannels() {
        return this.channels;
    }

    public final Map<Long, Channel> getChannelsPrivate() {
        return this.channelsPrivate;
    }

    public final Map<Long, List<Long>> getGuildToChannels() {
        return this.guildToChannels;
    }

    public final Map<Long, Guild> getGuilds() {
        return this.guilds;
    }

    public final Set<Long> getSmallGuildIds() {
        return this.smallGuildIds;
    }

    public final Set<Long> getUnreadChannelIds() {
        return this.unreadChannelIds;
    }

    public final Set<Long> getUnreadGuildIds() {
        return this.unreadGuildIds;
    }

    public int hashCode() {
        Map<Long, Guild> map = this.guilds;
        int iHashCode = (map != null ? map.hashCode() : 0) * 31;
        Map<Long, Channel> map2 = this.channels;
        int iHashCode2 = (iHashCode + (map2 != null ? map2.hashCode() : 0)) * 31;
        Map<Long, Channel> map3 = this.activeJoinedThreads;
        int iHashCode3 = (iHashCode2 + (map3 != null ? map3.hashCode() : 0)) * 31;
        Map<Long, Long> map4 = this.channelPerms;
        int iHashCode4 = (iHashCode3 + (map4 != null ? map4.hashCode() : 0)) * 31;
        Map<Long, Channel> map5 = this.channelsPrivate;
        int iHashCode5 = (iHashCode4 + (map5 != null ? map5.hashCode() : 0)) * 31;
        Map<Long, List<Long>> map6 = this.guildToChannels;
        int iHashCode6 = (iHashCode5 + (map6 != null ? map6.hashCode() : 0)) * 31;
        Set<Long> set = this.unreadChannelIds;
        int iHashCode7 = (iHashCode6 + (set != null ? set.hashCode() : 0)) * 31;
        Set<Long> set2 = this.unreadGuildIds;
        return iHashCode7 + (set2 != null ? set2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ChannelContext(guilds=");
        sbU.append(this.guilds);
        sbU.append(", channels=");
        sbU.append(this.channels);
        sbU.append(", activeJoinedThreads=");
        sbU.append(this.activeJoinedThreads);
        sbU.append(", channelPerms=");
        sbU.append(this.channelPerms);
        sbU.append(", channelsPrivate=");
        sbU.append(this.channelsPrivate);
        sbU.append(", guildToChannels=");
        sbU.append(this.guildToChannels);
        sbU.append(", unreadChannelIds=");
        sbU.append(this.unreadChannelIds);
        sbU.append(", unreadGuildIds=");
        return a.N(sbU, this.unreadGuildIds, ")");
    }
}
