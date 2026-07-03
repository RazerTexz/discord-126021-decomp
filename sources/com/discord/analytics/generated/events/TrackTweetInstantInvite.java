package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackTweetInstantInvite.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackTweetInstantInvite implements AnalyticsSchema, TrackBaseReceiver {
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
        return C12238m.areEqual(this.channel, trackTweetInstantInvite.channel) && C12238m.areEqual(this.server, trackTweetInstantInvite.server);
    }

    public int hashCode() {
        Long l = this.channel;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.server;
        return iHashCode + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackTweetInstantInvite(channel=");
        sbM833U.append(this.channel);
        sbM833U.append(", server=");
        return C1643a.m819G(sbM833U, this.server, ")");
    }
}
