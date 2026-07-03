package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackUserAttributionReceived.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackUserAttributionReceived implements AnalyticsSchema, TrackBaseReceiver {
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
        return C12238m.areEqual(this.adjustTrackerToken, trackUserAttributionReceived.adjustTrackerToken) && C12238m.areEqual(this.adjustTrackerName, trackUserAttributionReceived.adjustTrackerName) && C12238m.areEqual(this.attributionNetwork, trackUserAttributionReceived.attributionNetwork) && C12238m.areEqual(this.attributionCampaign, trackUserAttributionReceived.attributionCampaign) && C12238m.areEqual(this.attributionAdgroup, trackUserAttributionReceived.attributionAdgroup) && C12238m.areEqual(this.attributionCreative, trackUserAttributionReceived.attributionCreative) && C12238m.areEqual(this.adjustAdid, trackUserAttributionReceived.adjustAdid);
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
        StringBuilder sbM833U = C1643a.m833U("TrackUserAttributionReceived(adjustTrackerToken=");
        sbM833U.append(this.adjustTrackerToken);
        sbM833U.append(", adjustTrackerName=");
        sbM833U.append(this.adjustTrackerName);
        sbM833U.append(", attributionNetwork=");
        sbM833U.append(this.attributionNetwork);
        sbM833U.append(", attributionCampaign=");
        sbM833U.append(this.attributionCampaign);
        sbM833U.append(", attributionAdgroup=");
        sbM833U.append(this.attributionAdgroup);
        sbM833U.append(", attributionCreative=");
        sbM833U.append(this.attributionCreative);
        sbM833U.append(", adjustAdid=");
        return C1643a.m817E(sbM833U, this.adjustAdid, ")");
    }
}
