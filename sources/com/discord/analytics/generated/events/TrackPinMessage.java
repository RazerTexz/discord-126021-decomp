package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackPinMessage.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackPinMessage implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long guildId = null;
    private final Long channelId = null;
    private final Long authorId = null;
    private final Boolean pinned = null;
    private final transient String analyticsSchemaTypeName = "pin_message";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackPinMessage)) {
            return false;
        }
        TrackPinMessage trackPinMessage = (TrackPinMessage) other;
        return m.areEqual(this.guildId, trackPinMessage.guildId) && m.areEqual(this.channelId, trackPinMessage.channelId) && m.areEqual(this.authorId, trackPinMessage.authorId) && m.areEqual(this.pinned, trackPinMessage.pinned);
    }

    public int hashCode() {
        Long l = this.guildId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.channelId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.authorId;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Boolean bool = this.pinned;
        return iHashCode3 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackPinMessage(guildId=");
        sbU.append(this.guildId);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", authorId=");
        sbU.append(this.authorId);
        sbU.append(", pinned=");
        return a.D(sbU, this.pinned, ")");
    }
}
