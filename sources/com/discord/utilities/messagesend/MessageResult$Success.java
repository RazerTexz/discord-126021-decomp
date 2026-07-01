package com.discord.utilities.messagesend;

import com.discord.api.message.Message;
import d0.z.d.m;

/* JADX INFO: compiled from: MessageQueue.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MessageResult$Success extends MessageResult {
    private final Message message;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageResult$Success(Message message) {
        super(null);
        m.checkNotNullParameter(message, "message");
        this.message = message;
    }

    public final Message getMessage() {
        return this.message;
    }
}
