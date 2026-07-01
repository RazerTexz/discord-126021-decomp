package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannel2;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.analytics.generated.traits.TrackOverlayClientMetadata;
import com.discord.analytics.generated.traits.TrackOverlayClientMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackGuildViewed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackGuildViewed implements AnalyticsSchema, TrackBase2, TrackGuild2, TrackChannel2, TrackOverlayClientMetadata2 {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private TrackOverlayClientMetadata trackOverlayClientMetadata;
    private final Float guildAffinityScore = null;
    private final Long guildAffinityIndex = null;
    private final Boolean isPending = null;
    private final Boolean previewEnabled = null;
    private final Long postableChannels = null;
    private final Boolean premiumProgressBarEnabled = null;
    private final Boolean viewingStarred = null;
    private final transient String analyticsSchemaTypeName = "guild_viewed";

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
        if (!(other instanceof TrackGuildViewed)) {
            return false;
        }
        TrackGuildViewed trackGuildViewed = (TrackGuildViewed) other;
        return Intrinsics3.areEqual(this.guildAffinityScore, trackGuildViewed.guildAffinityScore) && Intrinsics3.areEqual(this.guildAffinityIndex, trackGuildViewed.guildAffinityIndex) && Intrinsics3.areEqual(this.isPending, trackGuildViewed.isPending) && Intrinsics3.areEqual(this.previewEnabled, trackGuildViewed.previewEnabled) && Intrinsics3.areEqual(this.postableChannels, trackGuildViewed.postableChannels) && Intrinsics3.areEqual(this.premiumProgressBarEnabled, trackGuildViewed.premiumProgressBarEnabled) && Intrinsics3.areEqual(this.viewingStarred, trackGuildViewed.viewingStarred);
    }

    public int hashCode() {
        Float f = this.guildAffinityScore;
        int iHashCode = (f != null ? f.hashCode() : 0) * 31;
        Long l = this.guildAffinityIndex;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Boolean bool = this.isPending;
        int iHashCode3 = (iHashCode2 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.previewEnabled;
        int iHashCode4 = (iHashCode3 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Long l2 = this.postableChannels;
        int iHashCode5 = (iHashCode4 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Boolean bool3 = this.premiumProgressBarEnabled;
        int iHashCode6 = (iHashCode5 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Boolean bool4 = this.viewingStarred;
        return iHashCode6 + (bool4 != null ? bool4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackGuildViewed(guildAffinityScore=");
        sbU.append(this.guildAffinityScore);
        sbU.append(", guildAffinityIndex=");
        sbU.append(this.guildAffinityIndex);
        sbU.append(", isPending=");
        sbU.append(this.isPending);
        sbU.append(", previewEnabled=");
        sbU.append(this.previewEnabled);
        sbU.append(", postableChannels=");
        sbU.append(this.postableChannels);
        sbU.append(", premiumProgressBarEnabled=");
        sbU.append(this.premiumProgressBarEnabled);
        sbU.append(", viewingStarred=");
        return outline.D(sbU, this.viewingStarred, ")");
    }
}
