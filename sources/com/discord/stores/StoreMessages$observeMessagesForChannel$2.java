package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.message.Message;
import d0.z.d.m;
import j0.k.b;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: StoreMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessages$observeMessagesForChannel$2<T, R> implements b<List<? extends Message>, Message> {
    public final /* synthetic */ long $messageId;

    public StoreMessages$observeMessagesForChannel$2(long j) {
        this.$messageId = j;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Message call(List<? extends Message> list) {
        return call2((List<Message>) list);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Message call2(List<Message> list) {
        T next;
        m.checkNotNullExpressionValue(list, "messages");
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            next = it.next();
            if (((Message) next).getId() == this.$messageId) {
                return next;
            }
        }
        next = (T) null;
        return next;
    }
}
