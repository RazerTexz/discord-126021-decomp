package com.discord.stores;

import androidx.core.app.NotificationCompat;
import j0.k.b;
import java.util.Map;

/* JADX INFO: compiled from: StoreReadStates.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreReadStates$computeUnreadMarker$1$1<T, R> implements b<Map<Long, ? extends StoreMessageAck$Ack>, StoreMessageAck$Ack> {
    public final /* synthetic */ long $channelId;

    public StoreReadStates$computeUnreadMarker$1$1(long j) {
        this.$channelId = j;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ StoreMessageAck$Ack call(Map<Long, ? extends StoreMessageAck$Ack> map) {
        return call2((Map<Long, StoreMessageAck$Ack>) map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final StoreMessageAck$Ack call2(Map<Long, StoreMessageAck$Ack> map) {
        return map.get(Long.valueOf(this.$channelId));
    }
}
