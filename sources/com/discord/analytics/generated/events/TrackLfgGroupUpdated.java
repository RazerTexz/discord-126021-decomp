package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannel2;
import com.discord.analytics.generated.traits.TrackLfgGroup;
import com.discord.analytics.generated.traits.TrackLfgGroup2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackLfgGroupUpdated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackLfgGroupUpdated implements AnalyticsSchema, TrackBase2, TrackChannel2, TrackLfgGroup2 {
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
        return Intrinsics3.areEqual(this.updatedSize, trackLfgGroupUpdated.updatedSize) && Intrinsics3.areEqual(this.previousSize, trackLfgGroupUpdated.previousSize) && Intrinsics3.areEqual(this.updatedTitle, trackLfgGroupUpdated.updatedTitle) && Intrinsics3.areEqual(this.updatedDescription, trackLfgGroupUpdated.updatedDescription);
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
        StringBuilder sbU = outline.U("TrackLfgGroupUpdated(updatedSize=");
        sbU.append(this.updatedSize);
        sbU.append(", previousSize=");
        sbU.append(this.previousSize);
        sbU.append(", updatedTitle=");
        sbU.append(this.updatedTitle);
        sbU.append(", updatedDescription=");
        return outline.D(sbU, this.updatedDescription, ")");
    }
}
