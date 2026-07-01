package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.message.Message;
import d0.t.s;
import d0.z.d.m;
import java.util.List;
import rx.functions.Func2;

/* JADX INFO: compiled from: StoreReadStates.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreReadStates$observeUnreadCountForChannel$2<T1, T2, R> implements Func2<List<? extends Message>, StoreMessageAck$Ack, Integer> {
    public final /* synthetic */ UtcDateTime $since;
    public final /* synthetic */ StoreReadStates this$0;

    public StoreReadStates$observeUnreadCountForChannel$2(StoreReadStates storeReadStates, UtcDateTime utcDateTime) {
        this.this$0 = storeReadStates;
        this.$since = utcDateTime;
    }

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ Integer call(List<? extends Message> list, StoreMessageAck$Ack storeMessageAck$Ack) {
        return call2((List<Message>) list, storeMessageAck$Ack);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Integer call2(List<Message> list, StoreMessageAck$Ack storeMessageAck$Ack) {
        Long lValueOf = storeMessageAck$Ack != null ? Long.valueOf(storeMessageAck$Ack.getMessageId()) : null;
        m.checkNotNullExpressionValue(list, "messages");
        int i = 0;
        if (!list.isEmpty()) {
            for (Message message : s.asReversed(list)) {
                if (lValueOf != null && message.getId() == storeMessageAck$Ack.getMessageId()) {
                    break;
                }
                if (StoreReadStates.access$wasMessageSentAfterTimestamp(this.this$0, this.$since, Long.valueOf(message.getId()))) {
                    i++;
                }
            }
        }
        return Integer.valueOf(i);
    }
}
