package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackThreadLimitReached.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackThreadLimitReached implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long parentChannelId = null;
    private final Long parentChannelType = null;
    private final Long guildId = null;
    private final transient String analyticsSchemaTypeName = "thread_limit_reached";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackThreadLimitReached)) {
            return false;
        }
        TrackThreadLimitReached trackThreadLimitReached = (TrackThreadLimitReached) other;
        return Intrinsics3.areEqual(this.parentChannelId, trackThreadLimitReached.parentChannelId) && Intrinsics3.areEqual(this.parentChannelType, trackThreadLimitReached.parentChannelType) && Intrinsics3.areEqual(this.guildId, trackThreadLimitReached.guildId);
    }

    public int hashCode() {
        Long l = this.parentChannelId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.parentChannelType;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.guildId;
        return iHashCode2 + (l3 != null ? l3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackThreadLimitReached(parentChannelId=");
        sbU.append(this.parentChannelId);
        sbU.append(", parentChannelType=");
        sbU.append(this.parentChannelType);
        sbU.append(", guildId=");
        return outline.G(sbU, this.guildId, ")");
    }
}
