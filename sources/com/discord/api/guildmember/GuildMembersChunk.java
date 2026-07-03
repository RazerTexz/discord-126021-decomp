package com.discord.api.guildmember;

import com.discord.api.presence.Presence;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GuildMembersChunk.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class GuildMembersChunk {
    private final long guildId;
    private final List<GuildMember> members;
    private final List<Long> notFound;
    private final List<Presence> presences;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: b */
    public final List<GuildMember> m7932b() {
        return this.members;
    }

    /* JADX INFO: renamed from: c */
    public final List<Long> m7933c() {
        return this.notFound;
    }

    /* JADX INFO: renamed from: d */
    public final List<Presence> m7934d() {
        return this.presences;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildMembersChunk)) {
            return false;
        }
        GuildMembersChunk guildMembersChunk = (GuildMembersChunk) other;
        return this.guildId == guildMembersChunk.guildId && C12238m.areEqual(this.members, guildMembersChunk.members) && C12238m.areEqual(this.presences, guildMembersChunk.presences) && C12238m.areEqual(this.notFound, guildMembersChunk.notFound);
    }

    public int hashCode() {
        long j = this.guildId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        List<GuildMember> list = this.members;
        int iHashCode = (i + (list != null ? list.hashCode() : 0)) * 31;
        List<Presence> list2 = this.presences;
        int iHashCode2 = (iHashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<Long> list3 = this.notFound;
        return iHashCode2 + (list3 != null ? list3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("GuildMembersChunk(guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", members=");
        sbM833U.append(this.members);
        sbM833U.append(", presences=");
        sbM833U.append(this.presences);
        sbM833U.append(", notFound=");
        return C1643a.m824L(sbM833U, this.notFound, ")");
    }
}
