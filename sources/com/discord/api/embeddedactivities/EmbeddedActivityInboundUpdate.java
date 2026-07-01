package com.discord.api.embeddedactivities;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: compiled from: EmbeddedActivityInboundUpdate.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class EmbeddedActivityInboundUpdate {
    private final long channelId;
    private final EmbeddedActivity embeddedActivity;
    private final long guildId;
    private final List<Long> users;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final EmbeddedActivity getEmbeddedActivity() {
        return this.embeddedActivity;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    public final List<Long> d() {
        return this.users;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmbeddedActivityInboundUpdate)) {
            return false;
        }
        EmbeddedActivityInboundUpdate embeddedActivityInboundUpdate = (EmbeddedActivityInboundUpdate) other;
        return this.channelId == embeddedActivityInboundUpdate.channelId && Intrinsics3.areEqual(this.embeddedActivity, embeddedActivityInboundUpdate.embeddedActivity) && this.guildId == embeddedActivityInboundUpdate.guildId && Intrinsics3.areEqual(this.users, embeddedActivityInboundUpdate.users);
    }

    public int hashCode() {
        long j = this.channelId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        EmbeddedActivity embeddedActivity = this.embeddedActivity;
        int iHashCode = embeddedActivity != null ? embeddedActivity.hashCode() : 0;
        long j2 = this.guildId;
        int i2 = (((i + iHashCode) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        List<Long> list = this.users;
        return i2 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("EmbeddedActivityInboundUpdate(channelId=");
        sbU.append(this.channelId);
        sbU.append(", embeddedActivity=");
        sbU.append(this.embeddedActivity);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", users=");
        return outline.L(sbU, this.users, ")");
    }
}
