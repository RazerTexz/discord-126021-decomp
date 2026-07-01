package com.discord.stores;

import androidx.core.app.NotificationCompat;
import j0.k.b;

/* JADX INFO: compiled from: StoreMessageAck.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessageAck$init$1$1<T, R> implements b<StoreMessagesLoader$ChannelLoadedState, Boolean> {
    public static final StoreMessageAck$init$1$1 INSTANCE = new StoreMessageAck$init$1$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Boolean call(StoreMessagesLoader$ChannelLoadedState storeMessagesLoader$ChannelLoadedState) {
        return call2(storeMessagesLoader$ChannelLoadedState);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(StoreMessagesLoader$ChannelLoadedState storeMessagesLoader$ChannelLoadedState) {
        return Boolean.valueOf(storeMessagesLoader$ChannelLoadedState.isInitialMessagesLoaded() && !storeMessagesLoader$ChannelLoadedState.isLoadingMessages());
    }
}
