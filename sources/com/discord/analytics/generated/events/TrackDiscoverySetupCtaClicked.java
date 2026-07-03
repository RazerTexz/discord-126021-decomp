package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackDiscoverySetupCtaClicked.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackDiscoverySetupCtaClicked implements AnalyticsSchema, TrackBaseReceiver, TrackGuildReceiver {
    private TrackBase trackBase;
    private TrackGuild trackGuild;
    private final CharSequence ctaName = null;
    private final CharSequence discoverySettingsView = null;
    private final CharSequence helpCenterArticleId = null;
    private final CharSequence modalStep = null;
    private final transient String analyticsSchemaTypeName = "discovery_setup_cta_clicked";

    @Override // com.discord.analytics.generated.traits.TrackGuildReceiver
    /* JADX INFO: renamed from: a, reason: from getter */
    public TrackGuild getTrackGuild() {
        return this.trackGuild;
    }

    @Override // com.discord.analytics.generated.traits.TrackGuildReceiver
    /* JADX INFO: renamed from: c */
    public void mo7508c(TrackGuild trackGuild) {
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
        return C12238m.areEqual(this.ctaName, trackDiscoverySetupCtaClicked.ctaName) && C12238m.areEqual(this.discoverySettingsView, trackDiscoverySetupCtaClicked.discoverySettingsView) && C12238m.areEqual(this.helpCenterArticleId, trackDiscoverySetupCtaClicked.helpCenterArticleId) && C12238m.areEqual(this.modalStep, trackDiscoverySetupCtaClicked.modalStep);
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
        StringBuilder sbM833U = C1643a.m833U("TrackDiscoverySetupCtaClicked(ctaName=");
        sbM833U.append(this.ctaName);
        sbM833U.append(", discoverySettingsView=");
        sbM833U.append(this.discoverySettingsView);
        sbM833U.append(", helpCenterArticleId=");
        sbM833U.append(this.helpCenterArticleId);
        sbM833U.append(", modalStep=");
        return C1643a.m817E(sbM833U, this.modalStep, ")");
    }
}
