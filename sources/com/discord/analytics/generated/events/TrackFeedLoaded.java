package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;
import java.util.List;

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
        if (!(other instanceof TrackFeedLoaded)) {
            return false;
        }
        TrackFeedLoaded trackFeedLoaded = (TrackFeedLoaded) other;
        return m.areEqual(this.loadId, trackFeedLoaded.loadId) && m.areEqual(this.feedItemIds, trackFeedLoaded.feedItemIds) && m.areEqual(this.unreadFeedItemIds, trackFeedLoaded.unreadFeedItemIds) && m.areEqual(this.readFeedItemIds, trackFeedLoaded.readFeedItemIds) && m.areEqual(this.loadTimeMillis, trackFeedLoaded.loadTimeMillis) && m.areEqual(this.homeSessionId, trackFeedLoaded.homeSessionId) && m.areEqual(this.startHomeSessionId, trackFeedLoaded.startHomeSessionId);
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
        StringBuilder sbU = a.U("TrackFeedLoaded(loadId=");
        sbU.append(this.loadId);
        sbU.append(", feedItemIds=");
        sbU.append(this.feedItemIds);
        sbU.append(", unreadFeedItemIds=");
        sbU.append(this.unreadFeedItemIds);
        sbU.append(", readFeedItemIds=");
        sbU.append(this.readFeedItemIds);
        sbU.append(", loadTimeMillis=");
        sbU.append(this.loadTimeMillis);
        sbU.append(", homeSessionId=");
        sbU.append(this.homeSessionId);
        sbU.append(", startHomeSessionId=");
        return a.E(sbU, this.startHomeSessionId, ")");
    }
}
