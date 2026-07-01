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

/* JADX INFO: compiled from: TrackDmListViewed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackDmListViewed implements AnalyticsSchema, TrackBase2, TrackGuild2, TrackChannel2 {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private final Long numUsersVisible = null;
    private final Long numUsersVisibleWithMobileIndicator = null;
    private final transient String analyticsSchemaTypeName = "dm_list_viewed";

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
        if (!(other instanceof TrackDmListViewed)) {
            return false;
        }
        TrackDmListViewed trackDmListViewed = (TrackDmListViewed) other;
        return Intrinsics3.areEqual(this.numUsersVisible, trackDmListViewed.numUsersVisible) && Intrinsics3.areEqual(this.numUsersVisibleWithMobileIndicator, trackDmListViewed.numUsersVisibleWithMobileIndicator);
    }

    public int hashCode() {
        Long l = this.numUsersVisible;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.numUsersVisibleWithMobileIndicator;
        return iHashCode + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackDmListViewed(numUsersVisible=");
        sbU.append(this.numUsersVisible);
        sbU.append(", numUsersVisibleWithMobileIndicator=");
        return outline.G(sbU, this.numUsersVisibleWithMobileIndicator, ")");
    }
}
