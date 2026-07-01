package com.discord.widgets.status;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreMessageAck$Ack;
import d0.z.d.m;
import rx.functions.Func2;

/* JADX INFO: compiled from: WidgetChatStatus.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatStatus$Model$Companion$get$isUnreadValidObs$1$isLastAckOlderThanMostRecent$1<T1, T2, R> implements Func2<StoreMessageAck$Ack, Long, Boolean> {
    public static final WidgetChatStatus$Model$Companion$get$isUnreadValidObs$1$isLastAckOlderThanMostRecent$1 INSTANCE = new WidgetChatStatus$Model$Companion$get$isUnreadValidObs$1$isLastAckOlderThanMostRecent$1();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ Boolean call(StoreMessageAck$Ack storeMessageAck$Ack, Long l) {
        return call2(storeMessageAck$Ack, l);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(StoreMessageAck$Ack storeMessageAck$Ack, Long l) {
        long messageId = storeMessageAck$Ack != null ? storeMessageAck$Ack.getMessageId() : 0L;
        m.checkNotNullExpressionValue(l, "mostRecentIdSnapshot");
        return Boolean.valueOf(messageId < l.longValue());
    }
}
