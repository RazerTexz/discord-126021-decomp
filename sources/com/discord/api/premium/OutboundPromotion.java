package com.discord.api.premium;

import b.d.b.a.a;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: OutboundPromotion.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class OutboundPromotion {
    private final UtcDateTime endDate;
    private final long id;
    private final String outboundRedemptionModalBody;
    private final String outboundRedemptionPageLink;
    private final String outboundRedemptionUrlFormat;
    private final String outboundTermsAndConditions;
    private final String outboundTitle;
    private final UtcDateTime startDate;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final UtcDateTime getEndDate() {
        return this.endDate;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getOutboundRedemptionModalBody() {
        return this.outboundRedemptionModalBody;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final String getOutboundRedemptionPageLink() {
        return this.outboundRedemptionPageLink;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final String getOutboundRedemptionUrlFormat() {
        return this.outboundRedemptionUrlFormat;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OutboundPromotion)) {
            return false;
        }
        OutboundPromotion outboundPromotion = (OutboundPromotion) other;
        return this.id == outboundPromotion.id && m.areEqual(this.startDate, outboundPromotion.startDate) && m.areEqual(this.endDate, outboundPromotion.endDate) && m.areEqual(this.outboundTitle, outboundPromotion.outboundTitle) && m.areEqual(this.outboundRedemptionModalBody, outboundPromotion.outboundRedemptionModalBody) && m.areEqual(this.outboundRedemptionPageLink, outboundPromotion.outboundRedemptionPageLink) && m.areEqual(this.outboundRedemptionUrlFormat, outboundPromotion.outboundRedemptionUrlFormat) && m.areEqual(this.outboundTermsAndConditions, outboundPromotion.outboundTermsAndConditions);
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final String getOutboundTermsAndConditions() {
        return this.outboundTermsAndConditions;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final String getOutboundTitle() {
        return this.outboundTitle;
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    public final UtcDateTime getStartDate() {
        return this.startDate;
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        UtcDateTime utcDateTime = this.startDate;
        int iHashCode = (i + (utcDateTime != null ? utcDateTime.hashCode() : 0)) * 31;
        UtcDateTime utcDateTime2 = this.endDate;
        int iHashCode2 = (iHashCode + (utcDateTime2 != null ? utcDateTime2.hashCode() : 0)) * 31;
        String str = this.outboundTitle;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.outboundRedemptionModalBody;
        int iHashCode4 = (iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.outboundRedemptionPageLink;
        int iHashCode5 = (iHashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.outboundRedemptionUrlFormat;
        int iHashCode6 = (iHashCode5 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.outboundTermsAndConditions;
        return iHashCode6 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("OutboundPromotion(id=");
        sbU.append(this.id);
        sbU.append(", startDate=");
        sbU.append(this.startDate);
        sbU.append(", endDate=");
        sbU.append(this.endDate);
        sbU.append(", outboundTitle=");
        sbU.append(this.outboundTitle);
        sbU.append(", outboundRedemptionModalBody=");
        sbU.append(this.outboundRedemptionModalBody);
        sbU.append(", outboundRedemptionPageLink=");
        sbU.append(this.outboundRedemptionPageLink);
        sbU.append(", outboundRedemptionUrlFormat=");
        sbU.append(this.outboundRedemptionUrlFormat);
        sbU.append(", outboundTermsAndConditions=");
        return a.J(sbU, this.outboundTermsAndConditions, ")");
    }
}
