package com.discord.utilities.messagesend;

import d0.z.d.m;

/* JADX INFO: compiled from: MessageQueue.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MessageResult$ValidationError extends MessageResult {
    private final String message;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageResult$ValidationError(String str) {
        super(null);
        m.checkNotNullParameter(str, "message");
        this.message = str;
    }

    public final String getMessage() {
        return this.message;
    }
}
