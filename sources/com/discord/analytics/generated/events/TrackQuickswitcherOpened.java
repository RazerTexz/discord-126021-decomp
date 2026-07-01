package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackQuickswitcherOpened.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackQuickswitcherOpened implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence source = null;
    private final Long currentGuildId = null;
    private final Long currentChannelId = null;
    private final Long currentChannelType = null;
    private final transient String analyticsSchemaTypeName = "quickswitcher_opened";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackQuickswitcherOpened)) {
            return false;
        }
        TrackQuickswitcherOpened trackQuickswitcherOpened = (TrackQuickswitcherOpened) other;
        return Intrinsics3.areEqual(this.source, trackQuickswitcherOpened.source) && Intrinsics3.areEqual(this.currentGuildId, trackQuickswitcherOpened.currentGuildId) && Intrinsics3.areEqual(this.currentChannelId, trackQuickswitcherOpened.currentChannelId) && Intrinsics3.areEqual(this.currentChannelType, trackQuickswitcherOpened.currentChannelType);
    }

    public int hashCode() {
        CharSequence charSequence = this.source;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.currentGuildId;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.currentChannelId;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.currentChannelType;
        return iHashCode3 + (l3 != null ? l3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackQuickswitcherOpened(source=");
        sbU.append(this.source);
        sbU.append(", currentGuildId=");
        sbU.append(this.currentGuildId);
        sbU.append(", currentChannelId=");
        sbU.append(this.currentChannelId);
        sbU.append(", currentChannelType=");
        return outline.G(sbU, this.currentChannelType, ")");
    }
}
