package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackStoreDirectoryFilterUpdated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackStoreDirectoryFilterUpdated implements AnalyticsSchema, TrackBaseReceiver {
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
        return C12238m.areEqual(this.loadId, trackStoreDirectoryFilterUpdated.loadId) && C12238m.areEqual(this.sort, trackStoreDirectoryFilterUpdated.sort);
    }

    public int hashCode() {
        CharSequence charSequence = this.loadId;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.sort;
        return iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackStoreDirectoryFilterUpdated(loadId=");
        sbM833U.append(this.loadId);
        sbM833U.append(", sort=");
        return C1643a.m817E(sbM833U, this.sort, ")");
    }
}
