package com.discord.api.thread;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: ThreadMemberListUpdate.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ThreadMemberListUpdate {
    private final long guildId;
    private final List<ThreadListMember> members;
    private final long threadId;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    public final List<ThreadListMember> b() {
        return this.members;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final long getThreadId() {
        return this.threadId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ThreadMemberListUpdate)) {
            return false;
        }
        ThreadMemberListUpdate threadMemberListUpdate = (ThreadMemberListUpdate) other;
        return this.guildId == threadMemberListUpdate.guildId && this.threadId == threadMemberListUpdate.threadId && m.areEqual(this.members, threadMemberListUpdate.members);
    }

    public int hashCode() {
        long j = this.guildId;
        long j2 = this.threadId;
        int i = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        List<ThreadListMember> list = this.members;
        return i + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ThreadMemberListUpdate(guildId=");
        sbU.append(this.guildId);
        sbU.append(", threadId=");
        sbU.append(this.threadId);
        sbU.append(", members=");
        return a.L(sbU, this.members, ")");
    }
}
