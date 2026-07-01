package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.application.Unread$Marker;
import rx.functions.Func3;

/* JADX INFO: compiled from: StoreReadStates.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreReadStates$computeUnreadMarker$1$3<T1, T2, T3, R> implements Func3<StoreMessageAck$Ack, StoreMessageAck$Ack, Long, Unread$Marker> {
    public final /* synthetic */ long $channelId;

    public StoreReadStates$computeUnreadMarker$1$3(long j) {
        this.$channelId = j;
    }

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ Unread$Marker call(StoreMessageAck$Ack storeMessageAck$Ack, StoreMessageAck$Ack storeMessageAck$Ack2, Long l) {
        return call2(storeMessageAck$Ack, storeMessageAck$Ack2, l);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Unread$Marker call2(StoreMessageAck$Ack storeMessageAck$Ack, StoreMessageAck$Ack storeMessageAck$Ack2, Long l) {
        if (storeMessageAck$Ack2 == null || !storeMessageAck$Ack2.isLockedAck()) {
            return storeMessageAck$Ack != null ? new Unread$Marker(this.$channelId, storeMessageAck$Ack.getMessageId(), l) : new Unread$Marker(this.$channelId, 0L, l);
        }
        return new Unread$Marker(this.$channelId, storeMessageAck$Ack2.getMessageId(), l);
    }
}
