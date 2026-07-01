package com.discord.api.thread;

import com.discord.api.guildmember.GuildMember;
import com.discord.api.presence.Presence;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.domain.ModelAuditLogEntry;

/* JADX INFO: compiled from: AugmentedThreadMember.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AugmentedThreadMember {
    private final int flags;
    private final long id;
    private final UtcDateTime joinTimestamp;
    private final GuildMember member;
    private final MuteConfig muteConfig;
    private final boolean muted;
    private final Presence presence;
    private final long userId;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final int getFlags() {
        return this.flags;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final UtcDateTime getJoinTimestamp() {
        return this.joinTimestamp;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final GuildMember getMember() {
        return this.member;
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
    public final Presence getPresence() {
        return this.presence;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final long getUserId() {
        return this.userId;
    }
}
