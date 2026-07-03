package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackApplicationGeneratedGenericEvent.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackApplicationGeneratedGenericEvent implements AnalyticsSchema, TrackBaseReceiver {
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
        return C12238m.areEqual(this.applicationId, trackApplicationGeneratedGenericEvent.applicationId) && C12238m.areEqual(this.activitySessionId, trackApplicationGeneratedGenericEvent.activitySessionId) && C12238m.areEqual(this.type, trackApplicationGeneratedGenericEvent.type) && C12238m.areEqual(this.name, trackApplicationGeneratedGenericEvent.name) && C12238m.areEqual(this.details, trackApplicationGeneratedGenericEvent.details);
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
        StringBuilder sbM833U = C1643a.m833U("TrackApplicationGeneratedGenericEvent(applicationId=");
        sbM833U.append(this.applicationId);
        sbM833U.append(", activitySessionId=");
        sbM833U.append(this.activitySessionId);
        sbM833U.append(", type=");
        sbM833U.append(this.type);
        sbM833U.append(", name=");
        sbM833U.append(this.name);
        sbM833U.append(", details=");
        return C1643a.m817E(sbM833U, this.details, ")");
    }
}
