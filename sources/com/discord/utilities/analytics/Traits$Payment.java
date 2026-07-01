package com.discord.utilities.analytics;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.Map;

/* JADX INFO: compiled from: Traits.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class Traits$Payment {
    private final String currency;
    private final boolean isGift;
    private final int price;
    private final int regularPrice;
    private final String type;

    public Traits$Payment(String str, int i, int i2, String str2, boolean z2) {
        m.checkNotNullParameter(str, "type");
        m.checkNotNullParameter(str2, "currency");
        this.type = str;
        this.price = i;
        this.regularPrice = i2;
        this.currency = str2;
        this.isGift = z2;
    }

    public static /* synthetic */ Traits$Payment copy$default(Traits$Payment traits$Payment, String str, int i, int i2, String str2, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = traits$Payment.type;
        }
        if ((i3 & 2) != 0) {
            i = traits$Payment.price;
        }
        int i4 = i;
        if ((i3 & 4) != 0) {
            i2 = traits$Payment.regularPrice;
        }
        int i5 = i2;
        if ((i3 & 8) != 0) {
            str2 = traits$Payment.currency;
        }
        String str3 = str2;
        if ((i3 & 16) != 0) {
            z2 = traits$Payment.isGift;
        }
        return traits$Payment.copy(str, i4, i5, str3, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getPrice() {
        return this.price;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getRegularPrice() {
        return this.regularPrice;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getCurrency() {
        return this.currency;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsGift() {
        return this.isGift;
    }

    public final Traits$Payment copy(String type, int price, int regularPrice, String currency, boolean isGift) {
        m.checkNotNullParameter(type, "type");
        m.checkNotNullParameter(currency, "currency");
        return new Traits$Payment(type, price, regularPrice, currency, isGift);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Traits$Payment)) {
            return false;
        }
        Traits$Payment traits$Payment = (Traits$Payment) other;
        return m.areEqual(this.type, traits$Payment.type) && this.price == traits$Payment.price && this.regularPrice == traits$Payment.regularPrice && m.areEqual(this.currency, traits$Payment.currency) && this.isGift == traits$Payment.isGift;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final int getPrice() {
        return this.price;
    }

    public final int getRegularPrice() {
        return this.regularPrice;
    }

    public final String getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        String str = this.type;
        int iHashCode = (((((str != null ? str.hashCode() : 0) * 31) + this.price) * 31) + this.regularPrice) * 31;
        String str2 = this.currency;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z2 = this.isGift;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode2 + r1;
    }

    public final boolean isGift() {
        return this.isGift;
    }

    public final void serializeTo(Map<String, Object> properties) {
        m.checkNotNullParameter(properties, "properties");
        properties.put("payment_type", this.type);
        properties.put("price", Integer.valueOf(this.price));
        properties.put("regular_price", Integer.valueOf(this.regularPrice));
        properties.put("currency", this.currency);
        properties.put("is_gift", Boolean.valueOf(this.isGift));
    }

    public String toString() {
        StringBuilder sbU = a.U("Payment(type=");
        sbU.append(this.type);
        sbU.append(", price=");
        sbU.append(this.price);
        sbU.append(", regularPrice=");
        sbU.append(this.regularPrice);
        sbU.append(", currency=");
        sbU.append(this.currency);
        sbU.append(", isGift=");
        return a.O(sbU, this.isGift, ")");
    }
}
