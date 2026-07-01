package com.discord.widgets.chat.list.adapter;

import com.discord.models.domain.ModelGift;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreUser;
import com.discord.widgets.chat.list.entries.GiftEntry;
import d0.z.d.m;
import j0.l.e.k;
import rx.Observable;

/* JADX INFO: compiled from: WidgetChatListAdapterItemGift.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemGift$ModelProvider {
    public static final WidgetChatListAdapterItemGift$ModelProvider INSTANCE = new WidgetChatListAdapterItemGift$ModelProvider();

    private WidgetChatListAdapterItemGift$ModelProvider() {
    }

    public static final /* synthetic */ Observable access$getInvalidGift(WidgetChatListAdapterItemGift$ModelProvider widgetChatListAdapterItemGift$ModelProvider, GiftEntry giftEntry) {
        return widgetChatListAdapterItemGift$ModelProvider.getInvalidGift(giftEntry);
    }

    public static final /* synthetic */ Observable access$getResolvedGiftModel(WidgetChatListAdapterItemGift$ModelProvider widgetChatListAdapterItemGift$ModelProvider, ModelGift modelGift, boolean z2) {
        return widgetChatListAdapterItemGift$ModelProvider.getResolvedGiftModel(modelGift, z2);
    }

    private final Observable<WidgetChatListAdapterItemGift$Model> getInvalidGift(GiftEntry item) {
        Observable<WidgetChatListAdapterItemGift$Model> observableJ = Observable.j(new k(Long.valueOf(item.getUserId())), StoreStream.Companion.getUsers().observeMeId(), WidgetChatListAdapterItemGift$ModelProvider$getInvalidGift$1.INSTANCE);
        m.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…lid(authorUserId, meId) }");
        return observableJ;
    }

    private final Observable<WidgetChatListAdapterItemGift$Model> getResolvedGiftModel(ModelGift gift, boolean redeeming) {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable<WidgetChatListAdapterItemGift$Model> observableJ = Observable.j(StoreUser.observeMe$default(storeStream$Companion.getUsers(), false, 1, null), storeStream$Companion.getLibrary().observeApplications(), new WidgetChatListAdapterItemGift$ModelProvider$getResolvedGiftModel$1(gift, redeeming));
        m.checkNotNullExpressionValue(observableJ, "Observable.combineLatest… me.id)\n        }\n      }");
        return observableJ;
    }

    public static /* synthetic */ Observable getResolvedGiftModel$default(WidgetChatListAdapterItemGift$ModelProvider widgetChatListAdapterItemGift$ModelProvider, ModelGift modelGift, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        return widgetChatListAdapterItemGift$ModelProvider.getResolvedGiftModel(modelGift, z2);
    }

    public final Observable<WidgetChatListAdapterItemGift$Model> get(GiftEntry item) {
        m.checkNotNullParameter(item, "item");
        Observable observableY = StoreStream.Companion.getGifting().requestGift(item.getGiftCode()).Y(new WidgetChatListAdapterItemGift$ModelProvider$get$1(item));
        m.checkNotNullExpressionValue(observableY, "StoreStream\n            …          }\n            }");
        return observableY;
    }
}
