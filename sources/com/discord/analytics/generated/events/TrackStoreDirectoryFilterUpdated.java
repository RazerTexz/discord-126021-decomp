package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackStoreDirectoryFilterUpdated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackStoreDirectoryFilterUpdated implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence loadId = null;
    private final CharSequence sort = null;
    private final transient String analyticsSchemaTypeName = "store_directory_filter_updated";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackStoreDirectoryFilterUpdated)) {
            return false;
        }
        TrackStoreDirectoryFilterUpdated trackStoreDirectoryFilterUpdated = (TrackStoreDirectoryFilterUpdated) other;
        return Intrinsics3.areEqual(this.loadId, trackStoreDirectoryFilterUpdated.loadId) && Intrinsics3.areEqual(this.sort, trackStoreDirectoryFilterUpdated.sort);
    }

    public int hashCode() {
        CharSequence charSequence = this.loadId;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.sort;
        return iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackStoreDirectoryFilterUpdated(loadId=");
        sbU.append(this.loadId);
        sbU.append(", sort=");
        return outline.E(sbU, this.sort, ")");
    }
}
