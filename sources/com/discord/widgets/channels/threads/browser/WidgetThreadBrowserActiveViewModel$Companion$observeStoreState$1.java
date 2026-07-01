package com.discord.widgets.channels.threads.browser;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreThreadsActiveJoined$ActiveJoinedThread;
import d0.t.g0;
import d0.z.d.m;
import j0.k.b;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map$Entry;

/* JADX INFO: compiled from: WidgetThreadBrowserActiveViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadBrowserActiveViewModel$Companion$observeStoreState$1<T, R> implements b<Map<Long, ? extends StoreThreadsActiveJoined$ActiveJoinedThread>, Map<Long, ? extends Channel>> {
    public static final WidgetThreadBrowserActiveViewModel$Companion$observeStoreState$1 INSTANCE = new WidgetThreadBrowserActiveViewModel$Companion$observeStoreState$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Map<Long, ? extends Channel> call(Map<Long, ? extends StoreThreadsActiveJoined$ActiveJoinedThread> map) {
        return call2((Map<Long, StoreThreadsActiveJoined$ActiveJoinedThread>) map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Map<Long, Channel> call2(Map<Long, StoreThreadsActiveJoined$ActiveJoinedThread> map) {
        m.checkNotNullExpressionValue(map, "threadMap");
        LinkedHashMap linkedHashMap = new LinkedHashMap(g0.mapCapacity(map.size()));
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map$Entry map$Entry = (Map$Entry) it.next();
            linkedHashMap.put(map$Entry.getKey(), ((StoreThreadsActiveJoined$ActiveJoinedThread) map$Entry.getValue()).getChannel());
        }
        return linkedHashMap;
    }
}
