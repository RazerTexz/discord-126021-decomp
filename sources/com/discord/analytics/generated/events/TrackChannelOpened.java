package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannelReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.analytics.generated.traits.TrackOverlayClientMetadata;
import com.discord.analytics.generated.traits.TrackOverlayClientMetadataReceiver;
import com.discord.analytics.generated.traits.TrackThread;
import com.discord.analytics.generated.traits.TrackThreadReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackChannelOpened.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackChannelOpened implements AnalyticsSchema, TrackBaseReceiver, TrackGuildReceiver, TrackChannelReceiver, TrackThreadReceiver, TrackOverlayClientMetadataReceiver {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private TrackOverlayClientMetadata trackOverlayClientMetadata;
    private TrackThread trackThread;
    private final Boolean channelIsNsfw = null;
    private final CharSequence channelView = null;
    private final Long parentId = null;
    private final CharSequence staticRoute = null;
    private final transient String analyticsSchemaTypeName = "channel_opened";

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
        if (!(other instanceof TrackChannelOpened)) {
            return false;
        }
        TrackChannelOpened trackChannelOpened = (TrackChannelOpened) other;
        return m.areEqual(this.channelIsNsfw, trackChannelOpened.channelIsNsfw) && m.areEqual(this.channelView, trackChannelOpened.channelView) && m.areEqual(this.parentId, trackChannelOpened.parentId) && m.areEqual(this.staticRoute, trackChannelOpened.staticRoute);
    }

    public int hashCode() {
        Boolean bool = this.channelIsNsfw;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        CharSequence charSequence = this.channelView;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l = this.parentId;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.staticRoute;
        return iHashCode3 + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackChannelOpened(channelIsNsfw=");
        sbU.append(this.channelIsNsfw);
        sbU.append(", channelView=");
        sbU.append(this.channelView);
        sbU.append(", parentId=");
        sbU.append(this.parentId);
        sbU.append(", staticRoute=");
        return a.E(sbU, this.staticRoute, ")");
    }
}
