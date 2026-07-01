package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackStreamSettingsUpdate.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackStreamSettingsUpdate implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long userPremiumTier = null;
    private final Long guildPremiumTier = null;
    private final Long streamQualityUserPremiumTier = null;
    private final Long streamQualityGuildPremiumTier = null;
    private final Long streamQualityPreset = null;
    private final Long streamQualityResolution = null;
    private final Long streamQualityFrameRate = null;
    private final transient String analyticsSchemaTypeName = "stream_settings_update";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackStreamSettingsUpdate)) {
            return false;
        }
        TrackStreamSettingsUpdate trackStreamSettingsUpdate = (TrackStreamSettingsUpdate) other;
        return m.areEqual(this.userPremiumTier, trackStreamSettingsUpdate.userPremiumTier) && m.areEqual(this.guildPremiumTier, trackStreamSettingsUpdate.guildPremiumTier) && m.areEqual(this.streamQualityUserPremiumTier, trackStreamSettingsUpdate.streamQualityUserPremiumTier) && m.areEqual(this.streamQualityGuildPremiumTier, trackStreamSettingsUpdate.streamQualityGuildPremiumTier) && m.areEqual(this.streamQualityPreset, trackStreamSettingsUpdate.streamQualityPreset) && m.areEqual(this.streamQualityResolution, trackStreamSettingsUpdate.streamQualityResolution) && m.areEqual(this.streamQualityFrameRate, trackStreamSettingsUpdate.streamQualityFrameRate);
    }

    public int hashCode() {
        Long l = this.userPremiumTier;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.guildPremiumTier;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.streamQualityUserPremiumTier;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.streamQualityGuildPremiumTier;
        int iHashCode4 = (iHashCode3 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.streamQualityPreset;
        int iHashCode5 = (iHashCode4 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.streamQualityResolution;
        int iHashCode6 = (iHashCode5 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.streamQualityFrameRate;
        return iHashCode6 + (l7 != null ? l7.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackStreamSettingsUpdate(userPremiumTier=");
        sbU.append(this.userPremiumTier);
        sbU.append(", guildPremiumTier=");
        sbU.append(this.guildPremiumTier);
        sbU.append(", streamQualityUserPremiumTier=");
        sbU.append(this.streamQualityUserPremiumTier);
        sbU.append(", streamQualityGuildPremiumTier=");
        sbU.append(this.streamQualityGuildPremiumTier);
        sbU.append(", streamQualityPreset=");
        sbU.append(this.streamQualityPreset);
        sbU.append(", streamQualityResolution=");
        sbU.append(this.streamQualityResolution);
        sbU.append(", streamQualityFrameRate=");
        return a.G(sbU, this.streamQualityFrameRate, ")");
    }
}
