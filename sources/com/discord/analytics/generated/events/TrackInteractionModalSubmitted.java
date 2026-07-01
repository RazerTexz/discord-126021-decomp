package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackInteractionModalSubmitted.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackInteractionModalSubmitted implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long applicationId = null;
    private final Long interactionId = null;
    private final transient String analyticsSchemaTypeName = "interaction_modal_submitted";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackInteractionModalSubmitted)) {
            return false;
        }
        TrackInteractionModalSubmitted trackInteractionModalSubmitted = (TrackInteractionModalSubmitted) other;
        return m.areEqual(this.applicationId, trackInteractionModalSubmitted.applicationId) && m.areEqual(this.interactionId, trackInteractionModalSubmitted.interactionId);
    }

    public int hashCode() {
        Long l = this.applicationId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.interactionId;
        return iHashCode + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackInteractionModalSubmitted(applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", interactionId=");
        return a.G(sbU, this.interactionId, ")");
    }
}
