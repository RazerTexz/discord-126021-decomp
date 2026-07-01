package com.discord.utilities.messagesend;


/* JADX INFO: compiled from: MessageQueue.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MessageResult$RateLimited extends MessageResult {
    private final long retryAfterMs;

    public MessageResult$RateLimited(long j) {
        super(null);
        this.retryAfterMs = j;
    }

    public final long getRetryAfterMs() {
        return this.retryAfterMs;
    }
}
