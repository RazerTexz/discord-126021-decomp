package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackCreateEmoji.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackCreateEmoji implements AnalyticsSchema, TrackBaseReceiver {
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
        return C12238m.areEqual(this.guildId, trackCreateEmoji.guildId) && C12238m.areEqual(this.animated, trackCreateEmoji.animated);
    }

    public int hashCode() {
        Long l = this.guildId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Boolean bool = this.animated;
        return iHashCode + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackCreateEmoji(guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", animated=");
        return C1643a.m816D(sbM833U, this.animated, ")");
    }
}
