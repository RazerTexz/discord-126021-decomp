package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackGuildScheduledEventViewed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackGuildScheduledEventViewed implements AnalyticsSchema, TrackBaseReceiver, TrackGuildReceiver {
    private TrackBase trackBase;
    private TrackGuild trackGuild;
    private final Long guildScheduledEventId = null;
    private final Long privacyLevel = null;
    private final transient String analyticsSchemaTypeName = "guild_scheduled_event_viewed";

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
        if (!(other instanceof TrackGuildScheduledEventViewed)) {
            return false;
        }
        TrackGuildScheduledEventViewed trackGuildScheduledEventViewed = (TrackGuildScheduledEventViewed) other;
        return C12238m.areEqual(this.guildScheduledEventId, trackGuildScheduledEventViewed.guildScheduledEventId) && C12238m.areEqual(this.privacyLevel, trackGuildScheduledEventViewed.privacyLevel);
    }

    public int hashCode() {
        Long l = this.guildScheduledEventId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.privacyLevel;
        return iHashCode + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackGuildScheduledEventViewed(guildScheduledEventId=");
        sbM833U.append(this.guildScheduledEventId);
        sbM833U.append(", privacyLevel=");
        return C1643a.m819G(sbM833U, this.privacyLevel, ")");
    }
}
