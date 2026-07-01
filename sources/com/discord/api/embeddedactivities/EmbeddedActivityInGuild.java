package com.discord.api.embeddedactivities;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: compiled from: EmbeddedActivityInGuild.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class EmbeddedActivityInGuild {
    private final long channelId;
    private final EmbeddedActivity embeddedActivity;
    private final List<Long> users;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final EmbeddedActivity getEmbeddedActivity() {
        return this.embeddedActivity;
    }

    public final List<Long> c() {
        return this.users;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmbeddedActivityInGuild)) {
            return false;
        }
        EmbeddedActivityInGuild embeddedActivityInGuild = (EmbeddedActivityInGuild) other;
        return this.channelId == embeddedActivityInGuild.channelId && Intrinsics3.areEqual(this.embeddedActivity, embeddedActivityInGuild.embeddedActivity) && Intrinsics3.areEqual(this.users, embeddedActivityInGuild.users);
    }

    public int hashCode() {
        long j = this.channelId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        EmbeddedActivity embeddedActivity = this.embeddedActivity;
        int iHashCode = (i + (embeddedActivity != null ? embeddedActivity.hashCode() : 0)) * 31;
        List<Long> list = this.users;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("EmbeddedActivityInGuild(channelId=");
        sbU.append(this.channelId);
        sbU.append(", embeddedActivity=");
        sbU.append(this.embeddedActivity);
        sbU.append(", users=");
        return outline.L(sbU, this.users, ")");
    }
}
