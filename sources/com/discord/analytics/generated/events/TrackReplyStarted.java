package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

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
        return m.areEqual(this.authorId, trackReplyStarted.authorId) && m.areEqual(this.channelId, trackReplyStarted.channelId);
    }

    public int hashCode() {
        Long l = this.authorId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.channelId;
        return iHashCode + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackReplyStarted(authorId=");
        sbU.append(this.authorId);
        sbU.append(", channelId=");
        return a.G(sbU, this.channelId, ")");
    }
}
