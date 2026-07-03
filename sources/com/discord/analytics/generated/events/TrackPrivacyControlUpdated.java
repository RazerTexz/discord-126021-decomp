package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackPrivacyControlUpdated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackPrivacyControlUpdated implements AnalyticsSchema, TrackBaseReceiver {
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
        return C12238m.areEqual(this.controlType, trackPrivacyControlUpdated.controlType) && C12238m.areEqual(this.controlState, trackPrivacyControlUpdated.controlState);
    }

    public int hashCode() {
        CharSequence charSequence = this.controlType;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Boolean bool = this.controlState;
        return iHashCode + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackPrivacyControlUpdated(controlType=");
        sbM833U.append(this.controlType);
        sbM833U.append(", controlState=");
        return C1643a.m816D(sbM833U, this.controlState, ")");
    }
}
