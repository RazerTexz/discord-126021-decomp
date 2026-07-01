package com.discord.api.guildscheduledevent;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: GuildScheduledEventRsvpGuildMember.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class GuildScheduledEventRsvpGuildMember {
    private final String avatar;
    private final String nick;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildScheduledEventRsvpGuildMember)) {
            return false;
        }
        GuildScheduledEventRsvpGuildMember guildScheduledEventRsvpGuildMember = (GuildScheduledEventRsvpGuildMember) other;
        return m.areEqual(this.avatar, guildScheduledEventRsvpGuildMember.avatar) && m.areEqual(this.nick, guildScheduledEventRsvpGuildMember.nick);
    }

    public int hashCode() {
        String str = this.avatar;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.nick;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("GuildScheduledEventRsvpGuildMember(avatar=");
        sbU.append(this.avatar);
        sbU.append(", nick=");
        return a.J(sbU, this.nick, ")");
    }
}
