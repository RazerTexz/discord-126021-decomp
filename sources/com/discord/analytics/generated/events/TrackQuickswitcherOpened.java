package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.source, trackQuickswitcherOpened.source) && C12238m.areEqual(this.currentGuildId, trackQuickswitcherOpened.currentGuildId) && C12238m.areEqual(this.currentChannelId, trackQuickswitcherOpened.currentChannelId) && C12238m.areEqual(this.currentChannelType, trackQuickswitcherOpened.currentChannelType);
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
        StringBuilder sbM833U = C1643a.m833U("TrackQuickswitcherOpened(source=");
        sbM833U.append(this.source);
        sbM833U.append(", currentGuildId=");
        sbM833U.append(this.currentGuildId);
        sbM833U.append(", currentChannelId=");
        sbM833U.append(this.currentChannelId);
        sbM833U.append(", currentChannelType=");
        return C1643a.m819G(sbM833U, this.currentChannelType, ")");
    }
}
