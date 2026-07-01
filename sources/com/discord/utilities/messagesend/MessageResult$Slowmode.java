package com.discord.utilities.messagesend;


/* JADX INFO: compiled from: MessageQueue.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MessageResult$Slowmode extends MessageResult {
    private final long cooldownMs;

    public MessageResult$Slowmode(long j) {
        super(null);
        this.cooldownMs = j;
    }

    public final long getCooldownMs() {
        return this.cooldownMs;
    }
}
