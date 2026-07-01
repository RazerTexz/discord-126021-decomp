package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackBotAbused.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackBotAbused implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long botId = null;
    private final CharSequence reason = null;
    private final transient String analyticsSchemaTypeName = "bot_abused";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackBotAbused)) {
            return false;
        }
        TrackBotAbused trackBotAbused = (TrackBotAbused) other;
        return Intrinsics3.areEqual(this.botId, trackBotAbused.botId) && Intrinsics3.areEqual(this.reason, trackBotAbused.reason);
    }

    public int hashCode() {
        Long l = this.botId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.reason;
        return iHashCode + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackBotAbused(botId=");
        sbU.append(this.botId);
        sbU.append(", reason=");
        return outline.E(sbU, this.reason, ")");
    }
}
