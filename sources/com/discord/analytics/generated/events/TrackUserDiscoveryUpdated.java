package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackUserDiscoveryUpdated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackUserDiscoveryUpdated implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Boolean hasName = null;
    private final Boolean discoverableEmail = null;
    private final Boolean discoverablePhone = null;
    private final Boolean contactSyncEnabled = null;
    private final transient String analyticsSchemaTypeName = "user_discovery_updated";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackUserDiscoveryUpdated)) {
            return false;
        }
        TrackUserDiscoveryUpdated trackUserDiscoveryUpdated = (TrackUserDiscoveryUpdated) other;
        return Intrinsics3.areEqual(this.hasName, trackUserDiscoveryUpdated.hasName) && Intrinsics3.areEqual(this.discoverableEmail, trackUserDiscoveryUpdated.discoverableEmail) && Intrinsics3.areEqual(this.discoverablePhone, trackUserDiscoveryUpdated.discoverablePhone) && Intrinsics3.areEqual(this.contactSyncEnabled, trackUserDiscoveryUpdated.contactSyncEnabled);
    }

    public int hashCode() {
        Boolean bool = this.hasName;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Boolean bool2 = this.discoverableEmail;
        int iHashCode2 = (iHashCode + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.discoverablePhone;
        int iHashCode3 = (iHashCode2 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Boolean bool4 = this.contactSyncEnabled;
        return iHashCode3 + (bool4 != null ? bool4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackUserDiscoveryUpdated(hasName=");
        sbU.append(this.hasName);
        sbU.append(", discoverableEmail=");
        sbU.append(this.discoverableEmail);
        sbU.append(", discoverablePhone=");
        sbU.append(this.discoverablePhone);
        sbU.append(", contactSyncEnabled=");
        return outline.D(sbU, this.contactSyncEnabled, ")");
    }
}
