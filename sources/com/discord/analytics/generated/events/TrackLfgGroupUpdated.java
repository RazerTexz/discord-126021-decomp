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

/* JADX INFO: compiled from: TrackLfgGroupUpdated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackLfgGroupUpdated implements AnalyticsSchema, TrackBaseReceiver, TrackChannelReceiver, TrackLfgGroupReceiver {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackLfgGroup trackLfgGroup;
    private final Boolean updatedSize = null;
    private final Long previousSize = null;
    private final Boolean updatedTitle = null;
    private final Boolean updatedDescription = null;
    private final transient String analyticsSchemaTypeName = "lfg_group_updated";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackLfgGroupUpdated)) {
            return false;
        }
        TrackLfgGroupUpdated trackLfgGroupUpdated = (TrackLfgGroupUpdated) other;
        return m.areEqual(this.updatedSize, trackLfgGroupUpdated.updatedSize) && m.areEqual(this.previousSize, trackLfgGroupUpdated.previousSize) && m.areEqual(this.updatedTitle, trackLfgGroupUpdated.updatedTitle) && m.areEqual(this.updatedDescription, trackLfgGroupUpdated.updatedDescription);
    }

    public int hashCode() {
        Boolean bool = this.updatedSize;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Long l = this.previousSize;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Boolean bool2 = this.updatedTitle;
        int iHashCode3 = (iHashCode2 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.updatedDescription;
        return iHashCode3 + (bool3 != null ? bool3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackLfgGroupUpdated(updatedSize=");
        sbU.append(this.updatedSize);
        sbU.append(", previousSize=");
        sbU.append(this.previousSize);
        sbU.append(", updatedTitle=");
        sbU.append(this.updatedTitle);
        sbU.append(", updatedDescription=");
        return a.D(sbU, this.updatedDescription, ")");
    }
}
