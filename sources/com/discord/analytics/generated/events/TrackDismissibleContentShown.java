package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackDismissibleContentShown.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackDismissibleContentShown implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence type = null;
    private final Long contentCount = null;
    private final CharSequence groupName = null;
    private final Boolean bypassFatigue = null;
    private final transient String analyticsSchemaTypeName = "dismissible_content_shown";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackDismissibleContentShown)) {
            return false;
        }
        TrackDismissibleContentShown trackDismissibleContentShown = (TrackDismissibleContentShown) other;
        return Intrinsics3.areEqual(this.type, trackDismissibleContentShown.type) && Intrinsics3.areEqual(this.contentCount, trackDismissibleContentShown.contentCount) && Intrinsics3.areEqual(this.groupName, trackDismissibleContentShown.groupName) && Intrinsics3.areEqual(this.bypassFatigue, trackDismissibleContentShown.bypassFatigue);
    }

    public int hashCode() {
        CharSequence charSequence = this.type;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.contentCount;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.groupName;
        int iHashCode3 = (iHashCode2 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Boolean bool = this.bypassFatigue;
        return iHashCode3 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackDismissibleContentShown(type=");
        sbU.append(this.type);
        sbU.append(", contentCount=");
        sbU.append(this.contentCount);
        sbU.append(", groupName=");
        sbU.append(this.groupName);
        sbU.append(", bypassFatigue=");
        return outline.D(sbU, this.bypassFatigue, ")");
    }
}
