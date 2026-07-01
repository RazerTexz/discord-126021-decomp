package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackDomainMigrated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackDomainMigrated implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Boolean success = null;
    private final Boolean hasData = null;
    private final Boolean currentIsNewer = null;
    private final transient String analyticsSchemaTypeName = "domain_migrated";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackDomainMigrated)) {
            return false;
        }
        TrackDomainMigrated trackDomainMigrated = (TrackDomainMigrated) other;
        return Intrinsics3.areEqual(this.success, trackDomainMigrated.success) && Intrinsics3.areEqual(this.hasData, trackDomainMigrated.hasData) && Intrinsics3.areEqual(this.currentIsNewer, trackDomainMigrated.currentIsNewer);
    }

    public int hashCode() {
        Boolean bool = this.success;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Boolean bool2 = this.hasData;
        int iHashCode2 = (iHashCode + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.currentIsNewer;
        return iHashCode2 + (bool3 != null ? bool3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackDomainMigrated(success=");
        sbU.append(this.success);
        sbU.append(", hasData=");
        sbU.append(this.hasData);
        sbU.append(", currentIsNewer=");
        return outline.D(sbU, this.currentIsNewer, ")");
    }
}
