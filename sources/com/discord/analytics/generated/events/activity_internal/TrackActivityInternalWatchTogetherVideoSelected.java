package com.discord.analytics.generated.events.activity_internal;

import com.discord.analytics.generated.traits.TrackActivityInternalMetadata;
import com.discord.analytics.generated.traits.TrackActivityInternalMetadataReceiver;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackActivityInternalWatchTogetherVideoSelected.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackActivityInternalWatchTogetherVideoSelected implements AnalyticsSchema, TrackBaseReceiver, TrackActivityInternalMetadataReceiver {
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
        return C12238m.areEqual(this.isHost, trackActivityInternalWatchTogetherVideoSelected.isHost) && C12238m.areEqual(this.isHostMode, trackActivityInternalWatchTogetherVideoSelected.isHostMode) && C12238m.areEqual(this.orderCurrent, trackActivityInternalWatchTogetherVideoSelected.orderCurrent) && C12238m.areEqual(this.orderSelected, trackActivityInternalWatchTogetherVideoSelected.orderSelected);
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
        StringBuilder sbM833U = C1643a.m833U("TrackActivityInternalWatchTogetherVideoSelected(isHost=");
        sbM833U.append(this.isHost);
        sbM833U.append(", isHostMode=");
        sbM833U.append(this.isHostMode);
        sbM833U.append(", orderCurrent=");
        sbM833U.append(this.orderCurrent);
        sbM833U.append(", orderSelected=");
        return C1643a.m819G(sbM833U, this.orderSelected, ")");
    }
}
