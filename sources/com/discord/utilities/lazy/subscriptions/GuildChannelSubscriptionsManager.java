package com.discord.utilities.lazy.subscriptions;

import android.util.LruCache;
import com.discord.models.domain.ModelAuditLogEntry;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.IntRange;
import p507d0.p580t.C12136h0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GuildChannelSubscriptionsManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildChannelSubscriptionsManager {
    private final Function2<Long, Map<Long, ? extends List<IntRange>>, Unit> changeHandler;
    private final HashMap<Long, LruCache<Long, List<IntRange>>> subscriptions;

    /* JADX WARN: Multi-variable type inference failed */
    public GuildChannelSubscriptionsManager(Function2<? super Long, ? super Map<Long, ? extends List<IntRange>>, Unit> function2) {
        C12238m.checkNotNullParameter(function2, "changeHandler");
        this.changeHandler = function2;
        this.subscriptions = new HashMap<>();
    }

    public final Map<Long, List<IntRange>> get(long guildId) {
        Map<Long, List<IntRange>> mapSnapshot;
        LruCache<Long, List<IntRange>> lruCache = this.subscriptions.get(Long.valueOf(guildId));
        return (lruCache == null || (mapSnapshot = lruCache.snapshot()) == null) ? C12136h0.emptyMap() : mapSnapshot;
    }

    public final void remove(long guildId) {
        this.subscriptions.remove(Long.valueOf(guildId));
    }

    public final void reset() {
        this.subscriptions.clear();
    }

    public final void retainAll(List<Long> guildIds) {
        C12238m.checkNotNullParameter(guildIds, "guildIds");
        Iterator<Map.Entry<Long, LruCache<Long, List<IntRange>>>> it = this.subscriptions.entrySet().iterator();
        while (it.hasNext()) {
            if (!guildIds.contains(Long.valueOf(it.next().getKey().longValue()))) {
                it.remove();
            }
        }
    }

    public final void subscribe(long guildId, long channelId, List<IntRange> ranges) {
        C12238m.checkNotNullParameter(ranges, "ranges");
        LruCache<Long, List<IntRange>> lruCache = this.subscriptions.get(Long.valueOf(guildId));
        if (lruCache == null) {
            lruCache = new LruCache<>(5);
        }
        if (C12238m.areEqual(lruCache.get(Long.valueOf(channelId)), ranges)) {
            return;
        }
        lruCache.put(Long.valueOf(channelId), ranges);
        this.subscriptions.put(Long.valueOf(guildId), lruCache);
        Function2<Long, Map<Long, ? extends List<IntRange>>, Unit> function2 = this.changeHandler;
        Long lValueOf = Long.valueOf(guildId);
        Map<Long, List<IntRange>> mapSnapshot = lruCache.snapshot();
        C12238m.checkNotNullExpressionValue(mapSnapshot, "guildSubscriptions.snapshot()");
        function2.invoke(lValueOf, mapSnapshot);
    }
}
