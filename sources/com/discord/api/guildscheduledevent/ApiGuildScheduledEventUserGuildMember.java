package com.discord.api.guildscheduledevent;

import com.discord.api.guildmember.GuildMember;
import com.discord.api.user.User;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.domain.ModelAuditLogEntry;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ApiGuildScheduledEventUser.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ApiGuildScheduledEventUserGuildMember {
    private final String avatar;
    private final UtcDateTime joinedAt;
    private final String nick;
    private final boolean pending;
    private final String premiumSince;
    private final List<Long> roles;

    /* JADX INFO: renamed from: a */
    public final GuildMember m7970a(User user, long guildId) {
        C12238m.checkNotNullParameter(user, "user");
        return new GuildMember(guildId, user, this.roles, this.nick, this.premiumSince, this.joinedAt, this.pending, null, Long.valueOf(user.getId()), this.avatar, null, null, null, 4096);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApiGuildScheduledEventUserGuildMember)) {
            return false;
        }
        ApiGuildScheduledEventUserGuildMember apiGuildScheduledEventUserGuildMember = (ApiGuildScheduledEventUserGuildMember) other;
        return C12238m.areEqual(this.roles, apiGuildScheduledEventUserGuildMember.roles) && C12238m.areEqual(this.nick, apiGuildScheduledEventUserGuildMember.nick) && C12238m.areEqual(this.premiumSince, apiGuildScheduledEventUserGuildMember.premiumSince) && C12238m.areEqual(this.joinedAt, apiGuildScheduledEventUserGuildMember.joinedAt) && this.pending == apiGuildScheduledEventUserGuildMember.pending && C12238m.areEqual(this.avatar, apiGuildScheduledEventUserGuildMember.avatar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v16 */
    public int hashCode() {
        List<Long> list = this.roles;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        String str = this.nick;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.premiumSince;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        UtcDateTime utcDateTime = this.joinedAt;
        int iHashCode4 = (iHashCode3 + (utcDateTime != null ? utcDateTime.hashCode() : 0)) * 31;
        boolean z2 = this.pending;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode4 + r2) * 31;
        String str3 = this.avatar;
        return i + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("ApiGuildScheduledEventUserGuildMember(roles=");
        sbM833U.append(this.roles);
        sbM833U.append(", nick=");
        sbM833U.append(this.nick);
        sbM833U.append(", premiumSince=");
        sbM833U.append(this.premiumSince);
        sbM833U.append(", joinedAt=");
        sbM833U.append(this.joinedAt);
        sbM833U.append(", pending=");
        sbM833U.append(this.pending);
        sbM833U.append(", avatar=");
        return C1643a.m822J(sbM833U, this.avatar, ")");
    }
}
