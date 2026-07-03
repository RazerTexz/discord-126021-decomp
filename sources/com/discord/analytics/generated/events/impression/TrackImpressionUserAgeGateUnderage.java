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

/* JADX INFO: compiled from: TrackImpressionUserAgeGateUnderage.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackImpressionUserAgeGateUnderage implements AnalyticsSchema, TrackBaseReceiver, TrackGuildReceiver, TrackChannelReceiver, TrackLocationMetadataReceiver, TrackImpressionMetadataReceiver {
    private final transient String analyticsSchemaTypeName;
    private final Boolean existingUser;
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private TrackImpressionMetadata trackImpressionMetadata;
    private TrackLocationMetadata trackLocationMetadata;

    public TrackImpressionUserAgeGateUnderage(Boolean bool) {
        this.existingUser = bool;
        this.analyticsSchemaTypeName = "impression_user_age_gate_underage";
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

    /* JADX INFO: renamed from: e */
    public void m7526e(TrackImpressionMetadata trackImpressionMetadata) {
        this.trackImpressionMetadata = trackImpressionMetadata;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackImpressionUserAgeGateUnderage) && C12238m.areEqual(this.existingUser, ((TrackImpressionUserAgeGateUnderage) other).existingUser);
        }
        return true;
    }

    public int hashCode() {
        Boolean bool = this.existingUser;
        if (bool != null) {
            return bool.hashCode();
        }
        return 0;
    }

    public String toString() {
        return C1643a.m816D(C1643a.m833U("TrackImpressionUserAgeGateUnderage(existingUser="), this.existingUser, ")");
    }

    public TrackImpressionUserAgeGateUnderage() {
        this(null);
    }
}
