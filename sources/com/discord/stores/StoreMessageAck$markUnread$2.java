package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.message.Message;
import java.util.List;
import kotlin.Pair;
import rx.functions.Func2;

/* JADX INFO: compiled from: StoreMessageAck.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessageAck$markUnread$2<T1, T2, R> implements Func2<List<? extends Message>, StoreMessageAck$Companion$ThreadAckState, Pair<? extends List<? extends Message>, ? extends StoreMessageAck$Companion$ThreadAckState>> {
    public static final StoreMessageAck$markUnread$2 INSTANCE = new StoreMessageAck$markUnread$2();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ Pair<? extends List<? extends Message>, ? extends StoreMessageAck$Companion$ThreadAckState> call(List<? extends Message> list, StoreMessageAck$Companion$ThreadAckState storeMessageAck$Companion$ThreadAckState) {
        return call2((List<Message>) list, storeMessageAck$Companion$ThreadAckState);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Pair<List<Message>, StoreMessageAck$Companion$ThreadAckState> call2(List<Message> list, StoreMessageAck$Companion$ThreadAckState storeMessageAck$Companion$ThreadAckState) {
        return new Pair<>(list, storeMessageAck$Companion$ThreadAckState);
    }
}
