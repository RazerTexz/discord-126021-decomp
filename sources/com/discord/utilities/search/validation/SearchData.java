package com.discord.utilities.search.validation;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.guild.UserGuildMember;
import com.discord.models.member.GuildMember;
import com.discord.models.user.CoreUser;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
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

    /* JADX INFO: compiled from: SearchData.kt */
    public static final class Builder {
        private final String getUsernameWithDiscrim(User user) {
            return user.getUsername() + user.getDiscriminator();
        }

        public final SearchData buildForChannel(Channel channel, MeUser meUser, Map<Long, GuildMember> guildMembers) {
            List<com.discord.api.user.User> listZ;
            Intrinsics3.checkNotNullParameter(meUser, "meUser");
            Intrinsics3.checkNotNullParameter(guildMembers, "guildMembers");
            HashMap map = new HashMap();
            HashMap map2 = new HashMap();
            SearchData2 searchData2 = new SearchData2(this, map, guildMembers, map2);
            if (channel != null && (listZ = channel.z()) != null) {
                Iterator<T> it = listZ.iterator();
                while (it.hasNext()) {
                    searchData2.invoke2((User) new CoreUser((com.discord.api.user.User) it.next()));
                }
            }
            searchData2.invoke2((User) meUser);
            return new SearchData(map2, null, map, null, null, 26, null);
        }

        public final SearchData buildForGuild(Map<Long, GuildMember> guildMembers, Map<Long, ? extends User> allUsers, Map<Long, Channel> guildSearchableChannels, Map<Long, Long> guildChannelPermissions) {
            Intrinsics3.checkNotNullParameter(guildMembers, "guildMembers");
            Intrinsics3.checkNotNullParameter(allUsers, "allUsers");
            Intrinsics3.checkNotNullParameter(guildSearchableChannels, "guildSearchableChannels");
            Intrinsics3.checkNotNullParameter(guildChannelPermissions, "guildChannelPermissions");
            HashMap map = new HashMap();
            for (Channel channel : guildSearchableChannels.values()) {
                map.put(ChannelUtils.c(channel), Long.valueOf(channel.getId()));
            }
            HashMap map2 = new HashMap();
            HashMap map3 = new HashMap();
            Iterator<Long> it = allUsers.keySet().iterator();
            while (it.hasNext()) {
                long jLongValue = it.next().longValue();
                GuildMember guildMember = guildMembers.get(Long.valueOf(jLongValue));
                User user = allUsers.get(Long.valueOf(jLongValue));
                if (guildMember != null && user != null) {
                    map2.put(Long.valueOf(jLongValue), new UserGuildMember(user, guildMember));
                    map3.put(getUsernameWithDiscrim(user), Long.valueOf(jLongValue));
                }
            }
            return new SearchData(map3, map, map2, guildSearchableChannels, guildChannelPermissions);
        }
    }

    public SearchData() {
        this(null, null, null, null, null, 31, null);
    }

    public SearchData(Map<String, Long> map, Map<String, Long> map2, Map<Long, UserGuildMember> map3, Map<Long, Channel> map4, Map<Long, Long> map5) {
        Intrinsics3.checkNotNullParameter(map, "usernameAndDiscriminatorIndex");
        Intrinsics3.checkNotNullParameter(map2, "channelNameIndex");
        Intrinsics3.checkNotNullParameter(map3, "users");
        Intrinsics3.checkNotNullParameter(map4, "channels");
        Intrinsics3.checkNotNullParameter(map5, "channelPermissions");
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
        Intrinsics3.checkNotNullParameter(usernameAndDiscriminatorIndex, "usernameAndDiscriminatorIndex");
        Intrinsics3.checkNotNullParameter(channelNameIndex, "channelNameIndex");
        Intrinsics3.checkNotNullParameter(users, "users");
        Intrinsics3.checkNotNullParameter(channels, "channels");
        Intrinsics3.checkNotNullParameter(channelPermissions, "channelPermissions");
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
        return Intrinsics3.areEqual(this.usernameAndDiscriminatorIndex, searchData.usernameAndDiscriminatorIndex) && Intrinsics3.areEqual(this.channelNameIndex, searchData.channelNameIndex) && Intrinsics3.areEqual(this.users, searchData.users) && Intrinsics3.areEqual(this.channels, searchData.channels) && Intrinsics3.areEqual(this.channelPermissions, searchData.channelPermissions);
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
        Intrinsics3.checkNotNullParameter(username, "username");
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
        StringBuilder sbU = outline.U("SearchData(usernameAndDiscriminatorIndex=");
        sbU.append(this.usernameAndDiscriminatorIndex);
        sbU.append(", channelNameIndex=");
        sbU.append(this.channelNameIndex);
        sbU.append(", users=");
        sbU.append(this.users);
        sbU.append(", channels=");
        sbU.append(this.channels);
        sbU.append(", channelPermissions=");
        return outline.M(sbU, this.channelPermissions, ")");
    }

    public /* synthetic */ SearchData(Map map, Map map2, Map map3, Map map4, Map map5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Maps6.emptyMap() : map, (i & 2) != 0 ? Maps6.emptyMap() : map2, (i & 4) != 0 ? Maps6.emptyMap() : map3, (i & 8) != 0 ? Maps6.emptyMap() : map4, (i & 16) != 0 ? Maps6.emptyMap() : map5);
    }
}
