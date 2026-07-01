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

/* JADX INFO: compiled from: TrackChannelPermissionsPageViewed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackChannelPermissionsPageViewed implements AnalyticsSchema, TrackBase2, TrackGuild2, TrackChannel2 {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private final CharSequence mode = null;
    private final Boolean channelIsPrivate = null;
    private final Boolean channelIsReadOnly = null;
    private final transient String analyticsSchemaTypeName = "channel_permissions_page_viewed";

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
        if (!(other instanceof TrackChannelPermissionsPageViewed)) {
            return false;
        }
        TrackChannelPermissionsPageViewed trackChannelPermissionsPageViewed = (TrackChannelPermissionsPageViewed) other;
        return Intrinsics3.areEqual(this.mode, trackChannelPermissionsPageViewed.mode) && Intrinsics3.areEqual(this.channelIsPrivate, trackChannelPermissionsPageViewed.channelIsPrivate) && Intrinsics3.areEqual(this.channelIsReadOnly, trackChannelPermissionsPageViewed.channelIsReadOnly);
    }

    public int hashCode() {
        CharSequence charSequence = this.mode;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Boolean bool = this.channelIsPrivate;
        int iHashCode2 = (iHashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.channelIsReadOnly;
        return iHashCode2 + (bool2 != null ? bool2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackChannelPermissionsPageViewed(mode=");
        sbU.append(this.mode);
        sbU.append(", channelIsPrivate=");
        sbU.append(this.channelIsPrivate);
        sbU.append(", channelIsReadOnly=");
        return outline.D(sbU, this.channelIsReadOnly, ")");
    }
}
