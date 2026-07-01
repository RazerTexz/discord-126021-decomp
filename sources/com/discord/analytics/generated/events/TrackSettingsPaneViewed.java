package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannelReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadataReceiver;
import com.discord.analytics.generated.traits.TrackOverlayClientMetadata;
import com.discord.analytics.generated.traits.TrackOverlayClientMetadataReceiver;
import com.discord.analytics.generated.traits.TrackSourceMetadata;
import com.discord.analytics.generated.traits.TrackSourceMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackSettingsPaneViewed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackSettingsPaneViewed implements AnalyticsSchema, TrackBaseReceiver, TrackGuildReceiver, TrackChannelReceiver, TrackLocationMetadataReceiver, TrackOverlayClientMetadataReceiver, TrackSourceMetadataReceiver {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private TrackLocationMetadata trackLocationMetadata;
    private TrackOverlayClientMetadata trackOverlayClientMetadata;
    private TrackSourceMetadata trackSourceMetadata;
    private final CharSequence settingsType = null;
    private final CharSequence originPane = null;
    private final CharSequence destinationPane = null;
    private final Boolean previewEnabled = null;
    private final transient String analyticsSchemaTypeName = "settings_pane_viewed";

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
        if (!(other instanceof TrackSettingsPaneViewed)) {
            return false;
        }
        TrackSettingsPaneViewed trackSettingsPaneViewed = (TrackSettingsPaneViewed) other;
        return m.areEqual(this.settingsType, trackSettingsPaneViewed.settingsType) && m.areEqual(this.originPane, trackSettingsPaneViewed.originPane) && m.areEqual(this.destinationPane, trackSettingsPaneViewed.destinationPane) && m.areEqual(this.previewEnabled, trackSettingsPaneViewed.previewEnabled);
    }

    public int hashCode() {
        CharSequence charSequence = this.settingsType;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.originPane;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.destinationPane;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Boolean bool = this.previewEnabled;
        return iHashCode3 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackSettingsPaneViewed(settingsType=");
        sbU.append(this.settingsType);
        sbU.append(", originPane=");
        sbU.append(this.originPane);
        sbU.append(", destinationPane=");
        sbU.append(this.destinationPane);
        sbU.append(", previewEnabled=");
        return a.D(sbU, this.previewEnabled, ")");
    }
}
