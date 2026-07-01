package com.discord.utilities.analytics;

import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import j0.k.b;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Set;

/* JADX INFO: compiled from: AnalyticsTracker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AnalyticsTracker$inviteSuggestionOpened$1<T, R> implements b<Map<Long, ? extends Integer>, Set<? extends Long>> {
    public static final AnalyticsTracker$inviteSuggestionOpened$1 INSTANCE = new AnalyticsTracker$inviteSuggestionOpened$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Set<? extends Long> call(Map<Long, ? extends Integer> map) {
        return call2((Map<Long, Integer>) map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Set<Long> call2(Map<Long, Integer> map) {
        m.checkNotNullExpressionValue(map, "userRelationships");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map$Entry<Long, Integer> map$Entry : map.entrySet()) {
            if (map$Entry.getValue().intValue() == 1) {
                linkedHashMap.put(map$Entry.getKey(), map$Entry.getValue());
            }
        }
        return linkedHashMap.keySet();
    }
}
