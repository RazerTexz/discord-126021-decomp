package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadataReceiver;
import com.discord.analytics.generated.traits.TrackLocationStackMetadata;
import com.discord.analytics.generated.traits.TrackLocationStackMetadataReceiver;
import com.discord.analytics.generated.traits.TrackSourceMetadata;
import com.discord.analytics.generated.traits.TrackSourceMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackPremiumFeatureUsageV2.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackPremiumFeatureUsageV2 implements AnalyticsSchema, TrackBaseReceiver, TrackLocationMetadataReceiver, TrackSourceMetadataReceiver, TrackLocationStackMetadataReceiver {
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
        return C12238m.areEqual(this.featureName, trackPremiumFeatureUsageV2.featureName) && C12238m.areEqual(this.featureTier, trackPremiumFeatureUsageV2.featureTier) && C12238m.areEqual(this.guildId, trackPremiumFeatureUsageV2.guildId) && C12238m.areEqual(this.rtcConnectionId, trackPremiumFeatureUsageV2.rtcConnectionId) && C12238m.areEqual(this.mediaSessionId, trackPremiumFeatureUsageV2.mediaSessionId) && C12238m.areEqual(this.inOverlay, trackPremiumFeatureUsageV2.inOverlay) && C12238m.areEqual(this.applicationName, trackPremiumFeatureUsageV2.applicationName);
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
        StringBuilder sbM833U = C1643a.m833U("TrackPremiumFeatureUsageV2(featureName=");
        sbM833U.append(this.featureName);
        sbM833U.append(", featureTier=");
        sbM833U.append(this.featureTier);
        sbM833U.append(", guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", rtcConnectionId=");
        sbM833U.append(this.rtcConnectionId);
        sbM833U.append(", mediaSessionId=");
        sbM833U.append(this.mediaSessionId);
        sbM833U.append(", inOverlay=");
        sbM833U.append(this.inOverlay);
        sbM833U.append(", applicationName=");
        return C1643a.m817E(sbM833U, this.applicationName, ")");
    }
}
