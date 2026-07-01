package com.discord.analytics.generated.traits;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

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
        return Intrinsics3.areEqual(this.price, trackPriceMetadata.price) && Intrinsics3.areEqual(this.regularPrice, trackPriceMetadata.regularPrice) && Intrinsics3.areEqual(this.currency, trackPriceMetadata.currency);
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
        StringBuilder sbU = outline.U("TrackPriceMetadata(price=");
        sbU.append(this.price);
        sbU.append(", regularPrice=");
        sbU.append(this.regularPrice);
        sbU.append(", currency=");
        return outline.E(sbU, this.currency, ")");
    }
}
