package com.discord.analytics.generated.events.impression;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannelReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.analytics.generated.traits.TrackImpressionMetadata;
import com.discord.analytics.generated.traits.TrackImpressionMetadataReceiver;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackImpressionEnableCreatorMonetizationCreateRequestLanding.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackImpressionEnableCreatorMonetizationCreateRequestLanding implements AnalyticsSchema, TrackBaseReceiver, TrackGuildReceiver, TrackChannelReceiver, TrackLocationMetadataReceiver, TrackImpressionMetadataReceiver {
    private final transient String analyticsSchemaTypeName;
    private final Boolean isApplicationPending;
    private final Boolean isEligible;
    private final CharSequence monetizationRequirementsJson;
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private TrackImpressionMetadata trackImpressionMetadata;
    private TrackLocationMetadata trackLocationMetadata;

    public TrackImpressionEnableCreatorMonetizationCreateRequestLanding() {
        this.isEligible = null;
        this.isApplicationPending = null;
        this.monetizationRequirementsJson = null;
        this.analyticsSchemaTypeName = "impression_enable_creator_monetization_create_request_landing";
    }

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
        if (!(other instanceof TrackImpressionEnableCreatorMonetizationCreateRequestLanding)) {
            return false;
        }
        TrackImpressionEnableCreatorMonetizationCreateRequestLanding trackImpressionEnableCreatorMonetizationCreateRequestLanding = (TrackImpressionEnableCreatorMonetizationCreateRequestLanding) other;
        return C12238m.areEqual(this.isEligible, trackImpressionEnableCreatorMonetizationCreateRequestLanding.isEligible) && C12238m.areEqual(this.isApplicationPending, trackImpressionEnableCreatorMonetizationCreateRequestLanding.isApplicationPending) && C12238m.areEqual(this.monetizationRequirementsJson, trackImpressionEnableCreatorMonetizationCreateRequestLanding.monetizationRequirementsJson);
    }

    public int hashCode() {
        Boolean bool = this.isEligible;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Boolean bool2 = this.isApplicationPending;
        int iHashCode2 = (iHashCode + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        CharSequence charSequence = this.monetizationRequirementsJson;
        return iHashCode2 + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackImpressionEnableCreatorMonetizationCreateRequestLanding(isEligible=");
        sbM833U.append(this.isEligible);
        sbM833U.append(", isApplicationPending=");
        sbM833U.append(this.isApplicationPending);
        sbM833U.append(", monetizationRequirementsJson=");
        return C1643a.m817E(sbM833U, this.monetizationRequirementsJson, ")");
    }

    public TrackImpressionEnableCreatorMonetizationCreateRequestLanding(Boolean bool, Boolean bool2, CharSequence charSequence) {
        this.isEligible = bool;
        this.isApplicationPending = bool2;
        this.monetizationRequirementsJson = charSequence;
        this.analyticsSchemaTypeName = "impression_enable_creator_monetization_create_request_landing";
    }
}
