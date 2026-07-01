package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;
import java.util.List;

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
        return m.areEqual(this.loadId, trackStoreDirectoryExited.loadId) && m.areEqual(this.applicationIdsViewed, trackStoreDirectoryExited.applicationIdsViewed) && m.areEqual(this.skuIdsViewed, trackStoreDirectoryExited.skuIdsViewed) && m.areEqual(this.durationMs, trackStoreDirectoryExited.durationMs);
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
        StringBuilder sbU = a.U("TrackStoreDirectoryExited(loadId=");
        sbU.append(this.loadId);
        sbU.append(", applicationIdsViewed=");
        sbU.append(this.applicationIdsViewed);
        sbU.append(", skuIdsViewed=");
        sbU.append(this.skuIdsViewed);
        sbU.append(", durationMs=");
        return a.G(sbU, this.durationMs, ")");
    }
}
