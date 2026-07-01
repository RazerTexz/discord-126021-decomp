package com.discord.stores;

import androidx.core.app.NotificationCompat;
import j0.k.b;
import java.util.Map;

/* JADX INFO: compiled from: StoreMessagesLoader.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessagesLoader$getMessagesLoadedState$1<T, R> implements b<Map<Long, ? extends StoreMessagesLoader$ChannelLoadedState>, StoreMessagesLoader$ChannelLoadedState> {
    public final /* synthetic */ long $channelId;

    public StoreMessagesLoader$getMessagesLoadedState$1(long j) {
        this.$channelId = j;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ StoreMessagesLoader$ChannelLoadedState call(Map<Long, ? extends StoreMessagesLoader$ChannelLoadedState> map) {
        return call2((Map<Long, StoreMessagesLoader$ChannelLoadedState>) map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final StoreMessagesLoader$ChannelLoadedState call2(Map<Long, StoreMessagesLoader$ChannelLoadedState> map) {
        StoreMessagesLoader$ChannelLoadedState storeMessagesLoader$ChannelLoadedState = map.get(Long.valueOf(this.$channelId));
        return storeMessagesLoader$ChannelLoadedState != null ? storeMessagesLoader$ChannelLoadedState : new StoreMessagesLoader$ChannelLoadedState(false, false, false, false, null, 31, null);
    }
}
