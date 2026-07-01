package com.discord.utilities.lazy.subscriptions;

import android.util.LruCache;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.t.Collections2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: GuildThreadSubscriptionsManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildThreadSubscriptionsManager {
    private final Function2<Long, List<Long>, Unit> changeHandler;
    private final HashMap<Long, LruCache<Long, Long>> subscriptions;

    /* JADX WARN: Multi-variable type inference failed */
    public GuildThreadSubscriptionsManager(Function2<? super Long, ? super List<Long>, Unit> function2) {
        Intrinsics3.checkNotNullParameter(function2, "changeHandler");
        this.changeHandler = function2;
        this.subscriptions = new HashMap<>();
    }

    public final List<Long> get(long guildId) {
        Map<Long, Long> mapSnapshot;
        Set<Long> setKeySet;
        List<Long> list;
        LruCache<Long, Long> lruCache = this.subscriptions.get(Long.valueOf(guildId));
        return (lruCache == null || (mapSnapshot = lruCache.snapshot()) == null || (setKeySet = mapSnapshot.keySet()) == null || (list = _Collections.toList(setKeySet)) == null) ? Collections2.emptyList() : list;
    }

    public final void remove(long guildId) {
        this.subscriptions.remove(Long.valueOf(guildId));
    }

    public final void reset() {
        this.subscriptions.clear();
    }

    public final void retainAll(List<Long> guildIds) {
        Intrinsics3.checkNotNullParameter(guildIds, "guildIds");
        Iterator<Map.Entry<Long, LruCache<Long, Long>>> it = this.subscriptions.entrySet().iterator();
        while (it.hasNext()) {
            if (!guildIds.contains(Long.valueOf(it.next().getKey().longValue()))) {
                it.remove();
            }
        }
    }

    public final void subscribe(long guildId, long channelId) {
        LruCache<Long, Long> lruCache = this.subscriptions.get(Long.valueOf(guildId));
        if (lruCache == null) {
            lruCache = new LruCache<>(3);
        }
        if (lruCache.get(Long.valueOf(channelId)) != null) {
            return;
        }
        lruCache.put(Long.valueOf(channelId), Long.valueOf(channelId));
        this.subscriptions.put(Long.valueOf(guildId), lruCache);
        this.changeHandler.invoke(Long.valueOf(guildId), _Collections.toList(lruCache.snapshot().keySet()));
    }
}
