package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.message.Message;
import d0.z.d.m;
import j0.k.b;
import java.util.List;

/* JADX INFO: compiled from: StoreMessageAck.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessageAck$markUnread$1<T, R> implements b<List<? extends Message>, Boolean> {
    public static final StoreMessageAck$markUnread$1 INSTANCE = new StoreMessageAck$markUnread$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Boolean call(List<? extends Message> list) {
        return call2((List<Message>) list);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(List<Message> list) {
        m.checkNotNullExpressionValue(list, "it");
        return Boolean.valueOf(!list.isEmpty());
    }
}
