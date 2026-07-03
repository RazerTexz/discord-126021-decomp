package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackPaymentSourceAdded.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackPaymentSourceAdded implements AnalyticsSchema, TrackBaseReceiver {
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
        return C12238m.areEqual(this.paymentSourceId, trackPaymentSourceAdded.paymentSourceId) && C12238m.areEqual(this.paymentSourceType, trackPaymentSourceAdded.paymentSourceType) && C12238m.areEqual(this.paymentGateway, trackPaymentSourceAdded.paymentGateway) && C12238m.areEqual(this.cardBrand, trackPaymentSourceAdded.cardBrand) && C12238m.areEqual(this.cardExpirationDate, trackPaymentSourceAdded.cardExpirationDate) && C12238m.areEqual(this.paymentSourceCountry, trackPaymentSourceAdded.paymentSourceCountry) && C12238m.areEqual(this.isDefault, trackPaymentSourceAdded.isDefault);
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
        StringBuilder sbM833U = C1643a.m833U("TrackPaymentSourceAdded(paymentSourceId=");
        sbM833U.append(this.paymentSourceId);
        sbM833U.append(", paymentSourceType=");
        sbM833U.append(this.paymentSourceType);
        sbM833U.append(", paymentGateway=");
        sbM833U.append(this.paymentGateway);
        sbM833U.append(", cardBrand=");
        sbM833U.append(this.cardBrand);
        sbM833U.append(", cardExpirationDate=");
        sbM833U.append(this.cardExpirationDate);
        sbM833U.append(", paymentSourceCountry=");
        sbM833U.append(this.paymentSourceCountry);
        sbM833U.append(", isDefault=");
        return C1643a.m816D(sbM833U, this.isDefault, ")");
    }
}
