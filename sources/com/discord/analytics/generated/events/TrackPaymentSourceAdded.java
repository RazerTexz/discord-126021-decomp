package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackPaymentSourceAdded.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackPaymentSourceAdded implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long paymentSourceId = null;
    private final Long paymentSourceType = null;
    private final Long paymentGateway = null;
    private final CharSequence cardBrand = null;
    private final Long cardExpirationDate = null;
    private final CharSequence paymentSourceCountry = null;
    private final Boolean isDefault = null;
    private final transient String analyticsSchemaTypeName = "payment_source_added";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackPaymentSourceAdded)) {
            return false;
        }
        TrackPaymentSourceAdded trackPaymentSourceAdded = (TrackPaymentSourceAdded) other;
        return Intrinsics3.areEqual(this.paymentSourceId, trackPaymentSourceAdded.paymentSourceId) && Intrinsics3.areEqual(this.paymentSourceType, trackPaymentSourceAdded.paymentSourceType) && Intrinsics3.areEqual(this.paymentGateway, trackPaymentSourceAdded.paymentGateway) && Intrinsics3.areEqual(this.cardBrand, trackPaymentSourceAdded.cardBrand) && Intrinsics3.areEqual(this.cardExpirationDate, trackPaymentSourceAdded.cardExpirationDate) && Intrinsics3.areEqual(this.paymentSourceCountry, trackPaymentSourceAdded.paymentSourceCountry) && Intrinsics3.areEqual(this.isDefault, trackPaymentSourceAdded.isDefault);
    }

    public int hashCode() {
        Long l = this.paymentSourceId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.paymentSourceType;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.paymentGateway;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        CharSequence charSequence = this.cardBrand;
        int iHashCode4 = (iHashCode3 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l4 = this.cardExpirationDate;
        int iHashCode5 = (iHashCode4 + (l4 != null ? l4.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.paymentSourceCountry;
        int iHashCode6 = (iHashCode5 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Boolean bool = this.isDefault;
        return iHashCode6 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackPaymentSourceAdded(paymentSourceId=");
        sbU.append(this.paymentSourceId);
        sbU.append(", paymentSourceType=");
        sbU.append(this.paymentSourceType);
        sbU.append(", paymentGateway=");
        sbU.append(this.paymentGateway);
        sbU.append(", cardBrand=");
        sbU.append(this.cardBrand);
        sbU.append(", cardExpirationDate=");
        sbU.append(this.cardExpirationDate);
        sbU.append(", paymentSourceCountry=");
        sbU.append(this.paymentSourceCountry);
        sbU.append(", isDefault=");
        return outline.D(sbU, this.isDefault, ")");
    }
}
