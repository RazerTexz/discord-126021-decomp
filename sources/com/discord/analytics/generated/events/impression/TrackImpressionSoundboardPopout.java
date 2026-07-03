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

/* JADX INFO: compiled from: TrackImpressionSoundboardPopout.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackImpressionSoundboardPopout implements AnalyticsSchema, TrackBaseReceiver, TrackGuildReceiver, TrackImpressionMetadataReceiver, TrackLocationMetadataReceiver, TrackChannelReceiver {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private TrackImpressionMetadata trackImpressionMetadata;
    private TrackLocationMetadata trackLocationMetadata;
    private final CharSequence mediaSessionId = null;
    private final CharSequence source = null;
    private final transient String analyticsSchemaTypeName = "impression_soundboard_popout";

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
        if (!(other instanceof TrackImpressionSoundboardPopout)) {
            return false;
        }
        TrackImpressionSoundboardPopout trackImpressionSoundboardPopout = (TrackImpressionSoundboardPopout) other;
        return C12238m.areEqual(this.mediaSessionId, trackImpressionSoundboardPopout.mediaSessionId) && C12238m.areEqual(this.source, trackImpressionSoundboardPopout.source);
    }

    public int hashCode() {
        CharSequence charSequence = this.mediaSessionId;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.source;
        return iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackImpressionSoundboardPopout(mediaSessionId=");
        sbM833U.append(this.mediaSessionId);
        sbM833U.append(", source=");
        return C1643a.m817E(sbM833U, this.source, ")");
    }
}
