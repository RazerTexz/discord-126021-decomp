package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackBotTokenCompromised.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackBotTokenCompromised implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long botId = null;
    private final CharSequence tokenUrl = null;
    private final transient String analyticsSchemaTypeName = "bot_token_compromised";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackBotTokenCompromised)) {
            return false;
        }
        TrackBotTokenCompromised trackBotTokenCompromised = (TrackBotTokenCompromised) other;
        return C12238m.areEqual(this.botId, trackBotTokenCompromised.botId) && C12238m.areEqual(this.tokenUrl, trackBotTokenCompromised.tokenUrl);
    }

    public int hashCode() {
        Long l = this.botId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.tokenUrl;
        return iHashCode + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackBotTokenCompromised(botId=");
        sbM833U.append(this.botId);
        sbM833U.append(", tokenUrl=");
        return C1643a.m817E(sbM833U, this.tokenUrl, ")");
    }
}
