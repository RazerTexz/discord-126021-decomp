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

/* JADX INFO: compiled from: TrackChannelPermissionsPageViewed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackChannelPermissionsPageViewed implements AnalyticsSchema, TrackBaseReceiver, TrackGuildReceiver, TrackChannelReceiver {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private final CharSequence mode = null;
    private final Boolean channelIsPrivate = null;
    private final Boolean channelIsReadOnly = null;
    private final transient String analyticsSchemaTypeName = "channel_permissions_page_viewed";

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
        if (!(other instanceof TrackChannelPermissionsPageViewed)) {
            return false;
        }
        TrackChannelPermissionsPageViewed trackChannelPermissionsPageViewed = (TrackChannelPermissionsPageViewed) other;
        return C12238m.areEqual(this.mode, trackChannelPermissionsPageViewed.mode) && C12238m.areEqual(this.channelIsPrivate, trackChannelPermissionsPageViewed.channelIsPrivate) && C12238m.areEqual(this.channelIsReadOnly, trackChannelPermissionsPageViewed.channelIsReadOnly);
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
        StringBuilder sbM833U = C1643a.m833U("TrackChannelPermissionsPageViewed(mode=");
        sbM833U.append(this.mode);
        sbM833U.append(", channelIsPrivate=");
        sbM833U.append(this.channelIsPrivate);
        sbM833U.append(", channelIsReadOnly=");
        return C1643a.m816D(sbM833U, this.channelIsReadOnly, ")");
    }
}
