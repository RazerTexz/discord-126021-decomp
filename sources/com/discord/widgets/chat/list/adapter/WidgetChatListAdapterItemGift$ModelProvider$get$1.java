package com.discord.widgets.chat.list.adapter;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreGifting$GiftState;
import com.discord.stores.StoreGifting$GiftState$Invalid;
import com.discord.stores.StoreGifting$GiftState$LoadFailed;
import com.discord.stores.StoreGifting$GiftState$Loading;
import com.discord.stores.StoreGifting$GiftState$RedeemedFailed;
import com.discord.stores.StoreGifting$GiftState$Redeeming;
import com.discord.stores.StoreGifting$GiftState$Resolved;
import com.discord.stores.StoreGifting$GiftState$Revoking;
import com.discord.widgets.chat.list.entries.GiftEntry;
import j0.k.b;
import j0.l.e.k;
import kotlin.NoWhenBranchMatchedException;
import rx.Observable;

/* JADX INFO: compiled from: WidgetChatListAdapterItemGift.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemGift$ModelProvider$get$1<T, R> implements b<StoreGifting$GiftState, Observable<? extends WidgetChatListAdapterItemGift$Model>> {
    public final /* synthetic */ GiftEntry $item;

    public WidgetChatListAdapterItemGift$ModelProvider$get$1(GiftEntry giftEntry) {
        this.$item = giftEntry;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetChatListAdapterItemGift$Model> call(StoreGifting$GiftState storeGifting$GiftState) {
        return call2(storeGifting$GiftState);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetChatListAdapterItemGift$Model> call2(StoreGifting$GiftState storeGifting$GiftState) {
        if ((storeGifting$GiftState instanceof StoreGifting$GiftState$Loading) || (storeGifting$GiftState instanceof StoreGifting$GiftState$LoadFailed)) {
            return new k(WidgetChatListAdapterItemGift$Model$Loading.INSTANCE);
        }
        if (storeGifting$GiftState instanceof StoreGifting$GiftState$Revoking) {
            return WidgetChatListAdapterItemGift$ModelProvider.getResolvedGiftModel$default(WidgetChatListAdapterItemGift$ModelProvider.INSTANCE, ((StoreGifting$GiftState$Revoking) storeGifting$GiftState).getGift(), false, 2, null);
        }
        if (storeGifting$GiftState instanceof StoreGifting$GiftState$Resolved) {
            return WidgetChatListAdapterItemGift$ModelProvider.getResolvedGiftModel$default(WidgetChatListAdapterItemGift$ModelProvider.INSTANCE, ((StoreGifting$GiftState$Resolved) storeGifting$GiftState).getGift(), false, 2, null);
        }
        if (storeGifting$GiftState instanceof StoreGifting$GiftState$Redeeming) {
            return WidgetChatListAdapterItemGift$ModelProvider.access$getResolvedGiftModel(WidgetChatListAdapterItemGift$ModelProvider.INSTANCE, ((StoreGifting$GiftState$Redeeming) storeGifting$GiftState).getGift(), true);
        }
        if (storeGifting$GiftState instanceof StoreGifting$GiftState$RedeemedFailed) {
            return WidgetChatListAdapterItemGift$ModelProvider.getResolvedGiftModel$default(WidgetChatListAdapterItemGift$ModelProvider.INSTANCE, ((StoreGifting$GiftState$RedeemedFailed) storeGifting$GiftState).getGift(), false, 2, null);
        }
        if (storeGifting$GiftState instanceof StoreGifting$GiftState$Invalid) {
            return WidgetChatListAdapterItemGift$ModelProvider.access$getInvalidGift(WidgetChatListAdapterItemGift$ModelProvider.INSTANCE, this.$item);
        }
        throw new NoWhenBranchMatchedException();
    }
}
