package com.discord.models.member;

import a0.a.a.b;
import androidx.annotation.ColorInt;
import androidx.core.view.ViewCompat;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelRecipientNick;
import com.discord.api.role.GuildRole;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.user.User;
import com.discord.stores.StoreGuilds;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.user.UserUtils;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GuildMember.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class GuildMember {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<Long> emptyRoles = new ArrayList();
    private final String avatarHash;
    private final String bannerHash;
    private final String bio;
    private final int color;
    private final UtcDateTime communicationDisabledUntil;
    private final long guildId;
    private final long hoistRoleId;
    private final UtcDateTime joinedAt;
    private final String nick;
    private final boolean pending;
    private final String premiumSince;
    private final List<Long> roles;
    private final long userId;

    /* JADX INFO: compiled from: GuildMember.kt */
    public static final class Companion {
        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ String getNickOrUsername$default(Companion companion, User user, GuildMember guildMember, Channel channel, List list, int i, Object obj) {
            if ((i & 8) != 0) {
                list = null;
            }
            return companion.getNickOrUsername(user, guildMember, channel, list);
        }

        public final int compareUserNames(User user1, User user2, GuildMember member1, GuildMember member2) {
            return UserUtils.INSTANCE.compareUserNames(user1, user2, member1 != null ? member1.getNick() : null, member2 != null ? member2.getNick() : null);
        }

        public final GuildMember from(com.discord.api.guildmember.GuildMember apiGuildMember, long guildId, Map<Long, GuildRole> guildRoles, StoreGuilds storeGuilds) {
            Map<Long, GuildRole> map;
            Map<Long, Map<Long, GuildRole>> roles;
            GuildRole guildRole;
            Intrinsics3.checkNotNullParameter(apiGuildMember, "apiGuildMember");
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
            Intrinsics3.checkNotNullParameter(roles, "roles");
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
            Intrinsics3.checkNotNullParameter(user, "user");
            return getNickOrUsername(user, member, null, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getNickOrUsername(User user, GuildMember member, Channel channel, List<ChannelRecipientNick> nicks) {
            ChannelRecipientNick channelRecipientNick;
            String nick;
            Object next;
            Intrinsics3.checkNotNullParameter(user, "user");
            String nick2 = null;
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
            if (channelRecipientNick != null && (nick = channelRecipientNick.getNick()) != null) {
                nick2 = nick;
            } else if (member != null) {
                nick2 = member.getNick();
            }
            return nick2 != null ? nick2 : user.getUsername();
        }
    }

    public GuildMember(@ColorInt int i, long j, List<Long> list, String str, String str2, boolean z2, UtcDateTime utcDateTime, long j2, long j3, String str3, String str4, String str5, UtcDateTime utcDateTime2) {
        this.color = i;
        this.hoistRoleId = j;
        this.roles = list;
        this.nick = str;
        this.premiumSince = str2;
        this.pending = z2;
        this.joinedAt = utcDateTime;
        this.guildId = j2;
        this.userId = j3;
        this.avatarHash = str3;
        this.bannerHash = str4;
        this.bio = str5;
        this.communicationDisabledUntil = utcDateTime2;
    }

    public static final int compareUserNames(User user, User user2, GuildMember guildMember, GuildMember guildMember2) {
        return INSTANCE.compareUserNames(user, user2, guildMember, guildMember2);
    }

    private final List<Long> component3() {
        return this.roles;
    }

    public static final int getColor(@ColorInt int i, @ColorInt int i2) {
        return INSTANCE.getColor(i, i2);
    }

    public static final int getColor(GuildMember guildMember, @ColorInt int i) {
        return INSTANCE.getColor(guildMember, i);
    }

    public static final String getNickOrUsername(GuildMember guildMember, User user) {
        return INSTANCE.getNickOrUsername(guildMember, user);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getAvatarHash() {
        return this.avatarHash;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getBannerHash() {
        return this.bannerHash;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getBio() {
        return this.bio;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final UtcDateTime getCommunicationDisabledUntil() {
        return this.communicationDisabledUntil;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getHoistRoleId() {
        return this.hoistRoleId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getNick() {
        return this.nick;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getPremiumSince() {
        return this.premiumSince;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getPending() {
        return this.pending;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final UtcDateTime getJoinedAt() {
        return this.joinedAt;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final long getUserId() {
        return this.userId;
    }

    public final GuildMember copy(@ColorInt int color, long hoistRoleId, List<Long> roles, String nick, String premiumSince, boolean pending, UtcDateTime joinedAt, long guildId, long userId, String avatarHash, String bannerHash, String bio, UtcDateTime communicationDisabledUntil) {
        return new GuildMember(color, hoistRoleId, roles, nick, premiumSince, pending, joinedAt, guildId, userId, avatarHash, bannerHash, bio, communicationDisabledUntil);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildMember)) {
            return false;
        }
        GuildMember guildMember = (GuildMember) other;
        return this.color == guildMember.color && this.hoistRoleId == guildMember.hoistRoleId && Intrinsics3.areEqual(this.roles, guildMember.roles) && Intrinsics3.areEqual(this.nick, guildMember.nick) && Intrinsics3.areEqual(this.premiumSince, guildMember.premiumSince) && this.pending == guildMember.pending && Intrinsics3.areEqual(this.joinedAt, guildMember.joinedAt) && this.guildId == guildMember.guildId && this.userId == guildMember.userId && Intrinsics3.areEqual(this.avatarHash, guildMember.avatarHash) && Intrinsics3.areEqual(this.bannerHash, guildMember.bannerHash) && Intrinsics3.areEqual(this.bio, guildMember.bio) && Intrinsics3.areEqual(this.communicationDisabledUntil, guildMember.communicationDisabledUntil);
    }

    public final String getAvatarHash() {
        return this.avatarHash;
    }

    public final String getBannerHash() {
        return this.bannerHash;
    }

    public final String getBio() {
        return this.bio;
    }

    public final int getColor() {
        return this.color;
    }

    public final UtcDateTime getCommunicationDisabledUntil() {
        return this.communicationDisabledUntil;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final long getHoistRoleId() {
        return this.hoistRoleId;
    }

    public final UtcDateTime getJoinedAt() {
        return this.joinedAt;
    }

    public final String getNick() {
        return this.nick;
    }

    public final boolean getPending() {
        return this.pending;
    }

    public final String getPremiumSince() {
        return this.premiumSince;
    }

    public final List<Long> getRoles() {
        List<Long> list = this.roles;
        return list != null ? list : emptyRoles;
    }

    public final long getUserId() {
        return this.userId;
    }

    public final boolean hasAvatar() {
        String str = this.avatarHash;
        if (str != null) {
            return (str.length() > 0) && this.guildId > 0 && this.userId > 0;
        }
        return false;
    }

    public final boolean hasBanner() {
        String str = this.bannerHash;
        if (str != null) {
            return (str.length() > 0) && this.guildId > 0 && this.userId > 0;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r0v33 */
    /* JADX WARN: Type inference failed for: r0v37 */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    public int hashCode() {
        int iA = (b.a(this.hoistRoleId) + (this.color * 31)) * 31;
        List<Long> list = this.roles;
        int iHashCode = (iA + (list != null ? list.hashCode() : 0)) * 31;
        String str = this.nick;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.premiumSince;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z2 = this.pending;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = (iHashCode3 + r0) * 31;
        UtcDateTime utcDateTime = this.joinedAt;
        int iA2 = (b.a(this.userId) + ((b.a(this.guildId) + ((i + (utcDateTime != null ? utcDateTime.hashCode() : 0)) * 31)) * 31)) * 31;
        String str3 = this.avatarHash;
        int iHashCode4 = (iA2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.bannerHash;
        int iHashCode5 = (iHashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.bio;
        int iHashCode6 = (iHashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
        UtcDateTime utcDateTime2 = this.communicationDisabledUntil;
        return iHashCode6 + (utcDateTime2 != null ? utcDateTime2.hashCode() : 0);
    }

    public final boolean isCommunicationDisabled() {
        UtcDateTime utcDateTime = this.communicationDisabledUntil;
        return utcDateTime != null && utcDateTime.getDateTimeMillis() > ClockFactory.get().currentTimeMillis();
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildMember(color=");
        sbU.append(this.color);
        sbU.append(", hoistRoleId=");
        sbU.append(this.hoistRoleId);
        sbU.append(", roles=");
        sbU.append(this.roles);
        sbU.append(", nick=");
        sbU.append(this.nick);
        sbU.append(", premiumSince=");
        sbU.append(this.premiumSince);
        sbU.append(", pending=");
        sbU.append(this.pending);
        sbU.append(", joinedAt=");
        sbU.append(this.joinedAt);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", userId=");
        sbU.append(this.userId);
        sbU.append(", avatarHash=");
        sbU.append(this.avatarHash);
        sbU.append(", bannerHash=");
        sbU.append(this.bannerHash);
        sbU.append(", bio=");
        sbU.append(this.bio);
        sbU.append(", communicationDisabledUntil=");
        sbU.append(this.communicationDisabledUntil);
        sbU.append(")");
        return sbU.toString();
    }

    public /* synthetic */ GuildMember(int i, long j, List list, String str, String str2, boolean z2, UtcDateTime utcDateTime, long j2, long j3, String str3, String str4, String str5, UtcDateTime utcDateTime2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, j, list, str, str2, z2, utcDateTime, j2, j3, (i2 & 512) != 0 ? null : str3, (i2 & 1024) != 0 ? null : str4, (i2 & 2048) != 0 ? null : str5, (i2 & 4096) != 0 ? null : utcDateTime2);
    }

    public GuildMember() {
        this(0, 0L, null, null, null, false, null, 0L, 0L, null, null, null, null);
    }
}
