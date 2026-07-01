package com.discord.api.guildscheduledevent;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

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
        return Intrinsics3.areEqual(this.avatar, guildScheduledEventRsvpGuildMember.avatar) && Intrinsics3.areEqual(this.nick, guildScheduledEventRsvpGuildMember.nick);
    }

    public int hashCode() {
        String str = this.avatar;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.nick;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildScheduledEventRsvpGuildMember(avatar=");
        sbU.append(this.avatar);
        sbU.append(", nick=");
        return outline.J(sbU, this.nick, ")");
    }
}
