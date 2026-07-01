package com.discord.models.member;

import androidx.annotation.ColorInt;
import androidx.core.view.ViewCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelRecipientNick;
import com.discord.api.role.GuildRole;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.user.User;
import com.discord.stores.StoreGuilds;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.user.UserUtils;
import d0.z.d.m;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GuildMember.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildMember$Companion {
    private GuildMember$Companion() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GuildMember from$default(GuildMember$Companion guildMember$Companion, com.discord.api.guildmember.GuildMember guildMember, long j, Map map, StoreGuilds storeGuilds, int i, Object obj) {
        return guildMember$Companion.from(guildMember, j, (i & 4) != 0 ? null : map, (i & 8) != 0 ? null : storeGuilds);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ String getNickOrUsername$default(GuildMember$Companion guildMember$Companion, User user, GuildMember guildMember, Channel channel, List list, int i, Object obj) {
        if ((i & 8) != 0) {
            list = null;
        }
        return guildMember$Companion.getNickOrUsername(user, guildMember, channel, list);
    }

    public final int compareUserNames(User user1, User user2, GuildMember member1, GuildMember member2) {
        return UserUtils.INSTANCE.compareUserNames(user1, user2, member1 != null ? member1.getNick() : null, member2 != null ? member2.getNick() : null);
    }

    public final GuildMember from(com.discord.api.guildmember.GuildMember apiGuildMember, long guildId, Map<Long, GuildRole> guildRoles, StoreGuilds storeGuilds) {
        Map<Long, GuildRole> map;
        Map<Long, Map<Long, GuildRole>> roles;
        GuildRole guildRole;
        m.checkNotNullParameter(apiGuildMember, "apiGuildMember");
        List<Long> listL = apiGuildMember.l();
        Iterator<Long> it = listL.iterator();
        GuildRole guildRole2 = null;
        GuildRole guildRole3 = null;
        while (it.hasNext()) {
            long jLongValue = it.next().longValue();
            if (guildRoles != null) {
                map = guildRoles;
            } else {
                map = (storeGuilds == null || (roles = storeGuilds.getRoles()) == null) ? null : roles.get(Long.valueOf(guildId));
            }
            if (map != null && (guildRole = map.get(Long.valueOf(jLongValue))) != null) {
                if (!RoleUtils.isDefaultColor(guildRole) && RoleUtils.rankIsHigher(guildRole, guildRole2)) {
                    guildRole2 = guildRole;
                }
                if (guildRole.getHoist() && RoleUtils.rankIsHigher(guildRole, guildRole3)) {
                    guildRole3 = guildRole;
                }
            }
        }
        return new GuildMember(RoleUtils.getOpaqueColor(guildRole2), guildRole3 != null ? guildRole3.getId() : 0L, listL.isEmpty() ^ true ? listL : null, apiGuildMember.getNick(), apiGuildMember.getPremiumSince(), apiGuildMember.getPending(), apiGuildMember.getJoinedAt(), guildId, apiGuildMember.getUser().getId(), apiGuildMember.getAvatar(), apiGuildMember.getBanner(), apiGuildMember.getBio(), apiGuildMember.getCommunicationDisabledUntil());
    }

    public final int getColor(@ColorInt int color, @ColorInt int defaultColor) {
        return color != -16777216 ? color : defaultColor;
    }

    public final int getColor(GuildMember member, @ColorInt int defaultColor) {
        return getColor(member != null ? member.getColor() : ViewCompat.MEASURED_STATE_MASK, defaultColor);
    }

    public final GuildRole getHighestRoleIconRole(List<Long> roles, Map<Long, GuildRole> guildRoles) {
        GuildRole guildRole;
        m.checkNotNullParameter(roles, "roles");
        Iterator<Long> it = roles.iterator();
        GuildRole guildRole2 = null;
        while (it.hasNext()) {
            long jLongValue = it.next().longValue();
            if (guildRoles != null && (guildRole = guildRoles.get(Long.valueOf(jLongValue))) != null) {
                if (((guildRole.getIcon() == null && guildRole.getUnicodeEmoji() == null) ? false : true) && RoleUtils.rankIsHigher(guildRole, guildRole2)) {
                    guildRole2 = guildRole;
                }
            }
        }
        return guildRole2;
    }

    public final String getNickOrUsername(GuildMember member, User user) {
        m.checkNotNullParameter(user, "user");
        return getNickOrUsername(user, member, null, null);
    }

    public /* synthetic */ GuildMember$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final String getNickOrUsername(User user, GuildMember member, Channel channel, List<ChannelRecipientNick> nicks) {
        ChannelRecipientNick channelRecipientNick;
        String strC;
        Object next;
        m.checkNotNullParameter(user, "user");
        String nick = null;
        if (nicks == null) {
            nicks = channel != null ? channel.q() : null;
        }
        if (nicks != null) {
            Iterator<T> it = nicks.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!(((ChannelRecipientNick) next).b() == user.getId()));
            channelRecipientNick = (ChannelRecipientNick) next;
        } else {
            channelRecipientNick = null;
        }
        if (channelRecipientNick != null && (strC = channelRecipientNick.getNick()) != null) {
            nick = strC;
        } else if (member != null) {
            nick = member.getNick();
        }
        return nick != null ? nick : user.getUsername();
    }
}
