package com.discord.analytics.generated.traits;

import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackPaymentMetadata.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackPaymentMetadata {
    private final CharSequence paymentType = null;
    private final Long price = null;
    private final Long regularPrice = null;
    private final CharSequence currency = null;
    private final Boolean isGift = null;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackPaymentMetadata)) {
            return false;
        }
        TrackPaymentMetadata trackPaymentMetadata = (TrackPaymentMetadata) other;
        return C12238m.areEqual(this.paymentType, trackPaymentMetadata.paymentType) && C12238m.areEqual(this.price, trackPaymentMetadata.price) && C12238m.areEqual(this.regularPrice, trackPaymentMetadata.regularPrice) && C12238m.areEqual(this.currency, trackPaymentMetadata.currency) && C12238m.areEqual(this.isGift, trackPaymentMetadata.isGift);
    }

    public int hashCode() {
        CharSequence charSequence = this.paymentType;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.price;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.regularPrice;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.currency;
        int iHashCode4 = (iHashCode3 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Boolean bool = this.isGift;
        return iHashCode4 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackPaymentMetadata(paymentType=");
        sbM833U.append(this.paymentType);
        sbM833U.append(", price=");
        sbM833U.append(this.price);
        sbM833U.append(", regularPrice=");
        sbM833U.append(this.regularPrice);
        sbM833U.append(", currency=");
        sbM833U.append(this.currency);
        sbM833U.append(", isGift=");
        return C1643a.m816D(sbM833U, this.isGift, ")");
    }
}
