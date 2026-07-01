package com.discord.utilities.search.validation;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.models.guild.UserGuildMember;
import d0.t.h0;
import d0.z.d.m;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: SearchData.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class SearchData {
    private final Map<String, Long> channelNameIndex;
    private final Map<Long, Long> channelPermissions;
    private final Map<Long, Channel> channels;
    private final Map<String, Long> usernameAndDiscriminatorIndex;
    private final Map<Long, UserGuildMember> users;

    public SearchData() {
        this(null, null, null, null, null, 31, null);
    }

    public SearchData(Map<String, Long> map, Map<String, Long> map2, Map<Long, UserGuildMember> map3, Map<Long, Channel> map4, Map<Long, Long> map5) {
        m.checkNotNullParameter(map, "usernameAndDiscriminatorIndex");
        m.checkNotNullParameter(map2, "channelNameIndex");
        m.checkNotNullParameter(map3, "users");
        m.checkNotNullParameter(map4, "channels");
        m.checkNotNullParameter(map5, "channelPermissions");
        this.usernameAndDiscriminatorIndex = map;
        this.channelNameIndex = map2;
        this.users = map3;
        this.channels = map4;
        this.channelPermissions = map5;
    }

    private final Map<String, Long> component1() {
        return this.usernameAndDiscriminatorIndex;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SearchData copy$default(SearchData searchData, Map map, Map map2, Map map3, Map map4, Map map5, int i, Object obj) {
        if ((i & 1) != 0) {
            map = searchData.usernameAndDiscriminatorIndex;
        }
        if ((i & 2) != 0) {
            map2 = searchData.channelNameIndex;
        }
        Map map6 = map2;
        if ((i & 4) != 0) {
            map3 = searchData.users;
        }
        Map map7 = map3;
        if ((i & 8) != 0) {
            map4 = searchData.channels;
        }
        Map map8 = map4;
        if ((i & 16) != 0) {
            map5 = searchData.channelPermissions;
        }
        return searchData.copy(map, map6, map7, map8, map5);
    }

    public final Map<String, Long> component2() {
        return this.channelNameIndex;
    }

    public final Map<Long, UserGuildMember> component3() {
        return this.users;
    }

    public final Map<Long, Channel> component4() {
        return this.channels;
    }

    public final Map<Long, Long> component5() {
        return this.channelPermissions;
    }

    public final SearchData copy(Map<String, Long> usernameAndDiscriminatorIndex, Map<String, Long> channelNameIndex, Map<Long, UserGuildMember> users, Map<Long, Channel> channels, Map<Long, Long> channelPermissions) {
        m.checkNotNullParameter(usernameAndDiscriminatorIndex, "usernameAndDiscriminatorIndex");
        m.checkNotNullParameter(channelNameIndex, "channelNameIndex");
        m.checkNotNullParameter(users, "users");
        m.checkNotNullParameter(channels, "channels");
        m.checkNotNullParameter(channelPermissions, "channelPermissions");
        return new SearchData(usernameAndDiscriminatorIndex, channelNameIndex, users, channels, channelPermissions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchData)) {
            return false;
        }
        SearchData searchData = (SearchData) other;
        return m.areEqual(this.usernameAndDiscriminatorIndex, searchData.usernameAndDiscriminatorIndex) && m.areEqual(this.channelNameIndex, searchData.channelNameIndex) && m.areEqual(this.users, searchData.users) && m.areEqual(this.channels, searchData.channels) && m.areEqual(this.channelPermissions, searchData.channelPermissions);
    }

    public final Map<String, Long> getChannelNameIndex() {
        return this.channelNameIndex;
    }

    public final Map<Long, Long> getChannelPermissions() {
        return this.channelPermissions;
    }

    public final Map<Long, Channel> getChannels() {
        return this.channels;
    }

    public final Long getUserId(String username, int discriminator) {
        m.checkNotNullParameter(username, "username");
        return this.usernameAndDiscriminatorIndex.get(username + discriminator);
    }

    public final Map<Long, UserGuildMember> getUsers() {
        return this.users;
    }

    public int hashCode() {
        Map<String, Long> map = this.usernameAndDiscriminatorIndex;
        int iHashCode = (map != null ? map.hashCode() : 0) * 31;
        Map<String, Long> map2 = this.channelNameIndex;
        int iHashCode2 = (iHashCode + (map2 != null ? map2.hashCode() : 0)) * 31;
        Map<Long, UserGuildMember> map3 = this.users;
        int iHashCode3 = (iHashCode2 + (map3 != null ? map3.hashCode() : 0)) * 31;
        Map<Long, Channel> map4 = this.channels;
        int iHashCode4 = (iHashCode3 + (map4 != null ? map4.hashCode() : 0)) * 31;
        Map<Long, Long> map5 = this.channelPermissions;
        return iHashCode4 + (map5 != null ? map5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("SearchData(usernameAndDiscriminatorIndex=");
        sbU.append(this.usernameAndDiscriminatorIndex);
        sbU.append(", channelNameIndex=");
        sbU.append(this.channelNameIndex);
        sbU.append(", users=");
        sbU.append(this.users);
        sbU.append(", channels=");
        sbU.append(this.channels);
        sbU.append(", channelPermissions=");
        return a.M(sbU, this.channelPermissions, ")");
    }

    public /* synthetic */ SearchData(Map map, Map map2, Map map3, Map map4, Map map5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? h0.emptyMap() : map, (i & 2) != 0 ? h0.emptyMap() : map2, (i & 4) != 0 ? h0.emptyMap() : map3, (i & 8) != 0 ? h0.emptyMap() : map4, (i & 16) != 0 ? h0.emptyMap() : map5);
    }
}
