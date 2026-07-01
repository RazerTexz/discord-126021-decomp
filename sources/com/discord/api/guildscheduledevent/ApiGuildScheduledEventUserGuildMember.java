package com.discord.api.guildscheduledevent;

import b.d.b.a.a;
import com.discord.api.guildmember.GuildMember;
import com.discord.api.user.User;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: ApiGuildScheduledEventUser.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ApiGuildScheduledEventUserGuildMember {
    private final String avatar;
    private final UtcDateTime joinedAt;
    private final String nick;
    private final boolean pending;
    private final String premiumSince;
    private final List<Long> roles;

    public final GuildMember a(User user, long guildId) {
        m.checkNotNullParameter(user, "user");
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
        return m.areEqual(this.roles, apiGuildScheduledEventUserGuildMember.roles) && m.areEqual(this.nick, apiGuildScheduledEventUserGuildMember.nick) && m.areEqual(this.premiumSince, apiGuildScheduledEventUserGuildMember.premiumSince) && m.areEqual(this.joinedAt, apiGuildScheduledEventUserGuildMember.joinedAt) && this.pending == apiGuildScheduledEventUserGuildMember.pending && m.areEqual(this.avatar, apiGuildScheduledEventUserGuildMember.avatar);
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
        StringBuilder sbU = a.U("ApiGuildScheduledEventUserGuildMember(roles=");
        sbU.append(this.roles);
        sbU.append(", nick=");
        sbU.append(this.nick);
        sbU.append(", premiumSince=");
        sbU.append(this.premiumSince);
        sbU.append(", joinedAt=");
        sbU.append(this.joinedAt);
        sbU.append(", pending=");
        sbU.append(this.pending);
        sbU.append(", avatar=");
        return a.J(sbU, this.avatar, ")");
    }
}
