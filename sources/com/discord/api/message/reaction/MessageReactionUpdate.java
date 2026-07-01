package com.discord.api.message.reaction;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: MessageReactionUpdate.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class MessageReactionUpdate {
    private final long channelId;
    private final MessageReactionEmoji emoji;
    private final long messageId;
    private final long userId;

    public MessageReactionUpdate(long j, long j2, long j3, MessageReactionEmoji messageReactionEmoji) {
        Intrinsics3.checkNotNullParameter(messageReactionEmoji, "emoji");
        this.userId = j;
        this.channelId = j2;
        this.messageId = j3;
        this.emoji = messageReactionEmoji;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final MessageReactionEmoji getEmoji() {
        return this.emoji;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final long getMessageId() {
        return this.messageId;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final long getUserId() {
        return this.userId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessageReactionUpdate)) {
            return false;
        }
        MessageReactionUpdate messageReactionUpdate = (MessageReactionUpdate) other;
        return this.userId == messageReactionUpdate.userId && this.channelId == messageReactionUpdate.channelId && this.messageId == messageReactionUpdate.messageId && Intrinsics3.areEqual(this.emoji, messageReactionUpdate.emoji);
    }

    public int hashCode() {
        long j = this.userId;
        long j2 = this.channelId;
        int i = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        long j3 = this.messageId;
        int i2 = (i + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        MessageReactionEmoji messageReactionEmoji = this.emoji;
        return i2 + (messageReactionEmoji != null ? messageReactionEmoji.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("MessageReactionUpdate(userId=");
        sbU.append(this.userId);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", messageId=");
        sbU.append(this.messageId);
        sbU.append(", emoji=");
        sbU.append(this.emoji);
        sbU.append(")");
        return sbU.toString();
    }
}
