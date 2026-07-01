package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import d0.z.d.m;
import j0.k.b;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map$Entry;

/* JADX INFO: compiled from: StoreSearchData.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreSearchData$getGuildSearchData$1<T, R> implements b<Map<Long, ? extends Channel>, Map<Long, ? extends Channel>> {
    public static final StoreSearchData$getGuildSearchData$1 INSTANCE = new StoreSearchData$getGuildSearchData$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Map<Long, ? extends Channel> call(Map<Long, ? extends Channel> map) {
        return call2((Map<Long, Channel>) map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Map<Long, Channel> call2(Map<Long, Channel> map) {
        m.checkNotNullExpressionValue(map, "guildChannels");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map$Entry<Long, Channel> map$Entry : map.entrySet()) {
            if (ChannelUtils.v(map$Entry.getValue())) {
                linkedHashMap.put(map$Entry.getKey(), map$Entry.getValue());
            }
        }
        return linkedHashMap;
    }
}
