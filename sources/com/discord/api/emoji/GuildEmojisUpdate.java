package com.discord.api.emoji;

import com.discord.api.guildhash.GuildHashes;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GuildEmojisUpdate.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class GuildEmojisUpdate {
    private final List<GuildEmoji> emojis;
    private final GuildHashes guildHashes;
    private final long guildId;

    /* JADX INFO: renamed from: a */
    public final List<GuildEmoji> m7816a() {
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
        return this.guildId == guildEmojisUpdate.guildId && C12238m.areEqual(this.emojis, guildEmojisUpdate.emojis) && C12238m.areEqual(this.guildHashes, guildEmojisUpdate.guildHashes);
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
        StringBuilder sbM833U = C1643a.m833U("GuildEmojisUpdate(guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", emojis=");
        sbM833U.append(this.emojis);
        sbM833U.append(", guildHashes=");
        sbM833U.append(this.guildHashes);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
