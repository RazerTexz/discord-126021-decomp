package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackDomainMigrated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackDomainMigrated implements AnalyticsSchema, TrackBaseReceiver {
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
        return C12238m.areEqual(this.success, trackDomainMigrated.success) && C12238m.areEqual(this.hasData, trackDomainMigrated.hasData) && C12238m.areEqual(this.currentIsNewer, trackDomainMigrated.currentIsNewer);
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
        StringBuilder sbM833U = C1643a.m833U("TrackDomainMigrated(success=");
        sbM833U.append(this.success);
        sbM833U.append(", hasData=");
        sbM833U.append(this.hasData);
        sbM833U.append(", currentIsNewer=");
        return C1643a.m816D(sbM833U, this.currentIsNewer, ")");
    }
}
