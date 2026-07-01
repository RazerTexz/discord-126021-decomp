package com.discord.api.thread;

import b.d.b.a.a;
import com.discord.api.guildmember.GuildMember;
import com.discord.api.presence.Presence;
import d0.z.d.m;

/* JADX INFO: compiled from: ThreadListMember.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ThreadListMember {
    private final GuildMember member;
    private final Presence presence;
    private final long userId;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final GuildMember getMember() {
        return this.member;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final Presence getPresence() {
        return this.presence;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final long getUserId() {
        return this.userId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ThreadListMember)) {
            return false;
        }
        ThreadListMember threadListMember = (ThreadListMember) other;
        return this.userId == threadListMember.userId && m.areEqual(this.member, threadListMember.member) && m.areEqual(this.presence, threadListMember.presence);
    }

    public int hashCode() {
        long j = this.userId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        GuildMember guildMember = this.member;
        int iHashCode = (i + (guildMember != null ? guildMember.hashCode() : 0)) * 31;
        Presence presence = this.presence;
        return iHashCode + (presence != null ? presence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ThreadListMember(userId=");
        sbU.append(this.userId);
        sbU.append(", member=");
        sbU.append(this.member);
        sbU.append(", presence=");
        sbU.append(this.presence);
        sbU.append(")");
        return sbU.toString();
    }
}
