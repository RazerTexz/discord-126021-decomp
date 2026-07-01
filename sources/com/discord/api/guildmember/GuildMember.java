package com.discord.api.guildmember;

import b.d.b.a.outline;
import com.discord.api.presence.Presence;
import com.discord.api.user.User;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: GuildMember.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class GuildMember {
    private final String avatar;
    private final String banner;
    private final String bio;
    private final UtcDateTime communicationDisabledUntil;
    private final long guildId;
    private final UtcDateTime joinedAt;
    private final String nick;
    private final boolean pending;
    private final String premiumSince;
    private final Presence presence;
    private final List<Long> roles;
    private final User user;
    private final Long userId;

    public GuildMember(long j, User user, List<Long> list, String str, String str2, UtcDateTime utcDateTime, boolean z2, Presence presence, Long l, String str3, String str4, String str5, UtcDateTime utcDateTime2) {
        Intrinsics3.checkNotNullParameter(user, "user");
        Intrinsics3.checkNotNullParameter(list, "roles");
        this.guildId = j;
        this.user = user;
        this.roles = list;
        this.nick = str;
        this.premiumSince = str2;
        this.joinedAt = utcDateTime;
        this.pending = z2;
        this.presence = presence;
        this.userId = l;
        this.avatar = str3;
        this.bio = str4;
        this.banner = str5;
        this.communicationDisabledUntil = utcDateTime2;
    }

    public static GuildMember a(GuildMember guildMember, long j, User user, List list, String str, String str2, UtcDateTime utcDateTime, boolean z2, Presence presence, Long l, String str3, String str4, String str5, UtcDateTime utcDateTime2, int i) {
        long j2 = (i & 1) != 0 ? guildMember.guildId : j;
        User user2 = (i & 2) != 0 ? guildMember.user : user;
        List<Long> list2 = (i & 4) != 0 ? guildMember.roles : null;
        String str6 = (i & 8) != 0 ? guildMember.nick : null;
        String str7 = (i & 16) != 0 ? guildMember.premiumSince : null;
        UtcDateTime utcDateTime3 = (i & 32) != 0 ? guildMember.joinedAt : null;
        boolean z3 = (i & 64) != 0 ? guildMember.pending : z2;
        Presence presence2 = (i & 128) != 0 ? guildMember.presence : null;
        Long l2 = (i & 256) != 0 ? guildMember.userId : null;
        String str8 = (i & 512) != 0 ? guildMember.avatar : null;
        String str9 = (i & 1024) != 0 ? guildMember.bio : str4;
        String str10 = (i & 2048) != 0 ? guildMember.banner : str5;
        UtcDateTime utcDateTime4 = (i & 4096) != 0 ? guildMember.communicationDisabledUntil : null;
        Objects.requireNonNull(guildMember);
        Intrinsics3.checkNotNullParameter(user2, "user");
        Intrinsics3.checkNotNullParameter(list2, "roles");
        return new GuildMember(j2, user2, list2, str6, str7, utcDateTime3, z3, presence2, l2, str8, str9, str10, utcDateTime4);
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getBanner() {
        return this.banner;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final String getBio() {
        return this.bio;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final UtcDateTime getCommunicationDisabledUntil() {
        return this.communicationDisabledUntil;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildMember)) {
            return false;
        }
        GuildMember guildMember = (GuildMember) other;
        return this.guildId == guildMember.guildId && Intrinsics3.areEqual(this.user, guildMember.user) && Intrinsics3.areEqual(this.roles, guildMember.roles) && Intrinsics3.areEqual(this.nick, guildMember.nick) && Intrinsics3.areEqual(this.premiumSince, guildMember.premiumSince) && Intrinsics3.areEqual(this.joinedAt, guildMember.joinedAt) && this.pending == guildMember.pending && Intrinsics3.areEqual(this.presence, guildMember.presence) && Intrinsics3.areEqual(this.userId, guildMember.userId) && Intrinsics3.areEqual(this.avatar, guildMember.avatar) && Intrinsics3.areEqual(this.bio, guildMember.bio) && Intrinsics3.areEqual(this.banner, guildMember.banner) && Intrinsics3.areEqual(this.communicationDisabledUntil, guildMember.communicationDisabledUntil);
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final UtcDateTime getJoinedAt() {
        return this.joinedAt;
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    public final String getNick() {
        return this.nick;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v18, types: [int] */
    /* JADX WARN: Type inference failed for: r0v40 */
    /* JADX WARN: Type inference failed for: r0v46 */
    /* JADX WARN: Type inference failed for: r1v12, types: [int] */
    public int hashCode() {
        long j = this.guildId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        User user = this.user;
        int iHashCode = (i + (user != null ? user.hashCode() : 0)) * 31;
        List<Long> list = this.roles;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        String str = this.nick;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.premiumSince;
        int iHashCode4 = (iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        UtcDateTime utcDateTime = this.joinedAt;
        int iHashCode5 = (iHashCode4 + (utcDateTime != null ? utcDateTime.hashCode() : 0)) * 31;
        boolean z2 = this.pending;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i2 = (iHashCode5 + r0) * 31;
        Presence presence = this.presence;
        int iHashCode6 = (i2 + (presence != null ? presence.hashCode() : 0)) * 31;
        Long l = this.userId;
        int iHashCode7 = (iHashCode6 + (l != null ? l.hashCode() : 0)) * 31;
        String str3 = this.avatar;
        int iHashCode8 = (iHashCode7 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.bio;
        int iHashCode9 = (iHashCode8 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.banner;
        int iHashCode10 = (iHashCode9 + (str5 != null ? str5.hashCode() : 0)) * 31;
        UtcDateTime utcDateTime2 = this.communicationDisabledUntil;
        return iHashCode10 + (utcDateTime2 != null ? utcDateTime2.hashCode() : 0);
    }

    /* JADX INFO: renamed from: i, reason: from getter */
    public final boolean getPending() {
        return this.pending;
    }

    /* JADX INFO: renamed from: j, reason: from getter */
    public final String getPremiumSince() {
        return this.premiumSince;
    }

    /* JADX INFO: renamed from: k, reason: from getter */
    public final Presence getPresence() {
        return this.presence;
    }

    public final List<Long> l() {
        return this.roles;
    }

    /* JADX INFO: renamed from: m, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    /* JADX INFO: renamed from: n, reason: from getter */
    public final Long getUserId() {
        return this.userId;
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildMember(guildId=");
        sbU.append(this.guildId);
        sbU.append(", user=");
        sbU.append(this.user);
        sbU.append(", roles=");
        sbU.append(this.roles);
        sbU.append(", nick=");
        sbU.append(this.nick);
        sbU.append(", premiumSince=");
        sbU.append(this.premiumSince);
        sbU.append(", joinedAt=");
        sbU.append(this.joinedAt);
        sbU.append(", pending=");
        sbU.append(this.pending);
        sbU.append(", presence=");
        sbU.append(this.presence);
        sbU.append(", userId=");
        sbU.append(this.userId);
        sbU.append(", avatar=");
        sbU.append(this.avatar);
        sbU.append(", bio=");
        sbU.append(this.bio);
        sbU.append(", banner=");
        sbU.append(this.banner);
        sbU.append(", communicationDisabledUntil=");
        sbU.append(this.communicationDisabledUntil);
        sbU.append(")");
        return sbU.toString();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GuildMember(long j, User user, List list, String str, String str2, UtcDateTime utcDateTime, boolean z2, Presence presence, Long l, String str3, String str4, String str5, UtcDateTime utcDateTime2, int i) {
        this(j, user, list, str, str2, utcDateTime, z2, null, l, str3, null, null, (i & 4096) != 0 ? null : utcDateTime2);
        int i2 = i & 1024;
        int i3 = i & 2048;
    }
}
