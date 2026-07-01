package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackAppLandingViewed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackAppLandingViewed implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long lastLogoutTs = null;
    private final transient String analyticsSchemaTypeName = "app_landing_viewed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackAppLandingViewed) && Intrinsics3.areEqual(this.lastLogoutTs, ((TrackAppLandingViewed) other).lastLogoutTs);
        }
        return true;
    }

    public int hashCode() {
        Long l = this.lastLogoutTs;
        if (l != null) {
            return l.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.G(outline.U("TrackAppLandingViewed(lastLogoutTs="), this.lastLogoutTs, ")");
    }
}
