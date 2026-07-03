package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackPinMessage.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackPinMessage implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long guildId = null;
    private final Long channelId = null;
    private final Long authorId = null;
    private final Boolean pinned = null;
    private final transient String analyticsSchemaTypeName = "pin_message";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackPinMessage)) {
            return false;
        }
        TrackPinMessage trackPinMessage = (TrackPinMessage) other;
        return C12238m.areEqual(this.guildId, trackPinMessage.guildId) && C12238m.areEqual(this.channelId, trackPinMessage.channelId) && C12238m.areEqual(this.authorId, trackPinMessage.authorId) && C12238m.areEqual(this.pinned, trackPinMessage.pinned);
    }

    public int hashCode() {
        Long l = this.guildId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.channelId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.authorId;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Boolean bool = this.pinned;
        return iHashCode3 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackPinMessage(guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", channelId=");
        sbM833U.append(this.channelId);
        sbM833U.append(", authorId=");
        sbM833U.append(this.authorId);
        sbM833U.append(", pinned=");
        return C1643a.m816D(sbM833U, this.pinned, ")");
    }
}
