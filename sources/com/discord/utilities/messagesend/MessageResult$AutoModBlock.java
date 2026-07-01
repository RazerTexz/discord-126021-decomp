package com.discord.utilities.messagesend;

import com.discord.models.message.Message;
import com.discord.utilities.error.Error;
import d0.z.d.m;

/* JADX INFO: compiled from: MessageQueue.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MessageResult$AutoModBlock extends MessageResult {
    private final Error error;
    private final Message message;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageResult$AutoModBlock(Error error, Message message) {
        super(null);
        m.checkNotNullParameter(error, "error");
        this.error = error;
        this.message = message;
    }

    public final Error getError() {
        return this.error;
    }

    public final Message getMessage() {
        return this.message;
    }
}
