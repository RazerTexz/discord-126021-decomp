package com.discord.api.guildscheduledevent;

import b.d.b.a.outline;
import com.discord.api.guildmember.GuildMember;
import com.discord.api.user.User;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: ApiGuildScheduledEventUser.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ApiGuildScheduledEventUser {
    private final long guildScheduledEventId;
    private final ApiGuildScheduledEventUser2 member;
    private final User user;

    public final GuildMember a(long guildId) {
        ApiGuildScheduledEventUser2 apiGuildScheduledEventUser2;
        User user = this.user;
        if (user == null || (apiGuildScheduledEventUser2 = this.member) == null) {
            return null;
        }
        return apiGuildScheduledEventUser2.a(user, guildId);
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
        return Intrinsics3.areEqual(this.user, apiGuildScheduledEventUser.user) && Intrinsics3.areEqual(this.member, apiGuildScheduledEventUser.member) && this.guildScheduledEventId == apiGuildScheduledEventUser.guildScheduledEventId;
    }

    public int hashCode() {
        User user = this.user;
        int iHashCode = (user != null ? user.hashCode() : 0) * 31;
        ApiGuildScheduledEventUser2 apiGuildScheduledEventUser2 = this.member;
        int iHashCode2 = (iHashCode + (apiGuildScheduledEventUser2 != null ? apiGuildScheduledEventUser2.hashCode() : 0)) * 31;
        long j = this.guildScheduledEventId;
        return iHashCode2 + ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        StringBuilder sbU = outline.U("ApiGuildScheduledEventUser(user=");
        sbU.append(this.user);
        sbU.append(", member=");
        sbU.append(this.member);
        sbU.append(", guildScheduledEventId=");
        return outline.C(sbU, this.guildScheduledEventId, ")");
    }
}
