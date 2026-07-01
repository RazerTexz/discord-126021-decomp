package com.discord.analytics.generated.events.impression;

import b.d.b.a.a;
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
import d0.z.d.m;

/* JADX INFO: compiled from: TrackImpressionEnableCreatorMonetizationAcceptTermsLanding.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackImpressionEnableCreatorMonetizationAcceptTermsLanding implements AnalyticsSchema, TrackBaseReceiver, TrackGuildReceiver, TrackChannelReceiver, TrackLocationMetadataReceiver, TrackImpressionMetadataReceiver {
    private final transient String analyticsSchemaTypeName;
    private final CharSequence creatorMonetizationEnableRequestId;
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private TrackImpressionMetadata trackImpressionMetadata;
    private TrackLocationMetadata trackLocationMetadata;

    public TrackImpressionEnableCreatorMonetizationAcceptTermsLanding() {
        this.creatorMonetizationEnableRequestId = null;
        this.analyticsSchemaTypeName = "impression_enable_creator_monetization_accept_terms_landing";
    }

    @Override // com.discord.analytics.generated.traits.TrackGuildReceiver
    /* JADX INFO: renamed from: a, reason: from getter */
    public TrackGuild getTrackGuild() {
        return this.trackGuild;
    }

    @Override // com.discord.analytics.generated.traits.TrackGuildReceiver
    public void c(TrackGuild trackGuild) {
        this.trackGuild = trackGuild;
    }

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackImpressionEnableCreatorMonetizationAcceptTermsLanding) && m.areEqual(this.creatorMonetizationEnableRequestId, ((TrackImpressionEnableCreatorMonetizationAcceptTermsLanding) other).creatorMonetizationEnableRequestId);
        }
        return true;
    }

    public int hashCode() {
        CharSequence charSequence = this.creatorMonetizationEnableRequestId;
        if (charSequence != null) {
            return charSequence.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.E(a.U("TrackImpressionEnableCreatorMonetizationAcceptTermsLanding(creatorMonetizationEnableRequestId="), this.creatorMonetizationEnableRequestId, ")");
    }

    public TrackImpressionEnableCreatorMonetizationAcceptTermsLanding(CharSequence charSequence) {
        this.creatorMonetizationEnableRequestId = charSequence;
        this.analyticsSchemaTypeName = "impression_enable_creator_monetization_accept_terms_landing";
    }
}
