package com.discord.api.thread;

import b.d.b.a.a;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: ThreadMemberUpdate.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ThreadMemberUpdate {
    private final int flags;
    private final long guildId;
    private final long id;
    private final UtcDateTime joinTimestamp;
    private final MuteConfig muteConfig;
    private final boolean muted;
    private final long userId;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final int getFlags() {
        return this.flags;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final UtcDateTime getJoinTimestamp() {
        return this.joinTimestamp;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final MuteConfig getMuteConfig() {
        return this.muteConfig;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ThreadMemberUpdate)) {
            return false;
        }
        ThreadMemberUpdate threadMemberUpdate = (ThreadMemberUpdate) other;
        return this.id == threadMemberUpdate.id && this.guildId == threadMemberUpdate.guildId && this.userId == threadMemberUpdate.userId && this.flags == threadMemberUpdate.flags && m.areEqual(this.joinTimestamp, threadMemberUpdate.joinTimestamp) && this.muted == threadMemberUpdate.muted && m.areEqual(this.muteConfig, threadMemberUpdate.muteConfig);
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final boolean getMuted() {
        return this.muted;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final long getUserId() {
        return this.userId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    public int hashCode() {
        long j = this.id;
        long j2 = this.guildId;
        int i = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        long j3 = this.userId;
        int i2 = (((i + ((int) (j3 ^ (j3 >>> 32)))) * 31) + this.flags) * 31;
        UtcDateTime utcDateTime = this.joinTimestamp;
        int iHashCode = (i2 + (utcDateTime != null ? utcDateTime.hashCode() : 0)) * 31;
        boolean z2 = this.muted;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i3 = (iHashCode + r0) * 31;
        MuteConfig muteConfig = this.muteConfig;
        return i3 + (muteConfig != null ? muteConfig.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ThreadMemberUpdate(id=");
        sbU.append(this.id);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", userId=");
        sbU.append(this.userId);
        sbU.append(", flags=");
        sbU.append(this.flags);
        sbU.append(", joinTimestamp=");
        sbU.append(this.joinTimestamp);
        sbU.append(", muted=");
        sbU.append(this.muted);
        sbU.append(", muteConfig=");
        sbU.append(this.muteConfig);
        sbU.append(")");
        return sbU.toString();
    }
}
