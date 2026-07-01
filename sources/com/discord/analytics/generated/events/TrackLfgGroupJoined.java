package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannelReceiver;
import com.discord.analytics.generated.traits.TrackLfgGroup;
import com.discord.analytics.generated.traits.TrackLfgGroupReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackLfgGroupJoined.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackLfgGroupJoined implements AnalyticsSchema, TrackBaseReceiver, TrackChannelReceiver, TrackLfgGroupReceiver {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackLfgGroup trackLfgGroup;
    private final Boolean browserFiltered = null;
    private final Long groupIndex = null;
    private final transient String analyticsSchemaTypeName = "lfg_group_joined";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackLfgGroupJoined)) {
            return false;
        }
        TrackLfgGroupJoined trackLfgGroupJoined = (TrackLfgGroupJoined) other;
        return m.areEqual(this.browserFiltered, trackLfgGroupJoined.browserFiltered) && m.areEqual(this.groupIndex, trackLfgGroupJoined.groupIndex);
    }

    public int hashCode() {
        Boolean bool = this.browserFiltered;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Long l = this.groupIndex;
        return iHashCode + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackLfgGroupJoined(browserFiltered=");
        sbU.append(this.browserFiltered);
        sbU.append(", groupIndex=");
        return a.G(sbU, this.groupIndex, ")");
    }
}
