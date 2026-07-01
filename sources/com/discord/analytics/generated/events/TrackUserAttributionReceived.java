package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackUserAttributionReceived.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackUserAttributionReceived implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence adjustTrackerToken = null;
    private final CharSequence adjustTrackerName = null;
    private final CharSequence attributionNetwork = null;
    private final CharSequence attributionCampaign = null;
    private final CharSequence attributionAdgroup = null;
    private final CharSequence attributionCreative = null;
    private final CharSequence adjustAdid = null;
    private final transient String analyticsSchemaTypeName = "user_attribution_received";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackUserAttributionReceived)) {
            return false;
        }
        TrackUserAttributionReceived trackUserAttributionReceived = (TrackUserAttributionReceived) other;
        return Intrinsics3.areEqual(this.adjustTrackerToken, trackUserAttributionReceived.adjustTrackerToken) && Intrinsics3.areEqual(this.adjustTrackerName, trackUserAttributionReceived.adjustTrackerName) && Intrinsics3.areEqual(this.attributionNetwork, trackUserAttributionReceived.attributionNetwork) && Intrinsics3.areEqual(this.attributionCampaign, trackUserAttributionReceived.attributionCampaign) && Intrinsics3.areEqual(this.attributionAdgroup, trackUserAttributionReceived.attributionAdgroup) && Intrinsics3.areEqual(this.attributionCreative, trackUserAttributionReceived.attributionCreative) && Intrinsics3.areEqual(this.adjustAdid, trackUserAttributionReceived.adjustAdid);
    }

    public int hashCode() {
        CharSequence charSequence = this.adjustTrackerToken;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.adjustTrackerName;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.attributionNetwork;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.attributionCampaign;
        int iHashCode4 = (iHashCode3 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.attributionAdgroup;
        int iHashCode5 = (iHashCode4 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        CharSequence charSequence6 = this.attributionCreative;
        int iHashCode6 = (iHashCode5 + (charSequence6 != null ? charSequence6.hashCode() : 0)) * 31;
        CharSequence charSequence7 = this.adjustAdid;
        return iHashCode6 + (charSequence7 != null ? charSequence7.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackUserAttributionReceived(adjustTrackerToken=");
        sbU.append(this.adjustTrackerToken);
        sbU.append(", adjustTrackerName=");
        sbU.append(this.adjustTrackerName);
        sbU.append(", attributionNetwork=");
        sbU.append(this.attributionNetwork);
        sbU.append(", attributionCampaign=");
        sbU.append(this.attributionCampaign);
        sbU.append(", attributionAdgroup=");
        sbU.append(this.attributionAdgroup);
        sbU.append(", attributionCreative=");
        sbU.append(this.attributionCreative);
        sbU.append(", adjustAdid=");
        return outline.E(sbU, this.adjustAdid, ")");
    }
}
