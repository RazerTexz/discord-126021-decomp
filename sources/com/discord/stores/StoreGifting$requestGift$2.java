package com.discord.stores;

import androidx.core.app.NotificationCompat;
import j0.k.b;
import java.util.Map;

/* JADX INFO: compiled from: StoreGifting.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGifting$requestGift$2<T, R> implements b<Map<String, ? extends StoreGifting$GiftState>, StoreGifting$GiftState> {
    public final /* synthetic */ String $giftCode;

    public StoreGifting$requestGift$2(String str) {
        this.$giftCode = str;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ StoreGifting$GiftState call(Map<String, ? extends StoreGifting$GiftState> map) {
        return call2(map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final StoreGifting$GiftState call2(Map<String, ? extends StoreGifting$GiftState> map) {
        StoreGifting$GiftState storeGifting$GiftState = map.get(this.$giftCode);
        return storeGifting$GiftState != null ? storeGifting$GiftState : StoreGifting$GiftState$Loading.INSTANCE;
    }
}
