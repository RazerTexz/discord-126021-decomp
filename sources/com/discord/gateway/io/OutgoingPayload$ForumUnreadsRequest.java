package com.discord.gateway.io;

import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: Outgoing.kt */
/* JADX INFO: loaded from: classes.dex */
public final class OutgoingPayload$ForumUnreadsRequest extends OutgoingPayload {
    private final long channelId;
    private final long guildId;
    private final List<OutgoingPayload$ForumUnreadsRequestThread> threads;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OutgoingPayload$ForumUnreadsRequest(long j, long j2, List<OutgoingPayload$ForumUnreadsRequestThread> list) {
        super(null);
        m.checkNotNullParameter(list, "threads");
        this.guildId = j;
        this.channelId = j2;
        this.threads = list;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final List<OutgoingPayload$ForumUnreadsRequestThread> getThreads() {
        return this.threads;
    }
}
