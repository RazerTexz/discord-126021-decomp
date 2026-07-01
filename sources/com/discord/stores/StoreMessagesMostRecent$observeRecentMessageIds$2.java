package com.discord.stores;

import androidx.core.app.NotificationCompat;
import j0.k.b;
import java.util.Map;

/* JADX INFO: compiled from: StoreMessagesMostRecent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessagesMostRecent$observeRecentMessageIds$2<T, R> implements b<Map<Long, ? extends Long>, Long> {
    public final /* synthetic */ long $channelId;

    public StoreMessagesMostRecent$observeRecentMessageIds$2(long j) {
        this.$channelId = j;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Long call(Map<Long, ? extends Long> map) {
        return call2((Map<Long, Long>) map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Long call2(Map<Long, Long> map) {
        Long l = map.get(Long.valueOf(this.$channelId));
        return Long.valueOf(l != null ? l.longValue() : 0L);
    }
}
