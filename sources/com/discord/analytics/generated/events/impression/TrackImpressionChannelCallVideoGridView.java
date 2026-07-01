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

/* JADX INFO: compiled from: TrackImpressionChannelCallVideoGridView.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackImpressionChannelCallVideoGridView implements AnalyticsSchema, TrackBaseReceiver, TrackGuildReceiver, TrackChannelReceiver, TrackLocationMetadataReceiver, TrackImpressionMetadataReceiver {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private TrackImpressionMetadata trackImpressionMetadata;
    private TrackLocationMetadata trackLocationMetadata;
    private final Long totalParticipants = null;
    private final Boolean canInvite = null;
    private final Boolean isAfkChannel = null;
    private final Long channelUserLimit = null;
    private final transient String analyticsSchemaTypeName = "impression_channel_call_video_grid_view";

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
        if (!(other instanceof TrackImpressionChannelCallVideoGridView)) {
            return false;
        }
        TrackImpressionChannelCallVideoGridView trackImpressionChannelCallVideoGridView = (TrackImpressionChannelCallVideoGridView) other;
        return m.areEqual(this.totalParticipants, trackImpressionChannelCallVideoGridView.totalParticipants) && m.areEqual(this.canInvite, trackImpressionChannelCallVideoGridView.canInvite) && m.areEqual(this.isAfkChannel, trackImpressionChannelCallVideoGridView.isAfkChannel) && m.areEqual(this.channelUserLimit, trackImpressionChannelCallVideoGridView.channelUserLimit);
    }

    public int hashCode() {
        Long l = this.totalParticipants;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Boolean bool = this.canInvite;
        int iHashCode2 = (iHashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.isAfkChannel;
        int iHashCode3 = (iHashCode2 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Long l2 = this.channelUserLimit;
        return iHashCode3 + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackImpressionChannelCallVideoGridView(totalParticipants=");
        sbU.append(this.totalParticipants);
        sbU.append(", canInvite=");
        sbU.append(this.canInvite);
        sbU.append(", isAfkChannel=");
        sbU.append(this.isAfkChannel);
        sbU.append(", channelUserLimit=");
        return a.G(sbU, this.channelUserLimit, ")");
    }
}
