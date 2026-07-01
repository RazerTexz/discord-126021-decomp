package com.discord.stores;

import a0.a.a.b;
import b.d.b.a.a;

/* JADX INFO: compiled from: StoreEmoji.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreEmoji$EmojiContext$Chat extends StoreEmoji$EmojiContext {
    private final long channelId;
    private final long guildId;

    public StoreEmoji$EmojiContext$Chat(long j, long j2) {
        super(null);
        this.guildId = j;
        this.channelId = j2;
    }

    public static /* synthetic */ StoreEmoji$EmojiContext$Chat copy$default(StoreEmoji$EmojiContext$Chat storeEmoji$EmojiContext$Chat, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = storeEmoji$EmojiContext$Chat.guildId;
        }
        if ((i & 2) != 0) {
            j2 = storeEmoji$EmojiContext$Chat.channelId;
        }
        return storeEmoji$EmojiContext$Chat.copy(j, j2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    public final StoreEmoji$EmojiContext$Chat copy(long guildId, long channelId) {
        return new StoreEmoji$EmojiContext$Chat(guildId, channelId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreEmoji$EmojiContext$Chat)) {
            return false;
        }
        StoreEmoji$EmojiContext$Chat storeEmoji$EmojiContext$Chat = (StoreEmoji$EmojiContext$Chat) other;
        return this.guildId == storeEmoji$EmojiContext$Chat.guildId && this.channelId == storeEmoji$EmojiContext$Chat.channelId;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public int hashCode() {
        return b.a(this.channelId) + (b.a(this.guildId) * 31);
    }

    public String toString() {
        StringBuilder sbU = a.U("Chat(guildId=");
        sbU.append(this.guildId);
        sbU.append(", channelId=");
        return a.C(sbU, this.channelId, ")");
    }
}
