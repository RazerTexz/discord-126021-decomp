package com.discord.models.thread.dto;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.message.Message;
import com.discord.api.thread.ThreadMember;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: ModelThreadListSync.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelThreadListSync {
    private final long guildId;
    private final List<ThreadMember> members;
    private final List<Message> mostRecentMessages;
    private final List<Channel> threads;

    /* JADX WARN: Multi-variable type inference failed */
    public ModelThreadListSync(long j, List<Channel> list, List<? extends ThreadMember> list2, List<Message> list3) {
        m.checkNotNullParameter(list, "threads");
        this.guildId = j;
        this.threads = list;
        this.members = list2;
        this.mostRecentMessages = list3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ModelThreadListSync copy$default(ModelThreadListSync modelThreadListSync, long j, List list, List list2, List list3, int i, Object obj) {
        if ((i & 1) != 0) {
            j = modelThreadListSync.guildId;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            list = modelThreadListSync.threads;
        }
        List list4 = list;
        if ((i & 4) != 0) {
            list2 = modelThreadListSync.members;
        }
        List list5 = list2;
        if ((i & 8) != 0) {
            list3 = modelThreadListSync.mostRecentMessages;
        }
        return modelThreadListSync.copy(j2, list4, list5, list3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    public final List<Channel> component2() {
        return this.threads;
    }

    public final List<ThreadMember> component3() {
        return this.members;
    }

    public final List<Message> component4() {
        return this.mostRecentMessages;
    }

    public final ModelThreadListSync copy(long guildId, List<Channel> threads, List<? extends ThreadMember> members, List<Message> mostRecentMessages) {
        m.checkNotNullParameter(threads, "threads");
        return new ModelThreadListSync(guildId, threads, members, mostRecentMessages);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelThreadListSync)) {
            return false;
        }
        ModelThreadListSync modelThreadListSync = (ModelThreadListSync) other;
        return this.guildId == modelThreadListSync.guildId && m.areEqual(this.threads, modelThreadListSync.threads) && m.areEqual(this.members, modelThreadListSync.members) && m.areEqual(this.mostRecentMessages, modelThreadListSync.mostRecentMessages);
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final List<ThreadMember> getMembers() {
        return this.members;
    }

    public final List<Message> getMostRecentMessages() {
        return this.mostRecentMessages;
    }

    public final List<Channel> getThreads() {
        return this.threads;
    }

    public int hashCode() {
        long j = this.guildId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        List<Channel> list = this.threads;
        int iHashCode = (i + (list != null ? list.hashCode() : 0)) * 31;
        List<ThreadMember> list2 = this.members;
        int iHashCode2 = (iHashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<Message> list3 = this.mostRecentMessages;
        return iHashCode2 + (list3 != null ? list3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ModelThreadListSync(guildId=");
        sbU.append(this.guildId);
        sbU.append(", threads=");
        sbU.append(this.threads);
        sbU.append(", members=");
        sbU.append(this.members);
        sbU.append(", mostRecentMessages=");
        return a.L(sbU, this.mostRecentMessages, ")");
    }
}
