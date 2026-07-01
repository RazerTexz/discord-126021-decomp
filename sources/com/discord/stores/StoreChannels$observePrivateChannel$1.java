package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import j0.k.b;
import java.util.Map;

/* JADX INFO: compiled from: StoreChannels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreChannels$observePrivateChannel$1<T, R> implements b<Map<Long, ? extends Channel>, Channel> {
    public final /* synthetic */ long $channelId;

    public StoreChannels$observePrivateChannel$1(long j) {
        this.$channelId = j;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Channel call(Map<Long, ? extends Channel> map) {
        return call2((Map<Long, Channel>) map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Channel call2(Map<Long, Channel> map) {
        return map.get(Long.valueOf(this.$channelId));
    }
}
