package com.discord.stores;

import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import j0.k.b;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map$Entry;

/* JADX INFO: compiled from: StoreUserRelationships.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserRelationships$observe$2<T, R> implements b<Map<Long, ? extends Integer>, Map<Long, ? extends Integer>> {
    public final /* synthetic */ Collection $userIds;

    public StoreUserRelationships$observe$2(Collection collection) {
        this.$userIds = collection;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Map<Long, ? extends Integer> call(Map<Long, ? extends Integer> map) {
        return call2((Map<Long, Integer>) map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Map<Long, Integer> call2(Map<Long, Integer> map) {
        m.checkNotNullExpressionValue(map, "it");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map$Entry<Long, Integer> map$Entry : map.entrySet()) {
            if (this.$userIds.contains(Long.valueOf(map$Entry.getKey().longValue()))) {
                linkedHashMap.put(map$Entry.getKey(), map$Entry.getValue());
            }
        }
        return linkedHashMap;
    }
}
