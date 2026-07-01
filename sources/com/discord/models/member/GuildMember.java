package com.discord.models.member;

import a0.a.a.b;
import androidx.annotation.ColorInt;
import b.d.b.a.a;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.user.User;
import com.discord.utilities.time.ClockFactory;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GuildMember.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class GuildMember {
    public static final GuildMember$Companion Companion = new GuildMember$Companion(null);
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
        return Companion.compareUserNames(user, user2, guildMember, guildMember2);
    }

    private final List<Long> component3() {
        return this.roles;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GuildMember copy$default(GuildMember guildMember, int i, long j, List list, String str, String str2, boolean z2, UtcDateTime utcDateTime, long j2, long j3, String str3, String str4, String str5, UtcDateTime utcDateTime2, int i2, Object obj) {
        return guildMember.copy((i2 & 1) != 0 ? guildMember.color : i, (i2 & 2) != 0 ? guildMember.hoistRoleId : j, (i2 & 4) != 0 ? guildMember.roles : list, (i2 & 8) != 0 ? guildMember.nick : str, (i2 & 16) != 0 ? guildMember.premiumSince : str2, (i2 & 32) != 0 ? guildMember.pending : z2, (i2 & 64) != 0 ? guildMember.joinedAt : utcDateTime, (i2 & 128) != 0 ? guildMember.guildId : j2, (i2 & 256) != 0 ? guildMember.userId : j3, (i2 & 512) != 0 ? guildMember.avatarHash : str3, (i2 & 1024) != 0 ? guildMember.bannerHash : str4, (i2 & 2048) != 0 ? guildMember.bio : str5, (i2 & 4096) != 0 ? guildMember.communicationDisabledUntil : utcDateTime2);
    }

    public static final int getColor(@ColorInt int i, @ColorInt int i2) {
        return Companion.getColor(i, i2);
    }

    public static final int getColor(GuildMember guildMember, @ColorInt int i) {
        return Companion.getColor(guildMember, i);
    }

    public static final String getNickOrUsername(GuildMember guildMember, User user) {
        return Companion.getNickOrUsername(guildMember, user);
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
        return this.color == guildMember.color && this.hoistRoleId == guildMember.hoistRoleId && m.areEqual(this.roles, guildMember.roles) && m.areEqual(this.nick, guildMember.nick) && m.areEqual(this.premiumSince, guildMember.premiumSince) && this.pending == guildMember.pending && m.areEqual(this.joinedAt, guildMember.joinedAt) && this.guildId == guildMember.guildId && this.userId == guildMember.userId && m.areEqual(this.avatarHash, guildMember.avatarHash) && m.areEqual(this.bannerHash, guildMember.bannerHash) && m.areEqual(this.bio, guildMember.bio) && m.areEqual(this.communicationDisabledUntil, guildMember.communicationDisabledUntil);
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
        StringBuilder sbU = a.U("GuildMember(color=");
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
