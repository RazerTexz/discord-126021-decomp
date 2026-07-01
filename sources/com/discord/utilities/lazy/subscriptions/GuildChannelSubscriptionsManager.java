package com.discord.utilities.lazy.subscriptions;

import android.util.LruCache;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.Ranges2;

/* JADX INFO: compiled from: GuildChannelSubscriptionsManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildChannelSubscriptionsManager {
    private final Function2<Long, Map<Long, ? extends List<Ranges2>>, Unit> changeHandler;
    private final HashMap<Long, LruCache<Long, List<Ranges2>>> subscriptions;

    /* JADX WARN: Multi-variable type inference failed */
    public GuildChannelSubscriptionsManager(Function2<? super Long, ? super Map<Long, ? extends List<Ranges2>>, Unit> function2) {
        Intrinsics3.checkNotNullParameter(function2, "changeHandler");
        this.changeHandler = function2;
        this.subscriptions = new HashMap<>();
    }

    public final Map<Long, List<Ranges2>> get(long guildId) {
        Map<Long, List<Ranges2>> mapSnapshot;
        LruCache<Long, List<Ranges2>> lruCache = this.subscriptions.get(Long.valueOf(guildId));
        return (lruCache == null || (mapSnapshot = lruCache.snapshot()) == null) ? Maps6.emptyMap() : mapSnapshot;
    }

    public final void remove(long guildId) {
        this.subscriptions.remove(Long.valueOf(guildId));
    }

    public final void reset() {
        this.subscriptions.clear();
    }

    public final void retainAll(List<Long> guildIds) {
        Intrinsics3.checkNotNullParameter(guildIds, "guildIds");
        Iterator<Map.Entry<Long, LruCache<Long, List<Ranges2>>>> it = this.subscriptions.entrySet().iterator();
        while (it.hasNext()) {
            if (!guildIds.contains(Long.valueOf(it.next().getKey().longValue()))) {
                it.remove();
            }
        }
    }

    public final void subscribe(long guildId, long channelId, List<Ranges2> ranges) {
        Intrinsics3.checkNotNullParameter(ranges, "ranges");
        LruCache<Long, List<Ranges2>> lruCache = this.subscriptions.get(Long.valueOf(guildId));
        if (lruCache == null) {
            lruCache = new LruCache<>(5);
        }
        if (Intrinsics3.areEqual(lruCache.get(Long.valueOf(channelId)), ranges)) {
            return;
        }
        lruCache.put(Long.valueOf(channelId), ranges);
        this.subscriptions.put(Long.valueOf(guildId), lruCache);
        Function2<Long, Map<Long, ? extends List<Ranges2>>, Unit> function2 = this.changeHandler;
        Long lValueOf = Long.valueOf(guildId);
        Map<Long, List<Ranges2>> mapSnapshot = lruCache.snapshot();
        Intrinsics3.checkNotNullExpressionValue(mapSnapshot, "guildSubscriptions.snapshot()");
        function2.invoke(lValueOf, mapSnapshot);
    }
}
