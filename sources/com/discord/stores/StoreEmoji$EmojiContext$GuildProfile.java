package com.discord.stores;

import a0.a.a.b;
import b.d.b.a.a;

/* JADX INFO: compiled from: StoreEmoji.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreEmoji$EmojiContext$GuildProfile extends StoreEmoji$EmojiContext {
    private final long guildId;

    public StoreEmoji$EmojiContext$GuildProfile(long j) {
        super(null);
        this.guildId = j;
    }

    public static /* synthetic */ StoreEmoji$EmojiContext$GuildProfile copy$default(StoreEmoji$EmojiContext$GuildProfile storeEmoji$EmojiContext$GuildProfile, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = storeEmoji$EmojiContext$GuildProfile.guildId;
        }
        return storeEmoji$EmojiContext$GuildProfile.copy(j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    public final StoreEmoji$EmojiContext$GuildProfile copy(long guildId) {
        return new StoreEmoji$EmojiContext$GuildProfile(guildId);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof StoreEmoji$EmojiContext$GuildProfile) && this.guildId == ((StoreEmoji$EmojiContext$GuildProfile) other).guildId;
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
        return a.C(a.U("GuildProfile(guildId="), this.guildId, ")");
    }
}
