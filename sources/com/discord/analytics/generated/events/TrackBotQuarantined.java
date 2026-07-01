package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackBotQuarantined.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackBotQuarantined implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long botId = null;
    private final transient String analyticsSchemaTypeName = "bot_quarantined";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackBotQuarantined) && m.areEqual(this.botId, ((TrackBotQuarantined) other).botId);
        }
        return true;
    }

    public int hashCode() {
        Long l = this.botId;
        if (l != null) {
            return l.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.G(a.U("TrackBotQuarantined(botId="), this.botId, ")");
    }
}
