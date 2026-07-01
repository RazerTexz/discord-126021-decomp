package com.discord.analytics.generated.traits;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackPriceMetadata.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackPriceMetadata {
    private final Long price = null;
    private final Long regularPrice = null;
    private final CharSequence currency = null;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackPriceMetadata)) {
            return false;
        }
        TrackPriceMetadata trackPriceMetadata = (TrackPriceMetadata) other;
        return m.areEqual(this.price, trackPriceMetadata.price) && m.areEqual(this.regularPrice, trackPriceMetadata.regularPrice) && m.areEqual(this.currency, trackPriceMetadata.currency);
    }

    public int hashCode() {
        Long l = this.price;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.regularPrice;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence = this.currency;
        return iHashCode2 + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackPriceMetadata(price=");
        sbU.append(this.price);
        sbU.append(", regularPrice=");
        sbU.append(this.regularPrice);
        sbU.append(", currency=");
        return a.E(sbU, this.currency, ")");
    }
}
