package com.discord.api.thread;

import com.discord.api.guildmember.GuildMember;
import com.discord.api.presence.Presence;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return this.userId == threadListMember.userId && C12238m.areEqual(this.member, threadListMember.member) && C12238m.areEqual(this.presence, threadListMember.presence);
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
        StringBuilder sbM833U = C1643a.m833U("ThreadListMember(userId=");
        sbM833U.append(this.userId);
        sbM833U.append(", member=");
        sbM833U.append(this.member);
        sbM833U.append(", presence=");
        sbM833U.append(this.presence);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
