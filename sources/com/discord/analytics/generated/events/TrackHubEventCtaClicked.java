package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackHubEventCtaClicked.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackHubEventCtaClicked implements AnalyticsSchema, TrackBaseReceiver, TrackGuildReceiver {
    private final transient String analyticsSchemaTypeName;
    private final Long guildScheduledEventGuildId;
    private final Long guildScheduledEventId;
    private TrackBase trackBase;
    private TrackGuild trackGuild;
    private final CharSequence type;

    public TrackHubEventCtaClicked() {
        this.guildScheduledEventId = null;
        this.guildScheduledEventGuildId = null;
        this.type = null;
        this.analyticsSchemaTypeName = "hub_event_cta_clicked";
    }

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
        if (!(other instanceof TrackHubEventCtaClicked)) {
            return false;
        }
        TrackHubEventCtaClicked trackHubEventCtaClicked = (TrackHubEventCtaClicked) other;
        return m.areEqual(this.guildScheduledEventId, trackHubEventCtaClicked.guildScheduledEventId) && m.areEqual(this.guildScheduledEventGuildId, trackHubEventCtaClicked.guildScheduledEventGuildId) && m.areEqual(this.type, trackHubEventCtaClicked.type);
    }

    public int hashCode() {
        Long l = this.guildScheduledEventId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.guildScheduledEventGuildId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence = this.type;
        return iHashCode2 + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackHubEventCtaClicked(guildScheduledEventId=");
        sbU.append(this.guildScheduledEventId);
        sbU.append(", guildScheduledEventGuildId=");
        sbU.append(this.guildScheduledEventGuildId);
        sbU.append(", type=");
        return a.E(sbU, this.type, ")");
    }

    public TrackHubEventCtaClicked(Long l, Long l2, CharSequence charSequence) {
        this.guildScheduledEventId = l;
        this.guildScheduledEventGuildId = l2;
        this.type = charSequence;
        this.analyticsSchemaTypeName = "hub_event_cta_clicked";
    }
}
