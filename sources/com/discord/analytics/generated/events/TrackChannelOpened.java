package com.discord.analytics.generated.events;

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
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        if (!(other instanceof TrackChannelOpened)) {
            return false;
        }
        TrackChannelOpened trackChannelOpened = (TrackChannelOpened) other;
        return C12238m.areEqual(this.channelIsNsfw, trackChannelOpened.channelIsNsfw) && C12238m.areEqual(this.channelView, trackChannelOpened.channelView) && C12238m.areEqual(this.parentId, trackChannelOpened.parentId) && C12238m.areEqual(this.staticRoute, trackChannelOpened.staticRoute);
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
        StringBuilder sbM833U = C1643a.m833U("TrackChannelOpened(channelIsNsfw=");
        sbM833U.append(this.channelIsNsfw);
        sbM833U.append(", channelView=");
        sbM833U.append(this.channelView);
        sbM833U.append(", parentId=");
        sbM833U.append(this.parentId);
        sbM833U.append(", staticRoute=");
        return C1643a.m817E(sbM833U, this.staticRoute, ")");
    }
}
