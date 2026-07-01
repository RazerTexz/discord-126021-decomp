package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackDiscoverySetupCtaClicked.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackDiscoverySetupCtaClicked implements AnalyticsSchema, TrackBase2, TrackGuild2 {
    private TrackBase trackBase;
    private TrackGuild trackGuild;
    private final CharSequence ctaName = null;
    private final CharSequence discoverySettingsView = null;
    private final CharSequence helpCenterArticleId = null;
    private final CharSequence modalStep = null;
    private final transient String analyticsSchemaTypeName = "discovery_setup_cta_clicked";

    @Override // com.discord.analytics.generated.traits.TrackGuild2
    /* JADX INFO: renamed from: a, reason: from getter */
    public TrackGuild getTrackGuild() {
        return this.trackGuild;
    }

    @Override // com.discord.analytics.generated.traits.TrackGuild2
    public void c(TrackGuild trackGuild) {
        this.trackGuild = trackGuild;
    }

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackDiscoverySetupCtaClicked)) {
            return false;
        }
        TrackDiscoverySetupCtaClicked trackDiscoverySetupCtaClicked = (TrackDiscoverySetupCtaClicked) other;
        return Intrinsics3.areEqual(this.ctaName, trackDiscoverySetupCtaClicked.ctaName) && Intrinsics3.areEqual(this.discoverySettingsView, trackDiscoverySetupCtaClicked.discoverySettingsView) && Intrinsics3.areEqual(this.helpCenterArticleId, trackDiscoverySetupCtaClicked.helpCenterArticleId) && Intrinsics3.areEqual(this.modalStep, trackDiscoverySetupCtaClicked.modalStep);
    }

    public int hashCode() {
        CharSequence charSequence = this.ctaName;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.discoverySettingsView;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.helpCenterArticleId;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.modalStep;
        return iHashCode3 + (charSequence4 != null ? charSequence4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackDiscoverySetupCtaClicked(ctaName=");
        sbU.append(this.ctaName);
        sbU.append(", discoverySettingsView=");
        sbU.append(this.discoverySettingsView);
        sbU.append(", helpCenterArticleId=");
        sbU.append(this.helpCenterArticleId);
        sbU.append(", modalStep=");
        return outline.E(sbU, this.modalStep, ")");
    }
}
