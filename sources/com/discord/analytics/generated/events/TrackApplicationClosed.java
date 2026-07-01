package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackApplicationClosed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackApplicationClosed implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long applicationId = null;
    private final Long activityDurationS = null;
    private final Long totalDurationS = null;
    private final Long totalDiscordSkuDurationS = null;
    private final CharSequence distributor = null;
    private final transient String analyticsSchemaTypeName = "application_closed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackApplicationClosed)) {
            return false;
        }
        TrackApplicationClosed trackApplicationClosed = (TrackApplicationClosed) other;
        return Intrinsics3.areEqual(this.applicationId, trackApplicationClosed.applicationId) && Intrinsics3.areEqual(this.activityDurationS, trackApplicationClosed.activityDurationS) && Intrinsics3.areEqual(this.totalDurationS, trackApplicationClosed.totalDurationS) && Intrinsics3.areEqual(this.totalDiscordSkuDurationS, trackApplicationClosed.totalDiscordSkuDurationS) && Intrinsics3.areEqual(this.distributor, trackApplicationClosed.distributor);
    }

    public int hashCode() {
        Long l = this.applicationId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.activityDurationS;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.totalDurationS;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.totalDiscordSkuDurationS;
        int iHashCode4 = (iHashCode3 + (l4 != null ? l4.hashCode() : 0)) * 31;
        CharSequence charSequence = this.distributor;
        return iHashCode4 + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackApplicationClosed(applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", activityDurationS=");
        sbU.append(this.activityDurationS);
        sbU.append(", totalDurationS=");
        sbU.append(this.totalDurationS);
        sbU.append(", totalDiscordSkuDurationS=");
        sbU.append(this.totalDiscordSkuDurationS);
        sbU.append(", distributor=");
        return outline.E(sbU, this.distributor, ")");
    }
}
