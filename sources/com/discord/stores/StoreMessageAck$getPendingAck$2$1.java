package com.discord.stores;

import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import rx.functions.Func3;

/* JADX INFO: compiled from: StoreMessageAck.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessageAck$getPendingAck$2$1<T1, T2, T3, R> implements Func3<StoreMessageAck$Ack, Long, StoreMessageAck$Companion$ThreadAckState, StoreMessageAck$PendingAck> {
    public final /* synthetic */ Long $channelId;
    public final /* synthetic */ StoreMessageAck$getPendingAck$2 this$0;

    public StoreMessageAck$getPendingAck$2$1(StoreMessageAck$getPendingAck$2 storeMessageAck$getPendingAck$2, Long l) {
        this.this$0 = storeMessageAck$getPendingAck$2;
        this.$channelId = l;
    }

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ StoreMessageAck$PendingAck call(StoreMessageAck$Ack storeMessageAck$Ack, Long l, StoreMessageAck$Companion$ThreadAckState storeMessageAck$Companion$ThreadAckState) {
        return call2(storeMessageAck$Ack, l, storeMessageAck$Companion$ThreadAckState);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002a, code lost:
    
        if (r8.invoke(r6, r7.longValue()) != false) goto L14;
     */
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final StoreMessageAck$PendingAck call2(StoreMessageAck$Ack storeMessageAck$Ack, Long l, StoreMessageAck$Companion$ThreadAckState storeMessageAck$Companion$ThreadAckState) {
        StoreMessageAck$Companion storeMessageAck$Companion = StoreMessageAck.Companion;
        if (storeMessageAck$Companion.isNonThreadChannel(storeMessageAck$Companion$ThreadAckState) || storeMessageAck$Companion.isThreadAndAbleToAck(storeMessageAck$Companion$ThreadAckState)) {
            StoreMessageAck$getPendingAck$2 storeMessageAck$getPendingAck$2 = this.this$0;
            if (!storeMessageAck$getPendingAck$2.$isLockedAck) {
                StoreMessageAck$getPendingAck$1 storeMessageAck$getPendingAck$1 = storeMessageAck$getPendingAck$2.$isUpdateRequired$1;
                m.checkNotNullExpressionValue(l, "mostRecentMessageId");
            }
            Long l2 = this.$channelId;
            m.checkNotNullExpressionValue(l2, "channelId");
            long jLongValue = l2.longValue();
            m.checkNotNullExpressionValue(l, "mostRecentMessageId");
            return new StoreMessageAck$PendingAck(jLongValue, new StoreMessageAck$Ack(l.longValue(), true, this.this$0.$isLockedAck));
        }
        return StoreMessageAck$PendingAck.Companion.getEMPTY();
    }
}
