package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.message.Message;
import d0.t.n;
import j0.k.b;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: StoreMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessages$observeSyncedMessagesForChannel$1<T, R> implements b<Map<Long, List<Message>>, List<? extends Message>> {
    public final /* synthetic */ long $channelId;

    public StoreMessages$observeSyncedMessagesForChannel$1(long j) {
        this.$channelId = j;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ List<? extends Message> call(Map<Long, List<Message>> map) {
        return call2(map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final List<Message> call2(Map<Long, List<Message>> map) {
        List<Message> list = map.get(Long.valueOf(this.$channelId));
        return list != null ? list : n.emptyList();
    }
}
