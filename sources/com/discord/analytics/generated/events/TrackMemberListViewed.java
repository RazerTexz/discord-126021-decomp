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

/* JADX INFO: compiled from: TrackMemberListViewed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackMemberListViewed implements AnalyticsSchema, TrackBase2, TrackGuild2, TrackChannel2 {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private final Long numUsersVisible = null;
    private final Long numUsersVisibleWithMobileIndicator = null;
    private final Long numUsersVisibleWithGameActivity = null;
    private final Long numUsersVisibleWithActivity = null;
    private final Boolean hasAddMembersCta = null;
    private final transient String analyticsSchemaTypeName = "member_list_viewed";

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
        if (!(other instanceof TrackMemberListViewed)) {
            return false;
        }
        TrackMemberListViewed trackMemberListViewed = (TrackMemberListViewed) other;
        return Intrinsics3.areEqual(this.numUsersVisible, trackMemberListViewed.numUsersVisible) && Intrinsics3.areEqual(this.numUsersVisibleWithMobileIndicator, trackMemberListViewed.numUsersVisibleWithMobileIndicator) && Intrinsics3.areEqual(this.numUsersVisibleWithGameActivity, trackMemberListViewed.numUsersVisibleWithGameActivity) && Intrinsics3.areEqual(this.numUsersVisibleWithActivity, trackMemberListViewed.numUsersVisibleWithActivity) && Intrinsics3.areEqual(this.hasAddMembersCta, trackMemberListViewed.hasAddMembersCta);
    }

    public int hashCode() {
        Long l = this.numUsersVisible;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.numUsersVisibleWithMobileIndicator;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.numUsersVisibleWithGameActivity;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.numUsersVisibleWithActivity;
        int iHashCode4 = (iHashCode3 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Boolean bool = this.hasAddMembersCta;
        return iHashCode4 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackMemberListViewed(numUsersVisible=");
        sbU.append(this.numUsersVisible);
        sbU.append(", numUsersVisibleWithMobileIndicator=");
        sbU.append(this.numUsersVisibleWithMobileIndicator);
        sbU.append(", numUsersVisibleWithGameActivity=");
        sbU.append(this.numUsersVisibleWithGameActivity);
        sbU.append(", numUsersVisibleWithActivity=");
        sbU.append(this.numUsersVisibleWithActivity);
        sbU.append(", hasAddMembersCta=");
        return outline.D(sbU, this.hasAddMembersCta, ")");
    }
}
