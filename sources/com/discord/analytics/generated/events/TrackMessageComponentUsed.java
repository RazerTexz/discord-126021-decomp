package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackMessageComponentUsed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackMessageComponentUsed implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long applicationId = null;
    private final Long interactionId = null;
    private final Long actionType = null;
    private final Long messageId = null;
    private final transient String analyticsSchemaTypeName = "message_component_used";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackMessageComponentUsed)) {
            return false;
        }
        TrackMessageComponentUsed trackMessageComponentUsed = (TrackMessageComponentUsed) other;
        return Intrinsics3.areEqual(this.applicationId, trackMessageComponentUsed.applicationId) && Intrinsics3.areEqual(this.interactionId, trackMessageComponentUsed.interactionId) && Intrinsics3.areEqual(this.actionType, trackMessageComponentUsed.actionType) && Intrinsics3.areEqual(this.messageId, trackMessageComponentUsed.messageId);
    }

    public int hashCode() {
        Long l = this.applicationId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.interactionId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.actionType;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.messageId;
        return iHashCode3 + (l4 != null ? l4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackMessageComponentUsed(applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", interactionId=");
        sbU.append(this.interactionId);
        sbU.append(", actionType=");
        sbU.append(this.actionType);
        sbU.append(", messageId=");
        return outline.G(sbU, this.messageId, ")");
    }
}
