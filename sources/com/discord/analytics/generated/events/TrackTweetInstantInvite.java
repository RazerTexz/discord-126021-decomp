package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackTweetInstantInvite.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackTweetInstantInvite implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long channel = null;
    private final Long server = null;
    private final transient String analyticsSchemaTypeName = "tweet_instant_invite";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackTweetInstantInvite)) {
            return false;
        }
        TrackTweetInstantInvite trackTweetInstantInvite = (TrackTweetInstantInvite) other;
        return Intrinsics3.areEqual(this.channel, trackTweetInstantInvite.channel) && Intrinsics3.areEqual(this.server, trackTweetInstantInvite.server);
    }

    public int hashCode() {
        Long l = this.channel;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.server;
        return iHashCode + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackTweetInstantInvite(channel=");
        sbU.append(this.channel);
        sbU.append(", server=");
        return outline.G(sbU, this.server, ")");
    }
}
