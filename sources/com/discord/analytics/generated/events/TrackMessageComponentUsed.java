package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackMessageComponentUsed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackMessageComponentUsed implements AnalyticsSchema, TrackBaseReceiver {
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
        return C12238m.areEqual(this.applicationId, trackMessageComponentUsed.applicationId) && C12238m.areEqual(this.interactionId, trackMessageComponentUsed.interactionId) && C12238m.areEqual(this.actionType, trackMessageComponentUsed.actionType) && C12238m.areEqual(this.messageId, trackMessageComponentUsed.messageId);
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
        StringBuilder sbM833U = C1643a.m833U("TrackMessageComponentUsed(applicationId=");
        sbM833U.append(this.applicationId);
        sbM833U.append(", interactionId=");
        sbM833U.append(this.interactionId);
        sbM833U.append(", actionType=");
        sbM833U.append(this.actionType);
        sbM833U.append(", messageId=");
        return C1643a.m819G(sbM833U, this.messageId, ")");
    }
}
