package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackUserDiscoveryUpdated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackUserDiscoveryUpdated implements AnalyticsSchema, TrackBaseReceiver {
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
        return C12238m.areEqual(this.hasName, trackUserDiscoveryUpdated.hasName) && C12238m.areEqual(this.discoverableEmail, trackUserDiscoveryUpdated.discoverableEmail) && C12238m.areEqual(this.discoverablePhone, trackUserDiscoveryUpdated.discoverablePhone) && C12238m.areEqual(this.contactSyncEnabled, trackUserDiscoveryUpdated.contactSyncEnabled);
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
        StringBuilder sbM833U = C1643a.m833U("TrackUserDiscoveryUpdated(hasName=");
        sbM833U.append(this.hasName);
        sbM833U.append(", discoverableEmail=");
        sbM833U.append(this.discoverableEmail);
        sbM833U.append(", discoverablePhone=");
        sbM833U.append(this.discoverablePhone);
        sbM833U.append(", contactSyncEnabled=");
        return C1643a.m816D(sbM833U, this.contactSyncEnabled, ")");
    }
}
