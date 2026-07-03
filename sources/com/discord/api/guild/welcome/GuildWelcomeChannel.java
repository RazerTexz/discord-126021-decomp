package com.discord.api.guild.welcome;

import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GuildWelcomeChannel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class GuildWelcomeChannel {
    private final long channelId;
    private final String description;
    private final Long emojiId;
    private final String emojiName;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final Long getEmojiId() {
        return this.emojiId;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final String getEmojiName() {
        return this.emojiName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildWelcomeChannel)) {
            return false;
        }
        GuildWelcomeChannel guildWelcomeChannel = (GuildWelcomeChannel) other;
        return this.channelId == guildWelcomeChannel.channelId && C12238m.areEqual(this.description, guildWelcomeChannel.description) && C12238m.areEqual(this.emojiId, guildWelcomeChannel.emojiId) && C12238m.areEqual(this.emojiName, guildWelcomeChannel.emojiName);
    }

    public int hashCode() {
        long j = this.channelId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.description;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        Long l = this.emojiId;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        String str2 = this.emojiName;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("GuildWelcomeChannel(channelId=");
        sbM833U.append(this.channelId);
        sbM833U.append(", description=");
        sbM833U.append(this.description);
        sbM833U.append(", emojiId=");
        sbM833U.append(this.emojiId);
        sbM833U.append(", emojiName=");
        return C1643a.m822J(sbM833U, this.emojiName, ")");
    }
}
