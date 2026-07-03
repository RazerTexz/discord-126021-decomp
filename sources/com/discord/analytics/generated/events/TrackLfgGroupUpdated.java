package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannelReceiver;
import com.discord.analytics.generated.traits.TrackLfgGroup;
import com.discord.analytics.generated.traits.TrackLfgGroupReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.updatedSize, trackLfgGroupUpdated.updatedSize) && C12238m.areEqual(this.previousSize, trackLfgGroupUpdated.previousSize) && C12238m.areEqual(this.updatedTitle, trackLfgGroupUpdated.updatedTitle) && C12238m.areEqual(this.updatedDescription, trackLfgGroupUpdated.updatedDescription);
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
        StringBuilder sbM833U = C1643a.m833U("TrackLfgGroupUpdated(updatedSize=");
        sbM833U.append(this.updatedSize);
        sbM833U.append(", previousSize=");
        sbM833U.append(this.previousSize);
        sbM833U.append(", updatedTitle=");
        sbM833U.append(this.updatedTitle);
        sbM833U.append(", updatedDescription=");
        return C1643a.m816D(sbM833U, this.updatedDescription, ")");
    }
}
