package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: TrackSystemMessageAgeRestrictedSent.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackSystemMessageAgeRestrictedSent implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final List<Long> guildIds = null;
    private final CharSequence messageType = null;
    private final transient String analyticsSchemaTypeName = "system_message_age_restricted_sent";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackSystemMessageAgeRestrictedSent)) {
            return false;
        }
        TrackSystemMessageAgeRestrictedSent trackSystemMessageAgeRestrictedSent = (TrackSystemMessageAgeRestrictedSent) other;
        return m.areEqual(this.guildIds, trackSystemMessageAgeRestrictedSent.guildIds) && m.areEqual(this.messageType, trackSystemMessageAgeRestrictedSent.messageType);
    }

    public int hashCode() {
        List<Long> list = this.guildIds;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        CharSequence charSequence = this.messageType;
        return iHashCode + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackSystemMessageAgeRestrictedSent(guildIds=");
        sbU.append(this.guildIds);
        sbU.append(", messageType=");
        return a.E(sbU, this.messageType, ")");
    }
}
