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

/* JADX INFO: compiled from: TrackImpressionActivityBoostingUpsell.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackImpressionActivityBoostingUpsell implements AnalyticsSchema, TrackBaseReceiver, TrackGuildReceiver, TrackChannelReceiver, TrackLocationMetadataReceiver, TrackImpressionMetadataReceiver {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private TrackImpressionMetadata trackImpressionMetadata;
    private TrackLocationMetadata trackLocationMetadata;
    private final Long applicationId = null;
    private final CharSequence sourceSection = null;
    private final Long tier = null;
    private final transient String analyticsSchemaTypeName = "impression_activity_boosting_upsell";

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
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackImpressionActivityBoostingUpsell)) {
            return false;
        }
        TrackImpressionActivityBoostingUpsell trackImpressionActivityBoostingUpsell = (TrackImpressionActivityBoostingUpsell) other;
        return m.areEqual(this.applicationId, trackImpressionActivityBoostingUpsell.applicationId) && m.areEqual(this.sourceSection, trackImpressionActivityBoostingUpsell.sourceSection) && m.areEqual(this.tier, trackImpressionActivityBoostingUpsell.tier);
    }

    public int hashCode() {
        Long l = this.applicationId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.sourceSection;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l2 = this.tier;
        return iHashCode2 + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackImpressionActivityBoostingUpsell(applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", sourceSection=");
        sbU.append(this.sourceSection);
        sbU.append(", tier=");
        return a.G(sbU, this.tier, ")");
    }
}
