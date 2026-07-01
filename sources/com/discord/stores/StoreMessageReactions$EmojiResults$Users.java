package com.discord.stores;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.api.message.reaction.MessageReactionEmoji;
import com.discord.models.user.User;
import d0.z.d.m;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: StoreMessageReactions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreMessageReactions$EmojiResults$Users extends StoreMessageReactions$EmojiResults {
    private final long channelId;
    private final MessageReactionEmoji emoji;
    private final long messageId;
    private final LinkedHashMap<Long, User> users;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMessageReactions$EmojiResults$Users(LinkedHashMap<Long, User> linkedHashMap, long j, long j2, MessageReactionEmoji messageReactionEmoji) {
        super(null);
        m.checkNotNullParameter(linkedHashMap, "users");
        m.checkNotNullParameter(messageReactionEmoji, "emoji");
        this.users = linkedHashMap;
        this.channelId = j;
        this.messageId = j2;
        this.emoji = messageReactionEmoji;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StoreMessageReactions$EmojiResults$Users copy$default(StoreMessageReactions$EmojiResults$Users storeMessageReactions$EmojiResults$Users, LinkedHashMap linkedHashMap, long j, long j2, MessageReactionEmoji messageReactionEmoji, int i, Object obj) {
        if ((i & 1) != 0) {
            linkedHashMap = storeMessageReactions$EmojiResults$Users.users;
        }
        if ((i & 2) != 0) {
            j = storeMessageReactions$EmojiResults$Users.channelId;
        }
        long j3 = j;
        if ((i & 4) != 0) {
            j2 = storeMessageReactions$EmojiResults$Users.messageId;
        }
        long j4 = j2;
        if ((i & 8) != 0) {
            messageReactionEmoji = storeMessageReactions$EmojiResults$Users.emoji;
        }
        return storeMessageReactions$EmojiResults$Users.copy(linkedHashMap, j3, j4, messageReactionEmoji);
    }

    public final LinkedHashMap<Long, User> component1() {
        return this.users;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getMessageId() {
        return this.messageId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final MessageReactionEmoji getEmoji() {
        return this.emoji;
    }

    public final StoreMessageReactions$EmojiResults$Users copy(LinkedHashMap<Long, User> users, long channelId, long messageId, MessageReactionEmoji emoji) {
        m.checkNotNullParameter(users, "users");
        m.checkNotNullParameter(emoji, "emoji");
        return new StoreMessageReactions$EmojiResults$Users(users, channelId, messageId, emoji);
    }

    public final StoreMessageReactions$EmojiResults$Users deepCopy() {
        return new StoreMessageReactions$EmojiResults$Users(new LinkedHashMap(this.users), this.channelId, this.messageId, this.emoji);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreMessageReactions$EmojiResults$Users)) {
            return false;
        }
        StoreMessageReactions$EmojiResults$Users storeMessageReactions$EmojiResults$Users = (StoreMessageReactions$EmojiResults$Users) other;
        return m.areEqual(this.users, storeMessageReactions$EmojiResults$Users.users) && this.channelId == storeMessageReactions$EmojiResults$Users.channelId && this.messageId == storeMessageReactions$EmojiResults$Users.messageId && m.areEqual(this.emoji, storeMessageReactions$EmojiResults$Users.emoji);
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

    public final LinkedHashMap<Long, User> getUsers() {
        return this.users;
    }

    public int hashCode() {
        LinkedHashMap<Long, User> linkedHashMap = this.users;
        int iA = (b.a(this.messageId) + ((b.a(this.channelId) + ((linkedHashMap != null ? linkedHashMap.hashCode() : 0) * 31)) * 31)) * 31;
        MessageReactionEmoji messageReactionEmoji = this.emoji;
        return iA + (messageReactionEmoji != null ? messageReactionEmoji.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Users(users=");
        sbU.append(this.users);
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
