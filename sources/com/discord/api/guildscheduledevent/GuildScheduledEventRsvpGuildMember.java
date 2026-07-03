package com.discord.api.guildscheduledevent;

import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.avatar, guildScheduledEventRsvpGuildMember.avatar) && C12238m.areEqual(this.nick, guildScheduledEventRsvpGuildMember.nick);
    }

    public int hashCode() {
        String str = this.avatar;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.nick;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("GuildScheduledEventRsvpGuildMember(avatar=");
        sbM833U.append(this.avatar);
        sbM833U.append(", nick=");
        return C1643a.m822J(sbM833U, this.nick, ")");
    }
}
