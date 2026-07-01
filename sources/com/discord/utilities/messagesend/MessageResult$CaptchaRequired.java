package com.discord.utilities.messagesend;

import com.discord.utilities.error.Error;
import d0.z.d.m;

/* JADX INFO: compiled from: MessageQueue.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MessageResult$CaptchaRequired extends MessageResult {
    private final long channelId;
    private final Error error;
    private final String nonce;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageResult$CaptchaRequired(Error error, long j, String str) {
        super(null);
        m.checkNotNullParameter(error, "error");
        this.error = error;
        this.channelId = j;
        this.nonce = str;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final Error getError() {
        return this.error;
    }

    public final String getNonce() {
        return this.nonce;
    }
}
