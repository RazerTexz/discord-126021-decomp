package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackContactSyncToggled.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackContactSyncToggled implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Boolean isEnabled = null;
    private final Boolean amDiscoverableEmail = null;
    private final Boolean amDiscoverablePhone = null;
    private final transient String analyticsSchemaTypeName = "contact_sync_toggled";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackContactSyncToggled)) {
            return false;
        }
        TrackContactSyncToggled trackContactSyncToggled = (TrackContactSyncToggled) other;
        return Intrinsics3.areEqual(this.isEnabled, trackContactSyncToggled.isEnabled) && Intrinsics3.areEqual(this.amDiscoverableEmail, trackContactSyncToggled.amDiscoverableEmail) && Intrinsics3.areEqual(this.amDiscoverablePhone, trackContactSyncToggled.amDiscoverablePhone);
    }

    public int hashCode() {
        Boolean bool = this.isEnabled;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Boolean bool2 = this.amDiscoverableEmail;
        int iHashCode2 = (iHashCode + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.amDiscoverablePhone;
        return iHashCode2 + (bool3 != null ? bool3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackContactSyncToggled(isEnabled=");
        sbU.append(this.isEnabled);
        sbU.append(", amDiscoverableEmail=");
        sbU.append(this.amDiscoverableEmail);
        sbU.append(", amDiscoverablePhone=");
        return outline.D(sbU, this.amDiscoverablePhone, ")");
    }
}
