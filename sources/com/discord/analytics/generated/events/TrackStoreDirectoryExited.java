package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackStoreDirectoryExited.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackStoreDirectoryExited implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final CharSequence loadId = null;
    private final List<Long> applicationIdsViewed = null;
    private final List<Long> skuIdsViewed = null;
    private final Long durationMs = null;
    private final transient String analyticsSchemaTypeName = "store_directory_exited";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackStoreDirectoryExited)) {
            return false;
        }
        TrackStoreDirectoryExited trackStoreDirectoryExited = (TrackStoreDirectoryExited) other;
        return C12238m.areEqual(this.loadId, trackStoreDirectoryExited.loadId) && C12238m.areEqual(this.applicationIdsViewed, trackStoreDirectoryExited.applicationIdsViewed) && C12238m.areEqual(this.skuIdsViewed, trackStoreDirectoryExited.skuIdsViewed) && C12238m.areEqual(this.durationMs, trackStoreDirectoryExited.durationMs);
    }

    public int hashCode() {
        CharSequence charSequence = this.loadId;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        List<Long> list = this.applicationIdsViewed;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        List<Long> list2 = this.skuIdsViewed;
        int iHashCode3 = (iHashCode2 + (list2 != null ? list2.hashCode() : 0)) * 31;
        Long l = this.durationMs;
        return iHashCode3 + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackStoreDirectoryExited(loadId=");
        sbM833U.append(this.loadId);
        sbM833U.append(", applicationIdsViewed=");
        sbM833U.append(this.applicationIdsViewed);
        sbM833U.append(", skuIdsViewed=");
        sbM833U.append(this.skuIdsViewed);
        sbM833U.append(", durationMs=");
        return C1643a.m819G(sbM833U, this.durationMs, ")");
    }
}
