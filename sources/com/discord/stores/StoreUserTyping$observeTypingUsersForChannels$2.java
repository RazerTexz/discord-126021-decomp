package com.discord.stores;

import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import j0.k.b;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Set;

/* JADX INFO: compiled from: StoreUserTyping.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserTyping$observeTypingUsersForChannels$2<T, R> implements b<Map<Long, ? extends Set<? extends Long>>, Map<Long, ? extends Set<? extends Long>>> {
    public final /* synthetic */ Set $channelIds;

    public StoreUserTyping$observeTypingUsersForChannels$2(Set set) {
        this.$channelIds = set;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Map<Long, ? extends Set<? extends Long>> call(Map<Long, ? extends Set<? extends Long>> map) {
        return call2((Map<Long, ? extends Set<Long>>) map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Map<Long, Set<Long>> call2(Map<Long, ? extends Set<Long>> map) {
        m.checkNotNullExpressionValue(map, "typingUsersByChannel");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map$Entry<Long, ? extends Set<Long>> map$Entry : map.entrySet()) {
            if (this.$channelIds.contains(Long.valueOf(map$Entry.getKey().longValue()))) {
                linkedHashMap.put(map$Entry.getKey(), map$Entry.getValue());
            }
        }
        return linkedHashMap;
    }
}
