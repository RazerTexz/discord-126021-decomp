package com.discord.utilities.search.validation;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.guild.UserGuildMember;
import com.discord.models.member.GuildMember;
import com.discord.models.user.CoreUser;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import d0.z.d.m;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchData.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SearchData$Builder {
    public static final /* synthetic */ String access$getUsernameWithDiscrim(SearchData$Builder searchData$Builder, User user) {
        return searchData$Builder.getUsernameWithDiscrim(user);
    }

    private final String getUsernameWithDiscrim(User user) {
        return user.getUsername() + user.getDiscriminator();
    }

    public final SearchData buildForChannel(Channel channel, MeUser meUser, Map<Long, GuildMember> guildMembers) {
        List<com.discord.api.user.User> listZ;
        m.checkNotNullParameter(meUser, "meUser");
        m.checkNotNullParameter(guildMembers, "guildMembers");
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        SearchData$Builder$buildForChannel$1 searchData$Builder$buildForChannel$1 = new SearchData$Builder$buildForChannel$1(this, map, guildMembers, map2);
        if (channel != null && (listZ = channel.z()) != null) {
            Iterator<T> it = listZ.iterator();
            while (it.hasNext()) {
                searchData$Builder$buildForChannel$1.invoke2((User) new CoreUser((com.discord.api.user.User) it.next()));
            }
        }
        searchData$Builder$buildForChannel$1.invoke2((User) meUser);
        return new SearchData(map2, null, map, null, null, 26, null);
    }

    public final SearchData buildForGuild(Map<Long, GuildMember> guildMembers, Map<Long, ? extends User> allUsers, Map<Long, Channel> guildSearchableChannels, Map<Long, Long> guildChannelPermissions) {
        m.checkNotNullParameter(guildMembers, "guildMembers");
        m.checkNotNullParameter(allUsers, "allUsers");
        m.checkNotNullParameter(guildSearchableChannels, "guildSearchableChannels");
        m.checkNotNullParameter(guildChannelPermissions, "guildChannelPermissions");
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
