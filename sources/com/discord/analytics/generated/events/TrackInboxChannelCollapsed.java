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

/* JADX INFO: compiled from: TrackInboxChannelCollapsed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackInboxChannelCollapsed implements AnalyticsSchema, TrackBaseReceiver, TrackGuildReceiver, TrackChannelReceiver {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private final Boolean isNowCollapsed = null;
    private final Long numUnreadChannelsRemaining = null;
    private final transient String analyticsSchemaTypeName = "inbox_channel_collapsed";

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
        if (!(other instanceof TrackInboxChannelCollapsed)) {
            return false;
        }
        TrackInboxChannelCollapsed trackInboxChannelCollapsed = (TrackInboxChannelCollapsed) other;
        return C12238m.areEqual(this.isNowCollapsed, trackInboxChannelCollapsed.isNowCollapsed) && C12238m.areEqual(this.numUnreadChannelsRemaining, trackInboxChannelCollapsed.numUnreadChannelsRemaining);
    }

    public int hashCode() {
        Boolean bool = this.isNowCollapsed;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Long l = this.numUnreadChannelsRemaining;
        return iHashCode + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackInboxChannelCollapsed(isNowCollapsed=");
        sbM833U.append(this.isNowCollapsed);
        sbM833U.append(", numUnreadChannelsRemaining=");
        return C1643a.m819G(sbM833U, this.numUnreadChannelsRemaining, ")");
    }
}
