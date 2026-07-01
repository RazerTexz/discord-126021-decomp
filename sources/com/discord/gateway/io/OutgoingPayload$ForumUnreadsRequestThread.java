package com.discord.gateway.io;


/* JADX INFO: compiled from: Outgoing.kt */
/* JADX INFO: loaded from: classes.dex */
public final class OutgoingPayload$ForumUnreadsRequestThread {
    private final long ackMessageId;
    private final long threadId;

    public OutgoingPayload$ForumUnreadsRequestThread(long j, long j2) {
        this.threadId = j;
        this.ackMessageId = j2;
    }

    public final long getAckMessageId() {
        return this.ackMessageId;
    }

    public final long getThreadId() {
        return this.threadId;
    }
}
