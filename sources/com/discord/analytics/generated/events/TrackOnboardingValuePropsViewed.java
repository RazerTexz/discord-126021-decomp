package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackOnboardingValuePropsViewed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackOnboardingValuePropsViewed implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Boolean skip = null;
    private final Long propsViewed = null;
    private final Long bucket = null;
    private final transient String analyticsSchemaTypeName = "onboarding_value_props_viewed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackOnboardingValuePropsViewed)) {
            return false;
        }
        TrackOnboardingValuePropsViewed trackOnboardingValuePropsViewed = (TrackOnboardingValuePropsViewed) other;
        return m.areEqual(this.skip, trackOnboardingValuePropsViewed.skip) && m.areEqual(this.propsViewed, trackOnboardingValuePropsViewed.propsViewed) && m.areEqual(this.bucket, trackOnboardingValuePropsViewed.bucket);
    }

    public int hashCode() {
        Boolean bool = this.skip;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Long l = this.propsViewed;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.bucket;
        return iHashCode2 + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackOnboardingValuePropsViewed(skip=");
        sbU.append(this.skip);
        sbU.append(", propsViewed=");
        sbU.append(this.propsViewed);
        sbU.append(", bucket=");
        return a.G(sbU, this.bucket, ")");
    }
}
