package com.discord.stores;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.utcdatetime.UtcDateTime;
import d0.z.d.m;

/* JADX INFO: compiled from: StoreThreadsActiveJoined.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreThreadsActiveJoined$ActiveJoinedThread {
    private final Channel channel;
    private final UtcDateTime joinTimestamp;
    private final boolean muted;

    public StoreThreadsActiveJoined$ActiveJoinedThread(Channel channel, UtcDateTime utcDateTime, boolean z2) {
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(utcDateTime, "joinTimestamp");
        this.channel = channel;
        this.joinTimestamp = utcDateTime;
        this.muted = z2;
    }

    public static /* synthetic */ StoreThreadsActiveJoined$ActiveJoinedThread copy$default(StoreThreadsActiveJoined$ActiveJoinedThread storeThreadsActiveJoined$ActiveJoinedThread, Channel channel, UtcDateTime utcDateTime, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            channel = storeThreadsActiveJoined$ActiveJoinedThread.channel;
        }
        if ((i & 2) != 0) {
            utcDateTime = storeThreadsActiveJoined$ActiveJoinedThread.joinTimestamp;
        }
        if ((i & 4) != 0) {
            z2 = storeThreadsActiveJoined$ActiveJoinedThread.muted;
        }
        return storeThreadsActiveJoined$ActiveJoinedThread.copy(channel, utcDateTime, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final UtcDateTime getJoinTimestamp() {
        return this.joinTimestamp;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getMuted() {
        return this.muted;
    }

    public final StoreThreadsActiveJoined$ActiveJoinedThread copy(Channel channel, UtcDateTime joinTimestamp, boolean muted) {
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(joinTimestamp, "joinTimestamp");
        return new StoreThreadsActiveJoined$ActiveJoinedThread(channel, joinTimestamp, muted);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreThreadsActiveJoined$ActiveJoinedThread)) {
            return false;
        }
        StoreThreadsActiveJoined$ActiveJoinedThread storeThreadsActiveJoined$ActiveJoinedThread = (StoreThreadsActiveJoined$ActiveJoinedThread) other;
        return m.areEqual(this.channel, storeThreadsActiveJoined$ActiveJoinedThread.channel) && m.areEqual(this.joinTimestamp, storeThreadsActiveJoined$ActiveJoinedThread.joinTimestamp) && this.muted == storeThreadsActiveJoined$ActiveJoinedThread.muted;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final UtcDateTime getJoinTimestamp() {
        return this.joinTimestamp;
    }

    public final boolean getMuted() {
        return this.muted;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        Channel channel = this.channel;
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        UtcDateTime utcDateTime = this.joinTimestamp;
        int iHashCode2 = (iHashCode + (utcDateTime != null ? utcDateTime.hashCode() : 0)) * 31;
        boolean z2 = this.muted;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode2 + r1;
    }

    public String toString() {
        StringBuilder sbU = a.U("ActiveJoinedThread(channel=");
        sbU.append(this.channel);
        sbU.append(", joinTimestamp=");
        sbU.append(this.joinTimestamp);
        sbU.append(", muted=");
        return a.O(sbU, this.muted, ")");
    }
}
