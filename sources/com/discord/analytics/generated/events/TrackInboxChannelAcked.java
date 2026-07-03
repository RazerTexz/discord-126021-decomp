package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannelReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackInboxChannelAcked.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackInboxChannelAcked implements AnalyticsSchema, TrackBaseReceiver, TrackGuildReceiver, TrackChannelReceiver {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private final Boolean markedAllChannelsAsRead = null;
    private final Long numUnreadChannelsRemaining = null;
    private final transient String analyticsSchemaTypeName = "inbox_channel_acked";

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
        if (!(other instanceof TrackInboxChannelAcked)) {
            return false;
        }
        TrackInboxChannelAcked trackInboxChannelAcked = (TrackInboxChannelAcked) other;
        return C12238m.areEqual(this.markedAllChannelsAsRead, trackInboxChannelAcked.markedAllChannelsAsRead) && C12238m.areEqual(this.numUnreadChannelsRemaining, trackInboxChannelAcked.numUnreadChannelsRemaining);
    }

    public int hashCode() {
        Boolean bool = this.markedAllChannelsAsRead;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Long l = this.numUnreadChannelsRemaining;
        return iHashCode + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackInboxChannelAcked(markedAllChannelsAsRead=");
        sbM833U.append(this.markedAllChannelsAsRead);
        sbM833U.append(", numUnreadChannelsRemaining=");
        return C1643a.m819G(sbM833U, this.numUnreadChannelsRemaining, ")");
    }
}
