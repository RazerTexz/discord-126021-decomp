package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackQuickswitcherOpened.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackQuickswitcherOpened implements AnalyticsSchema, TrackBaseReceiver {
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
        return m.areEqual(this.source, trackQuickswitcherOpened.source) && m.areEqual(this.currentGuildId, trackQuickswitcherOpened.currentGuildId) && m.areEqual(this.currentChannelId, trackQuickswitcherOpened.currentChannelId) && m.areEqual(this.currentChannelType, trackQuickswitcherOpened.currentChannelType);
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
        StringBuilder sbU = a.U("TrackQuickswitcherOpened(source=");
        sbU.append(this.source);
        sbU.append(", currentGuildId=");
        sbU.append(this.currentGuildId);
        sbU.append(", currentChannelId=");
        sbU.append(this.currentChannelId);
        sbU.append(", currentChannelType=");
        return a.G(sbU, this.currentChannelType, ")");
    }
}
