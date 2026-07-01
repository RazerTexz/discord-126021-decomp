package com.discord.api.guildmember;

import b.d.b.a.a;
import com.discord.api.presence.Presence;
import d0.z.d.m;
import java.util.List;

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

    public final List<GuildMember> b() {
        return this.members;
    }

    public final List<Long> c() {
        return this.notFound;
    }

    public final List<Presence> d() {
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
        return this.guildId == guildMembersChunk.guildId && m.areEqual(this.members, guildMembersChunk.members) && m.areEqual(this.presences, guildMembersChunk.presences) && m.areEqual(this.notFound, guildMembersChunk.notFound);
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
        StringBuilder sbU = a.U("GuildMembersChunk(guildId=");
        sbU.append(this.guildId);
        sbU.append(", members=");
        sbU.append(this.members);
        sbU.append(", presences=");
        sbU.append(this.presences);
        sbU.append(", notFound=");
        return a.L(sbU, this.notFound, ")");
    }
}
