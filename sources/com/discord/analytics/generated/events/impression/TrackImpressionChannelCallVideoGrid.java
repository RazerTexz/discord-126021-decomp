package com.discord.analytics.generated.events.impression;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackImpressionChannelCallVideoGrid.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackImpressionChannelCallVideoGrid implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long channelId = null;
    private final Long guildId = null;
    private final Long totalParticipants = null;
    private final Boolean canInvite = null;
    private final Boolean isAfkChannel = null;
    private final Long channelUserLimit = null;
    private final transient String analyticsSchemaTypeName = "impression_channel_call_video_grid";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackImpressionChannelCallVideoGrid)) {
            return false;
        }
        TrackImpressionChannelCallVideoGrid trackImpressionChannelCallVideoGrid = (TrackImpressionChannelCallVideoGrid) other;
        return m.areEqual(this.channelId, trackImpressionChannelCallVideoGrid.channelId) && m.areEqual(this.guildId, trackImpressionChannelCallVideoGrid.guildId) && m.areEqual(this.totalParticipants, trackImpressionChannelCallVideoGrid.totalParticipants) && m.areEqual(this.canInvite, trackImpressionChannelCallVideoGrid.canInvite) && m.areEqual(this.isAfkChannel, trackImpressionChannelCallVideoGrid.isAfkChannel) && m.areEqual(this.channelUserLimit, trackImpressionChannelCallVideoGrid.channelUserLimit);
    }

    public int hashCode() {
        Long l = this.channelId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.guildId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.totalParticipants;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Boolean bool = this.canInvite;
        int iHashCode4 = (iHashCode3 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.isAfkChannel;
        int iHashCode5 = (iHashCode4 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Long l4 = this.channelUserLimit;
        return iHashCode5 + (l4 != null ? l4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackImpressionChannelCallVideoGrid(channelId=");
        sbU.append(this.channelId);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", totalParticipants=");
        sbU.append(this.totalParticipants);
        sbU.append(", canInvite=");
        sbU.append(this.canInvite);
        sbU.append(", isAfkChannel=");
        sbU.append(this.isAfkChannel);
        sbU.append(", channelUserLimit=");
        return a.G(sbU, this.channelUserLimit, ")");
    }
}
