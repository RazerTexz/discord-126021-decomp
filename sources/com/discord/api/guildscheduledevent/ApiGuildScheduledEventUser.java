package com.discord.api.guildscheduledevent;

import b.d.b.a.a;
import com.discord.api.guildmember.GuildMember;
import com.discord.api.user.User;
import d0.z.d.m;

/* JADX INFO: compiled from: ApiGuildScheduledEventUser.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ApiGuildScheduledEventUser {
    private final long guildScheduledEventId;
    private final ApiGuildScheduledEventUserGuildMember member;
    private final User user;

    public final GuildMember a(long guildId) {
        ApiGuildScheduledEventUserGuildMember apiGuildScheduledEventUserGuildMember;
        User user = this.user;
        if (user == null || (apiGuildScheduledEventUserGuildMember = this.member) == null) {
            return null;
        }
        return apiGuildScheduledEventUserGuildMember.a(user, guildId);
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final long getGuildScheduledEventId() {
        return this.guildScheduledEventId;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApiGuildScheduledEventUser)) {
            return false;
        }
        ApiGuildScheduledEventUser apiGuildScheduledEventUser = (ApiGuildScheduledEventUser) other;
        return m.areEqual(this.user, apiGuildScheduledEventUser.user) && m.areEqual(this.member, apiGuildScheduledEventUser.member) && this.guildScheduledEventId == apiGuildScheduledEventUser.guildScheduledEventId;
    }

    public int hashCode() {
        User user = this.user;
        int iHashCode = (user != null ? user.hashCode() : 0) * 31;
        ApiGuildScheduledEventUserGuildMember apiGuildScheduledEventUserGuildMember = this.member;
        int iHashCode2 = (iHashCode + (apiGuildScheduledEventUserGuildMember != null ? apiGuildScheduledEventUserGuildMember.hashCode() : 0)) * 31;
        long j = this.guildScheduledEventId;
        return iHashCode2 + ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        StringBuilder sbU = a.U("ApiGuildScheduledEventUser(user=");
        sbU.append(this.user);
        sbU.append(", member=");
        sbU.append(this.member);
        sbU.append(", guildScheduledEventId=");
        return a.C(sbU, this.guildScheduledEventId, ")");
    }
}
