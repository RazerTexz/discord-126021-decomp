package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.presence.Presence;
import d0.z.d.m;
import j0.k.b;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map$Entry;

/* JADX INFO: compiled from: StoreUserPresence.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserPresence$observePresencesForUsers$1<T, R> implements b<Map<Long, ? extends Presence>, Map<Long, ? extends Presence>> {
    public final /* synthetic */ Collection $userIds;

    public StoreUserPresence$observePresencesForUsers$1(Collection collection) {
        this.$userIds = collection;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Map<Long, ? extends Presence> call(Map<Long, ? extends Presence> map) {
        return call2((Map<Long, Presence>) map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Map<Long, Presence> call2(Map<Long, Presence> map) {
        m.checkNotNullExpressionValue(map, "it");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map$Entry<Long, Presence> map$Entry : map.entrySet()) {
            if (this.$userIds.contains(Long.valueOf(map$Entry.getKey().longValue()))) {
                linkedHashMap.put(map$Entry.getKey(), map$Entry.getValue());
            }
        }
        return linkedHashMap;
    }
}
