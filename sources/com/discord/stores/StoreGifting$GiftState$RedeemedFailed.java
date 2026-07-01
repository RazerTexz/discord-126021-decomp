package com.discord.stores;

import b.d.b.a.a;
import com.discord.models.domain.ModelGift;
import d0.z.d.m;

/* JADX INFO: compiled from: StoreGifting.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreGifting$GiftState$RedeemedFailed extends StoreGifting$GiftState implements StoreGifting$HasGift {
    private final boolean canRetry;
    private final Integer errorCode;
    private final ModelGift gift;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGifting$GiftState$RedeemedFailed(ModelGift modelGift, boolean z2, Integer num) {
        super(null);
        m.checkNotNullParameter(modelGift, "gift");
        this.gift = modelGift;
        this.canRetry = z2;
        this.errorCode = num;
    }

    public static /* synthetic */ StoreGifting$GiftState$RedeemedFailed copy$default(StoreGifting$GiftState$RedeemedFailed storeGifting$GiftState$RedeemedFailed, ModelGift modelGift, boolean z2, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            modelGift = storeGifting$GiftState$RedeemedFailed.getGift();
        }
        if ((i & 2) != 0) {
            z2 = storeGifting$GiftState$RedeemedFailed.canRetry;
        }
        if ((i & 4) != 0) {
            num = storeGifting$GiftState$RedeemedFailed.errorCode;
        }
        return storeGifting$GiftState$RedeemedFailed.copy(modelGift, z2, num);
    }

    public final ModelGift component1() {
        return getGift();
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getCanRetry() {
        return this.canRetry;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getErrorCode() {
        return this.errorCode;
    }

    public final StoreGifting$GiftState$RedeemedFailed copy(ModelGift gift, boolean canRetry, Integer errorCode) {
        m.checkNotNullParameter(gift, "gift");
        return new StoreGifting$GiftState$RedeemedFailed(gift, canRetry, errorCode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreGifting$GiftState$RedeemedFailed)) {
            return false;
        }
        StoreGifting$GiftState$RedeemedFailed storeGifting$GiftState$RedeemedFailed = (StoreGifting$GiftState$RedeemedFailed) other;
        return m.areEqual(getGift(), storeGifting$GiftState$RedeemedFailed.getGift()) && this.canRetry == storeGifting$GiftState$RedeemedFailed.canRetry && m.areEqual(this.errorCode, storeGifting$GiftState$RedeemedFailed.errorCode);
    }

    public final boolean getCanRetry() {
        return this.canRetry;
    }

    public final Integer getErrorCode() {
        return this.errorCode;
    }

    @Override // com.discord.stores.StoreGifting$HasGift
    public ModelGift getGift() {
        return this.gift;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        ModelGift gift = getGift();
        int iHashCode = (gift != null ? gift.hashCode() : 0) * 31;
        boolean z2 = this.canRetry;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode + r2) * 31;
        Integer num = this.errorCode;
        return i + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("RedeemedFailed(gift=");
        sbU.append(getGift());
        sbU.append(", canRetry=");
        sbU.append(this.canRetry);
        sbU.append(", errorCode=");
        return a.F(sbU, this.errorCode, ")");
    }
}
