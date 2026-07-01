package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import d0.t.g0;
import d0.t.o;
import j0.k.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;

/* JADX INFO: compiled from: StoreChannels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreChannels$observeIds$1<T, R> implements b<Map<Long, ? extends Channel>, Map<Long, ? extends List<? extends Long>>> {
    public static final StoreChannels$observeIds$1 INSTANCE = new StoreChannels$observeIds$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Map<Long, ? extends List<? extends Long>> call(Map<Long, ? extends Channel> map) {
        return call2((Map<Long, Channel>) map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Map<Long, List<Long>> call2(Map<Long, Channel> map) {
        Collection<Channel> collectionValues = map.values();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t : collectionValues) {
            Long lValueOf = Long.valueOf(((Channel) t).getGuildId());
            Object arrayList = linkedHashMap.get(lValueOf);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(lValueOf, arrayList);
            }
            ((List) arrayList).add(t);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(g0.mapCapacity(linkedHashMap.size()));
        for (Map$Entry map$Entry : linkedHashMap.entrySet()) {
            Object key = map$Entry.getKey();
            List list = (List) map$Entry.getValue();
            ArrayList arrayList2 = new ArrayList(o.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(Long.valueOf(((Channel) it.next()).getId()));
            }
            linkedHashMap2.put(key, arrayList2);
        }
        return linkedHashMap2;
    }
}
