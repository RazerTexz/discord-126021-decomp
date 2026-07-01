package com.discord.widgets.guildscheduledevent;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import d0.z.d.m;

/* JADX INFO: compiled from: GuildScheduledEventUser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildScheduledEventUser {
    public static final GuildScheduledEventUser$Companion Companion = new GuildScheduledEventUser$Companion(null);
    private final GuildMember guildMember;
    private final long guildScheduledEventId;
    private final User user;

    public GuildScheduledEventUser(User user, GuildMember guildMember, long j) {
        m.checkNotNullParameter(user, "user");
        m.checkNotNullParameter(guildMember, "guildMember");
        this.user = user;
        this.guildMember = guildMember;
        this.guildScheduledEventId = j;
    }

    public static /* synthetic */ GuildScheduledEventUser copy$default(GuildScheduledEventUser guildScheduledEventUser, User user, GuildMember guildMember, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            user = guildScheduledEventUser.user;
        }
        if ((i & 2) != 0) {
            guildMember = guildScheduledEventUser.guildMember;
        }
        if ((i & 4) != 0) {
            j = guildScheduledEventUser.guildScheduledEventId;
        }
        return guildScheduledEventUser.copy(user, guildMember, j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final GuildMember getGuildMember() {
        return this.guildMember;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getGuildScheduledEventId() {
        return this.guildScheduledEventId;
    }

    public final GuildScheduledEventUser copy(User user, GuildMember guildMember, long guildScheduledEventId) {
        m.checkNotNullParameter(user, "user");
        m.checkNotNullParameter(guildMember, "guildMember");
        return new GuildScheduledEventUser(user, guildMember, guildScheduledEventId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildScheduledEventUser)) {
            return false;
        }
        GuildScheduledEventUser guildScheduledEventUser = (GuildScheduledEventUser) other;
        return m.areEqual(this.user, guildScheduledEventUser.user) && m.areEqual(this.guildMember, guildScheduledEventUser.guildMember) && this.guildScheduledEventId == guildScheduledEventUser.guildScheduledEventId;
    }

    public final GuildMember getGuildMember() {
        return this.guildMember;
    }

    public final long getGuildScheduledEventId() {
        return this.guildScheduledEventId;
    }

    public final User getUser() {
        return this.user;
    }

    public int hashCode() {
        User user = this.user;
        int iHashCode = (user != null ? user.hashCode() : 0) * 31;
        GuildMember guildMember = this.guildMember;
        return b.a(this.guildScheduledEventId) + ((iHashCode + (guildMember != null ? guildMember.hashCode() : 0)) * 31);
    }

    public String toString() {
        StringBuilder sbU = a.U("GuildScheduledEventUser(user=");
        sbU.append(this.user);
        sbU.append(", guildMember=");
        sbU.append(this.guildMember);
        sbU.append(", guildScheduledEventId=");
        return a.C(sbU, this.guildScheduledEventId, ")");
    }
}
