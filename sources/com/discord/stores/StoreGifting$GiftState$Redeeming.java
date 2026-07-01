package com.discord.stores;

import b.d.b.a.a;
import com.discord.models.domain.ModelGift;
import d0.z.d.m;

/* JADX INFO: compiled from: StoreGifting.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreGifting$GiftState$Redeeming extends StoreGifting$GiftState implements StoreGifting$HasGift {
    private final ModelGift gift;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGifting$GiftState$Redeeming(ModelGift modelGift) {
        super(null);
        m.checkNotNullParameter(modelGift, "gift");
        this.gift = modelGift;
    }

    public static /* synthetic */ StoreGifting$GiftState$Redeeming copy$default(StoreGifting$GiftState$Redeeming storeGifting$GiftState$Redeeming, ModelGift modelGift, int i, Object obj) {
        if ((i & 1) != 0) {
            modelGift = storeGifting$GiftState$Redeeming.getGift();
        }
        return storeGifting$GiftState$Redeeming.copy(modelGift);
    }

    public final ModelGift component1() {
        return getGift();
    }

    public final StoreGifting$GiftState$Redeeming copy(ModelGift gift) {
        m.checkNotNullParameter(gift, "gift");
        return new StoreGifting$GiftState$Redeeming(gift);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof StoreGifting$GiftState$Redeeming) && m.areEqual(getGift(), ((StoreGifting$GiftState$Redeeming) other).getGift());
        }
        return true;
    }

    @Override // com.discord.stores.StoreGifting$HasGift
    public ModelGift getGift() {
        return this.gift;
    }

    public int hashCode() {
        ModelGift gift = getGift();
        if (gift != null) {
            return gift.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("Redeeming(gift=");
        sbU.append(getGift());
        sbU.append(")");
        return sbU.toString();
    }
}
