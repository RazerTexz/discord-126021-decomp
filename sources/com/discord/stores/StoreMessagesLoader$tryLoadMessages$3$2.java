package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.api.message.Message;
import d0.t.o;
import d0.z.d.m;
import j0.k.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: StoreMessagesLoader.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessagesLoader$tryLoadMessages$3$2<T, R> implements b<List<? extends Message>, List<? extends com.discord.models.message.Message>> {
    public static final StoreMessagesLoader$tryLoadMessages$3$2 INSTANCE = new StoreMessagesLoader$tryLoadMessages$3$2();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ List<? extends com.discord.models.message.Message> call(List<? extends Message> list) {
        return call2((List<Message>) list);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final List<com.discord.models.message.Message> call2(List<Message> list) {
        m.checkNotNullExpressionValue(list, "messages");
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new com.discord.models.message.Message((Message) it.next()));
        }
        return arrayList;
    }
}
