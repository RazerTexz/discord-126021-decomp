package com.discord.api.thread;

import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: ThreadMember.kt */
/* JADX INFO: loaded from: classes.dex */
public class ThreadMember {
    private final int flags;
    private final long id;
    private final UtcDateTime joinTimestamp;
    private final MuteConfig muteConfig;
    private final boolean muted;
    private final long userId;

    public ThreadMember(long j, long j2, int i, UtcDateTime utcDateTime, boolean z2, MuteConfig muteConfig) {
        Intrinsics3.checkNotNullParameter(utcDateTime, "joinTimestamp");
        this.id = j;
        this.userId = j2;
        this.flags = i;
        this.joinTimestamp = utcDateTime;
        this.muted = z2;
        this.muteConfig = muteConfig;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public int getFlags() {
        return this.flags;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public UtcDateTime getJoinTimestamp() {
        return this.joinTimestamp;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final MuteConfig getMuteConfig() {
        return this.muteConfig;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final boolean getMuted() {
        return this.muted;
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public long getUserId() {
        return this.userId;
    }
}
