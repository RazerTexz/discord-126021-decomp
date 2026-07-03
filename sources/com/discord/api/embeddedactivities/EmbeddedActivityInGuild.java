package com.discord.api.embeddedactivities;

import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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

    /* JADX INFO: renamed from: c */
    public final List<Long> m7804c() {
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
        return this.channelId == embeddedActivityInGuild.channelId && C12238m.areEqual(this.embeddedActivity, embeddedActivityInGuild.embeddedActivity) && C12238m.areEqual(this.users, embeddedActivityInGuild.users);
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
        StringBuilder sbM833U = C1643a.m833U("EmbeddedActivityInGuild(channelId=");
        sbM833U.append(this.channelId);
        sbM833U.append(", embeddedActivity=");
        sbM833U.append(this.embeddedActivity);
        sbM833U.append(", users=");
        return C1643a.m824L(sbM833U, this.users, ")");
    }
}
