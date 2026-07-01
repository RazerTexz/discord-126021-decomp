package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackApplicationGeneratedGenericEvent.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackApplicationGeneratedGenericEvent implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long applicationId = null;
    private final CharSequence activitySessionId = null;
    private final CharSequence type = null;
    private final CharSequence name = null;
    private final CharSequence details = null;
    private final transient String analyticsSchemaTypeName = "application_generated_generic_event";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackApplicationGeneratedGenericEvent)) {
            return false;
        }
        TrackApplicationGeneratedGenericEvent trackApplicationGeneratedGenericEvent = (TrackApplicationGeneratedGenericEvent) other;
        return Intrinsics3.areEqual(this.applicationId, trackApplicationGeneratedGenericEvent.applicationId) && Intrinsics3.areEqual(this.activitySessionId, trackApplicationGeneratedGenericEvent.activitySessionId) && Intrinsics3.areEqual(this.type, trackApplicationGeneratedGenericEvent.type) && Intrinsics3.areEqual(this.name, trackApplicationGeneratedGenericEvent.name) && Intrinsics3.areEqual(this.details, trackApplicationGeneratedGenericEvent.details);
    }

    public int hashCode() {
        Long l = this.applicationId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.activitySessionId;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.type;
        int iHashCode3 = (iHashCode2 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.name;
        int iHashCode4 = (iHashCode3 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.details;
        return iHashCode4 + (charSequence4 != null ? charSequence4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackApplicationGeneratedGenericEvent(applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", activitySessionId=");
        sbU.append(this.activitySessionId);
        sbU.append(", type=");
        sbU.append(this.type);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", details=");
        return outline.E(sbU, this.details, ")");
    }
}
