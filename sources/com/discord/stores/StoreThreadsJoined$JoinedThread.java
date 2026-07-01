package com.discord.stores;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.domain.ModelMuteConfig;
import d0.z.d.m;

/* JADX INFO: compiled from: StoreThreadsJoined.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreThreadsJoined$JoinedThread {
    private final int flags;
    private final long guildId;
    private final UtcDateTime joinTimestamp;
    private final ModelMuteConfig muteConfig;
    private final boolean muted;
    private final long threadId;

    public StoreThreadsJoined$JoinedThread(long j, long j2, int i, boolean z2, ModelMuteConfig modelMuteConfig, UtcDateTime utcDateTime) {
        m.checkNotNullParameter(modelMuteConfig, "muteConfig");
        m.checkNotNullParameter(utcDateTime, "joinTimestamp");
        this.threadId = j;
        this.guildId = j2;
        this.flags = i;
        this.muted = z2;
        this.muteConfig = modelMuteConfig;
        this.joinTimestamp = utcDateTime;
    }

    public static /* synthetic */ StoreThreadsJoined$JoinedThread copy$default(StoreThreadsJoined$JoinedThread storeThreadsJoined$JoinedThread, long j, long j2, int i, boolean z2, ModelMuteConfig modelMuteConfig, UtcDateTime utcDateTime, int i2, Object obj) {
        return storeThreadsJoined$JoinedThread.copy((i2 & 1) != 0 ? storeThreadsJoined$JoinedThread.threadId : j, (i2 & 2) != 0 ? storeThreadsJoined$JoinedThread.guildId : j2, (i2 & 4) != 0 ? storeThreadsJoined$JoinedThread.flags : i, (i2 & 8) != 0 ? storeThreadsJoined$JoinedThread.muted : z2, (i2 & 16) != 0 ? storeThreadsJoined$JoinedThread.muteConfig : modelMuteConfig, (i2 & 32) != 0 ? storeThreadsJoined$JoinedThread.joinTimestamp : utcDateTime);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getThreadId() {
        return this.threadId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getFlags() {
        return this.flags;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getMuted() {
        return this.muted;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final ModelMuteConfig getMuteConfig() {
        return this.muteConfig;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final UtcDateTime getJoinTimestamp() {
        return this.joinTimestamp;
    }

    public final StoreThreadsJoined$JoinedThread copy(long threadId, long guildId, int flags, boolean muted, ModelMuteConfig muteConfig, UtcDateTime joinTimestamp) {
        m.checkNotNullParameter(muteConfig, "muteConfig");
        m.checkNotNullParameter(joinTimestamp, "joinTimestamp");
        return new StoreThreadsJoined$JoinedThread(threadId, guildId, flags, muted, muteConfig, joinTimestamp);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreThreadsJoined$JoinedThread)) {
            return false;
        }
        StoreThreadsJoined$JoinedThread storeThreadsJoined$JoinedThread = (StoreThreadsJoined$JoinedThread) other;
        return this.threadId == storeThreadsJoined$JoinedThread.threadId && this.guildId == storeThreadsJoined$JoinedThread.guildId && this.flags == storeThreadsJoined$JoinedThread.flags && this.muted == storeThreadsJoined$JoinedThread.muted && m.areEqual(this.muteConfig, storeThreadsJoined$JoinedThread.muteConfig) && m.areEqual(this.joinTimestamp, storeThreadsJoined$JoinedThread.joinTimestamp);
    }

    public final int getFlags() {
        return this.flags;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final UtcDateTime getJoinTimestamp() {
        return this.joinTimestamp;
    }

    public final ModelMuteConfig getMuteConfig() {
        return this.muteConfig;
    }

    public final boolean getMuted() {
        return this.muted;
    }

    public final long getThreadId() {
        return this.threadId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    public int hashCode() {
        int iA = (((b.a(this.guildId) + (b.a(this.threadId) * 31)) * 31) + this.flags) * 31;
        boolean z2 = this.muted;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = (iA + r0) * 31;
        ModelMuteConfig modelMuteConfig = this.muteConfig;
        int iHashCode = (i + (modelMuteConfig != null ? modelMuteConfig.hashCode() : 0)) * 31;
        UtcDateTime utcDateTime = this.joinTimestamp;
        return iHashCode + (utcDateTime != null ? utcDateTime.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("JoinedThread(threadId=");
        sbU.append(this.threadId);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", flags=");
        sbU.append(this.flags);
        sbU.append(", muted=");
        sbU.append(this.muted);
        sbU.append(", muteConfig=");
        sbU.append(this.muteConfig);
        sbU.append(", joinTimestamp=");
        sbU.append(this.joinTimestamp);
        sbU.append(")");
        return sbU.toString();
    }
}
