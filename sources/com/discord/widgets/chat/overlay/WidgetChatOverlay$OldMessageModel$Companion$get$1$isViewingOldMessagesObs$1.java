package com.discord.widgets.chat.overlay;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreChat$InteractionState;
import j0.k.b;

/* JADX INFO: compiled from: WidgetChatOverlay.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatOverlay$OldMessageModel$Companion$get$1$isViewingOldMessagesObs$1<T, R> implements b<StoreChat$InteractionState, Boolean> {
    public final /* synthetic */ Long $selectedChannelId;

    public WidgetChatOverlay$OldMessageModel$Companion$get$1$isViewingOldMessagesObs$1(Long l) {
        this.$selectedChannelId = l;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Boolean call(StoreChat$InteractionState storeChat$InteractionState) {
        return call2(storeChat$InteractionState);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(StoreChat$InteractionState storeChat$InteractionState) {
        long channelId = storeChat$InteractionState.getChannelId();
        Long l = this.$selectedChannelId;
        return Boolean.valueOf((l == null || channelId != l.longValue() || storeChat$InteractionState.getLastMessageId() == 0) ? false : true);
    }
}
