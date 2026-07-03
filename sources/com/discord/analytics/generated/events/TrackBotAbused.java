package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackBotAbused.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackBotAbused implements AnalyticsSchema, TrackBaseReceiver {
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
        return C12238m.areEqual(this.botId, trackBotAbused.botId) && C12238m.areEqual(this.reason, trackBotAbused.reason);
    }

    public int hashCode() {
        Long l = this.botId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.reason;
        return iHashCode + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackBotAbused(botId=");
        sbM833U.append(this.botId);
        sbM833U.append(", reason=");
        return C1643a.m817E(sbM833U, this.reason, ")");
    }
}
