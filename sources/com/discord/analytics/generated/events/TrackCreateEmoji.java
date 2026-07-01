package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackCreateEmoji.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackCreateEmoji implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long guildId = null;
    private final Boolean animated = null;
    private final transient String analyticsSchemaTypeName = "create_emoji";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackCreateEmoji)) {
            return false;
        }
        TrackCreateEmoji trackCreateEmoji = (TrackCreateEmoji) other;
        return Intrinsics3.areEqual(this.guildId, trackCreateEmoji.guildId) && Intrinsics3.areEqual(this.animated, trackCreateEmoji.animated);
    }

    public int hashCode() {
        Long l = this.guildId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Boolean bool = this.animated;
        return iHashCode + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackCreateEmoji(guildId=");
        sbU.append(this.guildId);
        sbU.append(", animated=");
        return outline.D(sbU, this.animated, ")");
    }
}
