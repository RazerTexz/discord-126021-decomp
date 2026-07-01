package com.discord.utilities.messagesend;

import com.discord.utilities.error.Error;
import d0.z.d.m;

/* JADX INFO: compiled from: MessageQueue.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MessageResult$UnknownFailure extends MessageResult {
    private final Error error;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageResult$UnknownFailure(Error error) {
        super(null);
        m.checkNotNullParameter(error, "error");
        this.error = error;
    }

    public final Error getError() {
        return this.error;
    }
}
