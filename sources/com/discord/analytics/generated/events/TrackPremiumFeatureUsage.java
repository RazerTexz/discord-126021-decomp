package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.analytics.generated.traits.TrackSourceMetadata;
import com.discord.analytics.generated.traits.TrackSourceMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackPremiumFeatureUsage.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackPremiumFeatureUsage implements AnalyticsSchema, TrackBase2, TrackLocationMetadata2, TrackSourceMetadata2 {
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private TrackSourceMetadata trackSourceMetadata;
    private final CharSequence featureName = null;
    private final CharSequence featureTier = null;
    private final Long guildId = null;
    private final Long rtcConnectionId = null;
    private final Long mediaSessionId = null;
    private final Boolean inOverlay = null;
    private final CharSequence applicationName = null;
    private final transient String analyticsSchemaTypeName = "premium_feature_usage";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackPremiumFeatureUsage)) {
            return false;
        }
        TrackPremiumFeatureUsage trackPremiumFeatureUsage = (TrackPremiumFeatureUsage) other;
        return Intrinsics3.areEqual(this.featureName, trackPremiumFeatureUsage.featureName) && Intrinsics3.areEqual(this.featureTier, trackPremiumFeatureUsage.featureTier) && Intrinsics3.areEqual(this.guildId, trackPremiumFeatureUsage.guildId) && Intrinsics3.areEqual(this.rtcConnectionId, trackPremiumFeatureUsage.rtcConnectionId) && Intrinsics3.areEqual(this.mediaSessionId, trackPremiumFeatureUsage.mediaSessionId) && Intrinsics3.areEqual(this.inOverlay, trackPremiumFeatureUsage.inOverlay) && Intrinsics3.areEqual(this.applicationName, trackPremiumFeatureUsage.applicationName);
    }

    public int hashCode() {
        CharSequence charSequence = this.featureName;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.featureTier;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l = this.guildId;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.rtcConnectionId;
        int iHashCode4 = (iHashCode3 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.mediaSessionId;
        int iHashCode5 = (iHashCode4 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Boolean bool = this.inOverlay;
        int iHashCode6 = (iHashCode5 + (bool != null ? bool.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.applicationName;
        return iHashCode6 + (charSequence3 != null ? charSequence3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackPremiumFeatureUsage(featureName=");
        sbU.append(this.featureName);
        sbU.append(", featureTier=");
        sbU.append(this.featureTier);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", rtcConnectionId=");
        sbU.append(this.rtcConnectionId);
        sbU.append(", mediaSessionId=");
        sbU.append(this.mediaSessionId);
        sbU.append(", inOverlay=");
        sbU.append(this.inOverlay);
        sbU.append(", applicationName=");
        return outline.E(sbU, this.applicationName, ")");
    }
}
