package com.discord.analytics.generated.traits;

import b.d.b.a.a;
import d0.z.d.m;

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
        return m.areEqual(this.paymentType, trackPaymentMetadata.paymentType) && m.areEqual(this.price, trackPaymentMetadata.price) && m.areEqual(this.regularPrice, trackPaymentMetadata.regularPrice) && m.areEqual(this.currency, trackPaymentMetadata.currency) && m.areEqual(this.isGift, trackPaymentMetadata.isGift);
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
        StringBuilder sbU = a.U("TrackPaymentMetadata(paymentType=");
        sbU.append(this.paymentType);
        sbU.append(", price=");
        sbU.append(this.price);
        sbU.append(", regularPrice=");
        sbU.append(this.regularPrice);
        sbU.append(", currency=");
        sbU.append(this.currency);
        sbU.append(", isGift=");
        return a.D(sbU, this.isGift, ")");
    }
}
