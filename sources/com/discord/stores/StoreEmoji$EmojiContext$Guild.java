package com.discord.stores;

import a0.a.a.b;
import b.d.b.a.a;

/* JADX INFO: compiled from: StoreEmoji.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreEmoji$EmojiContext$Guild extends StoreEmoji$EmojiContext {
    private final long guildId;

    public StoreEmoji$EmojiContext$Guild(long j) {
        super(null);
        this.guildId = j;
    }

    public static /* synthetic */ StoreEmoji$EmojiContext$Guild copy$default(StoreEmoji$EmojiContext$Guild storeEmoji$EmojiContext$Guild, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = storeEmoji$EmojiContext$Guild.guildId;
        }
        return storeEmoji$EmojiContext$Guild.copy(j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    public final StoreEmoji$EmojiContext$Guild copy(long guildId) {
        return new StoreEmoji$EmojiContext$Guild(guildId);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof StoreEmoji$EmojiContext$Guild) && this.guildId == ((StoreEmoji$EmojiContext$Guild) other).guildId;
        }
        return true;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public int hashCode() {
        return b.a(this.guildId);
    }

    public String toString() {
        return a.C(a.U("Guild(guildId="), this.guildId, ")");
    }
}
