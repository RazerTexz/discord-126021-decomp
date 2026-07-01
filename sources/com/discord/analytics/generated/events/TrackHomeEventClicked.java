package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackHomeEventClicked.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackHomeEventClicked implements AnalyticsSchema, TrackBaseReceiver, TrackGuildReceiver {
    private TrackBase trackBase;
    private TrackGuild trackGuild;
    private final Long guildScheduledEventId = null;
    private final CharSequence homeSessionId = null;
    private final Boolean isActive = null;
    private final transient String analyticsSchemaTypeName = "home_event_clicked";

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
        if (!(other instanceof TrackHomeEventClicked)) {
            return false;
        }
        TrackHomeEventClicked trackHomeEventClicked = (TrackHomeEventClicked) other;
        return m.areEqual(this.guildScheduledEventId, trackHomeEventClicked.guildScheduledEventId) && m.areEqual(this.homeSessionId, trackHomeEventClicked.homeSessionId) && m.areEqual(this.isActive, trackHomeEventClicked.isActive);
    }

    public int hashCode() {
        Long l = this.guildScheduledEventId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.homeSessionId;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Boolean bool = this.isActive;
        return iHashCode2 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackHomeEventClicked(guildScheduledEventId=");
        sbU.append(this.guildScheduledEventId);
        sbU.append(", homeSessionId=");
        sbU.append(this.homeSessionId);
        sbU.append(", isActive=");
        return a.D(sbU, this.isActive, ")");
    }
}
