package com.discord.stores;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.api.message.reaction.MessageReactionEmoji;
import d0.z.d.m;

/* JADX INFO: compiled from: StoreMessageReactions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreMessageReactions$EmojiResults$Failure extends StoreMessageReactions$EmojiResults {
    private final long channelId;
    private final MessageReactionEmoji emoji;
    private final long messageId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMessageReactions$EmojiResults$Failure(long j, long j2, MessageReactionEmoji messageReactionEmoji) {
        super(null);
        m.checkNotNullParameter(messageReactionEmoji, "emoji");
        this.channelId = j;
        this.messageId = j2;
        this.emoji = messageReactionEmoji;
    }

    public static /* synthetic */ StoreMessageReactions$EmojiResults$Failure copy$default(StoreMessageReactions$EmojiResults$Failure storeMessageReactions$EmojiResults$Failure, long j, long j2, MessageReactionEmoji messageReactionEmoji, int i, Object obj) {
        if ((i & 1) != 0) {
            j = storeMessageReactions$EmojiResults$Failure.channelId;
        }
        long j3 = j;
        if ((i & 2) != 0) {
            j2 = storeMessageReactions$EmojiResults$Failure.messageId;
        }
        long j4 = j2;
        if ((i & 4) != 0) {
            messageReactionEmoji = storeMessageReactions$EmojiResults$Failure.emoji;
        }
        return storeMessageReactions$EmojiResults$Failure.copy(j3, j4, messageReactionEmoji);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getMessageId() {
        return this.messageId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final MessageReactionEmoji getEmoji() {
        return this.emoji;
    }

    public final StoreMessageReactions$EmojiResults$Failure copy(long channelId, long messageId, MessageReactionEmoji emoji) {
        m.checkNotNullParameter(emoji, "emoji");
        return new StoreMessageReactions$EmojiResults$Failure(channelId, messageId, emoji);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreMessageReactions$EmojiResults$Failure)) {
            return false;
        }
        StoreMessageReactions$EmojiResults$Failure storeMessageReactions$EmojiResults$Failure = (StoreMessageReactions$EmojiResults$Failure) other;
        return this.channelId == storeMessageReactions$EmojiResults$Failure.channelId && this.messageId == storeMessageReactions$EmojiResults$Failure.messageId && m.areEqual(this.emoji, storeMessageReactions$EmojiResults$Failure.emoji);
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final MessageReactionEmoji getEmoji() {
        return this.emoji;
    }

    public final long getMessageId() {
        return this.messageId;
    }

    public int hashCode() {
        int iA = (b.a(this.messageId) + (b.a(this.channelId) * 31)) * 31;
        MessageReactionEmoji messageReactionEmoji = this.emoji;
        return iA + (messageReactionEmoji != null ? messageReactionEmoji.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Failure(channelId=");
        sbU.append(this.channelId);
        sbU.append(", messageId=");
        sbU.append(this.messageId);
        sbU.append(", emoji=");
        sbU.append(this.emoji);
        sbU.append(")");
        return sbU.toString();
    }
}
