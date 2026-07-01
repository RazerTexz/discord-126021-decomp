package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackTipaltiIpnReceived.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackTipaltiIpnReceived implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence key = null;
    private final CharSequence cDate = null;
    private final CharSequence type = null;
    private final Long payeeId = null;
    private final CharSequence refCode = null;
    private final Boolean isPayable = null;
    private final CharSequence complianceReviewStatus = null;
    private final CharSequence payeeStatus = null;
    private final CharSequence groupPayments = null;
    private final CharSequence submittedDate = null;
    private final CharSequence approvalDate = null;
    private final CharSequence declinedDate = null;
    private final transient String analyticsSchemaTypeName = "tipalti_ipn_received";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackTipaltiIpnReceived)) {
            return false;
        }
        TrackTipaltiIpnReceived trackTipaltiIpnReceived = (TrackTipaltiIpnReceived) other;
        return Intrinsics3.areEqual(this.key, trackTipaltiIpnReceived.key) && Intrinsics3.areEqual(this.cDate, trackTipaltiIpnReceived.cDate) && Intrinsics3.areEqual(this.type, trackTipaltiIpnReceived.type) && Intrinsics3.areEqual(this.payeeId, trackTipaltiIpnReceived.payeeId) && Intrinsics3.areEqual(this.refCode, trackTipaltiIpnReceived.refCode) && Intrinsics3.areEqual(this.isPayable, trackTipaltiIpnReceived.isPayable) && Intrinsics3.areEqual(this.complianceReviewStatus, trackTipaltiIpnReceived.complianceReviewStatus) && Intrinsics3.areEqual(this.payeeStatus, trackTipaltiIpnReceived.payeeStatus) && Intrinsics3.areEqual(this.groupPayments, trackTipaltiIpnReceived.groupPayments) && Intrinsics3.areEqual(this.submittedDate, trackTipaltiIpnReceived.submittedDate) && Intrinsics3.areEqual(this.approvalDate, trackTipaltiIpnReceived.approvalDate) && Intrinsics3.areEqual(this.declinedDate, trackTipaltiIpnReceived.declinedDate);
    }

    public int hashCode() {
        CharSequence charSequence = this.key;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.cDate;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.type;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Long l = this.payeeId;
        int iHashCode4 = (iHashCode3 + (l != null ? l.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.refCode;
        int iHashCode5 = (iHashCode4 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Boolean bool = this.isPayable;
        int iHashCode6 = (iHashCode5 + (bool != null ? bool.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.complianceReviewStatus;
        int iHashCode7 = (iHashCode6 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        CharSequence charSequence6 = this.payeeStatus;
        int iHashCode8 = (iHashCode7 + (charSequence6 != null ? charSequence6.hashCode() : 0)) * 31;
        CharSequence charSequence7 = this.groupPayments;
        int iHashCode9 = (iHashCode8 + (charSequence7 != null ? charSequence7.hashCode() : 0)) * 31;
        CharSequence charSequence8 = this.submittedDate;
        int iHashCode10 = (iHashCode9 + (charSequence8 != null ? charSequence8.hashCode() : 0)) * 31;
        CharSequence charSequence9 = this.approvalDate;
        int iHashCode11 = (iHashCode10 + (charSequence9 != null ? charSequence9.hashCode() : 0)) * 31;
        CharSequence charSequence10 = this.declinedDate;
        return iHashCode11 + (charSequence10 != null ? charSequence10.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackTipaltiIpnReceived(key=");
        sbU.append(this.key);
        sbU.append(", cDate=");
        sbU.append(this.cDate);
        sbU.append(", type=");
        sbU.append(this.type);
        sbU.append(", payeeId=");
        sbU.append(this.payeeId);
        sbU.append(", refCode=");
        sbU.append(this.refCode);
        sbU.append(", isPayable=");
        sbU.append(this.isPayable);
        sbU.append(", complianceReviewStatus=");
        sbU.append(this.complianceReviewStatus);
        sbU.append(", payeeStatus=");
        sbU.append(this.payeeStatus);
        sbU.append(", groupPayments=");
        sbU.append(this.groupPayments);
        sbU.append(", submittedDate=");
        sbU.append(this.submittedDate);
        sbU.append(", approvalDate=");
        sbU.append(this.approvalDate);
        sbU.append(", declinedDate=");
        return outline.E(sbU, this.declinedDate, ")");
    }
}
