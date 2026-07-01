package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.embeddedactivities.EmbeddedActivity;
import d0.t.h0;
import j0.k.b;
import java.util.Map;

/* JADX INFO: compiled from: StoreEmbeddedActivities.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreEmbeddedActivities$observeEmbeddedActivitiesForChannel$1<T, R> implements b<Map<Long, ? extends Map<Long, ? extends EmbeddedActivity>>, Map<Long, ? extends EmbeddedActivity>> {
    public final /* synthetic */ long $channelId;

    public StoreEmbeddedActivities$observeEmbeddedActivitiesForChannel$1(long j) {
        this.$channelId = j;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Map<Long, ? extends EmbeddedActivity> call(Map<Long, ? extends Map<Long, ? extends EmbeddedActivity>> map) {
        return call2((Map<Long, ? extends Map<Long, EmbeddedActivity>>) map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Map<Long, EmbeddedActivity> call2(Map<Long, ? extends Map<Long, EmbeddedActivity>> map) {
        Map<Long, EmbeddedActivity> map2 = map.get(Long.valueOf(this.$channelId));
        return map2 != null ? map2 : h0.emptyMap();
    }
}
