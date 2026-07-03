package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.guildIds, trackSystemMessageAgeRestrictedSent.guildIds) && C12238m.areEqual(this.messageType, trackSystemMessageAgeRestrictedSent.messageType);
    }

    public int hashCode() {
        List<Long> list = this.guildIds;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        CharSequence charSequence = this.messageType;
        return iHashCode + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackSystemMessageAgeRestrictedSent(guildIds=");
        sbM833U.append(this.guildIds);
        sbM833U.append(", messageType=");
        return C1643a.m817E(sbM833U, this.messageType, ")");
    }
}
