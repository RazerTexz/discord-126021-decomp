package com.discord.utilities.messagesend;

import com.discord.api.message.allowedmentions.MessageAllowedMentions;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: MessageQueue.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MessageRequest$Edit extends MessageRequest {
    private final MessageAllowedMentions allowedMentions;
    private final long channelId;
    private final String content;
    private final long messageId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageRequest$Edit(long j, String str, long j2, MessageAllowedMentions messageAllowedMentions, long j3, Function2<? super MessageResult, ? super Boolean, Unit> function2) {
        super(String.valueOf(j2), function2, j3, null);
        m.checkNotNullParameter(str, "content");
        m.checkNotNullParameter(function2, "onCompleted");
        this.channelId = j;
        this.content = str;
        this.messageId = j2;
        this.allowedMentions = messageAllowedMentions;
    }

    public final MessageAllowedMentions getAllowedMentions() {
        return this.allowedMentions;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final String getContent() {
        return this.content;
    }

    public final long getMessageId() {
        return this.messageId;
    }
}
