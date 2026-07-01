package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackPrivacyControlUpdated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackPrivacyControlUpdated implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence controlType = null;
    private final Boolean controlState = null;
    private final transient String analyticsSchemaTypeName = "privacy_control_updated";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackPrivacyControlUpdated)) {
            return false;
        }
        TrackPrivacyControlUpdated trackPrivacyControlUpdated = (TrackPrivacyControlUpdated) other;
        return Intrinsics3.areEqual(this.controlType, trackPrivacyControlUpdated.controlType) && Intrinsics3.areEqual(this.controlState, trackPrivacyControlUpdated.controlState);
    }

    public int hashCode() {
        CharSequence charSequence = this.controlType;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Boolean bool = this.controlState;
        return iHashCode + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackPrivacyControlUpdated(controlType=");
        sbU.append(this.controlType);
        sbU.append(", controlState=");
        return outline.D(sbU, this.controlState, ")");
    }
}
