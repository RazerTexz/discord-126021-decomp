package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackStoreListingExited.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackStoreListingExited implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final CharSequence loadId = null;
    private final Long durationMs = null;
    private final transient String analyticsSchemaTypeName = "store_listing_exited";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackStoreListingExited)) {
            return false;
        }
        TrackStoreListingExited trackStoreListingExited = (TrackStoreListingExited) other;
        return m.areEqual(this.loadId, trackStoreListingExited.loadId) && m.areEqual(this.durationMs, trackStoreListingExited.durationMs);
    }

    public int hashCode() {
        CharSequence charSequence = this.loadId;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.durationMs;
        return iHashCode + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackStoreListingExited(loadId=");
        sbU.append(this.loadId);
        sbU.append(", durationMs=");
        return a.G(sbU, this.durationMs, ")");
    }
}
