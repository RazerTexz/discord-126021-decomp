package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackApplicationClosed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackApplicationClosed implements AnalyticsSchema, TrackBaseReceiver {
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
        return C12238m.areEqual(this.applicationId, trackApplicationClosed.applicationId) && C12238m.areEqual(this.activityDurationS, trackApplicationClosed.activityDurationS) && C12238m.areEqual(this.totalDurationS, trackApplicationClosed.totalDurationS) && C12238m.areEqual(this.totalDiscordSkuDurationS, trackApplicationClosed.totalDiscordSkuDurationS) && C12238m.areEqual(this.distributor, trackApplicationClosed.distributor);
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
        StringBuilder sbM833U = C1643a.m833U("TrackApplicationClosed(applicationId=");
        sbM833U.append(this.applicationId);
        sbM833U.append(", activityDurationS=");
        sbM833U.append(this.activityDurationS);
        sbM833U.append(", totalDurationS=");
        sbM833U.append(this.totalDurationS);
        sbM833U.append(", totalDiscordSkuDurationS=");
        sbM833U.append(this.totalDiscordSkuDurationS);
        sbM833U.append(", distributor=");
        return C1643a.m817E(sbM833U, this.distributor, ")");
    }
}
