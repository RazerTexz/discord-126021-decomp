package com.discord.api.emoji;

import b.d.b.a.outline;
import com.discord.api.guildhash.GuildHashes;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: compiled from: GuildEmojisUpdate.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class GuildEmojisUpdate {
    private final List<GuildEmoji> emojis;
    private final GuildHashes guildHashes;
    private final long guildId;

    public final List<GuildEmoji> a() {
        return this.emojis;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final GuildHashes getGuildHashes() {
        return this.guildHashes;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildEmojisUpdate)) {
            return false;
        }
        GuildEmojisUpdate guildEmojisUpdate = (GuildEmojisUpdate) other;
        return this.guildId == guildEmojisUpdate.guildId && Intrinsics3.areEqual(this.emojis, guildEmojisUpdate.emojis) && Intrinsics3.areEqual(this.guildHashes, guildEmojisUpdate.guildHashes);
    }

    public int hashCode() {
        long j = this.guildId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        List<GuildEmoji> list = this.emojis;
        int iHashCode = (i + (list != null ? list.hashCode() : 0)) * 31;
        GuildHashes guildHashes = this.guildHashes;
        return iHashCode + (guildHashes != null ? guildHashes.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildEmojisUpdate(guildId=");
        sbU.append(this.guildId);
        sbU.append(", emojis=");
        sbU.append(this.emojis);
        sbU.append(", guildHashes=");
        sbU.append(this.guildHashes);
        sbU.append(")");
        return sbU.toString();
    }
}
