package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.analytics.generated.traits.TrackLocationStackMetadata;
import com.discord.analytics.generated.traits.TrackLocationStackMetadata2;
import com.discord.analytics.generated.traits.TrackSourceMetadata;
import com.discord.analytics.generated.traits.TrackSourceMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackPremiumFeatureUsageV2.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackPremiumFeatureUsageV2 implements AnalyticsSchema, TrackBase2, TrackLocationMetadata2, TrackSourceMetadata2, TrackLocationStackMetadata2 {
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private TrackLocationStackMetadata trackLocationStackMetadata;
    private TrackSourceMetadata trackSourceMetadata;
    private final CharSequence featureName = null;
    private final CharSequence featureTier = null;
    private final Long guildId = null;
    private final CharSequence rtcConnectionId = null;
    private final CharSequence mediaSessionId = null;
    private final Boolean inOverlay = null;
    private final CharSequence applicationName = null;
    private final transient String analyticsSchemaTypeName = "premium_feature_usage_v2";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackPremiumFeatureUsageV2)) {
            return false;
        }
        TrackPremiumFeatureUsageV2 trackPremiumFeatureUsageV2 = (TrackPremiumFeatureUsageV2) other;
        return Intrinsics3.areEqual(this.featureName, trackPremiumFeatureUsageV2.featureName) && Intrinsics3.areEqual(this.featureTier, trackPremiumFeatureUsageV2.featureTier) && Intrinsics3.areEqual(this.guildId, trackPremiumFeatureUsageV2.guildId) && Intrinsics3.areEqual(this.rtcConnectionId, trackPremiumFeatureUsageV2.rtcConnectionId) && Intrinsics3.areEqual(this.mediaSessionId, trackPremiumFeatureUsageV2.mediaSessionId) && Intrinsics3.areEqual(this.inOverlay, trackPremiumFeatureUsageV2.inOverlay) && Intrinsics3.areEqual(this.applicationName, trackPremiumFeatureUsageV2.applicationName);
    }

    public int hashCode() {
        CharSequence charSequence = this.featureName;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.featureTier;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l = this.guildId;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.rtcConnectionId;
        int iHashCode4 = (iHashCode3 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.mediaSessionId;
        int iHashCode5 = (iHashCode4 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Boolean bool = this.inOverlay;
        int iHashCode6 = (iHashCode5 + (bool != null ? bool.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.applicationName;
        return iHashCode6 + (charSequence5 != null ? charSequence5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackPremiumFeatureUsageV2(featureName=");
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
