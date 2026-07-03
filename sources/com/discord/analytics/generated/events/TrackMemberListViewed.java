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

/* JADX INFO: compiled from: TrackMemberListViewed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackMemberListViewed implements AnalyticsSchema, TrackBaseReceiver, TrackGuildReceiver, TrackChannelReceiver {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private final Long numUsersVisible = null;
    private final Long numUsersVisibleWithMobileIndicator = null;
    private final Long numUsersVisibleWithGameActivity = null;
    private final Long numUsersVisibleWithActivity = null;
    private final Boolean hasAddMembersCta = null;
    private final transient String analyticsSchemaTypeName = "member_list_viewed";

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
        if (!(other instanceof TrackMemberListViewed)) {
            return false;
        }
        TrackMemberListViewed trackMemberListViewed = (TrackMemberListViewed) other;
        return C12238m.areEqual(this.numUsersVisible, trackMemberListViewed.numUsersVisible) && C12238m.areEqual(this.numUsersVisibleWithMobileIndicator, trackMemberListViewed.numUsersVisibleWithMobileIndicator) && C12238m.areEqual(this.numUsersVisibleWithGameActivity, trackMemberListViewed.numUsersVisibleWithGameActivity) && C12238m.areEqual(this.numUsersVisibleWithActivity, trackMemberListViewed.numUsersVisibleWithActivity) && C12238m.areEqual(this.hasAddMembersCta, trackMemberListViewed.hasAddMembersCta);
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
        StringBuilder sbM833U = C1643a.m833U("TrackMemberListViewed(numUsersVisible=");
        sbM833U.append(this.numUsersVisible);
        sbM833U.append(", numUsersVisibleWithMobileIndicator=");
        sbM833U.append(this.numUsersVisibleWithMobileIndicator);
        sbM833U.append(", numUsersVisibleWithGameActivity=");
        sbM833U.append(this.numUsersVisibleWithGameActivity);
        sbM833U.append(", numUsersVisibleWithActivity=");
        sbM833U.append(this.numUsersVisibleWithActivity);
        sbM833U.append(", hasAddMembersCta=");
        return C1643a.m816D(sbM833U, this.hasAddMembersCta, ")");
    }
}
