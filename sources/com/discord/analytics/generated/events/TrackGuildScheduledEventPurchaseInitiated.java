package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackGuildScheduledEventPurchaseInitiated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackGuildScheduledEventPurchaseInitiated implements AnalyticsSchema, TrackBaseReceiver, TrackGuildReceiver {
    private TrackBase trackBase;
    private TrackGuild trackGuild;
    private final Long guildScheduledEventId = null;
    private final transient String analyticsSchemaTypeName = "guild_scheduled_event_purchase_initiated";

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
        if (this != other) {
            return (other instanceof TrackGuildScheduledEventPurchaseInitiated) && m.areEqual(this.guildScheduledEventId, ((TrackGuildScheduledEventPurchaseInitiated) other).guildScheduledEventId);
        }
        return true;
    }

    public int hashCode() {
        Long l = this.guildScheduledEventId;
        if (l != null) {
            return l.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.G(a.U("TrackGuildScheduledEventPurchaseInitiated(guildScheduledEventId="), this.guildScheduledEventId, ")");
    }
}
