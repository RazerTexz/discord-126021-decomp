package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.api.science.AnalyticsSchema;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackFeedLoaded.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackFeedLoaded implements AnalyticsSchema, TrackBaseReceiver, TrackGuildReceiver {
    private TrackBase trackBase;
    private TrackGuild trackGuild;
    private final CharSequence loadId = null;
    private final List<CharSequence> feedItemIds = null;
    private final List<CharSequence> unreadFeedItemIds = null;
    private final List<CharSequence> readFeedItemIds = null;
    private final Long loadTimeMillis = null;
    private final CharSequence homeSessionId = null;
    private final CharSequence startHomeSessionId = null;
    private final transient String analyticsSchemaTypeName = "feed_loaded";

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
        if (!(other instanceof TrackFeedLoaded)) {
            return false;
        }
        TrackFeedLoaded trackFeedLoaded = (TrackFeedLoaded) other;
        return C12238m.areEqual(this.loadId, trackFeedLoaded.loadId) && C12238m.areEqual(this.feedItemIds, trackFeedLoaded.feedItemIds) && C12238m.areEqual(this.unreadFeedItemIds, trackFeedLoaded.unreadFeedItemIds) && C12238m.areEqual(this.readFeedItemIds, trackFeedLoaded.readFeedItemIds) && C12238m.areEqual(this.loadTimeMillis, trackFeedLoaded.loadTimeMillis) && C12238m.areEqual(this.homeSessionId, trackFeedLoaded.homeSessionId) && C12238m.areEqual(this.startHomeSessionId, trackFeedLoaded.startHomeSessionId);
    }

    public int hashCode() {
        CharSequence charSequence = this.loadId;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        List<CharSequence> list = this.feedItemIds;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        List<CharSequence> list2 = this.unreadFeedItemIds;
        int iHashCode3 = (iHashCode2 + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<CharSequence> list3 = this.readFeedItemIds;
        int iHashCode4 = (iHashCode3 + (list3 != null ? list3.hashCode() : 0)) * 31;
        Long l = this.loadTimeMillis;
        int iHashCode5 = (iHashCode4 + (l != null ? l.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.homeSessionId;
        int iHashCode6 = (iHashCode5 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.startHomeSessionId;
        return iHashCode6 + (charSequence3 != null ? charSequence3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackFeedLoaded(loadId=");
        sbM833U.append(this.loadId);
        sbM833U.append(", feedItemIds=");
        sbM833U.append(this.feedItemIds);
        sbM833U.append(", unreadFeedItemIds=");
        sbM833U.append(this.unreadFeedItemIds);
        sbM833U.append(", readFeedItemIds=");
        sbM833U.append(this.readFeedItemIds);
        sbM833U.append(", loadTimeMillis=");
        sbM833U.append(this.loadTimeMillis);
        sbM833U.append(", homeSessionId=");
        sbM833U.append(this.homeSessionId);
        sbM833U.append(", startHomeSessionId=");
        return C1643a.m817E(sbM833U, this.startHomeSessionId, ")");
    }
}
