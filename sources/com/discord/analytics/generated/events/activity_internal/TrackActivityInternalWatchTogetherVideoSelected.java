package com.discord.analytics.generated.events.activity_internal;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackActivityInternalMetadata;
import com.discord.analytics.generated.traits.TrackActivityInternalMetadata2;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackActivityInternalWatchTogetherVideoSelected.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackActivityInternalWatchTogetherVideoSelected implements AnalyticsSchema, TrackBase2, TrackActivityInternalMetadata2 {
    private TrackActivityInternalMetadata trackActivityInternalMetadata;
    private TrackBase trackBase;
    private final Boolean isHost = null;
    private final Boolean isHostMode = null;
    private final Long orderCurrent = null;
    private final Long orderSelected = null;
    private final transient String analyticsSchemaTypeName = "activity_internal_watch_together_video_selected";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackActivityInternalWatchTogetherVideoSelected)) {
            return false;
        }
        TrackActivityInternalWatchTogetherVideoSelected trackActivityInternalWatchTogetherVideoSelected = (TrackActivityInternalWatchTogetherVideoSelected) other;
        return Intrinsics3.areEqual(this.isHost, trackActivityInternalWatchTogetherVideoSelected.isHost) && Intrinsics3.areEqual(this.isHostMode, trackActivityInternalWatchTogetherVideoSelected.isHostMode) && Intrinsics3.areEqual(this.orderCurrent, trackActivityInternalWatchTogetherVideoSelected.orderCurrent) && Intrinsics3.areEqual(this.orderSelected, trackActivityInternalWatchTogetherVideoSelected.orderSelected);
    }

    public int hashCode() {
        Boolean bool = this.isHost;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Boolean bool2 = this.isHostMode;
        int iHashCode2 = (iHashCode + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Long l = this.orderCurrent;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.orderSelected;
        return iHashCode3 + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackActivityInternalWatchTogetherVideoSelected(isHost=");
        sbU.append(this.isHost);
        sbU.append(", isHostMode=");
        sbU.append(this.isHostMode);
        sbU.append(", orderCurrent=");
        sbU.append(this.orderCurrent);
        sbU.append(", orderSelected=");
        return outline.G(sbU, this.orderSelected, ")");
    }
}
