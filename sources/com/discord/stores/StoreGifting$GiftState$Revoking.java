package com.discord.stores;

import b.d.b.a.a;
import com.discord.models.domain.ModelGift;
import d0.z.d.m;

/* JADX INFO: compiled from: StoreGifting.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreGifting$GiftState$Revoking extends StoreGifting$GiftState implements StoreGifting$HasGift {
    private final ModelGift gift;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGifting$GiftState$Revoking(ModelGift modelGift) {
        super(null);
        m.checkNotNullParameter(modelGift, "gift");
        this.gift = modelGift;
    }

    public static /* synthetic */ StoreGifting$GiftState$Revoking copy$default(StoreGifting$GiftState$Revoking storeGifting$GiftState$Revoking, ModelGift modelGift, int i, Object obj) {
        if ((i & 1) != 0) {
            modelGift = storeGifting$GiftState$Revoking.getGift();
        }
        return storeGifting$GiftState$Revoking.copy(modelGift);
    }

    public final ModelGift component1() {
        return getGift();
    }

    public final StoreGifting$GiftState$Revoking copy(ModelGift gift) {
        m.checkNotNullParameter(gift, "gift");
        return new StoreGifting$GiftState$Revoking(gift);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof StoreGifting$GiftState$Revoking) && m.areEqual(getGift(), ((StoreGifting$GiftState$Revoking) other).getGift());
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
        StringBuilder sbU = a.U("Revoking(gift=");
        sbU.append(getGift());
        sbU.append(")");
        return sbU.toString();
    }
}
