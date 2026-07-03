package com.discord.api.thread;

import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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

    /* JADX INFO: renamed from: b */
    public final List<ThreadListMember> m8266b() {
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
        return this.guildId == threadMemberListUpdate.guildId && this.threadId == threadMemberListUpdate.threadId && C12238m.areEqual(this.members, threadMemberListUpdate.members);
    }

    public int hashCode() {
        long j = this.guildId;
        long j2 = this.threadId;
        int i = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        List<ThreadListMember> list = this.members;
        return i + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("ThreadMemberListUpdate(guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", threadId=");
        sbM833U.append(this.threadId);
        sbM833U.append(", members=");
        return C1643a.m824L(sbM833U, this.members, ")");
    }
}
