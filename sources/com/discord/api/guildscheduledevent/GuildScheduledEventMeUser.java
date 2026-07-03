package com.discord.api.guildscheduledevent;

import com.discord.api.user.User;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GuildScheduledEventMeUser.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class GuildScheduledEventMeUser {
    private final GuildScheduledEvent guildScheduledEvent;
    private final long guildScheduledEventId;
    private final User user;
    private final long userId;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final long getGuildScheduledEventId() {
        return this.guildScheduledEventId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildScheduledEventMeUser)) {
            return false;
        }
        GuildScheduledEventMeUser guildScheduledEventMeUser = (GuildScheduledEventMeUser) other;
        return this.userId == guildScheduledEventMeUser.userId && this.guildScheduledEventId == guildScheduledEventMeUser.guildScheduledEventId && C12238m.areEqual(this.user, guildScheduledEventMeUser.user) && C12238m.areEqual(this.guildScheduledEvent, guildScheduledEventMeUser.guildScheduledEvent);
    }

    public int hashCode() {
        long j = this.userId;
        long j2 = this.guildScheduledEventId;
        int i = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        User user = this.user;
        int iHashCode = (i + (user != null ? user.hashCode() : 0)) * 31;
        GuildScheduledEvent guildScheduledEvent = this.guildScheduledEvent;
        return iHashCode + (guildScheduledEvent != null ? guildScheduledEvent.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("GuildScheduledEventMeUser(userId=");
        sbM833U.append(this.userId);
        sbM833U.append(", guildScheduledEventId=");
        sbM833U.append(this.guildScheduledEventId);
        sbM833U.append(", user=");
        sbM833U.append(this.user);
        sbM833U.append(", guildScheduledEvent=");
        sbM833U.append(this.guildScheduledEvent);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
