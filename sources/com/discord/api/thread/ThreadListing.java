package com.discord.api.thread;

import com.discord.api.channel.Channel;
import com.discord.api.message.Message;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ThreadListing.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ThreadListing {
    private final List<Message> firstMessages;
    private final boolean hasMore;
    private final List<ThreadMember> members;
    private final List<Channel> threads;

    /* JADX INFO: renamed from: a */
    public final List<Message> m8256a() {
        return this.firstMessages;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final boolean getHasMore() {
        return this.hasMore;
    }

    /* JADX INFO: renamed from: c */
    public final List<Channel> m8258c() {
        return this.threads;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ThreadListing)) {
            return false;
        }
        ThreadListing threadListing = (ThreadListing) other;
        return C12238m.areEqual(this.threads, threadListing.threads) && this.hasMore == threadListing.hasMore && C12238m.areEqual(this.members, threadListing.members) && C12238m.areEqual(this.firstMessages, threadListing.firstMessages);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    public int hashCode() {
        List<Channel> list = this.threads;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        boolean z2 = this.hasMore;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode + r2) * 31;
        List<ThreadMember> list2 = this.members;
        int iHashCode2 = (i + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<Message> list3 = this.firstMessages;
        return iHashCode2 + (list3 != null ? list3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("ThreadListing(threads=");
        sbM833U.append(this.threads);
        sbM833U.append(", hasMore=");
        sbM833U.append(this.hasMore);
        sbM833U.append(", members=");
        sbM833U.append(this.members);
        sbM833U.append(", firstMessages=");
        return C1643a.m824L(sbM833U, this.firstMessages, ")");
    }
}
