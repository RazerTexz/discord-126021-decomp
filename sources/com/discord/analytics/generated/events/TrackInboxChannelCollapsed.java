package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannel2;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackInboxChannelCollapsed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackInboxChannelCollapsed implements AnalyticsSchema, TrackBase2, TrackGuild2, TrackChannel2 {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private final Boolean isNowCollapsed = null;
    private final Long numUnreadChannelsRemaining = null;
    private final transient String analyticsSchemaTypeName = "inbox_channel_collapsed";

    @Override // com.discord.analytics.generated.traits.TrackGuild2
    /* JADX INFO: renamed from: a, reason: from getter */
    public TrackGuild getTrackGuild() {
        return this.trackGuild;
    }

    @Override // com.discord.analytics.generated.traits.TrackGuild2
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
        if (!(other instanceof TrackInboxChannelCollapsed)) {
            return false;
        }
        TrackInboxChannelCollapsed trackInboxChannelCollapsed = (TrackInboxChannelCollapsed) other;
        return Intrinsics3.areEqual(this.isNowCollapsed, trackInboxChannelCollapsed.isNowCollapsed) && Intrinsics3.areEqual(this.numUnreadChannelsRemaining, trackInboxChannelCollapsed.numUnreadChannelsRemaining);
    }

    public int hashCode() {
        Boolean bool = this.isNowCollapsed;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Long l = this.numUnreadChannelsRemaining;
        return iHashCode + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackInboxChannelCollapsed(isNowCollapsed=");
        sbU.append(this.isNowCollapsed);
        sbU.append(", numUnreadChannelsRemaining=");
        return outline.G(sbU, this.numUnreadChannelsRemaining, ")");
    }
}
