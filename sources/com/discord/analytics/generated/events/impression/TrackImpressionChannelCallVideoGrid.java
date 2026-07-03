package com.discord.analytics.generated.events.impression;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.channelId, trackImpressionChannelCallVideoGrid.channelId) && C12238m.areEqual(this.guildId, trackImpressionChannelCallVideoGrid.guildId) && C12238m.areEqual(this.totalParticipants, trackImpressionChannelCallVideoGrid.totalParticipants) && C12238m.areEqual(this.canInvite, trackImpressionChannelCallVideoGrid.canInvite) && C12238m.areEqual(this.isAfkChannel, trackImpressionChannelCallVideoGrid.isAfkChannel) && C12238m.areEqual(this.channelUserLimit, trackImpressionChannelCallVideoGrid.channelUserLimit);
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
        StringBuilder sbM833U = C1643a.m833U("TrackImpressionChannelCallVideoGrid(channelId=");
        sbM833U.append(this.channelId);
        sbM833U.append(", guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", totalParticipants=");
        sbM833U.append(this.totalParticipants);
        sbM833U.append(", canInvite=");
        sbM833U.append(this.canInvite);
        sbM833U.append(", isAfkChannel=");
        sbM833U.append(this.isAfkChannel);
        sbM833U.append(", channelUserLimit=");
        return C1643a.m819G(sbM833U, this.channelUserLimit, ")");
    }
}
