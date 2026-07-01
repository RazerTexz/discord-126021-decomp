package com.discord.stores;

import androidx.core.app.NotificationCompat;
import j0.k.b;

/* JADX INFO: compiled from: StoreMessageAck.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessageAck$init$1$2<T, R> implements b<StoreChat$InteractionState, Boolean> {
    public final /* synthetic */ StoreChannelsSelected$ResolvedSelectedChannel $selectedChannel;

    public StoreMessageAck$init$1$2(StoreChannelsSelected$ResolvedSelectedChannel storeChannelsSelected$ResolvedSelectedChannel) {
        this.$selectedChannel = storeChannelsSelected$ResolvedSelectedChannel;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Boolean call(StoreChat$InteractionState storeChat$InteractionState) {
        return call2(storeChat$InteractionState);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(StoreChat$InteractionState storeChat$InteractionState) {
        return Boolean.valueOf(storeChat$InteractionState.getChannelId() == this.$selectedChannel.getId());
    }
}
