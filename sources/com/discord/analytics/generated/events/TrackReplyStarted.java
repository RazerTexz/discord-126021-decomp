package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackReplyStarted.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackReplyStarted implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long authorId = null;
    private final Long channelId = null;
    private final transient String analyticsSchemaTypeName = "reply_started";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackReplyStarted)) {
            return false;
        }
        TrackReplyStarted trackReplyStarted = (TrackReplyStarted) other;
        return C12238m.areEqual(this.authorId, trackReplyStarted.authorId) && C12238m.areEqual(this.channelId, trackReplyStarted.channelId);
    }

    public int hashCode() {
        Long l = this.authorId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.channelId;
        return iHashCode + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackReplyStarted(authorId=");
        sbM833U.append(this.authorId);
        sbM833U.append(", channelId=");
        return C1643a.m819G(sbM833U, this.channelId, ")");
    }
}
